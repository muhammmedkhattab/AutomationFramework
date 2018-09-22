package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import data.DataDriven;

public class HomePage extends PageBase {
	// DataDriven DD =new DataDriven();
	String SearchObjectByCSS = DataDriven.getCellData("Prod_TD", "HomeSearchLocator", 1);

	public HomePage(WebDriver driver) {

		super(driver);
		// scroll down
		jse = (JavascriptExecutor) driver;

	}

	// String searchCSS="div.search-icon";
	// Search
	@FindBy(css = "div.search-icon")

	// @FindBy(how=How.CSS, using=SearchObjectByCSS)
	WebElement searchLink;

	// WebElement searchLink =
	// driver.findElement(By.cssSelector("div.search-icon"));
	// Language dropdown
	@FindBy(css = "select.locales-dropdown")
	WebElement languageDropdownList;

	// checkbox
	@FindBy(id = "confirm")
	WebElement confirmbtn;

	// email
	@FindBy(name = "email")
	WebElement emailTXT;

	// submit

	@FindBy(css = "button.submit")
	WebElement submitBtn;

	// validatemessage

	@FindBy(css = "div.hero-title.caps")
	public WebElement successMessage2;

	// Contact

	@FindBy(linkText = "Contact")
	WebElement contactLink;

	// side menu
	@FindBy(css = "div.nav-icon")
	WebElement sideMenuBtn;

	// item in side menu
	@FindBy(linkText = "WEST")
	WebElement menuItem;

	public void openSearch() throws InterruptedException {
		Thread.sleep(1000);
		clickButton(searchLink);

	}

	public void clickOnContactLink() {
		scrollToBottom();
		clickButton(contactLink);

	}

	public void Subscribe(String email) throws InterruptedException {

		scrollToBottom();

		Thread.sleep(1000);

		clickButton(confirmbtn);
		clickButton(emailTXT);
		setText(emailTXT, email);
		clickButton(submitBtn);
		scrollToBottom();

	}

	public void navigateSideMenu() {
		clickButton(sideMenuBtn);
		clickButton(menuItem);

	}

	public void selectLanguage(String Language) {

		scrollToBottom();
		select = new Select(languageDropdownList);
		select.selectByVisibleText(Language);
	}

}
