package com.model1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class log4jTest {
	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\2019 Soft\\Automation_Testing\\Browsers_Driver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void upUrl()
	{
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}
	@BeforeClass
	public void maximizeBrowser()
	{
		System.out.println("maximized");
		driver.manage().window().maximize();
	}
	@BeforeTest()
	public void getCookie()
	{
		Set<Cookie> cookiee=driver.manage().getCookies();
		for(Cookie ck:cookiee)
		{
			System.out.println("cookie name is: "+ck.getName());
		}
	}
  @Test
  public void loginToGmail() throws Exception {
  System.out.println("Method under test1");
// driver.manage().wait(1000);
 driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
//  driver.findElement(By.xpath("//li[@class='h-c-header__cta-li g-mail-nav-links--mobile  link--last']/child::a[@class='h-c-header__nav-li-link ']")).click();
  driver.findElement(By.xpath("//input[@id='identifierId']")).clear();
  System.out.println("field cleared1");
  driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("igajendrashinde@gmail.com");
  driver.findElement(By.cssSelector("span[class='RveJvd snByac']")).click();
  driver.findElement(By.cssSelector("input[type='password']")).clear();
  System.out.println("field cleared2");
 // driver.findElement(By.xpath("//div[@class='Xb9hP']/child::input[@name='password']")).sendKeys("Home@424304");
  driver.findElement(By.xpath("//div[@id='password']/div/div/div/input")).sendKeys("Home@424304");
  Thread.sleep(1000);
  System.out.println("Susseccfully login to gmail");
  }
  @AfterMethod
  public void takeScreenShot() throws IOException
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyDirectory(src,new File("D:\\eclipse-workspace\\Maven-Demo1\\ScreenShoot"));
	  System.out.println("Screenshot has captured successfully");

  }
  @AfterClass
  public void deleteCookie()
  {
	  driver.manage().deleteAllCookies();
	  System.out.println("Cookies deleted");
  }
  @AfterTest
  public void dbConnectionClosed() {
		System.out.println("In dbConnectionClosed method under AfterTest");
	}
  @AfterSuite
  public void closeBrowser()
  {
	  driver.close();
  }
}
