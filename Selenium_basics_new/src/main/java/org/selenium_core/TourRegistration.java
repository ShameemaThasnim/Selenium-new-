package org.selenium_core;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TourRegistration {
	public void verfyIsDisplayed() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		WebElement vote= driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		boolean isdisplayed=vote.isDisplayed();
		System.out.println("IsDisplayed "+isdisplayed);
		String tag=vote.getTagName();
		System.out.println(tag);
		
	}
	public void verfyIsEnabled() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		WebElement subscribe= driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		boolean isenabled=subscribe.isEnabled();
		System.out.println("IsEnabled "+isenabled);
		
	}
	public void verifyIsSelected() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		
		WebElement radiobuttonfemale= driver.findElement(By.xpath("//input[@id='gender-female']"));
		boolean isfemaleselected=radiobuttonfemale.isSelected();
		System.out.println("female element before selected:"+isfemaleselected);
		radiobuttonfemale.click();
		boolean afterfemaleselected=radiobuttonfemale.isSelected();
		System.out.println("female element after selection:"+afterfemaleselected);
		
	}
	public void validateDemoWebShopUserLoginCss() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement login=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
		login.click();
		WebElement email=driver.findElement(By.cssSelector("#Email"));
		email.sendKeys("shameemathasnim.ma@gmail.com");
		WebElement password=driver.findElement(By.cssSelector("#Password"));
		password.sendKeys("Sreekuttan$2023");
		WebElement loginlink=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
		loginlink.click();
		driver.close();
	}
	public void verifyCss() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement destination = driver.findElement(By.cssSelector("body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(3) > form > table > tbody > tr:nth-child(6) > td > table > tbody > tr > td:nth-child(2) > font > a"));
		destination.click();
		driver.close();
		
	}
	public void validateTotalNumberOfTagsInTheApplication() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		List<WebElement> inputname =driver.findElements(By.tagName("input"));
		int numberoftags=inputname.size();
		System.out.println(numberoftags);
		driver.close();
		
	}
	public void verifyPartialLinkText() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement destination = driver.findElement(By.partialLinkText("your des"));
		destination.click();
		driver.close();
		
	}
	public void verifyLinkText() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement destination = driver.findElement(By.linkText("your destination"));
		destination.click();
		driver.close();
		
	}
	public void validateDemoWebShopUserLogin() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement login=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
		login.click();
		WebElement email=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		email.sendKeys("shameemathasnim.ma@gmail.com");
		WebElement password=driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		password.sendKeys("Sreekuttan$2023");
		WebElement loginlink=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginlink.click();
		driver.close();
	}
	public void verifyDemoTourRegistration() {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement register=driver.findElement(By.partialLinkText("REGISTER"));
		register.click();
		WebElement first_name=driver.findElement(By.name("firstName"));
		first_name.sendKeys("shameema");
		WebElement last_name=driver.findElement(By.name("lastName"));
		last_name.sendKeys("Thasnim");
		WebElement phone=driver.findElement(By.name("phone"));
		phone.sendKeys("9746391813");
		WebElement email=driver.findElement(By.id("userName"));
		email.sendKeys("Shameemathasnim@gmail.com");
		WebElement address=driver.findElement(By.name("address1"));
		address.sendKeys("marakkaparambhil house");
		WebElement city=driver.findElement(By.name("city"));
		city.sendKeys("paravoor");
		WebElement state=driver.findElement(By.name("state"));
		state.sendKeys("kerala");
		WebElement postalcode=driver.findElement(By.name("postalCode"));
		postalcode.sendKeys("683520");
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys("Ammus");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("sreekuttan$2023");
		WebElement confirmpassword=driver.findElement(By.name("confirmPassword"));
		confirmpassword.sendKeys("sreekuttan$2023");
		WebElement login=driver.findElement(By.name("submit"));
		login.click();
		driver.close();
		
	}

	public static void main(String[] args) {
		TourRegistration  web = new TourRegistration();
		//web.verifyDemoTourRegistration();
		//web.verifyPartialLinkText();
		//web.verifyLinkText();
		//web.validateTotalNumberOfTagsInTheApplication();
		//web.verifyCss();
		//web.validateDemoWebShopUserLoginCss();
		//web.verifyIsSelected();
		//web.verfyIsEnabled();
		web.verfyIsDisplayed();
		
		

	}

}
