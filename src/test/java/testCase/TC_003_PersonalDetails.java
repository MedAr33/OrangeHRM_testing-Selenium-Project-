package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.MyInfoPage;
import pageObject.OrangeLoginPage;

public class TC_003_PersonalDetails extends BaseClass {
	@Test
	public void presenceOfPD() {
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
		
		if (mp.isDetailsDisplayed()) {
			log.info("personal details are displayed");
			Assert.assertTrue(true);
		}else {
			log.info("fail : personal details are not displayed");
			Assert.assertTrue(false);
		}
		
	}
}
