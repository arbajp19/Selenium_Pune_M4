package com.ShoppersStack.GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShoppersStack.Pom.Home_Page;
import com.ShoppersStack.Pom.Login_Page;
import com.ShoppersStack.Pom.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	
	public WebDriver driver;
	static WebDriver listenersDriver;
	public File_Utility file=new File_Utility();
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public Java_Utility java=new Java_Utility();
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public Webdriver_Utility webdriverUtil=new Webdriver_Utility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
		
		spark=new ExtentSparkReporter(FrameWorkConstants.reportPath+java.localDateTime()+".html");
		report=new ExtentReports();
		report.attachReporter(spark);
		test = report.createTest("Demo");
		
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("BeforeClass");
		
		String browser=file.readPropertyData("browser");
		String url=file.readPropertyData("url");
		
//		String browser = System.getProperty("browser");
//		String url = System.getProperty("url");
		
		
		if (browser.contains("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.contains("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.contains("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Enter Valid Browser Name");
		}
		listenersDriver=driver;
		welcomePage=new Welcome_Page(driver);
		loginPage=new Login_Page(driver);
		homePage=new Home_Page(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(url);
		
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("BeforeMethod");

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
		
		welcomePage.getLoginBtn().click();
		loginPage.getEmailTB().sendKeys(file.readPropertyData("username"));
		loginPage.getPasswordTB().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginBtn().click();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		
		homePage.getAccountSettingsBtn().click();
		homePage.getLogoutBtn().click();
	}

	@AfterClass
	public void afterclass() throws InterruptedException {
		System.out.println("AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
		report.flush();
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}

}
