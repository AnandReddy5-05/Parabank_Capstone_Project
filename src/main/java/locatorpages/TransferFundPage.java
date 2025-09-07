package locatorpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFundPage extends BasePage {
	@FindBy(linkText = "Transfer Funds")
	public WebElement transferFundsLink;
	@FindBy(id = "amount")
	public WebElement amount;
	@FindBy(id = "fromAccountId")
	public WebElement fromAcc;
	@FindBy(id = "toAccountId")
	public WebElement toAcc;
	@FindBy(xpath = "//input[@value='Transfer']")
	public WebElement transfer;
	@FindBy(xpath = "//h1[contains(text(),'Transfer Complete')]")
	public WebElement transferSuccessMsg;
	@FindBy(xpath = "//p[contains(text(),'Insufficient Funds')]")
	public WebElement insufficientFundsMsg;

	public TransferFundPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickTransferFundsLink() {
		transferFundsLink.click();
	}

	public void enterAmount(String amo) {
		amount.clear();
		amount.sendKeys(amo);
	}

	public void selectFromAccount() {
		Select dropDown = new Select(fromAcc);
		List<WebElement> options = dropDown.getOptions();
		if (!options.isEmpty()) {
			dropDown.selectByIndex(0);
		} else {
			throw new RuntimeException("No accounts available in From Account dropdown!");
		}
	}

	public void selectToAccount() {
		Select dropDown = new Select(toAcc);
		List<WebElement> options = dropDown.getOptions();
		if (options.size() > 1) {
			dropDown.selectByIndex(1);
		} else if (!options.isEmpty()) {
			dropDown.selectByIndex(0);
		} else {
			throw new RuntimeException("No accounts available in To Account dropdown!");
		}
	}

	public void clickOnTransferBtn() {
		transfer.click();
	}

	public boolean isTransferSuccessful() {
		try {
			return transferSuccessMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isInsufficientFundsErrorDisplayed() {
		try {
			return insufficientFundsMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
