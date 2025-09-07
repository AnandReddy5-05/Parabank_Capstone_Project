package locatorpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {

	@FindBy(linkText = "Log Out")
	public WebElement logoutLink;

	@FindBy(name = "username")
	public WebElement usernameField;

	public LogoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickLogout() {
		logoutLink.click();
	}

	public boolean isLoginPageDisplayed() {
		return usernameField.isDisplayed();
	}

}
