package webActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginXpathFile {
	
	public static void xpath(WebDriver driver,String user,String pwd,String button,String UserName,String Password) {
		WebElement userName = driver.findElement(By.xpath("//input[@id='"+user+"']"));
	    userName.sendKeys(UserName);
		WebElement password = driver.findElement(By.xpath("//input[@id='"+pwd+"']"));
		password.sendKeys(Password);
		WebElement Button = driver.findElement(By.xpath("//button[contains(text(),'"+button+"')]"));
		Button.click();
	}

}
