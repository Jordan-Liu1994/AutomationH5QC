package fuctionsH5FE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.VariableStore;

public class LoginFE extends VariableStore {
		
	public void loginOption() throws InterruptedException {
		Thread.sleep(5000);
		WebElement loginOption = bDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@text='登录']"));
		String loginOptionText = loginOption.getText();
		if (loginOption.isDisplayed()) {
			loginOption.click();
			System.out.println(loginOptionText);
		}
	}

}
