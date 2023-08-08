package webActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;

public class actions {
//	public  void initializingBrowser(String url) throws Throwable{
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get("https://trytestingthis.netlify.app/");
//        }
	public static void clickOn(WebDriver driver,By ele) throws Throwable{
        if(driver.findElement(ele).isDisplayed()) {
            driver.findElement(ele).click();
        }
    }
	public static void enterTextOn(WebDriver driver,By ele, String value) throws Throwable{
        if(driver.findElement(ele).isDisplayed()) {
            driver.findElement(ele).clear();
            driver.findElement(ele).sendKeys(value);
        }
    }
        public static void dropdown(WebDriver driver,By ele,String Method,String value) throws Throwable{
            if(driver.findElement(ele).isDisplayed()) {
            	Select singleSel = new Select(driver.findElement(ele));
				switch (Method) {
				case "byValue":
					singleSel.selectByValue(value);
					break;
				case "byIndex":
					int i=Integer.parseInt(value);
				    singleSel.selectByIndex(i);
					break;
				case "byVisibleText":
				    singleSel.selectByVisibleText(value);
					break;
				}
        		
            }
        }
        public static void verification(WebDriver driver,By ele) throws Throwable{
        	boolean AssertCheck  = driver.findElement(ele).isDisplayed();
    		Assert.assertTrue(AssertCheck);
            }
        
}

