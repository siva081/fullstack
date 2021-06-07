package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Googletask {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException  {
        // Set the Desired Capabilities
        caps.setCapability("deviceName", "Pixel 4 Emul");
    		caps.setCapability("platformName", "android");
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
	public void googleTasks() throws InterruptedException {
		// Create first task.
		Thread.sleep(10000);

		// Click on the new task.
		driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		Thread.sleep(3000);
		
		// Add title.
		driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
		Thread.sleep(3000);
		
		// Click on done button.
		driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

		// Create Second task.
		driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		Thread.sleep(3000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
		driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

		// Create third task.
		driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		Thread.sleep(3000);
		driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
		driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();

	}


	@AfterClass
	public void afterClass() {
		// Close the app.
		driver.quit();
	}
}