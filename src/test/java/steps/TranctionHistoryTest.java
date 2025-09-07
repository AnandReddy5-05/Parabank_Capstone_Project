package steps;

import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TranctionHistoryTest extends BaseTest {
	
	@Test
	@Given("the user is logged in for viewing transactions")
	public void user_is_logged_in() throws Exception {
		setUp();
		Thread.sleep(3000);
		loginPage.enterUserName("john");
		loginPage.enterPassword("demo");
		loginPage.clickOnLOginButton();

	}

	@When("the user navigates to Accounts Overview page")
	public void user_navigates_to_accounts_overview_page() throws Exception {
		tranctionHistoryPage.goToAccountsOverview();
		Thread.sleep(2000);
	}

	@And("selects the first account")
	public void selects_the_first_account() {
		tranctionHistoryPage.selectFirstAccount();
	}

	@Then("the transaction history should be displayed")
	public void the_transaction_history_should_be_displayed() throws Exception {
		tranctionHistoryPage.isTransactionHistoryDisplayed();
		Thread.sleep(3000);
		tearDown();
	}

}
