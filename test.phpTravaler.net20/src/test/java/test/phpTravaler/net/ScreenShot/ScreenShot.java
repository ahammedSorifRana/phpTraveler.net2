package test.phpTravaler.net.ScreenShot;

import org.openqa.selenium.WebDriver;



public class ScreenShot {
	
	WebDriver Driver;
	/**
	 * it will associate Driver with orginal Driver
	 * @param driver
	 */
	public ScreenShot(WebDriver driver) {
		this.Driver = driver;
		
	}
	
	/**
	 * It will capture ScreenShot
	 */
	
	/*public void TakeScreenShot(String name) {
		
		Calendar xDate = Calendar.getInstance();
		SimpleDateFormat formate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		
		File Source = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		File Destination =new File(System.getProperty("user.dir")+"//src//test//java//test//phpTravaler//net//CaptureScreenShot//"+name+"-"+formate.format(xDate.getTime())+".png");
		try {
			FileUtils.copyFile(Source,Destination );
		} catch (IOException e) {
			System.out.println("--Pic Capture Exception"+e.getMessage());
		}
		
		
	}*/

}
