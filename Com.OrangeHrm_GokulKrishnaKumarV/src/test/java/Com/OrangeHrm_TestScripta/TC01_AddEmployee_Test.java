package Com.OrangeHrm_TestScripta;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.orangehrm.pom.AddEmployee_Page;
import com.orangehrm.pom.EmployeeList_Page;

import generic_utility.BaseTest;

public class TC01_AddEmployee_Test extends BaseTest {
@Test
public void addEmployee() throws EncryptedDocumentException, IOException {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeClickable(homePage.getPim_Btn()));
	homePage.getPim_Btn().click();
	homePage.getAddEmployee_btn().click();
	AddEmployee_Page addEmployee=new AddEmployee_Page(driver); 
	wait.until(ExpectedConditions.elementToBeClickable(addEmployee.getFirstName_Txt()));
	addEmployee.getFirstName_Txt().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
	addEmployee.getMiddleName_Txt().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
	addEmployee.getLastName_Txt().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));
	addEmployee.getEmployeeId_Txt().sendKeys(Keys.CONTROL+"A");
	addEmployee.getEmployeeId_Txt().sendKeys(Keys.DELETE);	
	addEmployee.getEmployeeId_Txt().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 3));
	addEmployee.getSave_Btn().click();
	EmployeeList_Page employeeList=new EmployeeList_Page(driver);
	wait.until(ExpectedConditions.elementToBeClickable(employeeList.getDriversLNo_txt()));
	employeeList.getDriversLNo_txt().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
}
}
