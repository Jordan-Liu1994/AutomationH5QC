package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.android.AndroidDriver;

public class BaseDriver {

	static AndroidDriver driver;
	
	public AndroidDriver getDriver() {
		return driver;
	}

	URL URL;
	DesiredCapabilities capabilities;
	
	public void setRealMobileDevice(String platformName, String platformVersion, String deviceName, String udid, String appPackage, String appActivity, String automationName, String pageLoadStrategy) throws MalformedURLException {
		URL = new URL("http://localhost:5555/wd/hub");
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("udid", udid);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("automationName", automationName);
		capabilities.setCapability("pageLoadStrategy", pageLoadStrategy);
	}
	
	public void startDriver() {
		driver = new AndroidDriver(URL, capabilities);
		SessionId driverSessionID = driver.getSessionId();
		System.out.println(driverSessionID);
	}
	
	public void getURL(String url) {
		driver.get(url);
	}
	
	public void closeBrowser() {
		driver.close();
	}

	public void stopDriver() {
		driver.quit();
	}
}
