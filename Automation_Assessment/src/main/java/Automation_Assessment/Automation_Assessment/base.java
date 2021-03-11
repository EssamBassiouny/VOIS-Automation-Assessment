package Automation_Assessment.Automation_Assessment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;







public class base {
	protected static WebDriver driver;
	protected static Actions action;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor js;

	@Parameters({"browser"})
	public void intro(String browser) {
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "E:\\VOIS Automation Assessment\\Automation_Assessment\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if((browser.equalsIgnoreCase("firefox"))) 
		{
			System.setProperty("webdriver.gecko.driver", "E:\\VOIS Automation Assessment\\Automation_Assessment\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
	}


	public void validaccount() 
	{
		WebElement SignIn=driver.findElement(By.linkText("Sign in"));
		SignIn.click();

		WebElement enter_email=driver.findElement(By.id("email"));
		enter_email.sendKeys("essam@essam.com");

		WebElement passrd=driver.findElement(By.id("passwd"));
		passrd.sendKeys("123456");

		WebElement signbtn=driver.findElement(By.id("SubmitLogin"));
		signbtn.click();

		WebElement shop=driver.findElement(By.cssSelector("a[title='My Store']"));
		shop.click();
	} 

	public void javascript() 
	{
		js = (JavascriptExecutor) driver;
	}

	public  void actions() 
	{
		action=new Actions(driver);
	}

	public void explicit_wait() 
	{
		wait = new WebDriverWait(driver,30);
	}


}

