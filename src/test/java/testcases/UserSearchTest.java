package testcases;

import org.testng.annotations.Test;
import data.DataDriven;
import pom.HomePage;
import pom.SearchPage;

public class UserSearchTest extends TestBase {

	SearchPage searchObject;
	
	HomePage homeObject;
	String searchTXT = DataDriven.getCellData("Prod_TD", "SearchText", 1);
	String homePageURL = DataDriven.getCellData("Prod_TD", "HomePageProdURL", 1);
	
	@Test(priority = 2)
	public void UserSearchSuccessfully() throws InterruptedException {
		
		
		homeObject = new HomePage(driver);
		searchObject = new SearchPage(driver);
		homeObject.openSearch();
		searchObject.searchForValue(searchTXT);
		
		driver.navigate().to(homePageURL);
	}
}
