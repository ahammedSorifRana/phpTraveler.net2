package test.phpTravaler.net.Navigation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import test.phpTravaler.net.TestBase.TestBase;

public class TC0002_VerifySingUpWithValidCredential extends TestBase{
	navigation nav;

	@BeforeTest
	public void setUp() {
		inIt();
		
		}
	/**
	 * it will lounch Brower and navigate through URL
	 */
	@Test
	public void VerifySingUpWithValidCredential() {
		nav = new navigation(Driver);
		long time =System.currentTimeMillis();
		nav.singUp("Hello", "World", "3443553455",time+"newEmail@gmail.com", "Rana0260", null);
		TakeScreenShot("SingUp");
		Assert.assertEquals(true, nav.getRegistrationSuccess());
		}
	/**
	 * it will execute the testCase
	 */
	@AfterTest
	public void endTest() {
		Driver.close();
	
		}
	/**
	 * it will end the Test and Close Browser
	 */

	
	

}
