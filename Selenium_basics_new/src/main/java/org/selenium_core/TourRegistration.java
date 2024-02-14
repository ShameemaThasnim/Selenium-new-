package org.selenium_core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TourRegistration {
	public void verifyDemoTourRegistration() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
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
		
	}

	public static void main(String[] args) {
		TourRegistration  web = new TourRegistration();
		web.verifyDemoTourRegistration();
		
		

	}

}
