package sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//
/*Feature: Use the website to find shirts
So that I can order a shirt
As a customer
I want to be able to find t shirts
Scenario: I want to view Australian products in newzealand currency 
Given I want to see the Australian Products
And then I want the pricing to be in Newzeand dollars
then I want to see australian products in newzealand dollars

* 
*/

//Scenario 5: I should be able to select country Australia and And view the product price in Newzealand currency


public class S5newzaus {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\selenium\\geckodriver.exe");

		
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		//driver.manage().deleteAllCookies();
		//Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Navigate to ASOS url
		driver.get("http://www.asos.com");
		//click ok for cookies
		driver.findElement(By.id("btnClose")).click();
		driver.navigate().refresh();
		
		//selecting as australian customer
		driver.findElement(By.xpath("//*[@id='BodyTag']/div[4]/div/footer/div[2]/div[2]/div[2]/ul/li[6]/a/span")).click();
		
		//
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		//Selecting Newzealand currency
		
		driver.findElement(By.xpath("//*[@id='localisationMenu']/a/span[2]")).click();
		//*[@id="localisationMenu"]/a/span[2]
		Thread.sleep(2000);
		Select drpcurrency = new Select(driver.findElement(By.id("currencyList")));
		drpcurrency.selectByVisibleText("$ NZD");
		WebElement webElement = driver.findElement(By.id("txtSearch"));
		webElement.sendKeys("Purple T-Shirt");
		driver.findElement(By.className("go")).click();
		
		//Then I should find some products
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> lstProductsName=driver.findElements(By.cssSelector("ul > li.product-container.interactions"));
		    	for(WebElement eleDes:lstProductsName){
		    		 				    	
					System.out.println(eleDes.getText());
					String str =eleDes.getText(); 
					if(str.contains("Purple"))
						
					try{
					System.out.println("Test Passes");
					}
					catch (Throwable e)
					{
					
					System.out.println("Test Failed");	
					}
		    		
					Assert.assertTrue(str.contains("Purple"));
					    	
		    	}
		
		
		
	}

}
