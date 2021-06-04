package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity9 {

	 WebDriver driver;
	 
	  @Test (priority=1)
	  public void titletest() {
		 driver=new FirefoxDriver();
		 driver.get("http://alchemy.hguy.co/lms");
		 Assert.assertEquals("Alchemy LMS – An LMS Application", driver.getTitle());
	  }
	  
	  @Test (priority=2)
	  public void menutest() throws InterruptedException {
		 
		 driver.findElement(By.xpath("//li[contains(@id,'menu-item-1508')]")).click();
		 Assert.assertEquals("All Courses – Alchemy LMS", driver.getTitle());
		 driver.findElement(By.xpath("//a[contains(@class,'btn btn-primary')]")).click();
		 Assert.assertEquals("Social Media Marketing – Alchemy LMS", driver.getTitle());
		 driver.findElement(By.xpath("//a[contains(@class,'ld-button')]")).click();
		 
		 driver.findElement(By.xpath("//*[contains(@id,'user_login')]")).sendKeys("root");
		 driver.findElement(By.xpath("//*[contains(@id,'user_pass')]")).sendKeys("pa$$w0rd");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[contains(@id,'wp-submit')]")).click();
		// driver.findElement(By.xpath("//*[contains(@class,'ld-text ld-primary-color')]")).click();
		 driver.findElement(By.xpath("//*[contains(@class,'ld-item-title')]")).click();
		 
		 Thread.sleep(3000);
		 
		 driver.close();
		 
	  }
	
}
