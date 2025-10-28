package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee_Page {
	public AddEmployee_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//input[@name='firstName']")
private WebElement firstName_Txt;
@FindBy(xpath="//input[@name='middleName']")
private WebElement middleName_Txt;
@FindBy(xpath="//input[@name='lastName']")
private WebElement lastName_Txt;
@FindBy(xpath="//label[text()='Employee Id']/following::input[1]")
private WebElement employeeId_Txt;
@FindBy(xpath="//button[@type='submit']")
private WebElement save_Btn;
public WebElement getFirstName_Txt() {
	return firstName_Txt;
}
public WebElement getMiddleName_Txt() {
	return middleName_Txt;
}
public WebElement getLastName_Txt() {
	return lastName_Txt;
}
public WebElement getEmployeeId_Txt() {
	return employeeId_Txt;
}
public WebElement getSave_Btn() {
	return save_Btn;
}


}
