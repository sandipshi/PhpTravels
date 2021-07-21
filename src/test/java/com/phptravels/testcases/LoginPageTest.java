package com.phptravels.testcases;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.base.TestBase;
import com.phptravels.pages.LoginPage;
import com.phptravels.utils.Log;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
		Log.info("Constructor has been initialized");
		
	}
	
	@Test(priority=1)
	public void verifyTitleofPage() {
		Assert.assertTrue(loginpage.verifyTitle(),"Title is not displayed");
		Log.info("Verified Title of the page successfully");
	}
	
	@Test(priority=2)
	public void verifySubtextOfTitlePage() {
		Assert.assertTrue(loginpage.verifyTitleSubtext(),"Subtext of title is not displayed");
		Log.info("Verified subtext of Title of the page successfully");
	}
	
	@Test(priority=3)
	public void clickOnLoginButton() {
		loginpage.clickOnLogin();
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String Parent=it.next();
		String child=it.next();
		
		driver.switchTo().window(child);
		Log.info("Successfully focus has been on child window");
		Assert.assertTrue(loginpage.verifyLoginPageHeader());
	}
	
	@Test(priority=0)
	public void navigateToTest() {
		driver.navigate().to("https://www.javatpoint.com/selenium-webdriver-navigation-commands");
		
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		Log.info("Closed the Browser");
	}

}
