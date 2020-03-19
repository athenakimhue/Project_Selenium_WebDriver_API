package selenium;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

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
	Select select;
	
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
		 select= new Select(find(By.xpath(" //select[@id='job2']")));
		 Assert.assertTrue(select.isMultiple());
		 select.selectByValue("automation");
		 select.selectByValue("mobile");
		 select.selectByValue("desktop");
		
		 List<WebElement> allSelected = select.getAllSelectedOptions();
		 int numberOfSelected=allSelected.size();
		 
		 //Cach 1
		 for(WebElement items : allSelected ) {
			 System.out.println(items.getText());
		 }
		 
		 //Cach 2
		 for (int i=0 ; i<numberOfSelected;i++)
		 {
			 System.out.println(allSelected.get(i).getText());
		 }
		 
		 //DeSelect
		 select.deselectAll();
		 Assert.assertEquals(select.getAllSelectedOptions().size(),0);
	}
	@Test
	public void TC_02_Handle_DropdownList_02() {
		driver.get("https://demo.nopcommerce.com/register");
		Select selectDay,selectMonth,selectYear;
		String email;
		email ="kimhue"+randomNumber()+"@gmail.com"; 
		find(By.xpath("//input[@id='gender-female']")).click();
		find(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		find(By.xpath("//input[@id='LastName']")).sendKeys("Brack");
		
		selectDay	= new Select(find(By.xpath("//select[@name='DateOfBirthDay']")));
		selectMonth = new Select(find(By.xpath("//select[@name='DateOfBirthMonth']")));
		selectYear = new Select(find(By.xpath("//select[@name='DateOfBirthYear']")));
	
		Assert.assertEquals(selectDay.getOptions().size(),32);
		Assert.assertEquals(selectMonth.getOptions().size(),13);
		Assert.assertEquals(selectYear.getOptions().size(),112);
		
		selectDay.selectByValue("1");
		selectMonth.selectByValue("5");
		selectYear.selectByValue("1980");
		
		find(By.xpath("//input[@id='Email']")).sendKeys(email);
		find(By.xpath("//input[@id='Password']")).sendKeys("12345678");
		find(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
		find(By.xpath("//input[@id='register-button']")).click();
		
		Assert.assertTrue(find(By.xpath(" //a[@class='ico-account']")).isDisplayed());
		Assert.assertTrue(find(By.xpath("//a[@class='ico-logout']")).isDisplayed());	
	}

	
	public WebElement find(By by){
		return driver.findElement(by);
	}
	public int randomNumber()
	{
		Random rand= new Random();
		int number=rand.nextInt(1000);
		return number;
	}
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}

}