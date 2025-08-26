package regression;

import java.util.HashMap;

import org.apache.poi.poifs.crypt.DataSpaceMapUtils.DataSpaceMap;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateLoginUsingPOMDataProvider extends BaseTest {
	
	
	@Test(dataProvider="getTestData")
	public void validateLoginTest(HashMap<String, String> dataMap) {
		
		LoginPage loginPage =new LoginPage();
		
		//LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.usernameTextbox(dataMap.get("username"));
		loginPage.passwordTextbox(dataMap.get("password"));
		//loginPage.verifyTitle("Adactin.com - Search Hotel");
		loginPage.loginButton();
		
		//SearchHotelPage searchHotelPage= PageFactory.initElements(driver, SearchHotelPage.class);
		SearchHotelPage searchHotelPage= new SearchHotelPage();
		searchHotelPage.verifyTitle(dataMap.get("expTitle"));
		searchHotelPage.helloUsernameText(dataMap.get("username"));
		
	}
	
	
	@DataProvider
	public Object[][] getTestData(){
		
		Object[][] data=new Object[1][1];
		data[0][0]=UtilKit.getTestDataFromExcel("TC-001");

					

		
		return data;
		
	}

}
