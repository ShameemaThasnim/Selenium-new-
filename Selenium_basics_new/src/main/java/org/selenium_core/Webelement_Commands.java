package org.selenium_core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webelement_Commands {
	
	public void verifysawg_Laps_Username() {
		WebDriver driver = new ChromeDriver();
		WebElement element=driver.findElement(By.id("user-name"));
		WebElement pass_ele=driver.findElement(By.id("password"));
		WebElement log_ele=driver.findElement(By.id("login-button"));
		
		
	}

	public static void main(String[] args) {
		//WebDriver driver = new ChromeDriver();
		
		

	}

}
