package org.selenium_core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Launch {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");//loading web url
		driver.manage().window().maximize();
		String page_tittle=driver.getTitle();
		System.out.println(page_tittle);
		String page_url=driver.getCurrentUrl();
		System.out.println(page_url);
		String page_source=driver.getPageSource();
		System.out.println(page_source);
		//driver.close();
		//driver.quit();

	}

}
