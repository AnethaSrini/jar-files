package sample;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


/*Feature: Use the website to find shirts
So that I can order a shirt
As a customer
I want to be able to find t shirts
Scenario: I want to save some items 
Given I want to search for products like tshirts
When I  add  few products to my wishlist
Then I want see my selected products in my wishlist

* 
*/


//Scenario 6: Add items to wishlist

public class clicksave {
	public static void main(String args[]) throws InterruptedException {
		
		//Setting up this gecko driver ,because of incompatablity between selenium verson and firefox version in my computer
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\selenium\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.asos.com");
		//click ok for cookies
		driver.findElement(By.id("btnClose")).click();

		
		//@Given I want  to search for shirts				
		
		WebElement webElement = driver.findElement(By.id("txtSearch"));
		
		webElement.sendKeys("Purple T-Shirt");
		driver.findElement(By.className("go")).click();
		driver.findElement(By.linkText("ASOS Longline T-Shirt In Pastel Purple Towelling" )).click();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select drpsize = new Select(driver.findElement(By.cssSelector("select[data-id=sizeSelect]")));
		
		
		drpsize.selectByIndex(4);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//@When I add few items to my wishlist
		
		//			
		driver.findElement(By.xpath("//*[@id='product-save']/div/a/span[2]")).click();
		Thread.sleep(2000);
		
		
		//@Then I should see my selected products in wishlist
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Saved Items")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Listing out all my items in my wish list
		    int count=0;
		    List<WebElement> webquantity= driver.findElements(By.xpath("//*[@id='savedItemsApp']/div/saved-items-header/div/div[2]/saved-items-controls/div/saved-items-count/div/p/span"));
		    for(WebElement chk:webquantity){
		    	count++;
		    }
		    System.out.println("Number of Saved items "+ count );
		   
	}
	


}
