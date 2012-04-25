package app.autosync.models;

import app.autosync.core.AbstractOperation;

public final class Copy extends AbstractOperation {
	
	public Copy(final FileSet source, final FileSet destination) {
		if (source == null) {
			throw new IllegalArgumentException("Source must be provided.");
		}
		
		if (destination == null) {
			throw new IllegalArgumentException("Destination must be provided.");
		}
		
		this.source = source;
		this.destination = destination;
	}
	
	public FileSet getSource() {
		return source;
	}
	
	public FileSet getDestination() {
		return destination;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean doExecute() {
		return false;
	}
		
	private final FileSet source;
	private final FileSet destination;
}