package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends PageBase {

	public ContactPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(css = "textarea.contact-msg")
	WebElement contactMessage;

	@FindBy(css = "input.contact-input")
	WebElement fullName;

	@FindBy(id = "contact-email")
	WebElement emailTXT;

	@FindBy(id = "confirm")
	WebElement confirmCheckBox;

	@FindBy(css = "button.contact-submit")
	WebElement contactBtn;

	@FindBy(css = "p.feedback")
	public WebElement successMessage;

	public void fillContactForum(String Message, String FullName, String Email) throws InterruptedException {

		setText(contactMessage, Message);
		setText(fullName, FullName);
		setText(emailTXT, Email);
		Thread.sleep(1000);
		clickButton(confirmCheckBox);
		jse.executeScript("scrollBy(0,2000)");
		Thread.sleep(1000);
		clickButton(contactBtn);
	}

}
