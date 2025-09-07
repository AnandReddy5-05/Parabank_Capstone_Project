package locatorpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoanPage extends BasePage {

	@FindBy(linkText = "Request Loan")
	public WebElement requestLoanLink;

	@FindBy(xpath = "//a[text()='Request Loan']")
	public WebElement requestloan;

	@FindBy(id = "amount")
	public WebElement loanAmountInput;

	@FindBy(id = "downPayment")
	public WebElement downPaymentInput;

	@FindBy(id = "fromAccountId")
	public WebElement accountDropdown;

	@FindBy(xpath = "//input[@value='Apply Now']")
	public WebElement applyButton;

	@FindBy(xpath = "//div[@id='loanStatus'] | //div[@id='rightPanel']//p | //div[@id='rightPanel']//h1")
	public WebElement loanStatusMessage;

	@FindBy(xpath = "//p[contains(text(),'denied') or contains(text(),'Insufficient funds')]")
	public WebElement loanErrorMsg;

	public LoanPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnRequestLoan() {
		requestloan.click();
	}

	public void enterLoanAmount(String amount) {
		loanAmountInput.clear();
		loanAmountInput.sendKeys(amount);
	}

	public void enterDownPayment(String downPayment) {
		downPaymentInput.clear();
		downPaymentInput.sendKeys(downPayment);
	}

	public void enterLoanDetails(String amount, String down, String account) {
		loanAmountInput.clear();
		loanAmountInput.sendKeys(amount);

		downPaymentInput.clear();
		downPaymentInput.sendKeys(down);

		accountDropdown.sendKeys(account);
	}

	public void selectAccount(String acc) {
		new Select(accountDropdown).selectByVisibleText(acc);
	}

	public List<WebElement> getAccounts() {
		return new Select(accountDropdown).getOptions();
	}

	public void clickApply() {
		applyButton.click();
	}

	public String getLoanStatusMessage() {
		return loanStatusMessage.getText();
	}

	public boolean isLoanDenied() {
		try {
			return loanErrorMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
