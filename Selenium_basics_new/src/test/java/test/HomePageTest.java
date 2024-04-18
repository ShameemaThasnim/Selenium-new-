package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import listeners.RetryAnalyser;

public class HomePageTest extends Base{
  @Test(priority=1,groups={"Regression","Smoke"},retryAnalyzer= RetryAnalyser.class )
  public void verifyHomePageTittle() throws IOException {
	  String actual_tittle=driver.getTitle();
	  String data=ExcelUtility.readStringData(0, 0, Constants.HOME_PAGE_DATA)+"123";
	  //Assert.assertEquals(actual_tittle, data,"Tittle is invalid");
	  Assert.assertEquals(actual_tittle, data,Messages.TITTLE_MISMATCH);
  }
  @Test(priority=2,groups="Sanity")
  public void verifyCommunityPoolSelection() throws IOException {
	 
	  List<WebElement> communitypollelements = driver.findElements(By.xpath("//label[starts-with(@for,'pollanswe')]//parent::li"));
	  
		for(int i=0;i<communitypollelements.size();i++)
		{
			
			String poll_optionstext = communitypollelements.get(i).getText();
			String data=ExcelUtility.readStringData(0, 1, Constants.HOME_PAGE_DATA);
			if(poll_optionstext.equals(data))
			{
				//communitypollelements.get(i).click();
				String actual_poll=poll_optionstext;
				
				 //Assert.assertEquals(actual_poll, data,"poll option invalid");
				Assert.assertEquals(actual_poll, data,Messages.OPTION_MISMATCH);
				
			}
		}
		
  }
}
