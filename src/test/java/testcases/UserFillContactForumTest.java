package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import data.DataDriven;
import pom.ContactPage;
import pom.HomePage;
import pom.PageBase;

public class UserFillContactForumTest extends TestBase {
	Faker fakeData = new Faker();
	String email = fakeData.internet().emailAddress();
	String Name = fakeData.name().fullName();
	String Message = fakeData.gameOfThrones().character();
	String homePageURL = DataDriven.getCellData("Prod_TD", "HomePageProdURL", 1);
	HomePage homeObject;
	ContactPage contactObject;
	PageBase PageObject;
	
	// WindowHandling();
	String urlContactPage = DataDriven.getCellData("Prod_TD", "ContactPageURL", 1);

	@Test(priority = 5)
	public void UserFillForumSuccessfully() throws InterruptedException {
		Thread.sleep(500);
		homeObject = new HomePage(driver);
		contactObject = new ContactPage(driver);
		PageObject = new PageBase(driver);
		PageObject.saveCurrentURL(driver);
		homeObject.clickOnContactForm();

		PageObject.WindowHandling(driver, urlContactPage);
		contactObject.fillContactForum(Message, Name, email);

		String message = contactObject.successMessage.getText();
		String regex = ".*(Message|Successfully).*";
		Assert.assertTrue(message.matches(regex));
		driver.navigate().to(homePageURL);
	}
}
