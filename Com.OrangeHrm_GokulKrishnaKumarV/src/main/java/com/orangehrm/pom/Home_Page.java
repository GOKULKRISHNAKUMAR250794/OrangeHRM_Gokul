package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
public Home_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//i[contains(@class,'oxd-icon bi-care')]")
private WebElement profile_Icon;
@FindBy(xpath="//a[text()='Logout']")
private WebElement logout_Btn;
public WebElement getProfile_Icon() {
	return profile_Icon;
}
public WebElement getLogout_Btn() {
	return logout_Btn;
}
@FindBy(xpath="//span[text()='PIM']")
private WebElement pim_Btn;
@FindBy(xpath="//a[text()='Add Employee']")
private WebElement addEmployee_btn;
public WebElement getPim_Btn() {
	return pim_Btn;
}
public WebElement getAddEmployee_btn() {
	return addEmployee_btn;
}

}
