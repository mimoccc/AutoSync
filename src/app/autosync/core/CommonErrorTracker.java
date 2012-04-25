package app.autosync.core;

import java.util.Collections;
import java.util.List;

import app.autosync.util.StringUtils;

/**
 * Basic {@link ErrorTracker} implementation to allow
 * for a component-based approach when desired.  Classes
 * can delegate to this implementation instead of rolling 
 * their own.
 *
 * @author Matthew Cory
 */
public class CommonErrorTracker implements ErrorTracker {
	
	/**
	 * {@inheritDoc}
	 */
	public List<String> getErrors() {
		return Collections.unmodifiableList(errors);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<Throwable> getExceptions() {
		return Collections.unmodifiableList(exceptions);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addException(final Throwable exception) {
		if (exception == null) {
			throw new IllegalArgumentException("Exception must be provided.");
		}
		
		exceptions.add(exception);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addError(final String error) {
		if (StringUtils.isBlank(error)) {
			throw new IllegalArgumentException("Error message must be provided.");
		}
		
		errors.add(error);
	}
	
	/**
	 * Clears the lists of errors and exceptions.
	 */
	public final void clear() {
		errors.clear();
		exceptions.clear();
	}
	
	private final List<Throwable> exceptions = new java.util.ArrayList<Throwable>();
	private final List<String> errors = new java.util.ArrayList<String>();
}
