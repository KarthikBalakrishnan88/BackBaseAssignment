package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "searchbox")
	WebElement input_searchBox;

	@FindBy(id = "searchsubmit")
	WebElement button_search;

	@FindBy(css = "table.computers.zebra-striped")
	WebElement resultTable;

	@FindBy(id = "add")
	WebElement button_add;

	@FindBy(css = "em")
	WebElement notification_msg;

	@FindBy(css = "div.alert-message.warning")
	WebElement notification_cnfrm;

	public String notification_cnfrm_getText() {

		return notification_cnfrm.getText();
	}

	public String button_add_getText() {
		return button_add.getText();

	}

	public String button_add_getBackColor() {
		return button_add.getCssValue("background-color");
	}

	public String notification_msg_Text() {
		return notification_msg.getText();
	}

	public void link_ComputerName_click(String computerName) {
		WebElement computer = driver.findElement(By.partialLinkText(computerName));
		computer.click();
	}

	public void button_add_click() {
		button_add.click();
	}

	public void type_input_searchBox(String inputValue) {
		input_searchBox.clear();
		input_searchBox.sendKeys(inputValue);
	}

	public void click_button_search() throws Throwable {
		button_search.click();

	}

	public boolean check_resultTable() throws InterruptedException {
		boolean result = false;
		String text = resultTable.getText();
		if (text.length() > 0) {
			result = true;
		}
		return result;
	}

	public String resultTable_getText() throws InterruptedException {
		String text = resultTable.getText();
		return text;
	}

}
