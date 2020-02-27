package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.MyInfoPage;
import pageObject.OrangeLoginPage;

public class TC_005_AddPhotograph extends BaseClass {
	@Test
	public void uploadPhotograph() throws IOException, InterruptedException {
		OrangeLoginPage olp = new OrangeLoginPage(driver);
		MyInfoPage mp = new MyInfoPage(driver);

		olp.setUsername("Testprofile");
		log.info("username entered");
		olp.setPasseword("12345678");
		log.info("passeword entered");
		olp.clickLogin();
		log.info("login button pressed");

		mp.clickMyInfoTab();
		log.info("My Info tab is clicked");
		
		mp.clickPhotoCorner();
		log.info("photo in the corner clicked");		
		
		mp.addPhotograph();
		log.info("photograph 1mb added");
		
		mp.clickUploadBtn();
		log.info("upload button clicked");
		
		if (mp.getWarningMsg().contains("Successfully Uploaded" )) {
			log.info("photograph <1mb uploaded : test succeed");
			Assert.assertTrue(true);
		}else {
			log.info("photograph failed to upload : test failed");
			Assert.assertTrue(false);
		}
	}
	
}
