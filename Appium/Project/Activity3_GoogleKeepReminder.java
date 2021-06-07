package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class GoogleKeepReminder {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException  {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 Emul");
    		caps.setCapability("platformName", "android");
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
	public void googleKeepReminder() throws InterruptedException {

		Thread.sleep(5000);
		// Click on create new note 
		driver.findElementById("com.google.android.keep:id/new_note_button").click();

		Thread.sleep(3000);

		String createNote = "Create Reminder Note";

		// Enter the title.
		driver.findElementById("com.google.android.keep:id/editable_title").sendKeys(createNote);
		Thread.sleep(3000);

		// Enter the description.
		driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("As part of appium project create a reminder note");
		Thread.sleep(3000);

		// Click on reminder
		driver.findElementById("menu_reminder").click();
		Thread.sleep(3000);

		// Click on second option.
		driver.findElement(By.xpath("(.//*[@class='android.widget.TextView'])[2]")).click();

		// Click on Navigate back 
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']").click();

		boolean found = driver.findElementById("reminder_chip_text").isDisplayed();

		// Check if the reminder is added.
		Assert.assertTrue(found, "Reminder is not added.");

	}

	@AfterClass
	public void afterClass() {
		// Close the application
		driver.quit();
	}

}
