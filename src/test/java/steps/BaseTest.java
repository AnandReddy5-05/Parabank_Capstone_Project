package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import locatorpages.LoanPage;
import locatorpages.LoginPage;
import locatorpages.LogoutPage;
import locatorpages.OpenAccountPage;
import locatorpages.RegistrationPage;
import locatorpages.TranctionHistoryPage;
import locatorpages.TransferFundPage;


public class BaseTest {
	WebDriver driver;
	RegistrationPage regPage;
	LoginPage loginPage;
	OpenAccountPage openAccountPage;
	TransferFundPage transferFundPage;
	LoanPage loanPage;
	TranctionHistoryPage tranctionHistoryPage;
	LogoutPage logoutPage;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		regPage = new RegistrationPage(driver);
		loginPage = new LoginPage(driver);
		openAccountPage = new OpenAccountPage(driver);
		transferFundPage = new TransferFundPage(driver);
		loanPage = new LoanPage(driver);
		tranctionHistoryPage = new TranctionHistoryPage(driver);
		logoutPage = new LogoutPage(driver);

		driver.get("https://parabank.parasoft.com/parabank/transfer.htm");
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
