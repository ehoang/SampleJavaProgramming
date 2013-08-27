package emily.hoang;

import junit.framework.Assert;

import org.junit.Test;

public class KeyCountTest {

	@Test
	public void testCountFromFile() {
		String keyCount = KeyCount.countFromFile("/Users/emilyhoang/Documents/workspace/Dealer.com/src/testFile.txt");
		Assert.assertEquals("The total for Jane is 9. The total for John is 6. ", keyCount);
	}

	@Test
	public void testCountWithWrongFile() {
		String keyCount = KeyCount.countFromFile("/nonExistingFile.txt");
		Assert.assertEquals(null, keyCount);
	}
	
	@Test
	public void testCountWithNoFile() {
		String keyCount = KeyCount.countFromFile(null);
		Assert.assertEquals(null, keyCount);
	}
	
	@Test
	public void testCountWithEmptyFile() {
		String keyCount = KeyCount.countFromFile("/Users/emilyhoang/Documents/workspace/Dealer.com/src/emptyFile.txt");
		Assert.assertEquals("", keyCount);
	}
}
