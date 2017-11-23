package test.phpTravaler.net.Navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class navigation {
	
	WebDriver Driver;
	/**
	 * SingIn
	 */
	@FindBy(xpath="//div[@class='navbar']//li[@id='li_myaccount']")
	WebElement clickOnMyManue;
	@FindBy(xpath="//div[@class='navbar']//ul[@class='dropdown-menu']/li/a[contains(text(),'Login')]")
	WebElement LoginManue;

	@FindBy(xpath="//div[@class='form-group']/label[contains(text(),'Email')]//following::input[@name='username' and @type='email']")
	WebElement enterEmailAdd;
	
	@FindBy(xpath=".//*[@id='loginfrm']/div[1]/div[5]/div/div[2]/input")
	WebElement enterPassWord;
	
	@FindBy(xpath=".//*[@id='loginfrm']/div[1]/div[5]/button")
	WebElement clickOnLogin;
	/**
	 * SingUp
	 */
	
	@FindBy(xpath="//div[@class='navbar']//li[@id='li_myaccount']//ul//li/a[contains(text(),'Sign Up')]")
	WebElement SingUpManue;
	@FindBy(xpath=".//*[@id='headersignupform']/div[3]/input")
	WebElement firstName;
	@FindBy(xpath=".//*[@id='headersignupform']/div[4]/input")
	WebElement lastName;
	@FindBy(xpath=".//*[@id='headersignupform']/div[5]/input")
	WebElement mobileNumber;
	@FindBy(xpath=".//*[@id='headersignupform']/div[6]/input")
	WebElement emailAdd;
	@FindBy(xpath=".//*[@id='headersignupform']/div[7]/input")
	WebElement passWord;
	@FindBy(xpath=".//*[@id='headersignupform']/div[8]/input")
	WebElement confirmPass;
	@FindBy(xpath=".//*[@id='headersignupform']/div[9]/button")
	WebElement singUpButton;
	@FindBy(xpath=".//*[@id='bookings']/h4/strong")
	WebElement nothingBook;
	@FindBy(xpath="html/body/div[3]/div/div/div[2]/ul/ul/li[1]/ul/li[2]/a")
	WebElement singOut;
	
	@FindBy(xpath="html/body/div[3]/div/div/div[2]/ul/ul/li[1]/a/i[contains(@class,'icon')]")
	WebElement clickOnIcone;
	@FindBy(xpath=".//*[@id='headersignupform']/div[2]/div[contains(text(),'Email Already')]")
	WebElement emailAddExist;
	
	/**
	 * Associate Script with the Driver by crating constractor
	 * @param driver
	 */
	
	public navigation(WebDriver driver) {
		
		this.Driver = driver;
		PageFactory.initElements(driver, this);
		
	
	}
	/**
	 * 
	 * @param emailAdd
	 * @param passWord
	 * 
	 */
	public void Login(String emailAdd,String passWord)  {
		
		WebDriverWait xWait = new WebDriverWait(Driver, 60);
	
		
		clickOnMyManue.click();
		LoginManue.click();
		xWait.until(ExpectedConditions.visibilityOf(enterEmailAdd));
		enterEmailAdd.sendKeys(emailAdd);
		enterPassWord.sendKeys(passWord);
		clickOnLogin.click();
		}
	/**
	 * it will make login
	 * @exception without cangeing email add it will give some exception
	 * @param enterFirstName
	 * @param enterLastName
	 * @param enterMobileNumber
	 * @param enterPassword
	 */
	public void singUp(String enterFirstName,String enterLastName,String enterMobileNumber,String enterEmailNumber,String enterPassword,String Runmod) {
		clickOnMyManue.click();
		SingUpManue.click();
		firstName.sendKeys(enterFirstName);
		lastName.sendKeys(enterLastName);
		mobileNumber.sendKeys(enterMobileNumber);
		emailAdd.sendKeys(enterEmailNumber);
		passWord.sendKeys(enterPassword);
		confirmPass.sendKeys(enterPassword);
		singUpButton.click();

	}
	
	public boolean getRegistrationSuccess() {
			try {
				nothingBook.isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		
	}
	public boolean getEmailAlreadyExistMassage() {
			try {
				emailAddExist.isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
				
			}
		
	}
	public void SingOut() {
		if(getRegistrationSuccess()) {
		clickOnIcone.click();
		singOut.click();
		}
		
	}

}
