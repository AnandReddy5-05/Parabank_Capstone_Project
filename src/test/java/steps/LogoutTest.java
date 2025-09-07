package steps;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LogoutTest extends BaseTest {
	
	@Given("the user is logged in for logout")
	public void user_is_logged_in_for_logout() throws Exception {
		setUp();
		Thread.sleep(3000);
		loginPage.enterUserName("john");
		loginPage.enterPassword("demo");
		loginPage.clickOnLOginButton();
	}

	@When("the user clicks on Logout button")
	public void the_user_clicks_on_logout_button() {
		logoutPage.clickLogout();
	}

	@Then("the user should be redirected to the login page")
	public void the_user_should_be_redirected_to_the_login_page() {
		Assert.assertSame(logoutPage.isLoginPageDisplayed(), "User is not redirected to login page after logout!");
		tearDown();
	}
}
