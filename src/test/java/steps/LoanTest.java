package steps;

import java.util.List;


import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoanTest extends BaseTest {
    
	
	@Given("the user is logged in for loan request")
	public void user_is_logged_in_for_loan_request() throws Exception {
		setUp();
		Thread.sleep(3000);
		loginPage.enterUserName("john");
		loginPage.enterPassword("demo");
		loginPage.clickOnLOginButton();

	}

	@When("the user navigates to Request Loan page")
	public void user_navigates_to_request_loan_page() {
		loanPage.clickOnRequestLoan();
	}

	@And("the user enters loan amount {string} and down payment {string}")
	public void user_enters_loan_details(String loanAmount, String downPayment) {
		loanPage.enterLoanAmount(loanAmount);
		loanPage.enterDownPayment(downPayment);
	}

	@And("selects an account for loan")
	public void selects_an_account_for_loan() {
		List<WebElement> accounts = loanPage.getAccounts();
		if (accounts.isEmpty()) {
			throw new RuntimeException("No accounts available for loan request!");
		}
		String firstAccount = accounts.get(0).getText();
		loanPage.selectAccount(firstAccount);
	}

	@And("submits the loan request")
	public void submits_the_loan_request() {
		loanPage.clickApply();
	}

	@Then("the loan should be approved successfully")
	public void loan_should_be_approved_successfully() throws Exception {
		loanPage.getLoanStatusMessage();
		Thread.sleep(3000);
		tearDown();

	}

	@And("the user enters loan amount {string}, down payment {string}, and account number {string}")
	public void user_enters_loan_details(String loan, String down, String account) {
		loanPage.enterLoanDetails(loan, down, account);
	}

	@And("clicks on Apply Now button")
	public void clicks_on_apply_now_button() {
		loanPage.clickApply();
	}

	@Then("the loan should be denied with message {string}")
	public void loan_should_be_denied_with_message(String expectedMsg) throws Exception {
		loanPage.isLoanDenied();
		Thread.sleep(3000);
		tearDown();
	}

}
