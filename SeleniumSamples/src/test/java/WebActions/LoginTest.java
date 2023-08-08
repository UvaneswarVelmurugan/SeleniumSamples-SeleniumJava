package WebActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends webActions.loginXpathFile {
	WebDriver driver;

	@BeforeTest
	
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
  @Test(priority=1)
  @Parameters({"url","userId","pwdId","buttonText","username","password"})
  public void loginTest(String url,String user,String pwd,String button,String name,String pass) {
	  driver.get(url);
	  xpath(driver, user,pwd,button,name,pass); 
  }
  @AfterTest
	public void tearout() {
		driver.quit();
	}
}
