package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;

public class RegistrationPageTest extends Base {
  @Test
  public void verifyRegisterPagetittle() throws IOException {
	  WebElement register=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
	  register.click();
	  String actual_tittle=driver.getTitle();
	  //System.out.println(actual_tittle);
	  String data=ExcelUtility.readStringData(0, 0, Constants.REGISTRATION_PAGE_DATA);
	  Assert.assertEquals(actual_tittle, data,"invalid register page tittle");
  }
  @Test
  public void verifyUserRegister() throws IOException{
	  String firstname=ExcelUtility.readStringData(1, 0, Constants.REGISTRATION_PAGE_DATA);
	  String lastname=ExcelUtility.readStringData(2, 0, Constants.REGISTRATION_PAGE_DATA);
	  String email=ExcelUtility.readStringData(3, 0, Constants.REGISTRATION_PAGE_DATA);
	  String password=ExcelUtility.readStringData(4, 0, Constants.REGISTRATION_PAGE_DATA);
	  String confirmpass=ExcelUtility.readStringData(5, 0, Constants.REGISTRATION_PAGE_DATA);
	  WebElement register=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
	  register.click();
	  WebElement gender=driver.findElement(By.xpath("//input[@id='gender-female']"));
	  gender.click();
	  WebElement first_name=driver.findElement(By.id("FirstName"));
	  first_name.sendKeys(firstname);
	  WebElement last_name=driver.findElement(By.id("LastName"));
	  last_name.sendKeys(lastname);
	  WebElement e_mail=driver.findElement(By.id("Email"));
	  e_mail.sendKeys(email);
	  WebElement pass=driver.findElement(By.id("Password"));
	  pass.sendKeys(password);
	  WebElement con_pass=driver.findElement(By.id("ConfirmPassword"));
	  con_pass.sendKeys(confirmpass);
	  WebElement register_click=driver.findElement(By.id("register-button"));
	  register_click.click();
	  }
}
