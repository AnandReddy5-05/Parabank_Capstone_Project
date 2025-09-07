package locatorpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage extends BasePage {

	@FindBy(linkText = "Home")
	public WebElement home;
	@FindBy(linkText = "Open New Account")
	public WebElement openAccount;
	@FindBy(id = "type")
	public WebElement dropDown;
	@FindBy(xpath = "//input[@value='Open New Account']")
	public WebElement openAccountButton;
	@FindBy(xpath = "//p[text()='Congratulations, your account is now open.']")
	public WebElement title;

	public OpenAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clockOnHome() {
		home.click();
	}

	public void clickOnOpenAccout() {
		openAccount.click();
	}

	public void selectDropDown(String type) {
		dropDown.sendKeys(type);
	}

	public void clickOnOpenAccountButton() {
		openAccountButton.click();
	}

	public String getitle() {
		return title.getText();
	}

}
