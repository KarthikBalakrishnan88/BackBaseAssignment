package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functions.ComputerNames;
import pageObjects.AddComputerPage;
import pageObjects.HomePage;

public class AddComputerSteps {
	// Initialize web driver
	SeleniumDriver sd = new SeleniumDriver();

	// Initialize Pages
	AddComputerPage addPage = new AddComputerPage(sd.getDriver());
	HomePage homePage = new HomePage(sd.getDriver());

	// Initialize support functions
	ComputerNames name = new ComputerNames();

	@Given("^I am on the \"([^\"]*)\" page$")
	public void i_am_on_the_page(String strArg1) throws Throwable {
		switch (strArg1) {
		case "Add a computer":
			Assert.assertTrue(addPage.lable_header_getText().contains(strArg1));
			break;
		case "Edit computer":
			Assert.assertTrue(addPage.lable_header_getText().contains(strArg1));
			break;
		default:
			break;
		}
	}

	@When("^I enter computer name as \"([^\"]*)\"$")
	public void i_enter_computer_name_as(String computername) throws Throwable {
		if (computername.equals("Random_name")) {

			computername = name.randomIdentifier();
		}
		addPage.inputBox_computerName_type(computername);
	}

	@When("^I enter Introduced date as \"([^\"]*)\"$")
	public void i_enter_introduced_date_as(String introduceddate) throws Throwable {
		addPage.inputBox_introducedDate_type(introduceddate);
	}

	@When("^I enter Discontinued date as \"([^\"]*)\"$")
	public void i_enter_discontinued_date_as(String discontinueddate) throws Throwable {
		addPage.inputBox_discontinuedDate_type(discontinueddate);
	}

	@When("^I select Company as \"([^\"]*)\"$")
	public void i_select_Company_as(String company) throws Throwable {
		if (company.length() > 0) {
			addPage.dropDown_company_select(company);
		}
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String arg1) throws Throwable {
		addPage.button_create_click();
	}

	@Then("^I should see a notification with the added \"([^\"]*)\"$")
	public void i_should_see_a_notification_with_the_added(String computerName) throws Throwable {
		if (computerName.equals("Random_name")) {

			computerName = name.computerName;
		}
		Assert.assertTrue(
				homePage.notification_cnfrm_getText().contains("Done! Computer " + computerName + " has been created"));
	}

	@Then("^I should see \"([^\"]*)\" highlighted in the screen$")
	public void i_should_see_highlighted_in_the_screen(String arg1) throws Throwable {
		Assert.assertTrue(addPage.error_ntfn_isDisplayed());
	}
}
