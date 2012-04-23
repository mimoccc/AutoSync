package app.autosync.core;

import java.util.Collections;
import java.util.List;

import app.autosync.util.StringUtils;

/**
 * Abstract base class for batch operations.
 *
 * @author Matthew Cory
 */
public abstract class AbstractOperation implements Operation {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean execute() {
		hasExecuted = false;
		errors.clear();
		exceptions.clear();
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
	@Override
	public final List<String> getErrors() {
		if (!hasExecuted) {
			throw new IllegalStateException("This operation has not been executed.");
		}
		
		return Collections.unmodifiableList(errors);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Throwable> getExceptions() {
		if (!hasExecuted) {
			throw new IllegalStateException("This operation has not been executed.");
		}
		
		return Collections.unmodifiableList(exceptions);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void addException(final Throwable exception) {
		if (exception == null) {
			throw new IllegalArgumentException("Exception must be provided.");
		}
		
		exceptions.add(exception);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void addError(final String error) {
		if (StringUtils.isBlank(error)) {
			throw new IllegalArgumentException("Error message must be provided.");
		}
		
		errors.add(error);
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
	
	private final List<Throwable> exceptions = new java.util.ArrayList<Throwable>();
	private final List<String> errors = new java.util.ArrayList<String>();
	
	private boolean hasExecuted = false;
}
