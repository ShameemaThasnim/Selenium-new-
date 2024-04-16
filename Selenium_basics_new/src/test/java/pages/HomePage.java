package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
   
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement login;
	@FindBy (className="ico-register")
	WebElement register;
	public LoginPage clickOnLoginMenu() {
		WebElementUtility.clickOnElement(login);
		return new LoginPage(driver);
	}
	public RegistrationPage clickOnRegisterMenu() {
		WebElementUtility.clickOnElement(register);
		return new RegistrationPage(driver);
	}
	
	
	
	
}
