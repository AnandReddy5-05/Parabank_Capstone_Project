package locatorpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

	@FindBy(xpath = "//a[text()='Register']")
	public WebElement Register;
	@FindBy(id = "customer.firstName")
	public WebElement firstname;
	@FindBy(id = "customer.lastName")
	public WebElement lastname;
	@FindBy(id = "customer.address.street")
	public WebElement address;
	@FindBy(id = "customer.address.city")
	public WebElement city;
	@FindBy(id = "customer.address.state")
	public WebElement state;
	@FindBy(id = "customer.address.zipCode")
	public WebElement zipcode;
	@FindBy(id = "customer.phoneNumber")
	public WebElement phonenumber;
	@FindBy(id = "customer.ssn")
	public WebElement ssn;

	@FindBy(id = "customer.username")
	public WebElement username;
	@FindBy(id = "customer.password")
	public WebElement password;
	@FindBy(id = "repeatedPassword")
	public WebElement conformpassword;

	@FindBy(className = "button")
	public WebElement registerbutton;
	@FindBy(className = "title")
	public WebElement welcomeMessage;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnRegister() {
		Register.click();
	}

	public void enterFirstName(String fname) {
		firstname.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastname.sendKeys(lname);
	}

	public void enterAddress(String Address) {
		address.sendKeys(Address);
	}

	public void enterCity(String City) {
		city.sendKeys(City);
	}

	public void enterState(String State) {
		state.sendKeys(State);
	}

	public void enterZipcode(String Zipcode) {
		zipcode.sendKeys(Zipcode);
	}

	public void enterPhonenumber(String Phone) {
		phonenumber.sendKeys(Phone);
	}

	public void enterSsn(String Ssn) {
		ssn.sendKeys(Ssn);
	}

	public void enterUserName(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void enterConform(String conform) {
		conformpassword.sendKeys(conform);
	}

	public void clickOnRegisterButton() {
		registerbutton.click();
	}

	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}

}
