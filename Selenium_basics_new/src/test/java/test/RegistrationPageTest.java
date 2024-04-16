package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.selenium.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterConfirmPage;
import pages.RegistrationPage;
import pages.UserAccountPage;

public class RegistrationPageTest extends Base {
  @Test(priority=4,groups="Smoke",enabled=false)
  public void verifyRegisterPagetittle() throws IOException {
	  WebElement register=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
	  register.click();
	  String actual_tittle=driver.getTitle();
	  //System.out.println(actual_tittle);
	  String data=ExcelUtility.readStringData(0, 0, Constants.REGISTRATION_PAGE_DATA);
	  Assert.assertEquals(actual_tittle, data,Messages.TITTLE_MISMATCH);
  }
  @Test(priority=3,groups="Regression")
  public void verifyUserRegister() throws IOException{
	  String firstName= RandomDataUtility.getFirstName();
	  String lastname= RandomDataUtility.getLastName();
	  String email= firstName+"."+lastname+"123@yahoo.com";
	  String password=firstName+"."+lastname;
	  HomePage home= new HomePage(driver);
	  RegistrationPage regis_ter=home.clickOnRegisterMenu();
	  WebElement gender=driver.findElement(By.xpath("//input[@id='gender-female']"));
	  gender.click();
	  WebElement first_name=driver.findElement(By.id("FirstName"));
	  first_name.sendKeys(firstName);
	  WebElement last_name=driver.findElement(By.id("LastName"));
	  last_name.sendKeys(lastname);
	  WebElement e_mail=driver.findElement(By.id("Email"));
	  e_mail.sendKeys(email);
	  WebElement pass=driver.findElement(By.id("Password"));
	  pass.sendKeys(password);
	  WebElement con_pass=driver.findElement(By.id("ConfirmPassword"));
	  con_pass.sendKeys(password);
	  RegistrationPage register= new RegistrationPage(driver);
	  RegisterConfirmPage regi_con=register.clickOnRegisterButton();
	  String actual_email=regi_con.userGetText();
	  
	  //WebElement register_click=driver.findElement(By.id("register-button"));
	  //register_click.click();
	  //WebElement user_email_field=driver.findElement(By.className("account"));
	  //String actual_email=user_email_field.getText();
	  Assert.assertEquals(actual_email, email,Messages.USER_REGISTERATION_FAIL);
	  
	  //HomePage home= new HomePage(driver);
	  //RegistrationPage regis_ter=home.clickOnRegisterMenu();
	  
	  
	  }
}
