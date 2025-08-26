package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//WebElement usernameTextBox=driver.findElement(By.xpath("input[@name=username"));
	
	public LoginPage() {
		
		//PageFactory.initElements(driver, this);
		super();
	}
	
	@FindBy(xpath = "//input[@name='username']") WebElement usernameTextbox;
	@FindBy(xpath = "//input[@name='password']") WebElement passwordTextbox;
	@FindBy(xpath = "//input[@name='login']")  WebElement loginButton;
	
	
	public void usernameTextbox(String text) {
		
		type(usernameTextbox, text);
		
	}
	
	public void passwordTextbox(String text) {
		type(passwordTextbox, text);
	}
	
	public void loginButton() {
		click(loginButton);
	}
	

	
}
