package testcases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.UpcomingHondaBikesPage;
import pageobjects.UsedCarChennaiPage;
import testbase.BaseClass;
import utilities.ExcelUtils;

public class TS_03_UsedCarModels extends BaseClass{

	public UpcomingHondaBikesPage uh;
	public UsedCarChennaiPage uc;
	
	@Test(priority = 8,groups= {"master","smoke"})
	public void TC_08_verifyDirectedToUsedCarsChennai() throws InterruptedException 	{
		
		uh = new UpcomingHondaBikesPage(driver);
		uc = new UsedCarChennaiPage(driver);
		logger.info("***** TC_08_verifyDirectedToUsedCarsChennai Started *****");
		uh.scrollUp();
		logger.info("Scrolled Up");
		uh.clickUsedCars();
		logger.info("Hover on used cars");
		uh.clickChennaiBtn();
		logger.info("Clicked on chennai button");
		String currentUrl = getUrl(driver);
		logger.info("Captured current url");
		Assert.assertEquals(currentUrl, "https://www.zigwheels.com/used-car/Chennai","you are not directed to used cars chennai page.");
		logger.info("TC_08_verifyDirectedToUsedCarsChennai PASSED -- You has been directed to used cars chennai");
		logger.info("***** TC_08_verifyDirectedToUsedCarsChennai Finished *****");
	}
	
	@Test(priority = 9,groups= {"master","sanity"})
	public void TC_09_extarctUsedCarsModel() throws IOException  {
		
		logger.info("***** TC_09_extarctUsedCarsModel Started *****");
		List<String> usedCarModels = uc.getUsedCarsModels();
		logger.info("Captured used car models");
		
		for(String e : usedCarModels) {
			
			System.out.println(e);
			
		}
		logger.info("Printed used car models");
		ExcelUtils.writeIntoExistingExcel("popular car models", usedCarModels);
		logger.info("popular models has been written in excel");
		//go back to home
		uc.goToHomePage();
		logger.info("Redirected to home page");
		logger.info("TC_09_extarctUsedCarsModel PASSED -- All car models has been printed");
		logger.info("***** TC_09_extarctUsedCarsModel Finished *****");
	}
	
	
}
