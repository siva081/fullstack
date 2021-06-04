package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity8 {

	 WebDriver driver;
	 
	  @Test (priority=1)
	  public void titletest() {
		 driver=new FirefoxDriver();
		 driver.get("http://alchemy.hguy.co/lms");
		 Assert.assertEquals("Alchemy LMS – An LMS Application", driver.getTitle());
	  }
	  
	  @Test (priority=2)
	  public void menutest() throws InterruptedException {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		 driver.findElement(By.xpath("//li[contains(@id,'menu-item-1506')]")).click();
		 Thread.sleep(2000);
		 WebElement we = driver.findElement(By.xpath("//*[contains(@id,'wpforms-8-field_0')]"));
		 //js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", we);
		 js.executeScript("window.scrollBy(0,1000)");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[contains(@id,'wpforms-8-field_0')]")).sendKeys("Sivakumar TN");
		 
		 driver.findElement(By.xpath("//input[contains(@id,'wpforms-8-field_3')]")).sendKeys("​test");
		 driver.findElement(By.xpath("//textarea[contains(@id,'wpforms-8-field_2')]")).sendKeys("​this is test description");
		 
		 
		 driver.findElement(By.xpath("//input[contains(@id,'wpforms-8-field_1')]")).sendKeys("​rickyr1990@gmail.com");
		 driver.findElement(By.xpath("//*[contains(@id,'wpforms-submit-8')]")).click();
		
		 Thread.sleep(5000);
		 System.out.println(driver.findElement(By.xpath("//*[contains(@id,'wpforms-confirmation-8')]")).getText());
		 
	  }
	
}
