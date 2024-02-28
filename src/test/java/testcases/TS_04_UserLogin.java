package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.ZigWheelsPage;
import testbase.BaseClass;

public class TS_04_UserLogin extends BaseClass{

	public ZigWheelsPage zw;
	public LoginPage lp;
	
	
	
	@Test(priority = 10,groups= {"master","sanity"})
	public void TC_10_verifyLoginIsDisplayed() {
		zw = new ZigWheelsPage(driver);
		logger.info("***** TC_10_verifyLoginIsDisplayed Started *****");
		boolean status = zw.btnLoginIsDisplayed();
		logger.info("status for login and google sigin button is captured");
		if(status) {
			zw.clickLogin();
			logger.info("login button has been clicked");
			
		}
		zw.clickGoogleSigin(driver);
		logger.info("google signin button has been clicked");
		Assert.assertEquals(status, true,"the login button is not displayed");
		zw.switchDriver(driver);
		logger.info("driver has been switched to google sigin page");
		logger.info("TC_10_verifyLoginIsDisplayed PASSED -- login button has been clicked");
		logger.info("***** TC_10_verifyLoginIsDisplayed Finished *****");
	}
	
	@Test(priority = 11,groups= {"master","sanity"})
	public void TC_11_verifyDirectedTogoogleSign() {
		lp = new LoginPage(driver);
		logger.info("***** TC_11_verifyDirectedTogoogleSign Started *****");
		zw.switchDriver(driver);
		logger.info("driver has been switched to google sigin page");
		String title = lp.getCurrentTitle(driver);
		logger.info("captured current title");
		Assert.assertEquals(title.contains("Google"), true,"you are not directed to google signin");
		logger.info("TC_11_verifyDirectedTogoogleSign PASSED -- you has been directed to google signin");
		logger.info("***** TC_11_verifyDirectedTogoogleSign Finished *****");
	}
	

	@Test(priority = 12,groups= {"master","sanity"})
	public void TC_12_verifyErrorMsg() throws InterruptedException {
		
		
		logger.info("***** TC_12_verifyErrorMsg Started *****");
		String errorMsg = lp.enteringEmail();
		logger.info("invalid email has been entered");
		System.out.println(errorMsg);
		logger.info("error message has been printed");
		Assert.assertEquals(errorMsg.equals("Couldn’t find your Google Account"), true, "error message has not displayed");
		logger.info("TC_12_verifyErrorMsg PASSED -- error message has been displayed");
		logger.info("***** TC_12_verifyErrorMsg Finished *****");
	}
}
