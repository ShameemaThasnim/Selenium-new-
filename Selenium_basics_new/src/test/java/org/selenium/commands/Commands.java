package org.selenium.commands;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands extends Browser_Launch{
	@Test
	public void verifyCommunityPool() {
		driver.get("https://demowebshop.tricentis.com/");
		List<WebElement> communitypollelements = driver.findElements(By.xpath("//label[starts-with(@for,'pollanswe')]//parent::li"));
		for(int i=0;i<communitypollelements.size();i++)
		{
			//System.out.println(communitypollelements.get(i).getText());
			String poll_optionstext = communitypollelements.get(i).getText();
			if(poll_optionstext.equals("Poor"))
			{
				communitypollelements.get(i).click();
			}
		}
	}
	@Test
	public void verifyCurrentUrl() {
		driver.get("https://demowebshop.tricentis.com/");
		String actual_page_url=driver.getCurrentUrl();
		String expected_page_url="https://demowebshop.tricentis.com/";
		Assert.assertEquals(actual_page_url, expected_page_url,"Invalid current Url");
		//System.out.println(page_url);
	}
	@Test
	public void verifyPageTittle() {
		driver.get("https://demowebshop.tricentis.com/");
		String actual_page_tittle=driver.getTitle();
		//System.out.println(page_tittle);
		String expected_page_tittle="Demo Web Shop";
		Assert.assertEquals(actual_page_tittle, expected_page_tittle,"Invalid page tittle");
		
	}
	@Test
	public void verifyIsSelected() {
		boolean isfemaleselected;
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radiobuttonfemale= driver.findElement(By.xpath("//input[@id='gender-female']"));
		isfemaleselected=radiobuttonfemale.isSelected();
		Assert.assertFalse(isfemaleselected,"radio button is selected");
		System.out.println("Female button before selected:"+isfemaleselected);
		radiobuttonfemale.click();
		isfemaleselected=radiobuttonfemale.isSelected();
		Assert.assertTrue(isfemaleselected, "radio button not selected");
		System.out.println("Female button after selected:"+isfemaleselected);
	
	}
	@Test
	public void verfyIsEnabled() {
		driver.get("https://demowebshop.tricentis.com");
		WebElement subscribe= driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		boolean isenabled=subscribe.isEnabled();
		Assert.assertTrue(isenabled, "Subscribe button not enabled");
		System.out.println("is enabled:"+isenabled);
	}
	
	@Test
	public void verfyIsDisplayed() {
	
		driver.get("https://demowebshop.tricentis.com");
		WebElement vote= driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		boolean isdisplayed=vote.isDisplayed();
		Assert.assertTrue(isdisplayed, "vote button not enabled");
		System.out.println("IsDisplayed "+isdisplayed);
		
	}
	
	@Test
	
	public void verifyUserLogin() {
		String s="Shameemathasnim.ma@gmail.com";
		driver.get("https://demowebshop.tricentis.com/");
		WebElement login=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
		login.click();
		WebElement email=driver.findElement(By.cssSelector("#Email"));
		email.sendKeys(s);
		WebElement password=driver.findElement(By.cssSelector("#Password"));
		password.sendKeys("Sreekuttan$2023");
		WebElement loginlink=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
		loginlink.click();
		WebElement home_email=driver.findElement(By.cssSelector(".account"));
		Assert.assertEquals(home_email.getText(),s ,"Invalid login");
		System.out.println(home_email.getText());
		}
	@Test
	public void verfyValuesFromDropDown() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement country_drop_down=driver.findElement(By.xpath("//select[@name='country']"));
		Select select= new Select(country_drop_down);
		//select.selectByVisibleText("INDIA");
		//select.selectByIndex(5);
		select.selectByValue("ARMENIA");
		WebElement get_country_name=select.getFirstSelectedOption();
		System.out.println(get_country_name.getText());
		
		}
	@Test
	public void verfyTotalNumberOFDropDownValues() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement country_drop_down=driver.findElement(By.xpath("//select[@name='country']"));
		Select select= new Select(country_drop_down);
		List<WebElement> drop_downelementlist =select.getOptions();
		System.out.println(drop_downelementlist.size());
		
	}
	@Test
	public void verifyMultiSelectDropDown() {
		driver.get("https://selenium.qabible.in/select-input.php");
		WebElement multiselect= driver.findElement(By.xpath("//select[@id='multi-select-field']"));
		Select select= new Select(multiselect);
		boolean selectedvalue= select.isMultiple();
		System.out.println(selectedvalue);
		select.selectByVisibleText("Red");
		select.selectByVisibleText("Yellow");
		List<WebElement> selected_values =select.getAllSelectedOptions();
		for(WebElement e:selected_values) {
			System.out.println(e.getText());
		}
		select.deselectByVisibleText("Red");
		
	}
	@Test
	public void verifyFileUpload() {
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement choosefile= driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		choosefile.sendKeys("C:\\Users\\ashif\\git\\Selenium-new-\\Selenium_basics_new\\src\\main\\resources");
		WebElement acceptbox= driver.findElement(By.xpath("//input[@id='terms']"));
		acceptbox.click();
		WebElement submitbutton= driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submitbutton.click();
		}
	@Test
	public void verifyMultipleWindowHandling() {
		driver.get("https://demo.guru99.com/popup.php");
		String parentwindowhandleid = driver.getWindowHandle();
		System.out.println(parentwindowhandleid);
		WebElement clickhere= driver.findElement(By.xpath("//a[@target='_blank']"));
		clickhere.click();
		Set<String> windowhandlesid=driver.getWindowHandles();
		System.out.println(windowhandlesid);
		Iterator<String> value=windowhandlesid.iterator();
		while(value.hasNext())
		{
			String handleid=value.next();
			if(!handleid.equals(parentwindowhandleid))
			{
				driver.switchTo().window(handleid);
				WebElement email=driver.findElement(By.xpath("//input[@name='emailid']"));
				email.sendKeys("shameemathasnim.ma@gmail.com");
				WebElement submit= driver.findElement(By.xpath("//input[@name='btnLogin']"));
				submit.click();
				driver.close();
			}
		}
		driver.switchTo().window(parentwindowhandleid);
	}
	@Test
	public void validateSimpleAlert() {
		driver.get("https://demoqa.com/alerts");
		WebElement clickmebutton=driver.findElement(By.xpath("//button[@id='alertButton']"));
		clickmebutton.click();
		Alert alert = driver.switchTo().alert();
		String textmessage=alert.getText();
		System.out.println(textmessage);
		alert.accept();
		
	}
	@Test
	public void validateConfirmationAlert() {
		String expected="You selected Cancel";
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		WebElement clickmebutton=driver.findElement(By.xpath("//button[@id='confirmButton']"));
		clickmebutton.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		WebElement confirmation=driver.findElement(By.xpath("//span[@id='confirmResult']"));
		String actualtext=confirmation.getText();
		System.out.println(actualtext);
		Assert.assertEquals(actualtext,expected,"Text selected is ok");
		}
	@Test
	public void validatePromptAlert() {
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
        WebElement clickmebutton=driver.findElement(By.xpath("//button[@id='promtButton']"));
		clickmebutton.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Shameema");
		alert.accept();
		WebElement promptafterclick=driver.findElement(By.xpath("//span[@id='promptResult']"));
		String actualresult=promptafterclick.getText();
		System.out.println(actualresult);
		Assert.assertEquals(actualresult,"You entered Shameema","Text u entered doesn't match");
		}

}
