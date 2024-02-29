package org.selenium.commands;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

	import net.bytebuddy.implementation.bytecode.Throw;

	public class Browser_Launch {
	public WebDriver driver;

	public void initialize_Browser(String browser) {
		if(browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			throw new RuntimeException("Invalid browser received");
		}
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	@BeforeMethod
	public void setup() {
		initialize_Browser("Chrome");
	}
	}



