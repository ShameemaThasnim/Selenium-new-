package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class RegisterConfirmPage {

	  WebDriver driver;
		public RegisterConfirmPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(className="account")
		WebElement email_registered;
		
		
		public String userGetText() {
			String text=WebElementUtility.getText(email_registered);
			return text;
			
			
		}
}
