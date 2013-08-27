package emily.hoang;

public class Palindrome {

	/**
	 * Determines whether the specified string is a palindrome. A palindrome is
	 * a word or a phrase that is spelled exactly the same forwards or
	 * backwards. It should have at least one or more characters. All
	 * non-alphanumeric characters are ignored. This is not case sensitive.
	 * 
	 * @param input
	 *            the string to be tested
	 * @return <code>true</code> if a string is a palindrome; <code>false</code>
	 *         , otherwise.
	 */
	public static boolean isPalindrome(String input) {
		if ((input == null) || (input.isEmpty())) {
			return false;
		}

		// remove all non-alphanumeric characters
		String alphaNumericOnly = input.replaceAll("[^a-zA-Z0-9]", "");

		StringBuilder stringBuilder = new StringBuilder(alphaNumericOnly);
		stringBuilder.reverse();

		// compare string with the reverse form of the string
		return alphaNumericOnly.equalsIgnoreCase(stringBuilder.toString());
	}
}
