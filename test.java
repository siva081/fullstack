package hrm_project;

import org.testng.annotations.Test;

import junit.framework.Assert;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity_1 {
	WebDriver driver;
  @Test
  public void titletest() {
	  driver=new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/orangehrm");
	 Assert.assertEquals("OrangeHRM", driver.getTitle());
  }
  
  @Test (dependsOnMethods="titletest")
  public void closebrowser() {
	  driver.close();
  }

}
