package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseDriver {

	static AndroidDriver<MobileElement> driver;
	
	public AndroidDriver<MobileElement> getDriver() {
		return driver;
	}

	URL URL;
	DesiredCapabilities capabilities;
	
	public void setRealMobileDevice(String platformName, String platformVersion, String deviceName, String udid, String appPackage, String appActivity, String automationName) throws MalformedURLException {
		URL = new URL("http://localhost:5555/wd/hub");
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("udid", udid);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("automationName", automationName);
	}
	
	public void startDriver() {
		driver = new AndroidDriver<MobileElement>(URL, capabilities);
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
