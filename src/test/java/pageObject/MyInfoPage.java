package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {
	
	WebDriver driver;

	public MyInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//b[contains(text(),'My Info')]")
	WebElement myInfoTab;
	
	@FindBy(xpath = "//h1[contains(text(),'Personal Details')]")
	WebElement personalDetails;
	
	public void clickMyInfoTab() {
		myInfoTab.click();
	}
	public boolean isDetailsDisplayed() {
		return personalDetails.isDisplayed();
	}
}
