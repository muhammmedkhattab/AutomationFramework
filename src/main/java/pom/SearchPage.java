package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	// Search field
	@FindBy(css = "input.input.search-input")
	WebElement searchInputTXT;

	public void searchForValue(String searchTXT) {

		searchInputTXT.clear();
		setText(searchInputTXT, searchTXT);
		KeyPressEnter(searchInputTXT);

	}
}
