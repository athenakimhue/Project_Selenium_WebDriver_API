package selenium;

import java.util.List;
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

public class Topic_03_WebElement_API_Commands_1 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		WebElement emailTextbox=driver.findElement(By.xpath("//input[@id='email']"));
		emailTextbox.sendKeys("a@gmail.com");
		emailTextbox.clear();
		sleepInSecond(1);
		
		//Khai báo 1 list Element:
		List<WebElement> button=driver.findElements(By.xpath("//button"));
		System.out.println("Số button là:" + button.size());
		
		//Sub-Element
		WebElement registerForm= driver.findElement(By.id("reg_form_box"));
		registerForm.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys("Kim Huế");
		sleepInSecond(2);
		
		//Attribute
		WebElement phoneTextbox= driver.findElement(By.xpath("//input[@id='u_0_r']"));
		String phoneAttributeValue=phoneTextbox.getAttribute("aria-label");
		System.out.println("Attribute phone : "+phoneAttributeValue );
		
		
		//CssValue
		WebElement loginButton= driver.findElement(By.id("loginbutton"));
		
		String loginButtonBackgroundColor	=	loginButton.getCssValue("background-color");
		String loginButtonFont				=	loginButton.getCssValue("font-family");
		String loginButtonTagname			=	loginButton.getTagName(); //getTagname: Từ attribute -> tagname
		
		System.out.println("Background Color Button:"	+loginButtonBackgroundColor);
		System.out.println("Font-style Button:"			+loginButtonFont);
		System.out.println("Tagname Button:"			+loginButtonTagname);
		
		//getTEXT
		WebElement emailLabel=driver.findElement(By.xpath("//label[@for='email']"));
		String emailLabelText=emailLabel.getText();
		System.out.println("Email Label Text:"+emailLabelText);
	
		//isDisplayed (Kiểm tra element có hiển thị hay ko: True/False)
		//Assert.assertTrue(loginButton.isDisplayed());
		
		//isSelected (Kiểm tra Element đã dc chọn hay chưa?)
		WebElement maleRadioButton=driver.findElement(By.xpath("//label[text()='Nam']/preceding-sibling::input"));//  --- //label[contains(text(),'Male')]/preceding-sibling::input
		Assert.assertFalse(maleRadioButton.isSelected());
		maleRadioButton.click();
		Assert.assertTrue(maleRadioButton.isSelected());
		
		//submit- hoạt động như click(). chỉ dc sử dụng với form.
		driver.findElement(By.xpath("//input[@id='email']")).submit();
		sleepInSecond(5);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long time)
	{
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}