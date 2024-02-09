package org.selenium_core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Mozila_Launch {

	public static void main(String[] args) {
		WebDriver moz = new FirefoxDriver();
		moz.get("https://demowebshop.tricentis.com/");//loading web url
		moz.manage().window().maximize();
		String page_tittle=moz.getTitle();
		System.out.println(page_tittle);
		String page_url=moz.getCurrentUrl();
		System.out.println(page_url);
		String page_source=moz.getPageSource();
		System.out.println(page_source);
		moz.close();
		//moz.quit();


	}

}
