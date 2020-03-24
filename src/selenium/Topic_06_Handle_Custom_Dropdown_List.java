package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Handle_Custom_Dropdown_List {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor javascriptExe;

	@BeforeClass
	public void beforeClass() {
		driver 	= new ChromeDriver();
		wait 	= new WebDriverWait(driver,20);
		javascriptExe = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

//	@Test
//	public void TC_01_JQuery() throws Exception {
//		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
//		//Speed
//		selectItemInCustomDropdown("//span[@id='speed-button']","//ul[@id='speed-menu']//div","Fast");
//		Assert.assertTrue(verifyItemSelected("//span[@id='speed-button']/span[@class='ui-selectmenu-text' and text()='Fast']"));
//		selectItemInCustomDropdown("//span[@id='speed-button']","//ul[@id='speed-menu']//div","Medium");
//		Assert.assertTrue(verifyItemSelected("//span[@id='speed-button']/span[@class='ui-selectmenu-text' and text()='Medium']"));
//		selectItemInCustomDropdown("//span[@id='speed-button']","//ul[@id='speed-menu']//div","Slow");
//		Assert.assertTrue(verifyItemSelected("//span[@id='speed-button']/span[@class='ui-selectmenu-text' and text()='Slow']"));
//		
//
//		//Number
//		selectItemInCustomDropdown("//span[@id='number-button']","//ul[@id='number-menu']//div","4");
//		Assert.assertTrue(verifyItemSelected("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='4']"));
//		selectItemInCustomDropdown("//span[@id='number-button']","//ul[@id='number-menu']//div","12");
//		Assert.assertTrue(verifyItemSelected("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='12']"));
//		selectItemInCustomDropdown("//span[@id='number-button']","//ul[@id='number-menu']//div","19");
//		Assert.assertTrue(verifyItemSelected("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='19']"));
//
//		
//	}

	@Test
	public void TC_02_Angular() throws Exception {
		driver.get("https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding");
		
		selectItemInCustomDropdown("//ejs-dropdownlist[@id='games']//span[@class='e-input-group-icon e-ddl-icon e-search-icon']","//div[@id='games_popup']//li","Football");
		Assert.assertTrue(verifyItemSelected("//ejs-dropdownlist[@id='games']//option[contains(text(),'Football')]"));
		
	}

	@Test
	public void selectItemInCustomDropdown(String parentXpath, String childXpath, String expectedItem) throws Exception {
		//Click vao the chua all item de no dropdown ra
		driver.findElement(By.xpath(parentXpath)).click();
		
		//Wait cho den khi tat ca item duoc hien thi
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		
		//Dua tat ca item nay vao 1 list  element de duyet qua - sau do getText - compare voi text mong muon
		List<WebElement> allItems= driver.findElements(By.xpath(childXpath));
		
		//Dung vong lap de duyet qua
		for (WebElement item : allItems)
		{
			System.out.println("Item = "+ item.getText() );
			if (item.getText().equals(expectedItem)) {
				//Scroll to Element
				javascriptExe.executeScript("arguments[0].scrollIntoView(true);", item);
				Thread.sleep(1000);
				
				item.click();
				
				break;
			}
		}		
	}
	@Test
	public boolean verifyItemSelected(String xpathLocator) {
		boolean status=driver.findElement(By.xpath(xpathLocator)).isDisplayed();
		System.out.println("Status : "+status);
		if(status) return true;
		else return false;
	}

	public String getTextElement(String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator)).getText();
	}
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}

}