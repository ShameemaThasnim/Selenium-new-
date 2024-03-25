package org.selenium.commands;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Commands extends Browser_Launch{
	@Test
	public void verifyCommunityPool() {
		driver.get("https://demowebshop.tricentis.com/");
		List<WebElement> communitypollelements = driver.findElements(By.xpath("//label[starts-with(@for,'pollanswe')]//parent::li"));
		for(int i=0;i<communitypollelements.size();i++)
		{
			//System.out.println(communitypollelements.get(i).getText());
			String poll_optionstext = communitypollelements.get(i).getText();
			if(poll_optionstext.equals("Poor"))
			{
				communitypollelements.get(i).click();
			}
		}
	}
	@Test
	public void verifyCurrentUrl() {
		driver.get("https://demowebshop.tricentis.com/");
		String actual_page_url=driver.getCurrentUrl();
		String expected_page_url="https://demowebshop.tricentis.com/";
		Assert.assertEquals(actual_page_url, expected_page_url,"Invalid current Url");
		//System.out.println(page_url);
	}
	@Test
	public void verifyPageTittle() {
		driver.get("https://demowebshop.tricentis.com/");
		String actual_page_tittle=driver.getTitle();
		//System.out.println(page_tittle);
		String expected_page_tittle="Demo Web Shop";
		Assert.assertEquals(actual_page_tittle, expected_page_tittle,"Invalid page tittle");
		
	}
	@Test
	public void verifyIsSelected() {
		boolean isfemaleselected;
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radiobuttonfemale= driver.findElement(By.xpath("//input[@id='gender-female']"));
		isfemaleselected=radiobuttonfemale.isSelected();
		Assert.assertFalse(isfemaleselected,"radio button is selected");
		System.out.println("Female button before selected:"+isfemaleselected);
		radiobuttonfemale.click();
		isfemaleselected=radiobuttonfemale.isSelected();
		Assert.assertTrue(isfemaleselected, "radio button not selected");
		System.out.println("Female button after selected:"+isfemaleselected);
	
	}
	@Test
	public void verfyIsEnabled() {
		driver.get("https://demowebshop.tricentis.com");
		WebElement subscribe= driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		boolean isenabled=subscribe.isEnabled();
		Assert.assertTrue(isenabled, "Subscribe button not enabled");
		System.out.println("is enabled:"+isenabled);
	}
	
	@Test
	public void verfyIsDisplayed() {
	
		driver.get("https://demowebshop.tricentis.com");
		WebElement vote= driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		boolean isdisplayed=vote.isDisplayed();
		Assert.assertTrue(isdisplayed, "vote button not enabled");
		System.out.println("IsDisplayed "+isdisplayed);
		
	}
	
	@Test
	
	public void verifyUserLogin() {
		String s="Shameemathasnim.ma@gmail.com";
		driver.get("https://demowebshop.tricentis.com/");
		WebElement login=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
		login.click();
		WebElement email=driver.findElement(By.cssSelector("#Email"));
		email.sendKeys(s);
		WebElement password=driver.findElement(By.cssSelector("#Password"));
		password.sendKeys("Sreekuttan$2023");
		WebElement loginlink=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
		loginlink.click();
		WebElement home_email=driver.findElement(By.cssSelector(".account"));
		Assert.assertEquals(home_email.getText(),s ,"Invalid login");
		System.out.println(home_email.getText());
		}
	@Test
	public void verfyValuesFromDropDown() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement country_drop_down=driver.findElement(By.xpath("//select[@name='country']"));
		Select select= new Select(country_drop_down);
		//select.selectByVisibleText("INDIA");
		//select.selectByIndex(5);
		select.selectByValue("ARMENIA");
		WebElement get_country_name=select.getFirstSelectedOption();
		System.out.println(get_country_name.getText());
		
		}
	@Test
	public void verfyTotalNumberOFDropDownValues() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement country_drop_down=driver.findElement(By.xpath("//select[@name='country']"));
		Select select= new Select(country_drop_down);
		List<WebElement> drop_downelementlist =select.getOptions();
		System.out.println(drop_downelementlist.size());
		
	}
	@Test
	public void verifyMultiSelectDropDown() {
		driver.get("https://selenium.qabible.in/select-input.php");
		WebElement multiselect= driver.findElement(By.xpath("//select[@id='multi-select-field']"));
		Select select= new Select(multiselect);
		boolean selectedvalue= select.isMultiple();
		System.out.println(selectedvalue);
		select.selectByVisibleText("Red");
		select.selectByVisibleText("Yellow");
		List<WebElement> selected_values =select.getAllSelectedOptions();
		//for(WebElement e:selected_values) {
			//System.out.println(e.getText());
		//}
		for(int i=0;i<selected_values.size();i++)
		{
			System.out.println(selected_values.get(i).getText());
		}
		select.deselectByVisibleText("Red");
		
	}
	@Test
	public void verifyFileUpload() {
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement choosefile= driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		choosefile.sendKeys("C:\\Users\\ashif\\git\\Selenium-new-\\Selenium_basics_new\\src\\main\\resources");
		WebElement acceptbox= driver.findElement(By.xpath("//input[@id='terms']"));
		acceptbox.click();
		WebElement submitbutton= driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submitbutton.click();
		}
	@Test
	public void verifyMultipleWindowHandling() {
		driver.get("https://demo.guru99.com/popup.php");
		String parentwindowhandleid = driver.getWindowHandle();
		System.out.println(parentwindowhandleid);
		WebElement clickhere= driver.findElement(By.xpath("//a[@target='_blank']"));
		clickhere.click();
		Set<String> windowhandlesid=driver.getWindowHandles();
		System.out.println(windowhandlesid);
		Iterator<String> value=windowhandlesid.iterator();
		while(value.hasNext())
		{
			String handleid=value.next();
			if(!handleid.equals(parentwindowhandleid))
			{
				driver.switchTo().window(handleid);
				WebElement email=driver.findElement(By.xpath("//input[@name='emailid']"));
				email.sendKeys("shameemathasnim.ma@gmail.com");
				WebElement submit= driver.findElement(By.xpath("//input[@name='btnLogin']"));
				submit.click();
				driver.close();
			}
		}
		driver.switchTo().window(parentwindowhandleid);
	}
	@Test
	public void validateSimpleAlert() {
		driver.get("https://demoqa.com/alerts");
		WebElement clickmebutton=driver.findElement(By.xpath("//button[@id='alertButton']"));
		clickmebutton.click();
		Alert alert = driver.switchTo().alert();
		String textmessage=alert.getText();
		System.out.println(textmessage);
		alert.accept();
		
	}
	@Test
	public void validateConfirmationAlert() {
		String expected="You selected Cancel";
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		WebElement clickmebutton=driver.findElement(By.xpath("//button[@id='confirmButton']"));
		clickmebutton.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		WebElement confirmation=driver.findElement(By.xpath("//span[@id='confirmResult']"));
		String actualtext=confirmation.getText();
		System.out.println(actualtext);
		Assert.assertEquals(actualtext,expected,"Text selected is ok");
		}
	@Test
	public void validatePromptAlert() {
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
        WebElement clickmebutton=driver.findElement(By.xpath("//button[@id='promtButton']"));
		clickmebutton.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Shameema");
		alert.accept();
		WebElement promptafterclick=driver.findElement(By.xpath("//span[@id='promptResult']"));
		String actualresult=promptafterclick.getText();
		System.out.println(actualresult);
		Assert.assertEquals(actualresult,"You entered Shameema","Text u entered doesn't match");
		}
	@Test
	public void verifyRightClick() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightclickbutton=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action= new Actions(driver);
		action.contextClick(rightclickbutton).build().perform();
	}
	@Test
	public void verifyDoubleClick() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleclickbutton=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions action= new Actions(driver);
		action.doubleClick(doubleclickbutton).build().perform();
		Alert alert = driver.switchTo().alert();
		String alert_message=alert.getText();
		System.out.println(alert_message);
		alert.accept();
		
	}
	@Test
	public void verifyDragAndDrop() {
		driver.get("https://demoqa.com/droppable");
		WebElement sourcedrag=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetdrag=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action= new Actions(driver);
		action.dragAndDrop(sourcedrag, targetdrag).build().perform();
		
	}
	@Test
	public void verifyDragAndDropOffset() {
		driver.get("https://demoqa.com/dragabble");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		WebElement sourcedrag=driver.findElement(By.xpath("//div[@id='dragBox']"));
		Actions action= new Actions(driver);
		action.dragAndDropBy(sourcedrag, 150, 150).build().perform();
		
	}
	@Test
	public void verifyMouseOver() {
		driver.get("https://demoqa.com/menu/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
        Actions action= new Actions(driver);
        WebElement mainbottun=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        action.moveToElement(mainbottun).build().perform();
        WebElement subbutton=driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        action.doubleClick(subbutton).build().perform();
		
	}
	
	@Test
	public void verifyJavascriptClickAndSendkeys()
	{
	driver.get("https://demowebshop.tricentis.com/");	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('newsletter-email').value='shameemathasnim.ma@gmail.com'");
	js.executeScript("document.getElementById('newsletter-subscribe-button').click()");
	}
	@Test
	public void verifyVerticalScroll()
	{
		driver.get("https://demowebshop.tricentis.com/");	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	@Test
	public void verifyScreenshot() {
		driver.get("https://demowebshop.tricentis.com/");
		String actualtittle=driver.getTitle();
		String expectedtittle="demowebshop";
		Assert.assertEquals(actualtittle, expectedtittle,"tille is not eqaul");
	}
	@Test
	public void verifyFrames() {
		driver.get("https://demoqa.com/frames");
		List<WebElement> iframecount=driver.findElements(By.tagName("iframe"));
		int size=iframecount.size();
		System.out.println("Total number of iframe in webpage :"+size);
		WebElement iframe=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframe);
		WebElement iframe_text=driver.findElement(By.id("sampleHeading"));
		String text= iframe_text.getText();
		System.out.println("iframe test is :"+text);
		driver.switchTo().defaultContent();
		
	}
    @Test
	public void verifyDifferenceBetweenFindElementAndFindElements() {
    	driver.get("https://demowebshop.tricentis.com/");
    	//on match
    	WebElement subscribe=driver.findElement(By.id("newsletter-subscribe-button"));
    	System.out.println("webelement on match :"+subscribe);
    	List<WebElement> communitypool=driver.findElements(By.xpath("//li[@class='answer']//label"));
    	int size_communitypool=communitypool.size();
    	System.out.println("community pool size :"+size_communitypool);
    	
    	//on zero match
    	List<WebElement> communitypoolzeromatch=driver.findElements(By.xpath("//li[@class='answer1']//label"));
    	int size_communitypoolzeromatch=communitypoolzeromatch.size();
    	System.out.println("community pool size zro match :"+size_communitypoolzeromatch);
    	//WebElement subscribenomatch=driver.findElement(By.id("newsletter-subscribe-button1"));
    	//System.out.println("webelement on match :"+subscribenomatch);
    	
    	//on one plus match
    	WebElement communitypooloneplus=driver.findElement(By.xpath("//li[@class='answer']//label"));
    	communitypooloneplus.click();
    	
    	
		
	}
    @Test
    public void verifyIframeHomework() {
    	driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
    	WebElement text_input=driver.findElement(By.id("name"));
    	text_input.sendKeys("iframe practice");
    	WebElement iframe=driver.findElement(By.id("frm1"));
		driver.switchTo().frame(iframe);
		WebElement iframe_dropdown=driver.findElement(By.xpath("//select[@id='selectnav1']"));
		Select select= new Select(iframe_dropdown);
		select.selectByVisibleText("- Java");
		WebElement get_selected_value=select.getFirstSelectedOption();
		System.out.println(get_selected_value.getText());
		driver.switchTo().defaultContent();
		WebElement iframe2=driver.findElement(By.id("frm2"));
		driver.switchTo().frame(iframe2);
		WebElement iframe2_dropdown=driver.findElement(By.xpath("//select[@id='selectnav1']"));
		Select select2= new Select(iframe2_dropdown);
		select2.selectByVisibleText("Tech News");
		WebElement get_selected2_value=select2.getFirstSelectedOption();
		System.out.println(get_selected2_value.getText());
		driver.switchTo().defaultContent();
		}
    @Test
    public void verifyDynamicTable() {
    	driver.get("https://money.rediff.com/indices");
    	WebElement showmore=driver.findElement(By.id("showMoreLess"));
    	showmore.click();
    	WebElement webtable=driver.findElement(By.xpath("//table[@id='dataTable']//tbody"));
    	List<WebElement> raws=webtable.findElements(By.tagName("tr"));
    	int raw_size=raws.size();
    	for(int i=0;i<raw_size;i++)
    	{
    		List<WebElement> columns=raws.get(i).findElements(By.tagName("td"));
    		int columns_size=columns.size();
    		for(int j=0;j<columns_size;j++)
    		{
    			String cell_text=columns.get(j).getText();
    			if(cell_text.equals("S&P BSE 200"))
    			{
    				System.out.println("Prev close value is :"+columns.get(1).getText());
    			}
    		}
    	}
    	
    	
    }
    @Test
    public void verifyWaits() {
    	driver.get("https://demowebshop.tricentis.com");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	WebElement register=driver.findElement(By.className("ico-registers"));
    	register.click();
    	}
    @Test
    public void verifyExplicitWait() {
    	driver.get("https://demoqa.com/alerts");
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
    	WebElement clickbutton=driver.findElement(By.id("timerAlertButton"));
    	clickbutton.click();
    	wait.until(ExpectedConditions.alertIsPresent());
    	Alert alert=driver.switchTo().alert();
    	alert.accept();
    	
    }
    @Test
    public void verifyFluentWait() {
    	driver.get("https://demoqa.com/alerts");
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    	FluentWait fluwait= new FluentWait(driver);
    	fluwait.withTimeout(Duration.ofSeconds(20));
    	fluwait.pollingEvery(Duration.ofSeconds(2));
    	fluwait.ignoring(NoSuchElementException.class);
    	fluwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
    	WebElement clickbutton=driver.findElement(By.id("timerAlertButton"));
    	clickbutton.click();
    	fluwait.until(ExpectedConditions.alertIsPresent());
    	Alert alert=driver.switchTo().alert();
    	alert.accept();
    	
    	
    	
    	
    }
    @Test
    public void verifySoftAssert() {
    	SoftAssert softassert= new SoftAssert();
    	System.out.println("***********Test case start***********");
    	softassert.assertEquals("hello", "hello", "First soft alert is fail");
    	System.out.println("**soft assert successfull**");
    	softassert.assertTrue("Hello".equals("hello"),"Second soft assert is failed" );
    	softassert.assertTrue("Ammu".equals("ammu"), "Third soft assert failed");
    	System.out.println("*************Test case completed successfully***************");
    	softassert.assertAll();
    }
        
    	
}
