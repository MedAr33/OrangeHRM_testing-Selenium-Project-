package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.OrangeLoginPage;

public class TC_002_Login extends BaseClass {
	@Test
	public void login() {
		OrangeLoginPage olp = new OrangeLoginPage(driver);
		
		olp.setUsername("Testprofile");
		log.info("username entered");
		olp.setPasseword("12345678");
		log.info("passeword entered");
		olp.clickLogin();
		log.info("login button pressed");
		
		if (olp.isWelcomeDisplayed()) {
			log.info("login passed");
			Assert.assertTrue(true);			
		}else {
			log.info("login failed");
			Assert.assertTrue(false);
		}
	}
}
