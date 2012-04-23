package app.autosync.util;

/**
 * Utility methods for working with strings. Yes,
 * it's reinventing the wheel - Apache commons has
 * a great library for this stuff - but this allows
 * using only what we need and keeps the dependencies
 * low.  (If we need more, we can always refactor 
 * later.)
 *
 * @author Matther Cory
 */
public final class StringUtils {
	/**
	 * Default constructor; declared only so
	 * we can make it private and prevent
	 * instantiation. 
	 */
	private StringUtils() { }
	
	/** 
	 * Checks if a string is either <code>null</code>
	 * or just white space.
	 * 
	 * @param str the string to check.
	 *
	 * @return {@code true} if str is either 
	 *         {@code null} or just white space, 
	 *         {@code false} otherwise.
	 */
	public static boolean isBlank(final String str) {
		return ((str == null) || (str.trim().length() == 0));		
	}
}
