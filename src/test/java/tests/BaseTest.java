package tests;

import javax.swing.Box.Filler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class BaseTest {
	WebDriver driver;
	@FindBy(css = "[name='email']")
	private WebElement email;
	@FindBy(css = "[name='password']")
	private WebElement password;
	@FindBy(css = "[type='submit']")
	private WebElement loginBtn;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.involve.me/login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("avi.matnasoreq@gmail.com", "SeleniumTest123");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
