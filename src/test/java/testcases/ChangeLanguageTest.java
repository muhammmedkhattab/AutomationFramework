package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import data.DataDriven;
import pom.HomePage;
import pom.PageBase;

public class ChangeLanguageTest extends TestBase {
	HomePage homeObject;
	String DeutschlandURL = DataDriven.getCellData("Prod_TD", "DeutschlandURL", 1);
	String CountriesLanguageDeutschland = DataDriven.getCellData("Prod_TD", "CountriesLanguage", 1);
	String CountriesLanguageUSA = DataDriven.getCellData("Prod_TD", "CountriesLanguage", 2);
	String homePageURL = DataDriven.getCellData("Prod_TD", "HomePageProdURL", 1);

	PageBase PageObject;
	@Test(priority = 1)
	public void ChangeLanguage() throws InterruptedException {

		homeObject = new HomePage(driver);
		//PageObject = new PageBase(driver);

		homeObject.selectLanguage(CountriesLanguageDeutschland);
		Thread.sleep(300);
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equalsIgnoreCase(DeutschlandURL));
		Thread.sleep(500);
		homeObject.selectLanguage(CountriesLanguageUSA);


	}
}
