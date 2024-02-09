package org.selenium_core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Edge_Launch {

	public static void main(String[] args) {
		WebDriver edge = new EdgeDriver();
		edge.get("https://demowebshop.tricentis.com/");//loading web url
		edge.manage().window().maximize();
		String page_tittle=edge.getTitle();
		System.out.println(page_tittle);
		String page_url=edge.getCurrentUrl();
		System.out.println(page_url);
		String page_source=edge.getPageSource();
		System.out.println(page_source);
		edge.close();
		//edge.quit();
		

	}

}
