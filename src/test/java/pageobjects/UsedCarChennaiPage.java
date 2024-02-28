package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsedCarChennaiPage extends BasePage{

	public UsedCarChennaiPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[contains(@class,'usedCarMakeModelList')]//li")
	List<WebElement> listUsedCarModels;
	
	@FindBy(xpath="//a[@href='/']")
	WebElement linkHomepage;
	
	public List<String> getUsedCarsModels(){
		
		List<String> usedCarModelsTxt = new ArrayList<String>();
		
		for(WebElement e : listUsedCarModels) {
					
			usedCarModelsTxt.add(e.getText());
					
		}
	
		return usedCarModelsTxt;
	}
	
	public void goToHomePage() {
		linkHomepage.click();
	}
	

}
