package loginH5;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import fuctionsH5FE.LoginFE;
import utilities.CreateReport;
import utilities.ResultListener;
import utilities.VariableStore;

public class LoginH5FE extends VariableStore {

	CreateReport cR = new CreateReport();
	ResultListener rL = new ResultListener();
	
	LoginFE lFE = new LoginFE();

	private static String nameOfReport = "LoginH5FE";

	@BeforeClass(groups = { "start", "LoginH5FE" })
	@Parameters({ "platformName", "platformVersion", "deviceName", "udid", "appPackage", "appActivity", "automationName", "pageLoadStrategy", "platform", "browser", "javaVersion", "automationAuthor" })
	public void startRealMobileDevice(String platformName, String platformVersion, String deviceName, String udid, String appPackage, String appActivity, String automationName, String pageLoadStrategy, String platform, String browser, String javaVersion, String automationAuthor) throws MalformedURLException {
		bDriver.setRealMobileDevice(platformName, platformVersion, deviceName, udid, appPackage, appActivity, automationName, pageLoadStrategy);
		cR.generateReport(nameOfReport, platform, browser, javaVersion, automationAuthor);
	}

	@Test(priority = 0, groups = "LoginH5FE")
	@Parameters({ "url" })
	public void toClientSite(String url) {
		cR.createTest("toClientSite");
		bDriver.startDriver();
		bDriver.getURL(url);
	}

	@Test(priority = 1, groups = "LoginH5FE")
	@Parameters({ "usernameFE" })
	public void login(String usernameFE) throws InterruptedException {
		cR.createTest("login");
		lFE.loginOption();
		lFE.loginUsername(usernameFE);
		lFE.loginPassword(passwordFE);
		lFE.loginCaptcha(captchaFE);
		lFE.loginButton();
	}

	@AfterMethod(groups = { "LoginH5FE" })
	public void logCaseStatus(ITestResult result) {
		rL.logCaseStatus(result);
	}
	
	@AfterClass(groups = "LoginH5FE")
	public void endTest() throws InterruptedException {
		Thread.sleep(500);
		cR.flushTest();
//		bDriver.stopDriver();
	}
}
