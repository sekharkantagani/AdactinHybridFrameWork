package regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateLoginUsingPOM extends BasePage {
	
	
	
	@Test
	public void validateLoginTest() {
		
	
	LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
	
	loginPage.usernameTextbox("reyaz0806");
	loginPage.passwordTextbox("reyaz123");
	loginPage.loginButton();
	
	SearchHotelPage searchPage= PageFactory.initElements(driver, SearchHotelPage.class);
	
	searchPage.verifyTitle("Adactin.com - Search Hotel");
	searchPage.helloUsernameText("reyaz0806");
	
	
	}
}
