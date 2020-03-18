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



@Test
public class Topic_01_Locator_In_Selenium_1 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
	}
	
	public void TC_01_Id() throws Exception {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login");
		driver.findElement(By.id("email")).sendKeys("kim@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Abc@1234");
		driver.findElement(By.id("send2")).click();
		
	}
	
	//LinkText + PartialLinkText
	public void TC_02_Link() throws Exception {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login");
		driver.findElement(By.linkText("SITE MAP")).click();
		driver.findElement(By.partialLinkText("PRIVACY")).click();
	}
	//---------------------------------------------CSS--------------------------------------
	//1. id : #email
	//2. class: .validate-email
	//3. Tagname - Attribute - Value of attribute
	//------Tagname: <input>, <br>, <div>
	//	----Cú pháp : tagname[attribute='value']
	//  ----Ví dụ: input[id='email']   |  input[title='Email Address'] | input[xpath='1'] | input[spellcheck='false']
	
//	<input type="email" 
//	autocapitalize="off" autocorrect="off" spellcheck="false" 
//	name="login[username]" 
//	id="email" 
//	class="input-text required-entry validate-email" 
//	title="Email Address" 
//	xpath="1">
	
	public void TC_03_CssSelector() {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login");
		driver.findElement(By.cssSelector("#email")).sendKeys("A@gmail.com");
		driver.findElement(By.cssSelector("#email")).clear();//id
		driver.findElement(By.cssSelector(".validate-email")).sendKeys("A@gmail.com");
		driver.findElement(By.cssSelector(".validate-email")).clear();
		driver.findElement(By.cssSelector("input[spellcheck='false']")).sendKeys("A@gmail.com");
		driver.findElement(By.cssSelector("input[spellcheck='false']")).clear();
		driver.findElement(By.cssSelector("input[autocorrect='off']")).sendKeys("A@gmail.com");	
		driver.findElement(By.cssSelector("input[autocorrect='off']")).clear();
	}

	//--------------------------------------------Xpath---------------------------
	//----Cú pháp : //tagname[@attribute='value']
	//----Xpath : //cha//con: 
	//----------------> ví dụ: //form[@id='login-form']//input[@class='input-text required-entry validate-email']
	
	//----Nếu value of attribute class dài quá có thể thu gọn bằng contains:
	//----------------> ví dụ: //form[@id='login-form']//input[contains(@class,'input-text required-entry validate-email')]
	
	public void TC_04_Xpath()
	{
		driver.get("http://live.demoguru99.com/index.php/customer/account/login");
		driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("A@gmail.com");	
		driver.findElement(By.xpath("//input[@spellcheck='false']")).clear();
		driver.findElement(By.xpath("//form[@id='login-form']//input[@class='input-text required-entry validate-email']")).sendKeys("a@gmial.com");
		driver.findElement(By.xpath("//form[@id='login-form']//input[contains(@class,'validate-email')]")).sendKeys("a@gmial.com");
		
	}
	
	//---------------------------------------Tagname--------------------
	//----Đếm sô thẻ (tagname) có trong page:
	public void TC_05_Tagname()
	{
		driver.get("http://live.demoguru99.com/index.php/customer/account/login");
		System.out.println("Links in My Account Page: "+ driver.findElement(By.tagName("a")).getSize());
		System.out.println("Button in My Account Page: "+ driver.findElement(By.tagName("button")).getSize());
		System.out.println("Textboxes or Radio or Checkbox or Upload in My Account Page: "+ driver.findElement(By.tagName("input")).getSize());
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}