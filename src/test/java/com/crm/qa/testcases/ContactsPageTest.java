package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	TestUtil testUtils;
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();

		testUtils = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		testUtils.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLable() {
		Assert.assertTrue(contactsPage.verifyContactLabel(),
				"Contact label is missing on page");
	}

	@Test(priority =2)
	public void selectSingleContact() {
		contactsPage.selectContactByName("Ashish Kumar");
	}

	@Test(priority = 3, enabled = false)
	public void selectMutipleContact() {
		contactsPage.selectContactByName("Ashish Kumar");
		contactsPage.selectContactByName("Umesh Chor");

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);

		return data;

	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName,
			String lastName, String company) {
		homePage.clickOnNewContactLink();
		contactsPage.creatNewContact(title, firstName, lastName, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
