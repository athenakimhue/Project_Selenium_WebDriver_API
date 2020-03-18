package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_WebElement_API_Commands_2 {
	WebDriver driver;
	By emailTextboxBy		= By.xpath("//input[@id='mail']");
	By ageUder18RadioBy		= By.xpath("//input[@id='under_18']");
	By educationTextAreaBy	= By.xpath("//textarea[@id='edu']");
	By jobRole01DropdownBy	= By.xpath("//select[@id='job1']");
	By jobRole03DropdownBy	= By.xpath("//select[@id='job3']");
	By slide01By			= By.xpath("//input[@id='slider-1']");
	By slide02By			= By.xpath("//input[@id='slider-2']");
	By interestEnableBy		= By.xpath("//input[@id='development']") ;
	By passwordTextboxBy	= By.xpath("//input[@id='password']");
	By ageDisableBy			= By.xpath("//input[@id='radio-disabled']");
	By bioBy				= By.xpath("//textarea[@id='bio']");
	By interestDisableBy	= By.xpath("//input[@id='check-disbaled']");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://automationfc.github.io/basic-form/index.html");
	}

	@Test
	public void TC_01_Test_isDislay() {
		driver.navigate().refresh();
		if (isElementDisplayed(emailTextboxBy)) {
			senKeyToElement(emailTextboxBy,"A@gmail.com");
		}
		
		if(isElementDisplayed(ageUder18RadioBy)) {
			clickToElement(ageUder18RadioBy);
		}
		
		if(isElementDisplayed(educationTextAreaBy)) {
			senKeyToElement(educationTextAreaBy, "KMA");
		}
				
		
	}

	@Test
	public void TC_02_Test_enable_disable() {
			driver.navigate().refresh();
		//--Test
			//--Enable
			checkTrue(isElementEnabled(emailTextboxBy));
			checkTrue(isElementEnabled(ageUder18RadioBy));
			checkTrue(isElementEnabled(educationTextAreaBy));
			checkTrue(isElementEnabled(jobRole01DropdownBy));
			checkTrue(isElementEnabled(interestEnableBy));
			checkTrue(isElementEnabled(slide01By));
			
			//--Disable
			checkFalse(isElementEnabled(passwordTextboxBy));
			checkFalse(isElementEnabled(ageDisableBy));
			checkFalse(isElementEnabled(bioBy));
			checkFalse(isElementEnabled(interestDisableBy));
			checkFalse(isElementEnabled(jobRole03DropdownBy));
			checkFalse(isElementEnabled(slide02By));
	
	}

	@Test
	public void TC_03_Test_isSelected() {
		driver.navigate().refresh();
	
		clickToElement(ageUder18RadioBy);
		clickToElement(interestEnableBy);
	
		checkTrue(isElementSelected(ageUder18RadioBy));
		checkTrue(isElementSelected(interestEnableBy));
		
		clickToElement(interestEnableBy);
		checkFalse(isElementSelected(interestEnableBy));	
	}
	
	//--------------------------------FUNCTION--------------------------
	//find_function
	public WebElement find(By by) {
		return driver.findElement(by);
	}
	
	//click_function
	public void clickToElement(By by) {
		WebElement element= find(by);
		element.click();
	}
	
	//sendkey_function
	public void senKeyToElement(By by, String value) {
		WebElement element= find(by);
		element.sendKeys(value);
	}
	
	//isDisplayed_function
	public boolean isElementDisplayed(By by){
		WebElement element= find(by);
		if (element.isDisplayed()) {
			System.out.print("Element with by ["+by+"] is Displayed");
			return true;
		}else{
			System.out.print("Element with by ["+by+"] is Un-Displayed");
			return false;
		}
	}
	
	//isEnable_function
	public boolean isElementEnabled(By by){
			WebElement element= find(by);
			if (element.isEnabled()) {
				System.out.print("Element with by ["+by+"] is Enabled");
				return true;
			}else{
				System.out.print("Element with by ["+by+"] is Disabled");
				return false;
			}
		}
	
	//isSelected_function
	public boolean isElementSelected(By by){
		WebElement element= find(by);
		if (element.isSelected()) {
			System.out.print("Element with by ["+by+"] is Selected");
			return true;
		}else{
			System.out.print("Element with by ["+by+"] is de-Selected");
			return false;
		}
	}
	
	//checkTrue
	public void checkTrue(Boolean status)
	{
		Assert.assertTrue(status);
	}
	
	//checkFalse
	public void checkFalse(Boolean status)
	{
		Assert.assertFalse(status);
	}
	
	//Sleep_function
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}