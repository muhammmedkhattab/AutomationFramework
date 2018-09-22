package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import data.DataDriven;
import pom.HomePage;

public class UserNavigateToMenuTest extends TestBase {
	HomePage homeObject;
	
	String WestPageURL = DataDriven.getCellData("Prod_TD", "WestPageURL", 1);
	String homePageURL = DataDriven.getCellData("Prod_TD", "HomePageProdURL", 1);
	
	@Test(priority = 3)
	public void UserNavigateSuccessfully() throws InterruptedException {

		homeObject = new HomePage(driver);
		Thread.sleep(500);
		homeObject.navigateSideMenu();
		Thread.sleep(3000);
		
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equalsIgnoreCase(WestPageURL));
		getdriver(homePageURL);
	}
}
