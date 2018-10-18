package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SignUpPage;

public class SignUpTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@Test
	public void signUp() throws InterruptedException {
		SignUpPage signUpPage = new SignUpPage();
		signUpPage.doRegistration("Ashish", "Kumar", "test@gmail.com",
				"AshishTest", "password");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
