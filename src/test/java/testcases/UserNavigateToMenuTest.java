package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import data.DataDriven;
import pom.HomePage;

public class UserNavigateToMenuTest extends TestBase {
	HomePage homeObject;

	String WestPageURL = DataDriven.getCellData("Prod_TD", "WestPageURL", 1);
	String sideMenuBtnLocator = DataDriven.getCellData("HomePageLocators", "HomeSideMenu", 1);
	String menuItemLocator = DataDriven.getCellData("HomePageLocators", "HomeMenuItem", 1);
	@Test(priority = 3)
	public void UserNavigateSuccessfully() throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.navigateSideMenu(driver, sideMenuBtnLocator, menuItemLocator);
		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equalsIgnoreCase(WestPageURL));

	}
}
