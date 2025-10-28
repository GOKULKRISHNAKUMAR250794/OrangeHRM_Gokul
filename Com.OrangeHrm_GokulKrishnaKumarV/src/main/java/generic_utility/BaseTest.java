package generic_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orangehrm.pom.Home_Page;
import com.orangehrm.pom.Login_Page;

public class BaseTest {
	public WebDriver driver;
	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public FileUtility fileUtility=new FileUtility();
	public Login_Page loginPage;
	public WebDriverWait wait;
	public Home_Page homePage=new Home_Page(driver);
	
@BeforeSuite
public void beforeSuite() {
	System.out.println("connection of the database");
}
@BeforeTest
public void beforeTest() {
	System.out.println("external report---------started");
	spark =new ExtentSparkReporter(FrameWorkConstant.reportsPath);
	reports=new ExtentReports();
	reports.attachReporter(spark);
    test=reports.createTest("Login");
}
@BeforeClass
public void beforeClass() throws IOException {
	System.out.println("launching browsers-------");
	String browserName=fileUtility.readDataFromPropertyFile("browser");
	String url=fileUtility.readDataFromPropertyFile("url");
	if(browserName.equalsIgnoreCase("Chrome")) {
		driver=new ChromeDriver();
		}
	else if(browserName.equalsIgnoreCase("Edge")) {
		driver=new EdgeDriver();
	}
	else if(browserName.equalsIgnoreCase("FireFox")) {
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("please provide the valid browser name");
		throw new RuntimeException();
	}
	sDriver=driver;
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(url);
	}
@BeforeMethod
public void beforeMethod() throws IOException {
	
	loginPage=new Login_Page(driver);
	wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeClickable(loginPage.getUserName_Txt()));
	loginPage.getUserName_Txt().sendKeys(fileUtility.readDataFromPropertyFile("userName"));
	loginPage.getPassword_Txt().sendKeys(fileUtility.readDataFromPropertyFile("password"));
	loginPage.getLogin_Btn().click();
	homePage=new Home_Page(driver);
	
}
@AfterMethod
public void afterMethod() {
	System.out.println("logout");
	homePage.getProfile_Icon().click();
	homePage.getLogout_Btn().click();
}
@AfterClass
public void afterClass() throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();
}
@AfterTest
public void afterTest() {
	System.out.println("extent reports stops..........");
	reports.flush();
}
@AfterSuite
public void afterSuite() {
	System.out.println("disconnect the database......");
}

}
