package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class SignUpPage extends TestBase {

	@FindBy(id = "payment_plan_id")
	WebElement editionSelection;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "surname")
	WebElement lastName;

	@FindBy(name = "email")
	WebElement emailField;

	@FindBy(name = "email_confirm")
	WebElement confirmEmail;

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "passwordconfirm")
	WebElement passwordConfirm;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement iAgree;

	@FindBy(xpath = "//button[contains(text(),'SUBMIT')]")
	WebElement submitTab;

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public void doRegistration(String fName, String lName, String email,
			String uName, String pass) throws InterruptedException {

		/*
		 * ExpectedCondition<Boolean> pageLoadCondition = new
		 * ExpectedCondition<Boolean>() { public Boolean apply(WebDriver driver)
		 * { return ((JavascriptExecutor) driver).executeScript(
		 * "return document.readyState").equals("complete"); } }; WebDriverWait
		 * wait = new WebDriverWait(driver, 100); wait.until(pageLoadCondition);
		 */
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//ul[@class='nav navbar-nav navbar-right']/li//font"))
				.click();
		Select selectEdition = new Select(editionSelection);
		selectEdition.selectByVisibleText("Free Edition");
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		emailField.sendKeys(email);
		confirmEmail.sendKeys(email);
		username.sendKeys(uName);
		password.sendKeys(pass);
		passwordConfirm.sendKeys(pass);
		iAgree.click();
		submitTab.click();

	}
}
