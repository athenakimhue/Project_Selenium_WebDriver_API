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

public class Topic_02_WebBrowser_API_Commands_2 {
	WebDriver driver;
	String LoginPageUrl="http://live.demoguru99.com/index.php/customer/account/login/";
	String RegisterPageUrl="http://live.demoguru99.com/index.php/customer/account/create/";
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC_01_Verify_Url() {
		driver.get(LoginPageUrl);
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		String LoginPageCurentUrl=driver.getCurrentUrl();
		Assert.assertEquals(LoginPageCurentUrl,LoginPageCurentUrl);
		driver.findElement(By.xpath("//a[@class='button']")).click();
		String RegisterPageCurentUrl=driver.getCurrentUrl();
		Assert.assertEquals(RegisterPageCurentUrl,RegisterPageCurentUrl);
	}

	@Test
	public void TC_02_Verify_Title() {
		driver.get(LoginPageUrl);
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		String LoginPageTitle=driver.getTitle();
		Assert.assertEquals(LoginPageTitle,"Customer Login");
		driver.findElement(By.xpath("//a[@class='button']")).click();
		String RegisterPageTitle=driver.getTitle();
		Assert.assertEquals(RegisterPageTitle,"Create New Customer Account");
		
	}

	@Test
	public void TC_03_Navigate_Function() {
		driver.get(LoginPageUrl);
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		driver.findElement(By.xpath("//a[@class='button']")).click();
		String RegisterPageCurentUrl=driver.getCurrentUrl();
		Assert.assertEquals(RegisterPageCurentUrl,RegisterPageUrl);
		driver.navigate().back();
		String LoginPageCurentUrl=driver.getCurrentUrl();
		Assert.assertEquals(LoginPageCurentUrl,LoginPageUrl);
		driver.navigate().forward();
		String RegisterPageCurentUrlFoward=driver.getCurrentUrl();
		Assert.assertEquals(RegisterPageCurentUrlFoward,RegisterPageUrl);
		
	}
	
	@Test
	public void TC_04_Get_Page_Source_Code(){
		driver.get(LoginPageUrl);
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		String LoginPageSourceCode=driver.getPageSource();
		Assert.assertTrue(LoginPageSourceCode.contains("Login or Create an Account"));
		driver.findElement(By.xpath("//a[@class='button']")).click();
		String RegisterPageSourceCode=driver.getPageSource();
		Assert.assertTrue(RegisterPageSourceCode.contains("Create an Account"));
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}