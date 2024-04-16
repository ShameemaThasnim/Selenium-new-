package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class RegistrationPage {

    WebDriver driver;
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id ="register-button")
	WebElement register_button;
	
	
	
	public RegisterConfirmPage clickOnRegisterButton() {
		WebElementUtility.clickOnElement(register_button);
		return new RegisterConfirmPage(driver);
	}
	
}

