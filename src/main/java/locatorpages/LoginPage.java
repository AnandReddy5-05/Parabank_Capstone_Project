package locatorpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	@FindBy(name = "username")
	public WebElement username;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(xpath = "//input[@value='Log In']")
	public WebElement loginButton;

	@FindBy(xpath = "//h1")
	public WebElement pageTitle;

	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/p")
	public WebElement errorMsg;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickOnLOginButton() {
		loginButton.click();
	}

	public String getAccountOverviewTitle() {

		return pageTitle.getText();
	}

	public String getErrorMessage() {

		return errorMsg.getText();
	}

}
