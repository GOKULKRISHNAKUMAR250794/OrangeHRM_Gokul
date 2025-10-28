package generic_utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersUtility implements ITestListener {
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot)BaseTest.sDriver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(FrameWorkConstant.screenshotPath);
		try {
			FileHandler.copy(source, destination);
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
