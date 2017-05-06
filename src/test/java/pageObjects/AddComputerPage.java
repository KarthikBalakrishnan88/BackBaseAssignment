package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddComputerPage {
	WebDriver driver;

	public AddComputerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "main")
	WebElement lable_header;

	@FindBy(id = "name")
	WebElement inputBox_computerName;

	@FindBy(id = "introduced")
	WebElement inputBox_introducedDate;

	@FindBy(id = "discontinued")
	WebElement inputBox_discontinuedDate;

	@FindBy(id = "company")
	WebElement dropDown_company;

	@FindBy(css = "input.btn.primary")
	WebElement button_create;

	@FindBy(css = "div.clearfix.error")
	WebElement error_ntfn;

	public boolean error_ntfn_isDisplayed() {
		return error_ntfn.isDisplayed();
	}

	public String lable_header_getText() {
		return lable_header.getText();
	}

	public void inputBox_computerName_type(String input) {
		inputBox_computerName.clear();
		inputBox_computerName.sendKeys(input);
	}

	public void inputBox_introducedDate_type(String input) {
		inputBox_introducedDate.clear();
		inputBox_introducedDate.sendKeys(input);
	}

	public void inputBox_discontinuedDate_type(String input) {
		inputBox_discontinuedDate.clear();
		inputBox_discontinuedDate.sendKeys(input);
	}

	public void dropDown_company_select(String input) {
		Select dropDown = new Select(dropDown_company);
		dropDown.selectByVisibleText(input);
	}

	public void button_create_click() {
		button_create.click();
	}
}
