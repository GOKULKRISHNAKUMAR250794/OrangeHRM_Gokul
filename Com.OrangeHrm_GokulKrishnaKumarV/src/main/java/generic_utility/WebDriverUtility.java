package generic_utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
public void webPageScreenshot(WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File destination=new File(FrameWorkConstant.screenshotPath);
	FileHandler.copy(source, destination);
	}
public void webElementScreenshot(WebElement element) throws IOException {
	File source=element.getScreenshotAs(OutputType.FILE);
	File destination=new File(FrameWorkConstant.screenshotPath);
	FileHandler.copy(source, destination);
	
}
public void javascriptClick(WebDriver driver,WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",element);
	
}
public void selectByValue(WebElement element,String value) {
	Select select=new Select(element);
	select.selectByValue(value);
	
}
}
