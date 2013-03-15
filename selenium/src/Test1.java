import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.opera.core.systems.OperaDriver;

public class Test1 {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();


	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void Firefox (){ //Firefox method
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void Chrome (){ //Chrome method
		driver = new ChromeDriver();
	}

	public void Opera (){ //Opera method
		driver = new OperaDriver();
	}

	public void Explorer (){ //Explorer method
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		driver = new InternetExplorerDriver(ieCapabilities);
	}

	//This method takes two strings, the first is the CssSelector, the second is the text we are looking for
	//It then asserts that the CssSelector contains the text
	public void findCssText (String cssSel, String textStr) {
		try {
			assertTrue(driver.findElement(By.cssSelector(cssSel)).getText().contains(textStr));
			System.out.println(textStr +" Found OK");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}	  
	}

	//This method takes two strings, the first is the id, the second is the text we are looking for
	//It then asserts that the id contains the text
	public void findIdText (String id, String textStr) {
		try {
			assertTrue(driver.findElement(By.id(id)).getText().contains(textStr));
			System.out.println(textStr +" Found OK");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}	  
	}

	//This method takes one string, the id.
	//It then verifies that the element is present
	public void findIdElement (String id) {
		try {
			assertTrue(isElementPresent(By.id(id)));
			System.out.println(id +" Found OK");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}}

	//This method takes one string, the cssSelector.
	//It then verifies that the element is present
	public void findCssElement (String css) {
		try {
			assertTrue(isElementPresent(By.cssSelector(css)));
			System.out.println(css +" Found OK");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}}

	//This method takes one string, the linkText.
	//It then verifies that the element is present
	public void findLinkTextElement (String linkText) {
		try {
			assertTrue(isElementPresent(By.linkText(linkText)));
			System.out.println(linkText +" Found OK");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}}

	int i=0;

	@Before
	public void setUp() throws Exception {

		//Set the Base URL
		baseUrl = "http://www.cybercom.com";

	}
/*
	@Test
	public void test1() throws Exception {
		Firefox();
		driver.get(baseUrl + "/");
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchText")).click();
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchText")).clear();
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchText")).sendKeys("Volvo");
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchButton")).click();


		findIdText("ResultArea", "Cybercom wins deal with Volvo Cars");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchText");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchButton");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchInFiles");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchOnlyWholeWords");
		findIdElement("PageFooter");
		findCssElement ("img[alt=\"RSS icon.\"]");
		findLinkTextElement ("info@cybercom.com");
		findLinkTextElement ("Site map");
		findLinkTextElement ("RSS feed");

	}
*/
	@Test
	public void test2() throws Exception {
		Chrome();
		driver.get(baseUrl + "/");
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchText")).click();
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchText")).clear();
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchText")).sendKeys("Volvo");
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchButton")).click();


		findIdText("ResultArea", "Cybercom wins deal with Volvo Cars");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchText");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchButton");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchInFiles");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchOnlyWholeWords");
		findIdElement("PageFooter");
		findCssElement ("img[alt=\"RSS icon.\"]");
		findLinkTextElement ("info@cybercom.com");
		findLinkTextElement ("Site map");
		findLinkTextElement ("RSS feed");

	}
/*
	@Test
	public void test3() throws Exception {
		Explorer();
		driver.get(baseUrl + "/");
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchText")).click();
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchText")).clear();
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchText")).sendKeys("Volvo");
		driver.findElement(By.id("ctl00_FormHolder_ctl00_SearchButton")).click();


		findIdText("ResultArea", "Cybercom wins deal with Volvo Cars");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchText");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchButton");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchInFiles");
		findIdElement("ctl00_FormHolder_PageHolder_WideContentHolder_CenterContentHolder_MainBodyHolder_SearchOnlyWholeWords");
		findIdElement("PageFooter");
		findCssElement ("img[alt=\"RSS icon.\"]");
		findLinkTextElement ("info@cybercom.com");
		findLinkTextElement ("Site map");
		findLinkTextElement ("RSS feed");

	}
*/
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}}
}

