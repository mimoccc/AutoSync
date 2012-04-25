package app.autosync.models;

import java.util.Arrays;
import java.util.List;

import app.autosync.core.AbstractMultipleOperation;
import app.autosync.core.ParentedOperation;

public final class Sync extends AbstractMultipleOperation {

	@Override
	protected boolean canAddChild(ParentedOperation child) {
		return ACCEPTED_CLASSES.contains(child.getClass());
	}
	
	private static final List<Class<?>> ACCEPTED_CLASSES = Arrays.asList(new Class<?>[] { Copy.class });
}
