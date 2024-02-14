package org.selenium_core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webelement_Commands {
	
	public void verifysawg_Laps_Username() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		WebElement user_ele=driver.findElement(By.id("user-name"));
		user_ele.sendKeys("standard_user");
		
		WebElement pass_ele=driver.findElement(By.id("password"));
		pass_ele.sendKeys("secret_sauce");
		WebElement log_ele=driver.findElement(By.id("login-button"));
		log_ele.click();
		//String tagname=log_ele.getTagName();
		//System.out.println(tagname);
		driver.close();
		
		
	}

	public static void main(String[] args) {
		
		Webelement_Commands  web = new Webelement_Commands();
		web.verifysawg_Laps_Username();
		

	}

}
