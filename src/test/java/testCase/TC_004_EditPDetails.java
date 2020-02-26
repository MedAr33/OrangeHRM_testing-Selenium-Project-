package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.MyInfoPage;
import pageObject.OrangeLoginPage;

public class TC_004_EditPDetails extends BaseClass {
	@Test
	public void editPDetails() throws IOException {
		OrangeLoginPage olp = new OrangeLoginPage(driver);
		MyInfoPage mip = new MyInfoPage(driver);
		
		olp.setUsername("Testprofile");
		log.info("username entered");
		olp.setPasseword("12345678");
		log.info("passeword entered");
		olp.clickLogin();
		log.info("login button pressed");
		
		mip.clickMyInfoTab();
		log.info("My Info tab is clicked");
		mip.clickPDetailsLink();
		log.info("Personal Details link is clicked");
		mip.clickEditBtn();
		log.info("Edit button is clicked");
		mip.editfName("fTest");
		log.info("First name is modified");
		mip.editmName("mTest");
		log.info("Middle name is modified");
		mip.editlName("lTest");
		log.info("Last name is modified");
		mip.editLicenseExDate("2020-02-26");
		log.info("License expiry date is modified");
		mip.editGender();
		log.info("Gender is modified");
		mip.editMStatus("Single");
		log.info("Marital status is modified");
		mip.editNationalityMenu("Tunisian");
		log.info("Nationality is modified");
		
		
		mip.clickSaveBtn();
		log.info("Save button is pressed");
		
		if (mip.isSaveSuccessMsgDisplayed()) {
			log.info("Personal Details are modified and saved successfully");
			Assert.assertTrue(true);
		}else {
			log.info("Failed to modify and save Personal Details");
			captureScreen(driver, "TC_004_EditPDetails");
			Assert.assertTrue(false);
		}

	}
}
