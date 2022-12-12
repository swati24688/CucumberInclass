package steps;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.DataBasePage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinations extends TestBase {
	
	LoginPage loginPage;
	DataBasePage databasePage;

	@Before
	public void setUp() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		databasePage = new DataBasePage();
	}

	@Given("^User is on techfios login page$")
	public void user_is_on_techfios_login_page() {

		driver.get("https://www.techfios.com/billing/?ng=admin/");
	}

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String userName) {

		loginPage.entersUserName(userName);

	}

	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) {
		loginPage.enterPassword(password);
	}

	@And("^User clicks on signin button$")
	public void user_clicks_on_signin_button() {
		loginPage.clickSignInButton();
	}

	@Then("^User should land on Dashboard page$")
	public void user_should_land_on_Dashboard_page() {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals("page not found", expectedTitle, actualTitle);

	}

	@When("^User enters \"([^\"]*)\" from techfios database$")
	public void user_enters_from_techfios_database(String loginData) {
		switch (loginData) {
		case "username":
			loginPage.entersUserName(databasePage.getDataFromDB("username"));

			break;
		case "password":
			loginPage.enterPassword(databasePage.getDataFromDB("password"));

			break;
		default:
			System.out.println("Unable enter login data:" + loginData);
         break;
		}
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
