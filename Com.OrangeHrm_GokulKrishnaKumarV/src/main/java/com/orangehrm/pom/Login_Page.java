package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
public Login_Page(WebDriver driver){
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@name='username']")
private WebElement userName_Txt;
@FindBy(xpath="//input[@name='password']")
private WebElement password_Txt;
@FindBy(xpath="//button[contains(@class,'oxd-butto')]")
private WebElement Login_Btn;
@FindBy(xpath="//p[contains(@class,'oxd-text oxd-text--p orangehrm-lo')]")
private WebElement forgotPassword_Link;
public WebElement getUserName_Txt() {
	return userName_Txt;
}
public WebElement getPassword_Txt() {
	return password_Txt;
}
public WebElement getLogin_Btn() {
	return Login_Btn;
}
public WebElement getForgotPassword_Link() {
	return forgotPassword_Link;
}

}
