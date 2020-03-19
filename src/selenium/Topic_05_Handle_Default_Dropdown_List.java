package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Handle_Default_Dropdown_List {
	WebDriver driver;
	Select select,select1;
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test
	public void TC_01_Handle_DropdownList_01() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		select = new Select(find(By.xpath("//select[@id='job1']")));
		Assert.assertFalse(select.isMultiple());
		
		//Select text
		select.selectByVisibleText("Mobile Testing");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Testing");
		
		//Select value
		select.selectByValue("manual");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Manual Testing");
		
		//Select Index
		select.selectByIndex(9);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Functional UI Testing");
		
		
		 List<WebElement> ItemAll = select.getOptions();
		 Assert.assertEquals(ItemAll.size(),10);
		 
		 //Multiple
		 select1= new Select(find(By.xpath(" //select[@id='job2']")));
		 Assert.assertTrue(select1.isMultiple());
		 
		
		
	}
	@Test
	public void TC_02_Handle_DropdownList_02() {
		
	}

	
	public WebElement find(By by){
		return driver.findElement(by);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}