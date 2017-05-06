package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functions.ComputerNames;
import pageObjects.AddComputerPage;
import pageObjects.EditComputerPage;
import pageObjects.HomePage;

public class EditPageSteps {
	// Initialize web driver
	SeleniumDriver sd = new SeleniumDriver();
	static String computer_name = "";
	AddComputerPage addPage = new AddComputerPage(sd.getDriver());
	HomePage homePage = new HomePage(sd.getDriver());
	EditComputerPage editPage = new EditComputerPage(sd.getDriver());

	// Initialize support functions
	ComputerNames name = new ComputerNames();

	@When("^I click on a computer name \"([^\"]*)\" from the list$")
	public void i_click_on_a_computer_name_from_the_list(String computerName) throws Throwable {
		computer_name = computerName;
		homePage.type_input_searchBox(computerName);
		homePage.click_button_search();
		homePage.link_ComputerName_click(computerName);
	}

	@When("^I edit computer name as \"([^\"]*)\"$")
	public void i_edit_computer_name_as(String computerName) throws Throwable {
		if (computerName.equals("Random_name")) {

			computer_name = computer_name + name.randomIdentifier();
		}
		addPage.inputBox_computerName_type(computer_name);
	}

	@When("^I click on Save this computer button$")
	public void i_click_on_Save_this_computer_button() throws Throwable {
		editPage.button_save_click();
	}

	@Then("^I should see a notification with the edited \"([^\"]*)\"$")
	public void i_should_see_a_notification_with_the_edited(String arg1) throws Throwable {

		Assert.assertTrue(homePage.notification_cnfrm_getText()
				.contains("Done! Computer " + computer_name + " has been updated"));

	}

	@Then("^I should see a notification \"([^\"]*)\"$")
	public void i_should_see_a_notifiction_something(String strArg1) throws Throwable {
		Assert.assertTrue(homePage.notification_cnfrm_getText().contains("Done! Computer has been deleted"));
	}

}
