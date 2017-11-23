package test.phpTravaler.net.Navigation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import junit.framework.Assert;
import test.phpTravaler.net.TestBase.TestBase;

public class TC0003_VerifySingUpWithDifferentSetOfData extends TestBase {
	
	navigation nav ;
	
	/*
	 String enterFirstName= "Ahammed";

	String enterLastName="Sorif";
	String enterMobileNumber="3478499077";
	String enterEmailNumber="ahammed@gmail.com";
	String enterPassword="Rana0260";
	 */
	
	
	
	  @DataProvider(name="SingUpData")
	public String[][] getTestData() {
	
		  String[][] testdata = getData("phpSingUpData.xlsx", 0);
		
		return testdata;
	}
	
	
	
	
	
	
	@BeforeTest
	public void setUp() {
		inIt();
		
		}
	/**
	 * it will lounch Brower and navigate through URL
	 */
	@Test(dataProvider="SingUpData")

	public void testCaseName(String enterFirstName, String enterLastName, String enterMobileNumber, String enterEmailNumber, String enterPassword, String runmode) {

		 nav = new navigation(Driver);
		 System.out.println(runmode);
		nav.singUp(enterFirstName, enterLastName, enterMobileNumber, enterEmailNumber, enterPassword, runmode);
		//Assert.assertEquals(true, nav.getEmailAlreadyExistMassage());
		nav.SingOut();
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
