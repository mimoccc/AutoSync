package app.autosync.models;

import app.autosync.core.AbstractMultipleOperation;
import app.autosync.util.StringUtils;

/**
 * A collection of operations to perform on a given
 * interval.
 *
 * @author Matthew Cory 
 */
public final class Batch extends AbstractMultipleOperation {
	private final String title;
	private final Long interval;
	
	/** 
	 * Creates a new Batch instance with the given
	 * title and interval.
	 * 
	 * @param title the title of the Batch. Used for
	 *              display and storage purposes. Cannot
	 *              be {@code null} or an empty string.
	 * @param interval the interval in milliseconds between
	 *                 each execution of this batch.
	 *                 Cannot be {@code null} or negative.
	 */
	public Batch(final String title, final Long interval) {
		if (StringUtils.isBlank(title)) {
			throw new IllegalArgumentException("Title must be provided.");
		}
		
		if (interval == null) {
			throw new IllegalArgumentException("Interval must be provided.");
		}
		
		if (interval < 0) {
			throw new IllegalArgumentException("Interval must be non-negative");
		}
		
		this.title = title;
		this.interval = interval;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Long getInterval() {
		return interval;
	}
}
