package selenium;

import java.awt.Dimension;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class Topic_02_WebBrowser_API_Commands_1 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();

	}

	@Test
	public void TC_01_WebBrowser_API() {
	//NOTE: -----------------WebBrowser API:
		
		//Mở 1 page: GET
		driver.get("http://live.demoguru99.com/index.php/customer/account/login");
		
		//Đóng trình duyệt - Đóng tab đang active
		//driver.close();//Xử lí window or tab
		
		//Đóng trình duyệt - Đóng all tab
		//driver.quit();
		
		//Thao tác 1 Element
		WebElement emailTextbox=driver.findElement(By.cssSelector("#email"));
		emailTextbox.sendKeys("kimhue@gmail.com");
		
		//Thao tác nhiều Element
		List <WebElement> homepage= driver.findElements(By.tagName("a"));
		for (WebElement link : homepage )
		{
			System.out.println("Link = " + link.getAttribute("href"));
		}
		
		//Lấy url hiện tại của page
		String HomPageUrl=driver.getCurrentUrl();
		
		//Lấy ra source code của page hiện tại
		String HomePageSource=driver.getPageSource();
		Assert.assertTrue(HomePageSource.contains("If you have an account with us, please log in"));
		
		//Lấy title
		driver.getTitle();
		
		
		//Lấy id tab hiện tại :
		String handle=driver.getWindowHandle();
		System.out.println("Handle: " + handle);
		
		//Lấy id các tab
		Set<String> handles=driver.getWindowHandles();
		
		
		//---------Thao tác manager()
			//Thao tac với cookie: Add/ Del/ Get
			driver.manage().deleteAllCookies();
			
			//Thao tác với logs:
			driver.manage().logs().get(LogType.DRIVER);
			
			//Thao tác timeout: 
				//chờ cho Element được visiable/display để thao tác
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				//chờ cho 1 page được load
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				
			//Thao tác với Window- Test GUI
				driver.manage().window().fullscreen();
				driver.manage().window().maximize();
				
		//--------Thao tac với navigate
				driver.navigate().back();
				driver.navigate().forward();
				driver.navigate().refresh();
				
				//Mở ra 1 Url (có thể tracking(lưu lại history)có thể back/forward/...)
				driver.navigate().to("http://live.demoguru99.com/index.php/customer/account/login");
				
		//----------Thao tác Alert
				
				driver.switchTo().alert().accept();
				driver.switchTo().alert().dismiss();
				driver.switchTo().alert().getText();
				driver.switchTo().alert().sendKeys("hi");
				
		//-------------Lấy ID của driver
				driver.toString();	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}