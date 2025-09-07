package locatorpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TranctionHistoryPage extends BasePage {

	@FindBy(linkText = "Accounts Overview")
	public WebElement accountsOverviewLink;

	@FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")
	public WebElement accountLinks;

	@FindBy(xpath = "//table[@id='transactionTable']/tbody/tr")
	public List<WebElement> transactionRows;

	public TranctionHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void goToAccountsOverview() {
		accountsOverviewLink.click();
	}

	public void selectFirstAccount() {
		accountLinks.click();
	}

	public boolean isTransactionHistoryDisplayed() {
		return transactionRows.size() > 0;
	}

}
