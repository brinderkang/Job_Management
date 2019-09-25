package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


	
public class SeleniumWebDrivers {
			
	 public static WebDriver driver;
	 public void open_browser(String browser)
	 {
		   
		 switch(browser.trim())
		 {
			 case "Firefox":
				 System.setProperty("webdriver.gecko.driver", "C:\\Users\\brinderjeet.singh\\Downloads\\geckodriver-v0.14.0-win32\\geckodriver.exe");
				 driver=new FirefoxDriver();
			 break;
			 case "Chrome":
//		TO HANDEL EXCEPTION :- org.openqa.selenium.UnhandledAlertException: unexpected alert open: {Alert text : error}
				 DesiredCapabilities dc = new DesiredCapabilities();
				 dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				 
				 System.setProperty("webdriver.chrome.driver", "D:\\Brinder\\BrowserDrivers\\chromedriver.exe");
				 driver = new ChromeDriver(dc);							 
			 break;
			 case "IE":
				 System.setProperty("webdriver.ie.driver", "D:\\Brinder\\BrowserDrivers\\IEDriverServer.exe");
				 driver = new InternetExplorerDriver();
			 break;
			 case "htmlunitdriver":
//				 System.setProperty("webdriver.ie.driver", "D:\\Brinder\\BrowserDrivers\\IEDriverServer.exe");
				 driver = new HtmlUnitDriver();
			 break;
			 case "Edge":
				 
				 System.setProperty("webdriver.edge.driver", "D:\\Brinder\\BrowserDrivers\\MicrosoftWebDriver.exe");		 				 
				 driver = new EdgeDriver();
			 break;
			 default:
				 System.out.println(browser+"  Browser driver not available");
			 break;
			 
		 }
		 
		 driver.get("http://oca-mel-test:8300");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	 }
	 
	 public void close_browser()
	 {
		 driver.close();
		 driver.quit();
	 }

}
