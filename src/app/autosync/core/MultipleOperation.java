package app.autosync.core;

/**
 * Provides actions for operations that contain  multiple
 * children operations.
 *
 * @author Matthew Cory
 */
public interface MultipleOperation extends Operation {
	
	/**
	 * Adds a child operation that will execute in
	 * the order it was added.
	 *
	 * @param child the operation to add.
	 */
	void addChild(ParentedOperation child);
}
