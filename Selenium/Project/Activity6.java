package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity6 {

	 WebDriver driver;
	 
	  @Test (priority=1)
	  public void titletest() {
		 driver=new FirefoxDriver();
		 driver.get("http://alchemy.hguy.co/lms");
		 Assert.assertEquals("Alchemy LMS – An LMS Application", driver.getTitle());
	  }
	  
	  @Test (priority=2)
	  public void logintest() throws InterruptedException {
		 
		 driver.findElement(By.xpath("//li[contains(@id,'menu-item-1507')]")).click();
		 Assert.assertEquals("My Account – Alchemy LMS", driver.getTitle());
		 driver.findElement(By.xpath("//*[contains(@class,'ld-login ld-login ld-login-text ld-login-button ld-button')]")).click();
		
		 driver.findElement(By.xpath("//*[contains(@id,'user_login')]")).sendKeys("root");
		 driver.findElement(By.xpath("//*[contains(@id,'user_pass')]")).sendKeys("pa$$w0rd");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[contains(@id,'wp-submit')]")).click();
		 
		 
		 
			 
	  
	  }
	  
}
