package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class BasePage extends BaseTest {
	
	
	public BasePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void type(WebElement element, String text) {


		waitForElementPresence(element);
		
		element.sendKeys(text);
		test.log(Status.INFO, "Enetered text into the text box");
		
	}

	private void waitForElementPresence(WebElement element) {
		
		WebDriverWait myWait= new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(p.getProperty("explicitWait"))));
		myWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(WebElement elemnet) {
		
		waitForElementPresence(elemnet);
		
		elemnet.click(); 
		test.log(Status.INFO, "Clicked the button");
		
	}
	
	private String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	public void verifyTextPresenceAsValue(WebElement element, String text) {
		
		Assert.assertTrue(element.getAttribute("value").contains(text));
		
		
		
	}
	
	public void verifyTitle(String expTitle) {
		
		Assert.assertEquals(getTitle(), expTitle);
		test.log(Status.PASS, "Titles are matched");
		
	}

	
	

}
