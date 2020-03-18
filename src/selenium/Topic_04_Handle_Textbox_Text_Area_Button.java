package selenium;

import java.util.Random;
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

public class Topic_04_Handle_Textbox_Text_Area_Button {
	WebDriver driver;
	String emailAddress, name, gender, dob1,dob2, address, city, state, pincode, telephone, emailid, password;  
	By nameTextboxBy	= By.xpath("//input[@name='name']");
	By genderBy			= By.xpath("//input[@value='f']");
	By dobBy			= By.xpath("//input[@id='dob']");
	By addressBy		= By.xpath("//textarea[@name='addr']");
	By cityBy			= By.xpath("//input[@name='city']");
	By stateBy			= By.xpath("//input[@name='state']");
	By pincodeBy		= By.xpath("//input[@name='pinno']");
	By telephoneBy		= By.xpath("//input[@name='telephoneno']");
	By emailIDBy		= By.xpath("//input[@name='emailid']");
	By paswordBy		= By.xpath("//input[@name='password']");
	By submitBy			= By.xpath("//input[@name='sub']");

	@BeforeClass
	public void beforeClass() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//		options.addArguments("window-size=1366x768");
//		driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		emailAddress= "kimhue" + numberRandom() + "@gmail.com";
	}

	/**
	 * @throws InterruptedException
	 */
	@Test
	public void TC_01() throws InterruptedException {

		//Step01
		driver.get("http://demo.guru99.com/v4/");
		
		//Step02
		find(By.xpath("//a[contains(text(),'here')]")).click();
		
		//Resistry Email:
		find(By.xpath("//input[@name='emailid']")).sendKeys(emailAddress);
		find(By.xpath("//input[@name='btnLogin']")).click();
		
		//GetText User/Password
		String usernameID,password;
		usernameID	= find(By.xpath("//td[contains(text(),'User ID :')]/following-sibling::td")).getText();
		password	= find(By.xpath("//td[contains(text(),'Password :')]/following-sibling::td")).getText();
		driver.get("http://demo.guru99.com/v4/");
		
		//Login
		find(By.xpath("//input[@name='uid']")).sendKeys(usernameID);
		find(By.xpath("//input[@name='password']")).sendKeys(password);
		find(By.xpath("//input[@name='btnLogin']")).click();
		String textHeading = find(By.xpath("//marquee[@class='heading3']")).getText();
		Assert.assertEquals(textHeading, "Welcome To Manager's Page of Guru99 Bank");
		
		//Step 06
		find(By.xpath("//a[contains(text(),'New Customer')]")).click();
		
		//Resgister New Customer
		name = "John";
		dob1 = "2010-01-01";
		dob2 = "01/01/2010";
		address = "Hung Yen";
		city = "Ha Noi";
		state = "Single";
		pincode = "123456";
		telephone = "12345678";
		password = "12345678";  
		
		find(nameTextboxBy).sendKeys(name);
		find(genderBy).click();
		find(dobBy).sendKeys(dob2);
		find(addressBy).sendKeys(address);
		find(cityBy).sendKeys(city);
		find(stateBy).sendKeys(state);
		find(pincodeBy).sendKeys(pincode);
		find(telephoneBy).sendKeys(telephone);
		find(emailIDBy).sendKeys(emailAddress);
		find(paswordBy).sendKeys(password);
		find(submitBy).click();
		Thread.sleep(5000);
		
		//Verify New Customer
		Assert.assertEquals(find(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(),name);
		Assert.assertEquals(find(By.xpath("//td[contains(text(),'Birthdate')]/following-sibling::td")).getText(), dob1);
		Assert.assertEquals(find(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
		Assert.assertEquals(find(By.xpath("//td[contains(text(),'City')]/following-sibling::td")).getText(), city);
		Assert.assertEquals(find(By.xpath("//td[contains(text(),'State')]/following-sibling::td")).getText(), state);
		Assert.assertEquals(find(By.xpath("//td[contains(text(),'Pin')]/following-sibling::td")).getText(), pincode);
		Assert.assertEquals(find(By.xpath("//td[contains(text(),'Mobile No.')]/following-sibling::td")).getText(), telephone);
		Assert.assertEquals(find(By.xpath("//td[contains(text(),'Email')]/following-sibling::td")).getText(), emailAddress);

		String customerID=find(By.xpath("//td[contains(text(),'Customer ID')]/following-sibling::td")).getText();
		System.out.println("CustomerID la :"+ customerID);
		
		//Edit Customer
		find(By.xpath("//a[contains(text(),'Edit Customer')]")).click();
		find(By.xpath("//input[@name='cusid']")).sendKeys(customerID);
		find(By.xpath("//input[@name='AccSubmit']")).click();
		
	}



	public int numberRandom() {
		Random rand= new Random();
		int number=rand.nextInt(2000);
		return number;
	}
	public WebElement find(By by){
		return driver.findElement(by);
	}
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}

}