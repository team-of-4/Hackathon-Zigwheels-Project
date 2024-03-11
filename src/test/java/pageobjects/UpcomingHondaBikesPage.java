package pageobjects;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UpcomingHondaBikesPage extends BasePage{

	List<String> bikeNamesTxt = new ArrayList<String>();
	List<String> bikePricesTxt = new ArrayList<String>();
	List<String> bikeReleaseDatesTxt = new ArrayList<String>();
	
	public UpcomingHondaBikesPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
	WebElement btnViewMoreBikes;
	
	@FindBy(xpath="//strong[@class='lnk-hvr block of-hid h-height']")
	List<WebElement> listBikeNames;
	
	@FindBy(xpath="//div[contains(@title,'Ex-Showroom')]")
	List<WebElement> listBikePrices;
	
	@FindBy(xpath="//div[contains(text(),'Launch')]")
	List<WebElement> listBikeReleaseDates;
	
	@FindBy(xpath="//a[@href='/used-car']")
	WebElement drpdwnUsedCars;
	
	@FindBy(xpath="//span[normalize-space()='Chennai']")
	WebElement btnChennai;

	
	
	
public void clickViewMoreBikes() throws InterruptedException {
		
		//Thread.sleep(30);
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		
//		 wait.until(ExpectedConditions.elementToBeClickable(btnViewMoreBikes)).click();
//		
//		btnViewMoreBikes.click();
		 
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();",btnViewMoreBikes );
		 
		
		
	}
	
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
	
//	public void listWebElementToString() {
//		
//		for(int i=0; i<listBikeNames.size(); i++) {
//			
//			bikeNamesTxt.add(listBikeNames.get(i).getText());
//			bikePricesTxt.add(listBikePrices.get(i).getText());
//			bikeReleaseDatesTxt.add(listBikeReleaseDates.get(i).getText());
//		}
//		
//	}
	
	public List<String> getHondaBikeNames() {
		
		for(int i=0; i<listBikeNames.size(); i++) {	
			bikeNamesTxt.add(listBikeNames.get(i).getText());
		}
		
		return bikeNamesTxt;
		
	}
	
	public List<String> getHondaBikePrices() {
		
		for(int i=0; i<listBikePrices.size(); i++) {
			bikePricesTxt.add(listBikePrices.get(i).getText());
		}
		
		return bikePricesTxt;
			
	}
	
	public List<String> getHondaBikeReleaseDates() {
		
		for(int i=0; i<listBikeReleaseDates.size(); i++) {
			bikeReleaseDatesTxt.add(listBikeReleaseDates.get(i).getText());
		}
		
		return bikeReleaseDatesTxt;
		
	}
	
	public void scrollUp()  {
		
		//Thread.sleep(20);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollTo(0,0)", "");
		
		
	}
	
	public void clickUsedCars()  {
		
		
		
	//	Thread.sleep(20);
		
		Actions act = new Actions(driver);
		
		act.moveToElement(drpdwnUsedCars).perform();
		
		
		
		
	}
	
	public void clickChennaiBtn() throws InterruptedException {
		Thread.sleep(5);
		btnChennai.click();
	}
	

}
