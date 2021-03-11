package Registration_Login;



import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation_Assessment.Automation_Assessment.base;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class login extends base {
	@Parameters({"browser"})
	@BeforeClass
	public void BeforeTestcases(String browser) throws ATUTestRecorderException ,Throwable
	{	 
		intro(browser);
		
		
	}
	@AfterClass
	public void AfterTestcases() throws Throwable, ATUTestRecorderException
	{						
				driver.quit();
			
	}

	@Test(priority = 1)
	public void Signbtn_Check() 
	{	//Click on Sign in button in order to create a new account
		actions();
		WebElement SignIn=driver.findElement(By.linkText("Sign in"));
		action.moveToElement(SignIn).click().build().perform();
		WebElement createAcc=driver.findElement(By.xpath("//h3[contains(text(),'Create an account')]"));
		String exp=createAcc.getText();

		assertEquals(exp, "CREATE AN ACCOUNT");

	}

	@Test(priority = 2)
	public void Account_Registration() 
	{	
		//Add valid Email address in order to create an Account

		WebElement add_email=driver.findElement(By.id("email_create"));
		add_email.sendKeys("essam@essam.com");

		//Click on create button
		WebElement create=driver.findElement(By.id("SubmitCreate"));
		create.click();

		//check for URL
		String exp_URL="http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
		explicit_wait();
		wait.until(ExpectedConditions.urlToBe(exp_URL));
		String act_URL=driver.getCurrentUrl();
		assertEquals(exp_URL, act_URL);

		//Choose Title (MR)
		WebElement Title=driver.findElement(By.id("id_gender1"));
		Title.click();
		assertEquals(true, Title.isSelected());

		//enter first name: essam
		WebElement firstname=driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		firstname.sendKeys("essam");


		//enter last name: amr
		WebElement lastname=driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		lastname.sendKeys("amr");

		//check email
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		String exp_email="essam@essam.com";
		String act_email=email.getAttribute("value");
		assertEquals(exp_email, act_email);

		//enter password: 123456
		WebElement password=driver.findElement(By.id("passwd"));
		password.sendKeys("123456");

		//enter date of Birth 1-February-2000
		WebElement day=driver.findElement(By.id("days"));
		Select days=new Select(day);
		days.selectByValue("1");

		WebElement month=driver.findElement(By.id("months"));
		Select months=new Select(month);
		months.selectByValue("2");

		WebElement year=driver.findElement(By.id("years"));
		Select years=new Select(year);
		years.selectByValue("2000");

		//Sign up for our newsletter!
		WebElement newsletter=driver.findElement(By.id("newsletter"));
		newsletter.click();
		//Receive special offers from our partners!
		WebElement offer=driver.findElement(By.id("optin"));
		offer.click();

		//Enter Address
		WebElement Address=driver.findElement(By.id("address1"));
		Address.sendKeys("test,12345");

		//Enter City
		WebElement city=driver.findElement(By.xpath("//input[@id='city']"));
		city.sendKeys("Cairo");
		
		//Select State "California"
		WebElement states=driver.findElement(By.id("id_state"));
		Select state=new Select(states);
		state.selectByValue("5");
		
		//Enter Zip/Postal Code 
		WebElement zip=driver.findElement(By.id("postcode"));
		zip.sendKeys("12345");
		
		//Enter Country
		WebElement conts=driver.findElement(By.id("id_country"));
		Select cont=new Select(conts);
		cont.selectByValue("21");
		
		//Enter Mobile Phone
		WebElement mob=driver.findElement(By.id("phone_mobile"));
		mob.sendKeys("012345678");
		
		//Click on Register button
		WebElement reg=driver.findElement(By.id("submitAccount"));
		reg.click();
		
		//Check my account logged in
		WebElement check=driver.findElement(By.linkText("essam amr"));
		String act_check="essam amr";
		String exp_check=check.getText();
		assertEquals(act_check, exp_check);
		 



	}




}
