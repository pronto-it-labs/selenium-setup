package com.prontoitlabs.testDemo;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {
	@Test
	public void shouldBeAbleToLogin() {

		WebDriver driver = login("Enter your Email Id here", "Enter your Password here");

		new WebDriverWait(driver, 25).until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//*[contains(.,'Sign out')]")));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://mail.google.com/mail/u/0/"));

		// driver.quit();
	}

	public static WebDriver login(String userName, String passwordString) {
		System.setProperty("webdriver.chrome.driver",
				"/home/neha/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail");

		WebElement email = driver.findElement(By.name("Email"));

		email.sendKeys(userName);
		WebElement password = driver.findElement(By.name("Passwd"));

		password.sendKeys(passwordString);

		password.submit();
		return driver;
	}

}
