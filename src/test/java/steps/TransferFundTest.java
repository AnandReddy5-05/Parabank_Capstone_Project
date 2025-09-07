package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferFundTest extends BaseTest {
    
	
	@Given("the user is logged in for transferring funds")
	public void user_is_logged_in_for_transferring_funds() {
		setUp();
		driver.get("http://parabank.parasoft.com/parabank/index.htm");
		loginPage.enterUserName("john");
		loginPage.enterPassword("demo");
		loginPage.clickOnLOginButton();
	}

	@When("the user navigates to Transfer Funds page")
	public void user_navigates_to_transfer_funds_page() {
		transferFundPage.clickTransferFundsLink();
	}

	@And("the user enters sufficientAmount {string}")
	public void user_enters_sufficientAmount(String amt) {
		transferFundPage.enterAmount(amt);
	}

//	@And("the user enters from account to account")
//	public void enters_FromAmount_and_ToAmount() {
//		transferFundPage.selectFromAccount();
//		transferFundPage.selectToAccount();
//	}

	@And("clicks on Transfer button")
	public void clicks_on_transfer_button() {
		transferFundPage.clickOnTransferBtn();
	}

	@Then("the funds should be transferred successfully")
	public void funds_transferred_successfully() {
		transferFundPage.isTransferSuccessful();
		tearDown();
	}

	@And("the user enters insufficientamount {string}")
	public void user_enters_insufficientamountt(String amount) {
		transferFundPage.enterAmount(amount);
	}

	@Then("an error message {string} should be displayed")
	public void error_message_should_be_displayed(String expectedMessage) {
		transferFundPage.isInsufficientFundsErrorDisplayed();
		tearDown();
	}
}
