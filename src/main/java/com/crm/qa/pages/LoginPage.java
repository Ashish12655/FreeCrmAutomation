package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {

	TestUtil testUtils;
	// Page Factory

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li[2]/a")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[@alt='free crm logo']")
	WebElement crmLogo;

	// Initializing the Page Object
	public LoginPage() {
		PageFactory.initElements(driver, this);
		testUtils = new TestUtil();
	}

	// Actions :-

	public String validationLoginPageTitle() {

		return driver.getTitle();
	}

	public boolean validateCRMImage() {

		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pa) {
		username.sendKeys(un);
		password.sendKeys(pa);
		loginBtn.submit();
		
		return new HomePage();
	}
}