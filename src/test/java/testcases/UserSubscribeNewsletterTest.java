package testcases;


import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import data.DataDriven;
import pom.HomePage;

public class UserSubscribeNewsletterTest extends TestBase {
	String homePageURL = DataDriven.getCellData("Prod_TD", "HomePageProdURL", 1);
	HomePage homeObject;
	Faker fakeData = new Faker();
	String email = fakeData.internet().emailAddress();

	@Test(priority = 4)
	public void UserSearchSuccessfully() throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.Subscribe(email);
		getdriver(homePageURL);

	}
}
