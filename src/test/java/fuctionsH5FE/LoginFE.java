package fuctionsH5FE;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utilities.VariableStore;

public class LoginFE extends VariableStore {
	
	WebDriverWait wait;
	
	public void loginOption() throws InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement loginOption = bDriver.getDriver().findElement(AppiumBy.xpath("//android.view.View[@content-desc='index']"));
		if (loginOption.isDisplayed()) {
			loginOption.click();
		}
	}

	public void loginUsername(String usernameFE) throws InterruptedException {
		Thread.sleep(3000);
		bDriver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement loginUsername = bDriver.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"));
		if (loginUsername.isDisplayed()) {
			loginUsername.click();
			loginUsername.clear();
			loginUsername.sendKeys(usernameFE);	
			bDriver.getDriver().hideKeyboard();
		}
	}

	public void loginPassword(String passwordFE) throws InterruptedException {
		WebElement loginPassword = bDriver.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"));
		if (loginPassword.isDisplayed()) {
			loginPassword.click();
			loginPassword.clear();
			loginPassword.sendKeys(passwordFE);
			bDriver.getDriver().hideKeyboard();
		}
	}

	public void loginCaptcha(String captchaFE) throws InterruptedException {
		WebElement loginCaptcha = bDriver.getDriver().findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='captcha_code']"));
		if (loginCaptcha.isDisplayed()) {
			loginCaptcha.click();
			loginCaptcha.clear();
			loginCaptcha.sendKeys(captchaFE);
			bDriver.getDriver().hideKeyboard();
		}
	}

	public void loginButton() throws InterruptedException {
		bDriver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement loginButton = bDriver.getDriver().findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='login_button']"));
		String loginButtonText = loginButton.getText();
		if (loginButton.isDisplayed()) {
			loginButton.click();
			System.out.println(loginButtonText);
		}
	}
}
