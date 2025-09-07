package steps;

import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenAccountTest extends BaseTest {
    @Test
	@Given("the user is logged in for opening a new account")
	public void user_is_logged_in() throws Exception {
		setUp();
		Thread.sleep(3000);
		loginPage.enterUserName("john");
		loginPage.enterPassword("demo");
		loginPage.clickOnLOginButton();

	}

	@When("the user navigates to Open New Account page")
	public void navigate_to_open_new_account() {

		openAccountPage.clickOnOpenAccout();
	}

	@And("selects account type {string}")
	public void select_account_type(String string) {
		openAccountPage.selectDropDown(string);
	}

	@And("submits the request")
	public void submits_request() {
		openAccountPage.clickOnOpenAccountButton();
	}

	@Then("a new account should be opened successfully")
	public void account_open_success() throws Exception {
		String msg = openAccountPage.getitle();
		System.out.println(msg);
		Thread.sleep(3000);
		tearDown();
	}
}
