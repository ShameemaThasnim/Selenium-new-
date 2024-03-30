package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;

public class LoginPageTest extends Base{
  @Test
  public void verifyLoginPageTittle() throws IOException {
	  WebElement login=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
	  login.click();
	  String actual_tittle=driver.getTitle();
	  String data=ExcelUtility.readStringData(0, 0, Constants.LOGIN_PAGE_DATA);
	  Assert.assertEquals(actual_tittle, data,"invalid login page tittle");
	  
  }
  @Test
  public void verifyUserLogin() throws IOException
  {
	  String email=ExcelUtility.readStringData(0, 1, Constants.LOGIN_PAGE_DATA);
	  String password=ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE_DATA);
	  WebElement login=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
	  login.click();
	  WebElement email_ele=driver.findElement(By.cssSelector("#Email"));
	  email_ele.sendKeys(email);
	  WebElement password_ele=driver.findElement(By.cssSelector("#Password"));
	  password_ele.sendKeys(password);
	  WebElement loginlink=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
	  loginlink.click();
	  WebElement home_email=driver.findElement(By.cssSelector(".account"));
	  Assert.assertEquals(home_email.getText(),email ,"Invalid login");
	  System.out.println(home_email.getText());
  }
  @Test
  public void verifyUserLoginWithInvalidCredentials() throws IOException {
	  String email=ExcelUtility.readStringData(1, 0, Constants.LOGIN_PAGE_DATA);
	  String password=ExcelUtility.readStringData(1, 1, Constants.LOGIN_PAGE_DATA);
	  String expected=ExcelUtility.readStringData(1, 2, Constants.LOGIN_PAGE_DATA);
	  WebElement login=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
	  login.click();
	  WebElement email_ele=driver.findElement(By.cssSelector("#Email"));
	  email_ele.sendKeys(email);
	  WebElement password_ele=driver.findElement(By.cssSelector("#Password"));
	  password_ele.sendKeys(password);
	  WebElement loginlink=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
	  loginlink.click();
	  WebElement error_message=driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
	  String error_actual=error_message.getText();
	  Assert.assertEquals(error_actual, expected,"login validation not working properly");
	  
  }
}
