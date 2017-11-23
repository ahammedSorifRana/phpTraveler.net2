package test.phpTravaler.net.homePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;
import test.phpTravaler.net.TestBase.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath=".//*[@id='HOTELS']/form/div[1]/div/label[text()='Location']")
	WebElement Location;
	@FindBy(xpath=".//*[@id='dpd1']/input")
	WebElement ClickOnCheckIn;
	
	@FindBy(xpath="html/body/div[10]/div[1]/table/tbody/tr/td")
	WebElement AllCheckInDate;
	
	
	
	
	public  boolean VerifyHomePage() {
		try {
			Assert.assertEquals("Location", Location.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	public void selectCheckInDate() {
		
		ClickOnCheckIn.click();
		List<WebElement> dates = Driver.findElements(By.xpath("html/body/div[10]/div[1]/table/tbody/tr/td"));
		
		for(WebElement xDate : dates) {
			
		String	Actual_date = xDate.getText();
			String Expected_Data = "12";
			if(Expected_Data.equalsIgnoreCase(Actual_date)) {
				
				xDate.click();
				break;
			}
		}
		
		
		
	}
	public void selectCheckOutDate() {
		
		
		
	}

}
