package pageObject;

import java.io.IOException;
import java.util.List;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfoPage {

	WebDriver driver;

	public MyInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[contains(text(),'My Info')]")
	WebElement myInfoTab;

	@FindBy(xpath = "//h1[contains(text(),'Personal Details')]")
	WebElement personalDetailsTitle;

	@FindBy(xpath = "//a[contains(text(),'Personal Details')]")
	WebElement personalDetailsLink;

	@FindBy(id = "btnSave")
	WebElement editBtn;

	@FindBy(name = "personal[txtEmpFirstName]")
	WebElement fName;

	@FindBy(name = "personal[txtEmpMiddleName]")
	WebElement mName;

	@FindBy(name = "personal[txtEmpLastName]")
	WebElement lName;

	@FindBy(name = "personal[txtLicExpDate]")
	WebElement licenseExDate;

	@FindBy(xpath = "//li[@class='radio']")
	List<WebElement> genderList;

	@FindBy(id = "personal_cmbNation")
	WebElement nationalityMenu;

	@FindBy(id = "personal_cmbMarital")
	WebElement statusMenu;

	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@class='message success fadable']")
	WebElement saveSuccessMsg;
	
	@FindBy(id = "empPic")
	WebElement photograph;
	
	@FindBy(id = "photofile")
	WebElement addFileBtn;
	
	@FindBy(id = "btnSave")
	WebElement uploadBtn;
	
	@FindBy(xpath = "//div[@class='message success fadable']")
	WebElement warningMsg;
	
	
	
	
	public void waitForVisibility(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
	}
	public void waitToBeClickabale(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickMyInfoTab() {
		myInfoTab.click();
	}

	public void clickPDetailsLink() {
		waitForVisibility(personalDetailsLink);
		personalDetailsLink.click();
	}

	public void clickEditBtn() {
		editBtn.click();
	}

	public boolean isDetailsDisplayed() {
		return personalDetailsTitle.isDisplayed();
	}

	public void editfName(String first) {
		fName.clear();
		fName.sendKeys(first);
	}

	public void editmName(String middle) {
		mName.clear();
		mName.sendKeys(middle);
	}

	public void editlName(String last) {
		lName.clear();
		lName.sendKeys(last);
	}

	public void editLicenseExDate(String date) {
		licenseExDate.clear();
		licenseExDate.sendKeys(date);
	}

	public void editGender() {
		for (WebElement element : genderList) {
			if (!element.isSelected()) {
				element.click();

			}
		}
	}

	public void editNationalityMenu(String nationality) {
		Select sel = new Select(nationalityMenu);
		sel.selectByVisibleText(nationality);
	}

	public void editMStatus(String stat) {
		Select selectStat = new Select(statusMenu);
		selectStat.selectByVisibleText(stat);
	}

	public void clickSaveBtn() {
		saveBtn.click();
	}

	public boolean isSaveSuccessMsgDisplayed() {
		waitForVisibility(saveSuccessMsg);
		return saveSuccessMsg.isDisplayed();
	}
	public void clickPhotoCorner() {
		photograph.click();
	}
	
	public void addPhotograph() throws IOException {
		Actions action = new Actions(driver);
		action.moveToElement(addFileBtn).click().perform();
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\AutoIT\\upload500mo.exe");
	}
	public void clickUploadBtn() {
		waitToBeClickabale(uploadBtn);
		uploadBtn.click();
	}
	public String getWarningMsg() {
		waitForVisibility(warningMsg);
		return warningMsg.getText();
	}

}
