package pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@type='email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//div[normalize-space()='Couldn’t find your Google Account']")
	WebElement errorMsg;

	public String getCurrentTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String enteringEmail() throws InterruptedException {
		
		inputEmail.sendKeys(RandomStringUtils.random(10,true,true)+"@gmail.com");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		return errorMsg.getText();
		
	}
	
}
