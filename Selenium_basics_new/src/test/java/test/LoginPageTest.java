package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.selenium.utilities.RandomDataUtility;
import org.selenium.utilities.WebElementUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import dataprovider.DataProviders;
import pages.HomePage;
import pages.LoginPage;
import pages.UserAccountPage;

public class LoginPageTest extends Base{
  @Test(priority=5,groups="Smoke",enabled=false)
  public void verifyLoginPageTittle() throws IOException {
	 // WebElement login=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
	 // login.click();
	  HomePage home= new HomePage(driver);
	  LoginPage login=home.clickOnLoginMenu();
	  String actual_tittle=driver.getTitle();
	  String data=ExcelUtility.readStringData(0, 0, Constants.LOGIN_PAGE_DATA);
	  Assert.assertEquals(actual_tittle, data,Messages.TITTLE_MISMATCH);
	  
  }
  @Test(priority=6,groups={"Smoke","Regression"})
  public void verifyUserLogin() throws IOException
  {
	  
	  String email=ExcelUtility.readStringData(0, 1, Constants.LOGIN_PAGE_DATA);
	  String password=ExcelUtility.readStringData(0, 2, Constants.LOGIN_PAGE_DATA);
	 // WebElement login=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
	  //login.click();
	  HomePage home= new HomePage(driver);
	  LoginPage login=home.clickOnLoginMenu();
	  //WebElement email_ele=driver.findElement(By.cssSelector("#Email"));
	  //email_ele.sendKeys(email);
	  LoginPage login_page= new LoginPage(driver);
	  login_page.enterUserName(email);
	  //WebElement password_ele=driver.findElement(By.cssSelector("#Password"));
	  //password_ele.sendKeys(password);
	  login_page.enterPassword(password);
	  //WebElement loginlink=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
	  //loginlink.click();
	  UserAccountPage userpage=login_page.clickOnLoginButton();
	  //WebElement home_email=driver.findElement(By.cssSelector(".account"));
	  //System.out.println(home_email.getText());
	  UserAccountPage user = new UserAccountPage(driver);
	  String user_text=user.userGetText();
	  Assert.assertEquals(user_text,email ,Messages.LOGIN_MISMATCH);
	  //System.out.println(home_email.getText());
  }
  @Test(priority=7,groups="Sanity",dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)
  public void verifyUserLoginWithInvalidCredentials(String username, String password) throws IOException {
	  //String email=ExcelUtility.readStringData(1, 0, Constants.LOGIN_PAGE_DATA);
	  //String password=ExcelUtility.readStringData(1, 1, Constants.LOGIN_PAGE_DATA);
	  String expected=ExcelUtility.readStringData(1, 2, Constants.LOGIN_PAGE_DATA);
	  //WebElement login=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
	  //login.click();
	  HomePage home= new HomePage(driver);
	  LoginPage login=home.clickOnLoginMenu();
	  //WebElement email_ele=driver.findElement(By.cssSelector("#Email"));
	  //email_ele.sendKeys(username);
	  LoginPage login_page= new LoginPage(driver);
	  login_page.enterUserName(username);
	  login_page.enterPassword(password);
	  UserAccountPage userpage=login_page.clickOnLoginButton();
	  //WebElement password_ele=driver.findElement(By.cssSelector("#Password"));
	 // password_ele.sendKeys(password);
	  //WebElement loginlink=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
	 // loginlink.click();
	  //WebElement error_message=driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
	  //String error_actual=error_message.getText();
	  String error_actual=login_page.userGetText();
	  Assert.assertEquals(error_actual, expected,Messages.LOGIN_FAILED_WARNING_MESSAGE_NOT_FOUND);
	  
  }
}
