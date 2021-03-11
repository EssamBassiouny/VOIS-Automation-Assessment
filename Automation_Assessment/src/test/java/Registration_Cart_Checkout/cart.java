package Registration_Cart_Checkout;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation_Assessment.Automation_Assessment.base;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class cart extends base {
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browser) throws ATUTestRecorderException 
	{ 
		intro(browser);
		validaccount();
	} 

	@AfterClass
	public void afterClass() throws InterruptedException, ATUTestRecorderException 
	{
				
		driver.quit();
		
	}

	@Test
	public void Additems() 
	{actions();
	javascript();

	//Choose item (first item): Faded Short Sleeve T-shirts
	
	js.executeScript("window.scrollBy(0,700)");
	WebElement shop=driver.findElement(By.id("homefeatured"));
	List<WebElement> list=shop.findElements(By.cssSelector("div[itemtype='http://schema.org/Product']"));	
	action.moveToElement(list.get(0)).click().build().perform();
	WebElement shirt=driver.findElement(By.cssSelector("h1[itemprop='name']"));
	String act_name="Faded Short Sleeve T-shirts";
	String exp_name=shirt.getText();
	assertEquals(act_name, exp_name);
	
	//Add the Faded Short Sleeve T-shirts to (Cart)
	WebElement cart=driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
	cart.click();
	WebElement proceed1=driver.findElement(By.cssSelector("a[title='Proceed to checkout']"));
	proceed1.click();
	String exp_message="Your shopping cart contains: 1 Product";
	String act_message=driver.findElement(By.cssSelector("span[class='heading-counter']")).getText();
	assertEquals(exp_message,act_message);
	
	
	//Proceed to Checkout (Summary)
	js.executeScript("window.scrollBy(0,700)");
	WebElement proceed2=driver.findElement(By.linkText("Proceed to checkout"));
	proceed2.click();
	
	//Proceed to Checkout (Address)
	js.executeScript("window.scrollBy(0,500)");
	WebElement proceed3=driver.findElement(By.cssSelector("button[name='processAddress']"));
	proceed3.click();
	
	//Proceed to Checkout ( Shipping) and accept terms
	js.executeScript("window.scrollBy(0,500)");
	WebElement terms=driver.findElement(By.id("cgv"));
	terms.click();
	assertTrue(terms.isSelected());
	
	WebElement proceed4=driver.findElement(By.cssSelector("button[name='processCarrier']"));
	proceed4.click();
	
	//Proceed to Checkout (Payment)
	//pay by bank wire
	js.executeScript("window.scrollBy(0,500)");
	WebElement pay=driver.findElement(By.cssSelector("a[title='Pay by bank wire']"));
	pay.click();
	String exp_pay="BANK-WIRE PAYMENT.";
	String act_pay=driver.findElement(By.cssSelector("h3[class='page-subheading']")).getText();
	assertEquals(exp_pay, act_pay);
	
	//Confirm the Order (ORDER CONFIRMATION)
	js.executeScript("window.scrollBy(0,500)");
	WebElement confirm=driver.findElement(By.cssSelector("button[class='button btn btn-default button-medium']"));
	confirm.click();
	String exp_confirm="Your order on My Store is complete.";
	String act_confirm=driver.findElement(By.cssSelector("p[class='cheque-indent']")).getText();
	assertEquals(exp_confirm, act_confirm);
	
	
	}


}
