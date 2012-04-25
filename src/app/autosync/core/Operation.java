package app.autosync.core;

/**
 * Represents an executable operation for a batch.
 *
 * @author Matthew Cory
 */
public interface Operation extends ErrorTracker {
	
	/**
	 * Performs this operation's logic.  
	 *
	 * @return {@code true} if the operation executed
	 *         without error, or {@code false} if errors
	 *         occured during execution.
	 */
	boolean execute();
}
