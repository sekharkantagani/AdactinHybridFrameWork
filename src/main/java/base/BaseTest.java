package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Exceptions.InvalidBrowserException;
import utils.ExtentManager;

public class BaseTest {

	public static FileInputStream fis1;
	public static Properties p;
	public static WebDriver driver;
	public static FileInputStream fis2;
	public static Properties l;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeTest
	public void beforTest() {

		try {
			fis1 = new FileInputStream("Properties\\Config");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		p = new Properties();

		try {
			p.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis2 = new FileInputStream("Properties\\Locator");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		l = new Properties();

		try {
			l.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reports=ExtentManager.getReports();

	}

	@BeforeMethod
	public void setUp(Method method) {
		
		test=reports.createTest(method.getName());

		String browserName = p.getProperty("browser");

		switch (browserName) {
		case "Chrome":

			driver = new ChromeDriver();
			test.log(Status.INFO, browserName+"is started");

			break;
		case "Edge":

			driver = new EdgeDriver();
			test.log(Status.INFO, browserName+"is started");

		default:
			try {
				throw new InvalidBrowserException();
			} catch (InvalidBrowserException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			break;
		}

		driver.get(p.getProperty("url"));
		test.log(Status.INFO, "App is launched by using url"+ p.getProperty("url"));

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(p.getProperty("implicitWait"))));
	}

	@AfterMethod
	public void cleanUp() {
		if (driver != null) {
			driver.quit(); // ensures browser is closed after each test
			test.log(Status.INFO, "Browser is closed");

		}
	}

	@AfterTest
	public void reportsEnd() {
		
		reports.flush();
	}
}
