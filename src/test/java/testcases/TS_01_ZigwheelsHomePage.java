package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.ZigWheelsPage;
import testbase.BaseClass;

public class TS_01_ZigwheelsHomePage extends BaseClass{

	public ZigWheelsPage zw;
	
	@Test(priority = 1,groups= {"smoke","master"})
	public void TC_01_verifyDirectedToCorrectSite() {
		
		zw = new ZigWheelsPage(driver);
		logger.info("***** TC_01_verifyDirectedToCorrectSite Start *****");
		String currentUrl = getUrl(driver);
		logger.info("Captuted the current url.");
		Assert.assertEquals(currentUrl.equals("https://www.zigwheels.com/"), true,"you are not directed to zigwheels.com");
		logger.info("TC_01_verifyDirectedToCorrectSite PASSED -- you has been directed to zigwheels.com");
		logger.info("***** TC_01_verifyDirectedToCorrectSite End *****");
		
	}
	
	
	@Test(priority = 2,groups= {"regression","master"})
	public void TC_02_verifyDirectedToUpcomingBikes() {
		
		//zw = new ZigWheelsPage(driver);
		logger.info("***** TC_02_verifyDirectedToUpcomingBikes Started *****");
		zw.hoverNewBikes(driver);
		logger.info("Hover on new bikes.");
		zw.clickUpcomingBikes();
		logger.info("Clicked on upcoming bikes.");
		String currentUrl = zw.getUrl(driver);
		logger.info("Captuted the current url.");
		Assert.assertEquals(currentUrl.equals("https://www.zigwheels.com/upcoming-bikes"), true,"you are not directed to upcoming bikes");
		logger.info("TC_02_verifyDirectedToUpcomingBikes PASSED -- you has been directed to upcoming bikes");
		logger.info("***** TC_02_verifyDirectedToUpcomingBikes Finished *****");
	}
	
	
	
}
