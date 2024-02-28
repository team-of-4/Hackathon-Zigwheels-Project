package testcases;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.UpcomingBikesPage;
import pageobjects.UpcomingHondaBikesPage;
import testbase.BaseClass;
import utilities.ExcelUtils;

public class TS_02_UpcomingHondaBikes extends BaseClass{
	
	List<String> bikeNames = new ArrayList<String>();
	List<String> bikePrices = new ArrayList<String>();
	List<String> bikeReleaseDates = new ArrayList<String>();
	
	Map<String,String[]> bikeUnder4Lac = new LinkedHashMap<String,String[]>();
	
	public UpcomingBikesPage ub;
	public UpcomingHondaBikesPage uh;

	@Test(priority = 3,groups= {"master","smoke"})
	public void TC_03_verifySelectedManfufacturerHonda() {
		uh = new UpcomingHondaBikesPage(driver);
		ub = new UpcomingBikesPage(driver);
		logger.info("***** TC_03_verifySelectedManfufacturerHonda Started *****");
		ub.selectingManufacturer();
		logger.info("honda is selected.");
		String currentUrl = getUrl(driver);
		logger.info("Captuted the current url.");
		Assert.assertEquals(currentUrl, "https://www.zigwheels.com/upcoming-honda-bikes","honda is not selected");
		logger.info("TC_03_verifySelectedManfufacturerHonda PASSED -- honda has been selected");
		logger.info("***** TC_03_verifySelectedManfufacturerHonda Finished *****");
	}
	
	
	@Test(priority = 4,groups= {"master","sanity"})
	public void TC_04_verifyBikeNameForUpcomingHondaBikes() throws InterruptedException {
		logger.info("***** TC_04_verifyBikeNameForUpcomingHondaBikes Started *****");
		uh.clickViewMoreBikes();
		logger.info("Clicked on view more bikes");
		bikeNames = uh.getHondaBikeNames();
		logger.info("Gets the list of names of honda upcoming bikes");
		//System.out.println(bikeNames.size());
		for(int i=0;i<bikeNames.size();i++) {
			Assert.assertEquals(bikeNames.get(i).isEmpty(),false,"Name for bike "+i+" is not displayed");
		}
		logger.info("TC_04_verifyBikeNameForUpcomingHondaBikes PASSED -- names for all bikes are displayed");
		logger.info("***** TC_04_verifyBikeNameForUpcomingHondaBikes Finished *****");
		
	}
	
	
	@Test(priority = 5,groups= {"master","sanity"})
	public void TC_05_verifyBikePricesForUpcomingHondaBikes() {
		logger.info("***** TC_05_verifyBikePricesForUpcomingHondaBikes Started *****");
		bikePrices = uh.getHondaBikePrices();
		logger.info("Gets the list of prices of honda upcoming bikes");
		//System.out.println(bikePrices.size());
		for(int i=0;i<bikePrices.size();i++) {
			Assert.assertEquals(bikePrices.get(i).isEmpty(), false,"Price for bike "+i+" is not displayed");
		}
		logger.info("TC_05_verifyBikePricesForUpcomingHondaBikes PASSED -- prices for all bikes are displayed");
		logger.info("***** TC_05_verifyBikePricesForUpcomingHondaBikes Finished *****");
		
	}
	
	
	@Test(priority = 6,groups= {"master","sanity"})
	public void TC_06_verifyBikeReleaseDatesForUpcomingHondaBikes() {
		logger.info("***** TC_06_verifyBikeReleaseDatesForUpcomingHondaBikes Started *****");
		bikeReleaseDates = uh.getHondaBikeReleaseDates();
		logger.info("Gets the list of release date of honda upcoming bikes");
		//System.out.println(bikeReleaseDates.size());
		for(int i=0;i<bikeReleaseDates.size();i++) {
			Assert.assertEquals(bikeReleaseDates.get(i).isEmpty(), false,"release date for bike "+i+" is not displayed");
		}
		logger.info("TC_06_verifyBikeReleaseDatesForUpcomingHondaBikes PASSED -- release date for all bikes are displayed");
		logger.info("***** TC_06_verifyBikeReleaseDatesForUpcomingHondaBikes Finished *****");
		
	}
	
	@Test(priority = 7,groups= {"master","sanity"})
	public void TC_07_extractHondaBikes4lac() throws InterruptedException {
	
		logger.info("***** TC_07_extractHondaBikes4lac Started *****");
		for(int i=0 ; i<bikeNames.size();i++) {
			
			String bikeName = bikeNames.get(i);
	
			String bikePrice = bikePrices.get(i);
	
			String bikeReleaseDate = bikeReleaseDates.get(i);
			
			String[] bikePrice_ =  bikePrice.split(" ");
			
			double bikePriceD = 0;
			int bikePriceI = 0;
			
			if(bikePrice_[1].contains(".")) {
				bikePriceD = Double.parseDouble(bikePrice_[1]);
			}
			else {
				String a = bikePrice_[1].replace(",", "");
				bikePriceI = Integer.parseInt(a);
			}
			
			if(bikePriceD<4.0) {
				bikeUnder4Lac.put(bikeName, new String[] {bikePrice,bikeReleaseDate});
			}
			
					
		}
		
		for(Map.Entry<String, String[]> e :bikeUnder4Lac.entrySet()) {	
			
			System.out.println("Bike Name: "+e.getKey()+" Price: "+e.getValue()[0]+" Release Date: "+e.getValue()[1]);
		}
		ExcelUtils.savetoExcel("honda bikes under 4Lac", bikeUnder4Lac);
		logger.info("written into excel");
		logger.info("TC_07_extractHondaBikes4lac PASSED -- Honda bikes under 4 Lac printed.");
		logger.info("***** TC_07_extractHondaBikes4lac Finished *****");
		
	}
	
}
