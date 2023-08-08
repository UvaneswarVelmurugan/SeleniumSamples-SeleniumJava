package WebActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import webActions.actions;

public class radioAndCheckAction extends actions{
	WebDriver driver;
	public static final By radioButton = By.xpath("//label[text()='Male']");
	public static final By checkBox = By.xpath("//input[@name='option1']");
	public static final By dropDown = By.id("option");
	public static final By dropDownOption = By.xpath("//option[@value='option 1']");
	
	@BeforeTest
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://trytestingthis.netlify.app/");
	}
//	@BeforeTest
//	@Parameters({"url"})
//	public void initializingBrowser(String url)
//	{
//		initializingBrowser(url);
//	}
	@Test(priority = 1)
	public void clickingOnRadioButton() throws Throwable {
		clickOn(driver,radioButton);
	}
	@Test(priority = 2)
	public void ClickingOnCheckBoxes() throws Throwable {
		clickOn( driver,checkBox);
	}
	@Test(priority = 3)
	@Parameters({"Method","value"})
	public void ClickingOnDropDown(String method,String option) throws Throwable {
		
		dropdown(driver,dropDown,method,option);
	}
	@AfterTest
	public void tearout() {
		driver.quit(); 
	}
}
