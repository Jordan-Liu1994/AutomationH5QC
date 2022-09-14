package fuctionsH5FE;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import utilities.VariableStore;

public class LoginFE extends VariableStore {
		
	public void loginOption() throws InterruptedException {
		Thread.sleep(2000);
		MobileElement loginOption = bDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@text='登录']"));
		String loginOptionText = loginOption.getText();
		if (loginOption.isDisplayed()) {
			loginOption.click();
			System.out.println(loginOptionText);
		}
	}

}
