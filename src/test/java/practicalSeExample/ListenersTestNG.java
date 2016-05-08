package practicalSeExample;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersTestNG implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("Finished...");
		
	}

	public void onStart(ITestContext arg0) {
		System.out.println("Started...");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("On test fail but with scuccess percent...");
	}


	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Skipped");
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Started...");
		
	}


//Find More Tutorials On WebDriver at -> http://software-testing-tutorials-automation.blogspot.com

	//This method will execute only when the test is pass.
	public void onTestSuccess(ITestResult tr) {
		//If screenShotOnPass = yes, call captureScreenShot.
		
			captureScreenShot(tr,"pass");
		
	}

	//This method will execute only on the event of fail test.
	public void onTestFailure(ITestResult tr) {		
		//If screenShotOnFail = yes, call captureScreenShot.
		
			captureScreenShot(tr,"fail");
		
	}

	// This method will execute before the main test start (@Test)
	
	//Function to capture screenshot.
	public void captureScreenShot(ITestResult result, String status){	
		String destDir = "";
		String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
		//To capture screenshot.
		File scrFile = ((TakesScreenshot) GoogleLogin.driver).getScreenshotAs(OutputType.FILE);
  	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
  	//If status = fail then set folder name "screenshots/Failures"
  	if(status.equalsIgnoreCase("fail")){
  		destDir = "screenshots/Failures";
  	}
  	//If status = pass then set folder name "screenshots/Success"
  	else if (status.equalsIgnoreCase("pass")){
  		destDir = "screenshots/Success";
  	}
  	
  	//To create folder to store screenshots
  	new File(destDir).mkdirs();
  	//Set file name with combination of test class name + date time.
  	String destFile = passfailMethod+" - "+dateFormat.format(new Date()) + ".png";
  	
      try {
      	//Store file at destination folder location
   	   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
      }
      catch (IOException e) {
           e.printStackTrace();
      }
 } 
}