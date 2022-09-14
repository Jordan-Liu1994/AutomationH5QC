package loginH5;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import fuctionsH5FE.LoginFE;
import utilities.VariableStore;

public class OpenChrome extends VariableStore {

	LoginFE lFE = new LoginFE();

	@BeforeClass(groups = { "start" })
	@Parameters({ "platformName", "platformVersion", "deviceName", "udid", "appPackage", "appActivity", "automationName" })
	public void startRealMobileDevice(String platformName, String platformVersion, String deviceName, String udid, String appPackage, String appActivity, String automationName) throws MalformedURLException {
		bDriver.setRealMobileDevice(platformName, platformVersion, deviceName, udid, appPackage, appActivity, automationName);
	}

	@Test(priority = 0)
	@Parameters({ "url" })
	public void toClientSite(String url) {
		bDriver.startDriver();
		bDriver.getURL(url);
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		lFE.loginOption();
	}

	@AfterClass
	public void endTest() throws InterruptedException {
		Thread.sleep(3000);
		bDriver.stopDriver();
	}
}
