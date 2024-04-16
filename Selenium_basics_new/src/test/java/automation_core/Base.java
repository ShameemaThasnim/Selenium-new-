package automation_core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class Base {
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
	@AfterMethod(alwaysRun= true)
	public void closeBrowser(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
		takeScreenShot(result);
		}
		driver.close();
	}
	
	@BeforeMethod(alwaysRun= true)
	@Parameters({"browser","baseurl"})
	public void setup(String browsername, String url) {
		initialize_Browser(browsername);
		driver.get(url);
	}
	public void takeScreenShot(ITestResult result) throws IOException
	{
		TakesScreenshot takescreenshot= (TakesScreenshot) driver;
		File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./ScreenShot/"+result.getName()+".png"));
	}
	
	}






