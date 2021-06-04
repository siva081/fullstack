package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4 {

	 WebDriver driver;
	 
	  @Test (priority=1)
	  public void titletest() {
		 driver=new FirefoxDriver();
		 driver.get("http://alchemy.hguy.co/lms");
		 Assert.assertEquals("Alchemy LMS – An LMS Application", driver.getTitle());
	  }
	  
	  @Test (priority=2)
	  public void headertest() {
		 
		 String headertext = driver.findElement(By.xpath("//h3[contains(@class,'entry-title')]")).getText();
		 Assert.assertEquals("Social Media Marketing", headertext);
	  }
	
}
