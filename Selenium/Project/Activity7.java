package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity7 {

	 WebDriver driver;
	 
	  @Test (priority=1)
	  public void titletest() {
		 driver=new FirefoxDriver();
		 driver.get("http://alchemy.hguy.co/lms");
		 Assert.assertEquals("Alchemy LMS – An LMS Application", driver.getTitle());
	  }
	  
	  @Test (priority=2)
	  public void menutest() {
		 
		 driver.findElement(By.xpath("//li[contains(@id,'menu-item-1508')]")).click();
		 Assert.assertEquals("All Courses – Alchemy LMS", driver.getTitle());
		 List<WebElement> coursecount = driver.findElements(By.xpath("//*[contains(@class,'caption')]"));
		 System.out.println(coursecount.size());
	  }
	
}
