import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;



public class MultiBrowserDemoTest {
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	public static final String USERNAME = "declanfanning_H4C1on";
	public static final String ACCESSKEY = "nM7kyqVLrzLqP5r1xAFH";
	public static final String URL = "https://" + USERNAME + ":" + ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	 @Test (dataProvider = "browserStackTestData")
	public void setup1(Platform platform, String browserName, String browserVersion) throws MalformedURLException {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	
	caps.setPlatform(platform);
	caps.setBrowserName(browserName);
	caps.setVersion(browserVersion);
	caps.setCapability("browserstack.debug", true);
	
	URL browserStackURL = new URL(URL);
	driver = new RemoteWebDriver(browserStackURL, caps);
	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.findElement(By.id("btnLogin")).click();
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	driver.quit();
}
	 
	 @DataProvider (name="browserStackTestData", parallel = true)
	 public Object[][] getData(){
		 Object[][] testData = new Object[][]{
			 {Platform.WINDOWS, "chrome", "63.0"},
			 {Platform.WINDOWS, "chrome", "62.0"},
			 {Platform.WINDOWS, "chrome", "61.0"},
			 {Platform.WINDOWS, "chrome", "60.0"},
			 {Platform.WINDOWS, "chrome", "59.0"}
	 };
	 
return testData;

}
}
