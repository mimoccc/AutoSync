package app.autosync.core;

/**
 * Defines an operation that has a parent operation
 * to allow for a bit of an Observer pattern 
 * implementation.
 *
 * @author Matthew Cory
 */
public interface ParentedOperation extends Operation {
	
	void setParent(Operation operation);
	
	Operation getParent(Operation operation);
}