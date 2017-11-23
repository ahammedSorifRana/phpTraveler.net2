package test.phpTravaler.net.Navigation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.phpTravaler.net.TestBase.TestBase;

public class TC0001_VerifyLogInWithValidCredential extends TestBase {
	
	navigation nav;
	
	@BeforeTest
	public void setUp() {
		
		inIt();
		
		
		}
	/**
	 * it will lounch Brower and navigate through URL
	 */
	@Test
	public void VerifyLogInWithValidCredential() {
		
		
		nav = new navigation(Driver);
		nav.Login("user@phptravels.com", "demouser");
		TakeScreenShot("SingIn");
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
