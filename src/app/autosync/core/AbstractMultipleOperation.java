package app.autosync.core;

import java.util.Collections;
import java.util.List;

/**
 * Abstract base class for batch operations that 
 * contain multiple children operations.
 *
 * @author Matthew Cory
 */
public abstract class AbstractMultipleOperation extends AbstractOperation implements MultipleOperation {
	
	/**
	 * {@inheritDoc}
	 */
	public final void addChild(ParentedOperation child) {
		if (child == null) {
			throw new IllegalArgumentException("Child must be provided.");
		}
		
		if (!canAddChild(child)) {
			throw new IllegalArgumentException("Unable to accept child.");
		}
		
		child.setParent(this);
		children.add(child);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final boolean doExecute() {
		final boolean singleExecRes = executeSingle();
		final boolean childExecRes = executeChildren();
		return (singleExecRes && childExecRes);
	}
	
	/**
	 * Executes each child operation in the order
	 * they were added.
	 */
	protected final boolean executeChildren() {
		boolean res = true;
		for (final Operation child : children) {
			res &= child.execute();
		}
		return res;
	}
	
	protected boolean executeSingle() {
		return true;
	}
	
	protected final List<ParentedOperation> getChildren() {
		return Collections.unmodifiableList(children);
	}
	
	protected abstract boolean canAddChild(final ParentedOperation child);
	
	private final List<ParentedOperation> children = new java.util.ArrayList<ParentedOperation>();
}
