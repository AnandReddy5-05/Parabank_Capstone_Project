package steps;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationTest extends BaseTest {
	@Test
	@Given("the user is on Home page")
	public void the_user_is_on_Home_page() throws Exception {
		setUp();
		Thread.sleep(3000);
	}

	@When("the user clicks on Register")
	public void the_user_clicks_on_Register() throws Exception {
		regPage.clickOnRegister();
		Thread.sleep(3000);

	}

	@When("the user enters valid registration details")
	public void the_user_enters_valid_registration_details() throws Exception {
		regPage.enterFirstName("John");
		regPage.enterLastName("Doe");
		regPage.enterAddress("123 Test Street");
		regPage.enterCity("Hyderabad");
		regPage.enterState("Telangana");
		regPage.enterZipcode("500001");
		regPage.enterPhonenumber("9876543210");
		regPage.enterSsn("12345");
		regPage.enterUserName("danny");
		regPage.enterPassword("new");
		regPage.enterConform("demo");
		Thread.sleep(3000);

	}

	@And("clicks on the Register button")
	public void clicks_on_the_Register_button() throws Exception {
		regPage.clickOnRegisterButton();
		Thread.sleep(3000);

	}

	@Then("the user account should be created successfully")
	public void the_user_account_should_be_created_successfully() {
		String actualMessage = regPage.getWelcomeMessage();
		Assert.assertTrue(actualMessage.contains("ParaSoft Demo"),
				"Expected welcome message, but found: " + actualMessage);
		tearDown();
	}

}
