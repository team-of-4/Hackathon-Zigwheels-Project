package pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZigWheelsPage extends BasePage{

	public ZigWheelsPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='New Bikes']")
	WebElement drpdwnNewBikes;
	
	@FindBy(xpath="//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
	WebElement spanUpcomingBikes;
	
	//new pages below
	
//	@FindBy(id="makeId")
//	WebElement drpdwnManufacturers; -- upcoming bikes page
	
	
	
//	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
//	WebElement btnViewMoreBikes;
//	
//	@FindBy(xpath="//strong[@class='lnk-hvr block of-hid h-height']")
//	List<WebElement> listBikeNames;
//	
//	@FindBy(xpath="//div[contains(@title,'Ex-Showroom')]")
//	List<WebElement> listBikePrices;
//	
//	@FindBy(xpath="//div[contains(text(),'Launch Date')]")
//	List<WebElement> listBikeReleaseDates;
//	
//	@FindBy(xpath="//a[@href='/used-car']")
//	WebElement drpdwnUsedCars;
//	
//	@FindBy(xpath="//span[normalize-space()='Chennai']")
//	WebElement btnChennai;
	
//	@FindBy(xpath="//ul[contains(@class,'usedCarMakeModelList')]//li")
//	List<WebElement> listUsedCarModels;
//	
//	@FindBy(xpath="//a[@href='/']")
//	WebElement linkHomepage;
	
	
	
	//------------
	@FindBy(id="forum_login_div_lg")
	WebElement btnLogin;
	
	@FindBy(xpath="//div[contains(@class,'googleSignIn')]")
	WebElement btnGoogleSignin;
	
	
	public String getUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void hoverNewBikes(WebDriver driver) {
		
		Actions act = new Actions(driver);
		act.moveToElement(drpdwnNewBikes);
		act.perform();
	
		
	}
	
	public void clickUpcomingBikes() {
		spanUpcomingBikes.click();
	}
	
//	public void selectingManufacturer() {
//		
//		Select select =  new Select(drpdwnManufacturers);
//		select.selectByVisibleText("Honda");
//			
//	}
	
//	public void clickViewMoreBikes() throws InterruptedException {
//		
//		//Thread.sleep(30);
//		
////		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
////		
////		 wait.until(ExpectedConditions.elementToBeClickable(btnViewMoreBikes)).click();
////		
////		btnViewMoreBikes.click();
//		 
//		 JavascriptExecutor js = (JavascriptExecutor)driver;
//		 js.executeScript("arguments[0].click();",btnViewMoreBikes );
//		 
//		
//		
//	}
//	
//	public Map<String, String[]> getUpcomingHondaBikesUnder4Lac() {
//		
//		Map<String,String[]> bikeUnder4Lac = new LinkedHashMap<String,String[]>();
//		
//		for(int i=0 ; i<listBikeNames.size();i++) {
//			
//			String bikeName = listBikeNames.get(i).getText();
//		//	bikeNamesTxt.add(bikeName);
//			String bikePrice = listBikePrices.get(i).getText();
//		//	bikePricesTxt.add(bikePrice);
//			String bikeReleaseDate = listBikeReleaseDates.get(i).getText();
//		//	bikeReleaseDatesTxt.add(bikeReleaseDate);
//			
//			String[] bikePrice_ =  bikePrice.split(" ");
//			
//			double bikePriceD = 0;
//			int bikePriceI = 0;
//			
//			if(bikePrice_[1].contains(".")) {
//				bikePriceD = Double.parseDouble(bikePrice_[1]);
//			}
//			else {
//				String a = bikePrice_[1].replace(",", "");
//				bikePriceI = Integer.parseInt(a);
//			}
//			
//			if(bikePriceD<4.0) {
//				bikeUnder4Lac.put(bikeName, new String[] {bikePrice,bikeReleaseDate});
//			}
//			
//					
//		}
//		
//		return bikeUnder4Lac;
//	}
//	
////	public List<WebElement> extractHondaBikeNames() {
////		
////		return listBikeNames;
////		
////	}
////	
////	public List<WebElement> extractHondaBikePrices() {
////			
////			return listBikePrices;
////			
////	}
////	
////	public List<WebElement> extractHondaBikeReleaseDates() {
////		
////		return listBikeReleaseDates;
////		
////	}
//	
//	public void scrollUp() throws InterruptedException {
//		
//		//Thread.sleep(20);
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		
//		js.executeScript("window.scrollTo(0,0)", "");
//		
//	}
//	
//	public void clickUsedCars() throws InterruptedException {
//		
//		
//		
//	//	Thread.sleep(20);
//		
//		Actions act = new Actions(driver);
//		
//		act.moveToElement(drpdwnUsedCars).perform();
//		
//		btnChennai.click();
//		
//		
//	}
	
//	public List<String> getUsedCarsModels(){
//		
//		List<String> usedCarModelsTxt = new ArrayList<String>();
//		
//		for(WebElement e : listUsedCarModels) {
//					
//			usedCarModelsTxt.add(e.getText());
//					
//		}
//	
//		return usedCarModelsTxt;
//	}
//	
//	public void goToHomePage() {
//		linkHomepage.click();
//	}

	public boolean btnLoginIsDisplayed() {
		return btnLogin.isDisplayed();
	}
	
	public boolean btnGoogleSigninIsDisplayed() {
		return btnGoogleSignin.isDisplayed();
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickGoogleSigin(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",btnGoogleSignin);
		
	}
	
	public void switchDriver(WebDriver driver) {
		
		Set<String> windowIds = driver.getWindowHandles();
		
		ArrayList<String> windowIdsList = new ArrayList<String>(windowIds);
		
		driver.switchTo().window(windowIdsList.get(1));
		
	}
}
