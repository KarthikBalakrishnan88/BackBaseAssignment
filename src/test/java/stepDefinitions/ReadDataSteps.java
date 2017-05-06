package stepDefinitions;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.AddComputerPage;
import pageObjects.EditComputerPage;
import pageObjects.HomePage;

public class ReadDataSteps {
	// Initialize web driver
	SeleniumDriver sd = new SeleniumDriver();

	// Initialize Pages
	HomePage homePage = new HomePage(sd.getDriver());
	AddComputerPage addPage = new AddComputerPage(sd.getDriver());
	EditComputerPage editPage = new EditComputerPage(sd.getDriver());

	@Given("^I naviagte to the URL \"([^\"]*)\"$")
	public void i_naviagte_to_the_url_something(String strArg1) throws Throwable {
		sd.getDriver().navigate().to(strArg1);
	}

	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
		String pageTitle = sd.getDriver().getTitle();
		Assert.assertEquals("Computers database", pageTitle);
	}

	@When("^I enter the search criteria as (.+)$")
	public void i_enter_the_search_criteria_as(String computername) throws Throwable {
		if (computername.toLowerCase().equals("space")) {
			homePage.type_input_searchBox(" ");
		} else {
			homePage.type_input_searchBox(computername);
		}
	}

	@When("^I click on Filter by name button$")
	public void i_click_on_Filter_by_name_button() throws Throwable {
		homePage.click_button_search();
	}

	@Then("^I should be able to see the sample application$")
	public void i_should_be_able_to_see_the_sample_application() throws Throwable {
		String pageTitle = sd.getDriver().getTitle();
		Assert.assertEquals("Computers database", pageTitle);
	}

	@Then("^I should be able to see the results in the screen$")
	public void i_should_be_able_to_see_the_results_in_the_screen() throws Throwable {

		Assert.assertFalse(!homePage.check_resultTable());
	}

	@Given("^I click on Add a new computer button$")
	public void i_click_on_Add_a_new_computer_button() throws Throwable {
		homePage.button_add_click();
	}

	@Given("^I enter computer details$")
	public void i_enter_computer_details(DataTable details) throws Throwable {
		List<List<String>> data = details.raw();
		addPage.inputBox_computerName_type(data.get(1).get(0));
		addPage.inputBox_introducedDate_type(data.get(1).get(1));
		addPage.inputBox_discontinuedDate_type(data.get(1).get(2));
		addPage.dropDown_company_select(data.get(1).get(3));
	}

	@Given("^I click on Create this computer button$")
	public void i_click_on_Create_this_computer_button() throws Throwable {
		addPage.button_create_click();
	}

	@Then("^I should see the results$")
	public void i_should_see_the_results(DataTable result) throws Throwable {
		List<List<String>> data = result.raw();
		String expectedResult = "";
		for (int i = 0; i <= 3; i++) {
			expectedResult = expectedResult + " " + data.get(1).get(i);
		}
		// System.out.println(expectedResult.trim());
		Assert.assertTrue(homePage.resultTable_getText().contains(expectedResult.trim()));
	}

	@Given("^I click on a computer \"([^\"]*)\" from the list$")
	public void i_click_on_a_computer_from_the_list(String computer_name) throws Throwable {
		homePage.link_ComputerName_click(computer_name);
	}

	@Given("^I Update computer details$")
	public void i_Update_computer_details(DataTable details) throws Throwable {
		List<List<String>> data = details.raw();
		addPage.inputBox_computerName_type(data.get(1).get(0));
		addPage.inputBox_introducedDate_type(data.get(1).get(1));
		addPage.inputBox_discontinuedDate_type(data.get(1).get(2));
		addPage.dropDown_company_select(data.get(1).get(3));
	}

	@Given("^I click on save this computer  button$")
	public void i_click_on_save_this_computer_button() throws Throwable {
		editPage.button_save_click();
	}

	@Given("^I click on Delete this computer button$")
	public void i_click_on_Delete_this_computer_button() throws Throwable {
		editPage.button_delete_click();
	}

	@Then("^I should not see computer details in the results$")
	public void i_should_not_see_computer_details_in_the_results(DataTable result) throws Throwable {
		List<List<String>> data = result.raw();
		String expectedResult = "";
		for (int i = 0; i <= 3; i++) {
			expectedResult = expectedResult + " " + data.get(1).get(i);
		}
		try {
			Assert.assertFalse(homePage.resultTable_getText().contains(expectedResult.trim()));
		} catch (Exception e) {
			System.out.println(homePage.notification_msg_Text());

		}

	}

}
