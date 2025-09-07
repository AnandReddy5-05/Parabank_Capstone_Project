package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginTest extends BaseTest {
  
	@Given("the user is on the Parabank login page")
	public void user_on_login_page() throws Exception {
		setUp();
		Thread.sleep(2000);
	}

	@When("the user enters valid credentials")
	public void user_enters_valid_credentials() {
		loginPage.enterUserName("john");
		loginPage.enterPassword("demo");
	}

	@And("clicks the Login button")
	public void clicks_login_button() {
		loginPage.clickOnLOginButton();
	}

	@Then("the user should be redirected to the Account Overview page")
	public void user_redirected_to_account_overview() {
		String title = loginPage.getAccountOverviewTitle();
		Assert.assertEquals(title, "Accounts Overview");
		tearDown();
	}

	@Given("the user is on the Parabank login page for invalid login")
	public void user_on_login_page_invalid() {
		setUp();
	}

	@When("the user enters invalid credentials")
	public void user_enters_invalid_credentials() {
		loginPage.enterUserName("abcg");
		loginPage.enterPassword("efgh");
	}

	@And("clicks the Login button with invalid credentials")
	public void clicks_login_button_invalid() {
		loginPage.clickOnLOginButton();
	}

	@Then("an error message should be displayed")
	public void error_message_displayed() {
		String error = loginPage.getErrorMessage();
		Assert.assertEquals(error, "The username and password could not be verified");
		tearDown();
	}

}
