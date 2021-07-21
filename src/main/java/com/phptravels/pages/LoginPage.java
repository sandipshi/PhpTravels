package com.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.base.TestBase;

public class LoginPage extends TestBase {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="PHPTRAVELS")
	@CacheLookup
	WebElement title;
	
	@FindBy(id="TRAVEL_TECHNOLOGY_PARTNER")
	@CacheLookup
	WebElement titlesubtext;
	
	@FindBy(id="header-title")
	@CacheLookup
	WebElement headerTitle;
	
	@FindBy(xpath="//a[text()='Login']")
	@CacheLookup
	WebElement loginElement;
	
	@FindBy(xpath="//h1//small")
	@CacheLookup
	WebElement loginPageHeaderElement;
	
	public boolean verifyTitle() {
		return title.isDisplayed();
	}
	
	public boolean verifyTitleSubtext() {
		return titlesubtext.isDisplayed();
	}
	
	public boolean verifyHeaderTitle() {
		return headerTitle.isDisplayed(); 
	}
	
	public void clickOnLogin() {
		loginElement.click();
	}
	
	public boolean verifyLoginPageHeader() {
		return loginPageHeaderElement.isDisplayed();
	}
	

}
