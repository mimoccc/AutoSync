package app.autosync.models;

import java.io.File;
import java.util.List;

import app.autosync.core.ErrorTracker;

public abstract class FileSet implements ErrorTracker {
	// how to handle IOExceptions though, esp. if this isn't an Operation?
	public final List<File> getFiles() {
		return null;
	}
}
