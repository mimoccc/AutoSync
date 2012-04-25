package app.autosync.core;

import java.util.List;

/**
 * Abstract base class for batch operations.
 *
 * @author Matthew Cory
 */
public abstract class AbstractOperation implements Operation {
	
	/**
	 * {@inheritDoc}
	 */
	public final boolean execute() {
		hasExecuted = false;
		errorTracker.clear();
		boolean result = false;
		try {
			result = this.doExecute();
		} catch (Throwable t) {
			addException(t);
			result = false;
		} finally {
			hasExecuted = true;
		}
		
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public final List<String> getErrors() {
		if (!hasExecuted) {
			throw new IllegalStateException("This operation has not been executed.");
		}
		
		return errorTracker.getErrors();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public final List<Throwable> getExceptions() {
		if (!hasExecuted) {
			throw new IllegalStateException("This operation has not been executed.");
		}
		
		return errorTracker.getExceptions();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public final void addException(final Throwable exception) {
		errorTracker.addException(exception);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public final void addError(final String error) {
		errorTracker.addError(error);
	}
	
	/**
	 * When implemented in a descendant class, performs
	 * the actual logic of the operation.
	 *
	 * @return {@code true} if the operation executed
	 *         without error, or {@code false} if errors
	 *         occured during execution.
	 */
	protected abstract boolean doExecute();
	
	private final CommonErrorTracker errorTracker = new CommonErrorTracker();
	
	private boolean hasExecuted = false;
}
