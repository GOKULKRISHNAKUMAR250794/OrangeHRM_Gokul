package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeList_Page {
public EmployeeList_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//label[text()=\"Driver's License Number\"]/following::input[1]")
private WebElement driversLNo_txt;
@FindBy(xpath="//label[text()=\"Other Id\"]/following::input[1]")
private WebElement otherId_txt;
@FindBy(xpath="//label[text()=\"License Expiry Date\"]/following::div/div/div/input/following::i")
private WebElement licenseExpiry_widgets;
public WebElement getDriversLNo_txt() {
	return driversLNo_txt;
}
public WebElement getOtherId_txt() {
	return otherId_txt;
}
public WebElement getLicenseExpiry_widgets() {
	return licenseExpiry_widgets;
}

}
