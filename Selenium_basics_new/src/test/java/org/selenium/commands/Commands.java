package org.selenium.commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	
	
	

}
