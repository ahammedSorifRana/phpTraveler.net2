package test.phpTravaler.net.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import test.phpTravaler.net.ExcelReader.ExcelReader;

public class TestBase {
	public WebDriver Driver;
	ExcelReader ExcelData;
	String URL="http://www.phptravels.net";
	String Browser= "chrome";

	
	public void inIt() {
		
		chooseBrowser(Browser);
		getUrl(URL);
		
	}
	/**
	 * 
	 * @param Browser,URL
	 * 
	 * combine to method chosseBrowser & getUrl
	 */
	
	
	
	
	public void chooseBrowser(String Browser) {
		
		switch (Browser) {
			case "fireFox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Driver//geckodriver.exe");
				Driver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
				Driver = new ChromeDriver();
				break;
			default:
				System.out.println("No Browser Found");
			}

		}
	/** 
	 * it will take @param  as Browser 
	 * @return selected browser
	 * @see selected Browser will launch
	 * */
	
	public void getUrl(String URL) {
		
		Driver.get(URL);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.manage().window().maximize();
		}
	
	/** 
	 * it will take @param as URL
	 * @return it will take to the specific URL
	 * @return it will will wait maximum 60s if some webElemen is unable to identify
	 * @return it will make Browser maximum size
	 * @see webPage will be seen
	 * @see Browser is get maximum size
	 */
	public void TakeScreenShot(String name) {
		
		Calendar xDate = Calendar.getInstance();
		SimpleDateFormat formate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		
			File Source = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
			File Destination =new File(System.getProperty("user.dir")+"//src//test//java//test//phpTravaler//net//CaptureScreenShot//"+name+"-"+formate.format(xDate.getTime())+".png");
			try {
				FileUtils.copyFile(Source,Destination );
				Reporter.log("<a herf='"+Destination.getAbsolutePath()+"'><img src='"+Destination.getAbsolutePath()+"' height='100' width='100'/>)</0>");
			} catch (IOException e) {
				System.out.println("--Pic Capture Exception"+e.getMessage());
			}
			
		}
	public String[][] getData(String excelName,int SheetNum) {
		///test.phpTravaler.net/src/test/java/test/phpTravaler/net/Data/phpSingUpDat.xlsx
		String FilePath =System.getProperty("user.dir")+"//src//test//java//test//phpTravaler//net//Data//"+excelName;
		ExcelData = new ExcelReader(FilePath);
		 String[][] xData =  ExcelData.getExcelData(SheetNum);
		return xData;
	}

}
