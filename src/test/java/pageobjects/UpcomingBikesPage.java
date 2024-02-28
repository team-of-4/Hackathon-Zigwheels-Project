package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpcomingBikesPage extends BasePage {

	public UpcomingBikesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="makeId")
	WebElement drpdwnManufacturers;
	
	public void selectingManufacturer() {
		
		Select select =  new Select(drpdwnManufacturers);
		select.selectByVisibleText("Honda");
			
	}
	
	
}
