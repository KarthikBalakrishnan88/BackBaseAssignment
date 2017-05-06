package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditComputerPage {
	WebDriver driver;

	public EditComputerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input.btn.primary")
	WebElement button_save;

	@FindBy(css = "input.btn.danger")
	WebElement button_delete;

	public void button_save_click() {
		button_save.click();
	}

	public void button_delete_click() {
		button_delete.click();
	}
}
