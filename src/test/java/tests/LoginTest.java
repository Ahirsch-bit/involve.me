package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.LoginPage;
import utilities.AllureAttachment;

public class LoginTest extends BaseTest {

	// login test
	@Severity(SeverityLevel.CRITICAL)
	@Link("https://app.involve.me/login")
	@Description("This tests the ability to log in with proper credentials.")
	@Test(enabled = false)
	public void login() {
		driver.quit();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		LoginPage loginpage = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get("https://app.involve.me/login");
		loginpage.login("avi.matnasoreq@gmail.com", "SeleniumTest123");
		String expected = null;
		String actual = loginpage.getErrorMsg();
		Assert.assertEquals(actual, expected);
		AllureAttachment.addTextAttachment("stuff");

	}

	// wrong pw test
	@Severity(SeverityLevel.CRITICAL)
	@Link("https://app.involve.me/login")
	@Description("This tests attempts to log in with wrong credentials.")
	@Test(enabled = true)
	public void wrongPw(){
		driver.quit();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		LoginPage loginpage = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get("https://app.involve.me/login");
		loginpage.login("avi@google.com", "1234");
		String expected = "These credentials do not match our records.";
		String actual = loginpage.getErrorMsg();
		Assert.assertEquals(actual, expected);
		AllureAttachment.addTextAttachment("Using incogneto browser");
	}

}
