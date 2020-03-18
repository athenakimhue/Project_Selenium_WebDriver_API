package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Locator_In_Selenium_2 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
	}

	@Test
	public void TC_01_Login_With_EP_Empty() {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("#advice-required-entry-email")).getText(), "This is a required field.");
	}

	@Test
	public void TC_02_Login_With_Email_Invalid() {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.findElement(By.cssSelector("#email")).sendKeys("12341234@12341234");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
		
	}

	@Test
	public void TC_03_Login_With_Password_Less_Than_6_Characters () {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.findElement(By.cssSelector("#email")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("#pass")).sendKeys("123");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		String error_message=driver.findElement(By.cssSelector("#advice-validate-password-pass")).getText();
		Assert.assertEquals(error_message,"Please enter 6 or more characters without leading or trailing spaces.");
	}
	@Test
	public void TC_04_Login_With_Password_Incorrect() 
	{
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.findElement(By.cssSelector("#email")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("#pass")).sendKeys("123123123123");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		String error_message= driver.findElement(By.xpath("//span[contains(text(),'Invalid login or password.')]")).getText();
		Assert.assertEquals(error_message,"Invalid login or password.");
		
		
		//NOTE:------------------Hàm sủ dụng để verify dữ liệu- ASSERT
		Assert.assertEquals(error_message, "Invalid login or password.");
		Assert.assertTrue(error_message.equals("Invalid login or password."));
		Assert.assertTrue(error_message.contains("Invalid login"));	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	

}


