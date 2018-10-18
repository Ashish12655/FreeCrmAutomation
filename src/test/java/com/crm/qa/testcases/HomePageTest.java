package com.crm.qa.testcases;

import junit.framework.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtils;
	ContactsPage contactsPage;

	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		testUtils = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),
				prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals("HomePage title not matched", "CRMPRO", title);
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtils.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectuserName());
	}

	@Test(priority = 3)
	public void verifyContactLinkTest() {
		testUtils.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
