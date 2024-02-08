package org.selenium_core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Edge_Launch {

	public static void main(String[] args) {
		WebDriver edge = new EdgeDriver();
		edge.get("https://demowebshop.tricentis.com/");//loading web url
		edge.manage().window().maximize();

	}

}
