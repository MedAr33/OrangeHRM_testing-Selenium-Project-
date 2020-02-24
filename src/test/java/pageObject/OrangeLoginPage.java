package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLoginPage {
	
	WebDriver driver;

	public OrangeLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "txtUsername")	
	WebElement usernameField;
	
	@FindBy(id = "txtPassword")	
	WebElement passewordField;
	
	@FindBy(id = "btnLogin")	
	WebElement loginBtn;
	
	@FindBy(id = "welcome")
	WebElement menu;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutBtn;
	
	
	
	public void setUsername(String uname) {
		usernameField.sendKeys(uname);		
	}
	public void setPasseword(String pword) {
		passewordField.sendKeys(pword);
	}
	public void clickLogin() {
		loginBtn.click();
	}
	public void clickLogout() {
		menu.click();
		logoutBtn.click();
	}
	
}
