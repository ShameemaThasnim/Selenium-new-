package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;

public class HomePageTest extends Base{
  @Test
  public void verifyHomePageTittle() throws IOException {
	  String actual_tittle=driver.getTitle();
	  String data=ExcelUtility.readStringData(0, 0, Constants.HOME_PAGE_DATA);
	  Assert.assertEquals(actual_tittle, data,"Tittle is invalid");
  }
  @Test
  public void verifyCommunityPoolSelection() throws IOException {
	  List<WebElement> communitypollelements = driver.findElements(By.xpath("//label[starts-with(@for,'pollanswe')]//parent::li"));
	  
		for(int i=0;i<communitypollelements.size();i++)
		{
			
			String poll_optionstext = communitypollelements.get(i).getText();
			if(poll_optionstext.equals("Excellent"))
			{
				//communitypollelements.get(i).click();
				String actual_poll=poll_optionstext;
				String data=ExcelUtility.readStringData(0, 1, Constants.HOME_PAGE_DATA);
				 Assert.assertEquals(actual_poll, data,"poll option invalid");
				
			}
		}
		
  }
}
