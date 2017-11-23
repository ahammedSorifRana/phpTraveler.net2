package test.phpTravaler.net.ListenerClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;

import test.phpTravaler.net.TestBase.TestBase;

public class Listener extends TestBase {

	
	public void onTestFailure(ITestResult result) {

		
		Calendar xDate = Calendar.getInstance();
		SimpleDateFormat formate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String scrFile = result.getName();
		if(!result.isSuccess()) {
			File Source = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
			File Destination =new File(System.getProperty("user.dir")+"//src//test//java//test//phpTravaler//net//CaptureScreenShot//"+scrFile+"-"+formate.format(xDate.getTime())+".png");
			try {
				FileUtils.copyFile(Source,Destination );
				Reporter.log("<a herf='"+Destination.getAbsolutePath()+"'><img src='"+Destination.getAbsolutePath()+"' height='100' width='100'/>)</0>");
			} catch (IOException e) {
				System.out.println("--Pic Capture Exception"+e.getMessage());
			}
		}	
	}
	
	public void onTestPass(ITestResult result) {

		
		Calendar xDate = Calendar.getInstance();
		SimpleDateFormat formate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String scrFile = result.getName();
		if(result.isSuccess()) {
			File Source = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
			File Destination =new File(System.getProperty("user.dir")+"//src//test//java//test//phpTravaler//net//CaptureScreenShot//"+scrFile+"-"+formate.format(xDate.getTime())+".png");
			try {
				FileUtils.copyFile(Source,Destination );
				Reporter.log("<a herf='"+Destination.getAbsolutePath()+"'><img src='"+Destination.getAbsolutePath()+"' height='100' width='100'/>)</0>");
			} catch (IOException e) {
				System.out.println("--Pic Capture Exception"+e.getMessage());
			}
		}	
	
		
	}
/*
public void onTestSkip(ITestResult result) {

		
		Calendar xDate = Calendar.getInstance();
		SimpleDateFormat formate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String scrFile = result.getName();
		if(result.SKIP) {
			File Source = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
			File Destination =new File(System.getProperty("user.dir")+"//src//test//java//test//phpTravaler//net//CaptureScreenShot//"+scrFile+"-"+formate.format(xDate.getTime())+".png");
			try {
				FileUtils.copyFile(Source,Destination );
				Reporter.log("<a herf='"+Destination.getAbsolutePath()+"'><img src='"+Destination.getAbsolutePath()+"' height='100' width='100'/>)</0>");
			} catch (IOException e) {
				System.out.println("--Pic Capture Exception"+e.getMessage());
			}
		}	
	
		
	}
	*/

}
