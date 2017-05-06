package stepDefinitions;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import pageObjects.HomePage;

public class HomePageSteps {
	// Initialize web driver
	SeleniumDriver sd = new SeleniumDriver();

	// Initialize Pages
	HomePage homePage = new HomePage(sd.getDriver());

	@Then("^I should be able to see a button with caption as \"([^\"]*)\"$")
	public void i_should_be_able_to_see_a_button_with_caption_as(String arg1) throws Throwable {
		Assert.assertTrue(homePage.button_add_getText().contains(arg1));
		// System.out.println(homePage.button_add_getText());
	}

	@Then("^the Button color should have the back color as \"([^\"]*)\"$")
	public void the_Button_color_should_have_the_back_color_as(String arg1) throws Throwable {
		Assert.assertTrue(homePage.button_add_getBackColor().contains(arg1));

	}

	@Then("^the computer detail table should have the below columns$")
	public void the_computer_detail_table_should_have_the_below_columns(DataTable result) throws Throwable {
		List<List<String>> data = result.raw();
		String expectedResult = "";
		for (int i = 0; i <= 3; i++) {
			expectedResult = expectedResult + " " + data.get(1).get(i);
		}
		// System.out.println(expectedResult.trim());
		Assert.assertTrue(homePage.resultTable_getText().contains(expectedResult.trim()));
	}

}
