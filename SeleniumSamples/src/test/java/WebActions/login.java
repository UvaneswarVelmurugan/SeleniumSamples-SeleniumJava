package WebActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import webActions.actions;

public class login extends actions{
	WebDriver driver;
	public static final By loginButton = By.xpath("//button[contains(text(),'Submit')]");
	public static final By userName = By.xpath("//input[@id='username']");
	public static final By password = By.xpath("//input[@id='password']");
	public static final By assertCheck = By.xpath("//h1[contains(text(),'Logged In Successfully')]");
	
	@BeforeTest
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	 @Parameters({"url"})
	  public void appInit(String url) {
		  driver.get(url);
	}
	
  @Test(priority=2)
  @Parameters({"username","password"})
  public void loginTest(String UserName, String Password) throws Throwable {
	    enterTextOn(driver, userName, UserName);
		enterTextOn(driver, password, Password);
		clickOn(driver, loginButton); 
		verification(driver,assertCheck); 
  }
  @AfterTest
	public void tearout() {
		driver.quit();
	}
}
