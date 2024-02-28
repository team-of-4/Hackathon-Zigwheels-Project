package stepdefinations;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testbase.BaseClass;
import utilities.ExcelUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import pageobjects.UpcomingBikesPage;
import pageobjects.UpcomingHondaBikesPage;
import pageobjects.UsedCarChennaiPage;
import pageobjects.ZigWheelsPage;
 
 
public class Steps extends BaseClass
{
	public static WebDriver driver;
	public static Logger logger;
	//public Logger logger = LogManager.getLogger(this.getClass());
	public Properties p;

	String currentUrl = null;
	String currentUrlUBPage = null;
	String currentUrlUHPage = null;
	String currentUrlUCPage = null;
	String title = null;
	String errorMsg = null;
	boolean status;
	
	ZigWheelsPage zw;
	UpcomingBikesPage ub;
	UpcomingHondaBikesPage uh;
	UsedCarChennaiPage uc;
	LoginPage lp;

	List<String> bikeNames=new ArrayList<String>();
	List<String> bikePrices=new ArrayList<String>();
	List<String> bikeReleaseDates=new ArrayList<String>();
	List<String> usedCarModels = new  ArrayList<String>();
	Map<String,String[]> bikeUnder4Lac=new HashMap<String,String[]>();

	
	//ZigWheels feature
	//Scenario: ZigWheels Page
	@Given("User navigate to zigwheels page")
	public void User_navigate_to_zigwheels_page() throws IOException {
		logger = LogManager.getLogger(this.getClass());
		logger.info("cucumber started");
		logger.info("***** Scenario: ZigWheels Page Started *****");
		FileReader f = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(f);
		logger.info("config.properties file is loaded");
		driver = setup("chrome","windows");
		
		
	}
	
	@When("User gets the current url")
	public void User_gets_the_current_url() throws IOException {
		currentUrl = getUrl(driver);
		logger.info("Captuted the current url.");
	}
	
	@Then("Verify directed to zigwheels page")
	public void Verify_directed_to_zigwheels_page() {
		Assert.assertEquals(currentUrl.equals("https://www.zigwheels.com/"), true,"you are not directed to zigwheels.com");
		logger.info("***** Scenario: ZigWheels Page PASSED -- you has been directed to zigwheels.com *****");
	}
	
	
	
	//Scenario: Upcoming Page
	@Given("User is on zigwheels page")
	public void User_is_on_zigwheels_page() throws IOException {
		logger.info("***** Scenario: Upcoming Page Started *****");
		System.out.println("user is on zigwheels");
		logger.info("user is on zigwheels home page");
		
	}
	
	
	@When("User hover on new bikes")
	public void User_hover_on_new_bikes() {
		zw = new ZigWheelsPage(driver);
		zw.hoverNewBikes(driver);
		logger.info("hovered on new bikes");
	}
	
	@And("clicks on upcoming bikes")
	public void clicks_on_upcoming_bikes() {
		zw.clickUpcomingBikes();
		logger.info("clicked on upcoming bikes");
	}
	
	@And("capturing current url")
	public void capturing_current_url() {
		currentUrlUBPage = getUrl(driver);
		logger.info("captured the current url for upcoming bikes page");
	}
	
	@Then("Verify directed to upcoming page")
	public void Verify_directed_to_upcoming_page() {
		Assert.assertEquals(currentUrlUBPage.equals("https://www.zigwheels.com/upcoming-bikes"), true,"you are not directed to upcoming bikes");
		logger.info("verified that the user is on upcoming bikes page");
		logger.info("***** Scenario: Upcoming Page Finished *****");
	}
	
	
	
	//Feature: Upcoming Bikes
	//Scenario: Selecting Honda
	@Given("User is on upcoming bikes page")
	public void user_is_on_upcoming_bikes_page() {
		logger.info("***** Scenario: Selecting Honda Started *****");
	    System.out.println("user is on upcoming bike page");
	    logger.info("user is on upcoming bike page");
	}

	@When("User selects honda")
	public void user_selects_honda() {
		ub = new UpcomingBikesPage(driver);
		ub.selectingManufacturer();
		logger.info("honda manufacturer is selected");
		
	}

	@When("getting current url")
	public void getting_current_url() {
		currentUrlUHPage = getUrl(driver);
		logger.info("captured the current url for upcoming honda bikes page");
	}

	@Then("Verify directed to honda upcoming bikes")
	public void verify_directed_to_honda_upcoming_bikes() {
		Assert.assertEquals(currentUrlUHPage, "https://www.zigwheels.com/upcoming-honda-bikes","honda is not selected");
		logger.info("verified that the user is on upcoming honda bikes page");
		logger.info("***** Scenario: Selecting Honda Finished *****");
		
	}
	
	//Scenario: Check Bike Details
	@Given("User is on honda upcoming page")
	public void user_is_on_honda_upcoming_page() {
		logger.info("***** Scenario: Check Bike Details Started *****");
	    System.out.println("user is on honda upcoming page");
	    logger.info("user is on honda upcoming page");
	}

	@When("User click on view more")
	public void user_click_on_view_more() throws InterruptedException {
		uh = new UpcomingHondaBikesPage(driver);
		uh.clickViewMoreBikes();
		logger.info("clicked on view more");
	}

	@Then("Verify bike names")
	public void verify_bike_names() {
		bikeNames = uh.getHondaBikeNames();
		logger.info("got the bike names");
		for(int i=0;i<bikeNames.size();i++) {
			Assert.assertEquals(bikeNames.get(i).isEmpty(),false,"Name for bike "+i+" is not displayed");
		}
		logger.info("all bike names are present");
	}

	@Then("verify bike prices")
	public void verify_bike_prices() {
		bikePrices = uh.getHondaBikePrices();
		logger.info("got the bike price");
		for(int i=0;i<bikePrices.size();i++) {
			Assert.assertEquals(bikePrices.get(i).isEmpty(), false,"Price for bike "+i+" is not displayed");
		}
		logger.info("all bike prices are present");
	}

	@Then("verify bike release dates")
	public void verify_bike_release_dates() {
		bikeReleaseDates = uh.getHondaBikeReleaseDates();
		logger.info("got the bike release dates");
		for(int i=0;i<bikeReleaseDates.size();i++) {
			Assert.assertEquals(bikeReleaseDates.get(i).isEmpty(), false,"release date for bike "+i+" is not displayed");
		}
		logger.info("all bike release dates are present");
	}
	
	@Then("extract bikes under {int} lac to excel")
	public void extract_bikes_under_lac_to_excel(Integer int1) {
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
		System.out.println("written into excel");
		logger.info("***** Scenario: Check Bike Details Finished *****");
	}
	
	
	
	//Feature: Used Car Models
	//Scenario: Used Car Models Page
	@Given("User is on upcoming honda")
	public void user_is_on_upcoming_honda() {
		logger.info("***** Scenario: Used Car Models Page started *****");
	    System.out.println("user is on page and bikes under 4 lac extracted") ;
	    logger.info("user is on page and bikes under 4 lac extracted");
	}

	@When("User Scroll up")
	public void user_scroll_up() {
		uh = new UpcomingHondaBikesPage(driver);
		uh.scrollUp();
		 logger.info("scrolled Up");
	}

	@When("hover on used cars")
	public void hover_on_used_cars() {
		uh.clickUsedCars();
		 logger.info("clicked on used cars button");
	}

	@When("click on chennai")
	public void click_on_chennai() throws InterruptedException {
		uh.clickChennaiBtn();
		 logger.info("clicked on chennai button");
	}

	@Then("Directed to used cars in chennai")
	public void directed_to_used_cars_in_chennai() {
		currentUrlUCPage = getUrl(driver);
		logger.info("got url for used cars in chennai page");
		Assert.assertEquals(currentUrlUCPage, "https://www.zigwheels.com/used-car/Chennai","you are not directed to used cars chennai page.");
		logger.info("verified that the user is on used cars page");
	}

	@Then("extract new car models to excel")
	public void extract_new_car_models_to_excel() throws IOException {
		uc = new UsedCarChennaiPage(driver);
		usedCarModels = uc.getUsedCarsModels();
		logger.info("got used car models");
		for(String e : usedCarModels) {
			
			System.out.println(e);
			
		}
		ExcelUtils.writeIntoExistingExcel("popular car models", usedCarModels);
		System.out.println("written into excel");
		logger.info("written into excel");
		
	}
	
	@Then("going back to home page")
	public void going_back_to_home_page() {
		uc.goToHomePage();
		logger.info("directed to home page");
		logger.info("***** Scenario: Selecting Honda Finished *****");
	}
	
	
	//Feature: User Login
	//Scenario: Login Page
	@Given("User is on home page")
	public void user_is_on_home_page() {
		logger.info("***** Scenario: Login Page Started *****");
	    System.out.println("user is on home page");
	    logger.info("user is on home page");
	}

	@When("Login button is displayed")
	public void login_button_is_displayed() {
		zw = new ZigWheelsPage(driver);
		status = zw.btnLoginIsDisplayed();
		logger.info("login button is displayed");
	}

	@Then("click on login button and goggle sigin button")
	public void click_on_login_button_and_goggle_sigin_button() {
		if(status) {
			zw.clickLogin();
			logger.info("login button is clicked");
			zw.clickGoogleSigin(driver);
			logger.info("google signin button is clicked");
		}
		Assert.assertEquals(status, true,"the login button is not displayed");
		logger.info("***** Scenario: Login Page Finished *****");
	}
	


	
	//Scenario: Google Sign Page
	@Given("User is google sign page")
	public void user_is_google_sign_page() {
		logger.info("***** Scenario: Google Sign Page Started *****");
		zw = new ZigWheelsPage(driver);
		lp = new LoginPage(driver);
		zw.switchDriver(driver);
		System.out.println("user is on google sign page");
		logger.info("user is on google sign page");
	}

	@When("User gets title of page")
	public void user_gets_title_of_page() {
		 title = lp.getCurrentTitle(driver);
		 logger.info("getting title of google sign in page");
	}

	@Then("Verify the page title")
	public void verify_the_page_title() {
		Assert.assertEquals(title.contains("Google"), true,"you are not directed to google signin");	
		logger.info("verified that we are on google sign in page");
	}

	@Then("entering wrong email id and capturing error message")
	public void entering_wrong_email_id_and_capturing_error_message() throws InterruptedException {
		errorMsg = lp.enteringEmail();
		logger.info("entered invalid email");
		Assert.assertEquals(errorMsg.equals("Couldn’t find your Google Account"), true, "error message has not displayed");
		logger.info("verified that error message is displayed");
	}

	@Then("closing the all windows")
	public void closing_the_all_windows() {
		driver.quit();
		logger.info("***** Scenario: Google Sign Page Finished *****");
	}
	
	
	
	
}