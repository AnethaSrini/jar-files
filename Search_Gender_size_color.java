package sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Feature: Use the website to find shirts
        So that I can order a shirt
        As a customer
        I want to be able to find t shirts
  Given I want to find some T-shirt
  then Refine by color
  And refine by Gender
  And refine by Size*/


// Scenario 4 Search by gender or color or size


public class Search_Gender_size_color {
	public static void main(String args[]) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\selenium\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
						
		//Given I want to order a shirt in ASOS website
			driver.get("http://www.asos.com");
		    //click ok for cookies
		    driver.findElement(By.id("btnClose")).click();

									
		//search for  t shirt
		
		WebElement webElement = driver.findElement(By.id("txtSearch"));
		webElement.sendKeys("T Shirt");
		driver.findElement(By.className("go")).click();
		
		//Refine search by Gender WoMen
		driver.findElement(By.xpath("//*[@id='productlist-results']/aside/div[1]/div/div/ul/li[1]/a/span[2]")).click();
		driver.navigate().refresh();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> lstProductsName=driver.findElements(By.cssSelector("ul > li.product-container.interactions"));
		    	for(WebElement eleDes:lstProductsName){
		    		 				    	
					System.out.println(eleDes.getText());
					String str =eleDes.getText(); 
					if(str.contains("Women"))
						
					try{
					System.out.println("Test Passes");
					}
					catch (Throwable e)
					{
					
					System.out.println("Test Failed");	
					}
		    		
										    	
		    	}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		//@And Refine search by Select Size tall
		driver.findElement(By.xpath("//*[@id='productlist-results']/aside/div[2]/div/div/ul/li[6]/a/span[2]")).click();
		List<WebElement> lstProductsName1=driver.findElements(By.cssSelector("ul > li.product-container.interactions"));
    	for(WebElement eleDes:lstProductsName1){
    		 				    	
			System.out.println(eleDes.getText());
			String str =eleDes.getText(); 
			if(str.contains("Tall"))
				
			try{
			System.out.println("Test Passes");
			}
			catch (Throwable e)
			{
			
			System.out.println("Test Failed");	
			}
    		
								    	
    	}
    	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
    	
		//@And Refine search by color Navy
		driver.findElement(By.xpath("//*[@id='productlist-results']/aside/div[5]/div/div/ul/li[11]/a/span[2]")).click();
		//
		List<WebElement> lstProductsName2=driver.findElements(By.cssSelector("ul > li.product-container.interactions"));
    	for(WebElement eleDes:lstProductsName2){
    		 				    	
			System.out.println(eleDes.getText());
			String str =eleDes.getText(); 
			if(str.contains("Navy"))
				
			try{
			System.out.println("Test Passes");
			}
			catch (Throwable e)
			{
			
			System.out.println("Test Failed");	
			}
    		
								    	
    	}
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
		
		
		
		

	}
}
