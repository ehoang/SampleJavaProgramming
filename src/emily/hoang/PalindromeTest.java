package emily.hoang;

import junit.framework.Assert;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void testIsPalindrome() {
		Assert.assertTrue(Palindrome.isPalindrome("pop"));
		Assert.assertTrue(Palindrome.isPalindrome("Ah, Satan sees Natasha"));
		
		Assert.assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama."));
		Assert.assertTrue(Palindrome.isPalindrome("Was it a car or a cat I saw?"));
		
		Assert.assertTrue(Palindrome.isPalindrome("ufoTofu"));

		Assert.assertFalse(Palindrome.isPalindrome(null));
		Assert.assertFalse(Palindrome.isPalindrome(""));
		Assert.assertFalse(Palindrome.isPalindrome("This is a negative test."));
	}

}
