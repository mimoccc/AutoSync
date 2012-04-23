package app.autosync.core;

import java.util.List;

/**
 * Represents an executable operation for a batch.
 *
 * @author Matthew Cory
 */
public interface Operation {
	
	/**
	 * Performs this operation's logic.  
	 *
	 * @return {@code true} if the operation executed
	 *         without error, or {@code false} if errors
	 *         occured during execution.
	 */
	boolean execute();
	
	/**
	 * Get any error messages that were generated
	 * during execution.  If the operation has not
	 * executed yet, this should throw an 
	 * {@code IllegalStateException}.
	 *
	 * @return a {@code List} of error messages 
	 *         that were thrown during execution.
	 */
	List<String> getErrors();
	
	/**
	 * Get any {@code Throwable}s that were generated
	 * during execution.  If the operation has not
	 * executed yet, this should throw an 
	 * {@code IllegalStateException}.
	 *
	 * @return a {@code List} of {@code Throwable}s 
	 *         that were thrown during execution.
	 */
	List<Throwable> getExceptions();
	
	/**
	 * Adds an exception generated during execution.
	 *
	 * @param exception the exception to add.  Must not
	 *                  be {@code null}.
	 */
	void addException(Throwable exception);
	
	/**
	 * Adds an error message generated during execution.
	 *
	 * @param error the error message to add.  Must not
	 *                  be {@code null} or just white space.
	 */
	void addError(String error);
}
