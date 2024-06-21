package Testcase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class TestCase1 {
	 WebDriver driver;
	
	@BeforeTest
	public void SetUp()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	     this.driver=new ChromeDriver(options);
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}
  @Test
  public void Test() {
	  
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  WebElement el=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/h3"));
	  js.executeScript("arguments[0].scrollIntoView();", el);
	  WebElement e=driver.findElement(By.linkText("Blog"));
	  js.executeScript("arguments[0].click()", e);
	  js.executeScript("window.location='https://youtube.com'");
	  
	  /*
	  driver.findElement(By.linkText("Blog")).click();
	  String actualurl="https://demowebshop.tricentis.com/blog";
	  String expectedurl=driver.getCurrentUrl();
	  Assert.assertEquals(actualurl, expectedurl);
	  WebElement blogarchive=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[1]/strong"));
	 Assert.assertTrue( blogarchive.isDisplayed());
	 */
  }
  
  @AfterTest
  public void TearDown()
  {
	  driver.close();
  }
}
