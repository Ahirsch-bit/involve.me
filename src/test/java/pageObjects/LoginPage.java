package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	@FindBy(css = "[name='email']")
	private WebElement email;
	@FindBy(css = "[name='password']")
	private WebElement password;
	@FindBy(css = "[type='submit']")
	private WebElement loginBtn;
	@FindBy(css = ".alert-danger")
	private WebElement wrongPw;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Step("login with: {mail}, and {pw}")
	public void login(String mail, String pw) {
		fillText(email, mail);
		fillText(password, pw);
		click(loginBtn);

	}

	public String getErrorMsg() {
		try {
			return getText(wrongPw);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}
