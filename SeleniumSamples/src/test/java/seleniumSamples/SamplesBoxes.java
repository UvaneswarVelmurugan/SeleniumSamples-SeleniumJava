package seleniumSamples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class SamplesBoxes {
	WebDriver driver;

	@BeforeMethod
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://trytestingthis.netlify.app/");
	}

	@Test(priority = 1)
	public void textBox() {
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Saai");
		String fname = driver.findElement(By.xpath("//input[@name='fname']")).getAttribute("value");
		String originalFname= "Saai";
		Assert.assertEquals(fname,originalFname);
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("Uvan");
		String lname = driver.findElement(By.xpath("//input[@name='lname']")).getAttribute("value");
		String originalLname= "Uvan";
		Assert.assertEquals(lname,originalLname);
	}

	@Test(priority = 2)
	public void radioButton() {
		WebElement radio=driver.findElement(By.xpath("//label[text()='Male']"));
		radio.click();
        Assert.assertTrue(radio.isEnabled());
	}

	@Test(priority = 3)
	public void dropDown() {
		Select singleSel = new Select(driver.findElement(By.id("option")));
		singleSel.selectByValue("option 2");
		WebElement Drop=driver.findElement(By.xpath("//select[@id='option']//option[@value='option 2']"));
				
		if(singleSel == Drop)
		{
			Assert.assertTrue(true);
		}
	}

	@Test(priority = 4)
	public void checkBoxes() {
		WebElement option1 = driver.findElement(By.xpath("//input[@name='option1']"));
        option1.click();
        Assert.assertTrue(option1.isSelected());
        WebElement option2 = driver.findElement(By.xpath("//input[@name='option2']"));
        option2.click();
        Assert.assertTrue(option2.isSelected());
	}

	@Test(priority = 5)
	public void numberTextBox() {
		driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("3");
		driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys(Keys.ARROW_UP);
		String date = driver.findElement(By.xpath("//input[@id='quantity']")).getAttribute("value");
		Assert.assertEquals(date,"4");
	}

	@Test(priority = 6)
	public void suggestionClass() {
		driver.findElement(By.xpath("//input[@name='Options']")).sendKeys("Mint");
		String date = driver.findElement(By.xpath("//input[@name='Options']")).getAttribute("value");
		Assert.assertEquals(date,"Mint");
		driver.findElement(By.xpath("//input[@name='Options']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@name='Options']")).sendKeys(Keys.ENTER);
		
	}

	@Test(priority = 7)
	public void dateSelect() {
		driver.findElement(By.xpath("//input[@id='day']")).sendKeys("10102023");
		String date = driver.findElement(By.xpath("//input[@id='day']")).getAttribute("value");
		Assert.assertEquals(date,"2023-10-10");
	}

	@Test(priority = 8)
	public void dragAndDrop() {
		WebElement drag = driver.findElement(By.id("drag1"));
		WebElement drop = driver.findElement(By.id("div1"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		boolean fileUploadAssert  = driver.findElement(By.xpath("//div//img[@id='drag1']")).isDisplayed();
		Assert.assertTrue(fileUploadAssert);
	}

	@Test(priority = 9)
	public void alertBox() {
		driver.findElement(By.xpath("//button[@onclick='alertfunction()']")).click();
		Alert alert = driver.switchTo().alert();
		String validText = alert.getText();
		Assert.assertEquals(validText, "Press a button!");
		alert.accept();
	}

	@Test(priority = 10)
	public void fileUpload() {
		driver.findElement(By.xpath("//input[@id='myfile']"))
				.sendKeys("C:\\Users\\uvaneswar.vel\\Downloads\\Software Testing Basics.docx");
		boolean fileUploadAssert  = driver.findElement(By.xpath("//input[@id='myfile']")).isDisplayed();
		Assert.assertTrue(fileUploadAssert);
	}

	@Test(priority = 11)
	public void slider() {
		WebElement slider = driver.findElement(By.xpath("//input[@id='a']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 90, 8).perform();
		boolean sliderAssert  = driver.findElement(By.xpath("//output[contains(text(),'100')]")).isDisplayed();
		Assert.assertTrue(sliderAssert);
	}

	@AfterMethod
	public void tearout() {
		driver.quit();
	}
}
