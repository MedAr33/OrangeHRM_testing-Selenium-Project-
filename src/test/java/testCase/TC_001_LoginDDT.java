package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.OrangeLoginPage;
import utilities.XLutils;

public class TC_001_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String usename, String passeword) throws IOException {
		OrangeLoginPage olp = new OrangeLoginPage(driver);

		olp.setUsername(usename);
		log.info("username entered");
		olp.setPasseword(passeword);
		log.info("passeword entered");
		olp.clickLogin();
		log.info("login button pressed");

		if (!driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/index.php/auth/")) {
			if (driver.getCurrentUrl()
					.equals("https://opensource-demo.orangehrmlive.com/index.php/pim/viewMyDetails")) {
				log.info("login passed : valid credentials \n Myinfo paged is played");
				olp.clickLogout();
				Assert.assertTrue(true);
			} else {
				log.info("login passed : valid credentials \n Myinfo page is not displayed !");
				captureScreen(driver, "loginDDT");
				olp.clickLogout();
				Assert.assertTrue(false);
			}

		} else {
			log.info("login failed : invalid credentials");
			Assert.assertTrue(true);

		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = "C:\\Users\\USER\\Documents\\eclipse-workspace\\OrangeHRM\\testData\\loginTestData.xlsx";

		int rownum = XLutils.getRowCount(path, "Feuil1");
		int colcount = XLutils.getCellCount(path, "Feuil1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLutils.getCellData(path, "Feuil1", i, j);// 1 0
			}

		}
		return logindata;
	}
}
