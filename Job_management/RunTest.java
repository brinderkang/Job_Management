package Test;

import java.awt.AWTException;
import java.io.File;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Generic.Xls_Reader;
import Pages.JobInducted;
import Pages.SeleniumWebDrivers;
import Pages.V3Login;

public class RunTest {
	
	V3Login objlogin=new V3Login();
	SeleniumWebDrivers objseldriver= new SeleniumWebDrivers();
	JobInducted objjobinduct=new JobInducted();
	static ExtentReports report;
	ExtentTest logger;
	@BeforeSuite
	@Parameters("browser")
	 public void launch_browser(@Optional("Chrome")String browser)
	 {
		//ExtentReports(String filePath,Boolean replaceExisting) 
		 //filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		 //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		 //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		 //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		 report = new ExtentReports ("D:\\Eclipse\\workspace\\Job_management\\src\\Logs\\extentreport.html", true);
		 //extent.addSystemInfo("Environment","Environment Name")
		 report
		                .addSystemInfo("Host Name", "Software Testing")
		                .addSystemInfo("Environment", "Automation Testing")
		                .addSystemInfo("User Name", "Brinder");
		                //loading the external xml file (i.e., extent-config.xml) which was placed at below path     
		                report.loadConfig(new File("D:\\Eclipse\\workspace\\Job_management\\src\\Logs\\extent-config.xml"));
		objseldriver.open_browser(browser);
	 }
//	@BeforeTest
//	 public void startReport(){
//	 //ExtentReports(String filePath,Boolean replaceExisting) 
//	 //filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
//	 //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
//	 //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
//	 //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
//	 report = new ExtentReports ("D:\\Eclipse\\workspace\\Job_management\\src\\Logs\\extentreport.html", true);
//	 //extent.addSystemInfo("Environment","Environment Name")
//	 report
//	                .addSystemInfo("Host Name", "Software Testing")
//	                .addSystemInfo("Environment", "Automation Testing")
//	                .addSystemInfo("User Name", "Brinder");
//	                //loading the external xml file (i.e., extent-config.xml) which was placed at below path     
//	                report.loadConfig(new File("D:\\Eclipse\\workspace\\Job_management\\src\\Logs\\extent-config.xml"));
//	 }
	
	@Test(testName="login", alwaysRun=true,priority=0)
	public void testlogin()
	{
		logger=report.startTest("testlogin");
		objlogin.login();	
		logger.log(LogStatus.PASS, "Logged in successfully");
		 report.endTest(logger);
		
	}
	@Test(testName="navtojobinduct",priority=1)
	public void navjobinduct() throws InterruptedException, AWTException
	{
		logger=report.startTest("navjobinduct");
		System.out.println("job induct");
		objjobinduct.jobinducttile();
//		objjobinduct.uploadrecords();
//		objjobinduct.datalinkbutton();
//		objjobinduct.datamapping();
//		objjobinduct.MapingIcontoView();
//		objjobinduct.viewjobs();
//		objjobinduct.viewjobsrecords();
		logger.log(LogStatus.PASS, "Navigated successfully");
		 report.endTest(logger);
	}
	@Test(testName="uploadRecords",priority=2)
	public void VerifyUploadRecords() throws InterruptedException, AWTException
	{
		logger=report.startTest("VerifyUploadRecords");
		objjobinduct.uploadrecords();
		report.endTest(logger);
	}
	@Test(testName="datalinkicon",priority=3)
	public void VerifyDatalinkIcon() throws InterruptedException, AWTException
	{
		logger=report.startTest("VerifyDatalinkIcon");
		objjobinduct.datalinkbutton();
		report.endTest(logger);
	}
	@Test(testName="datamapping",priority=4)
	public void VerifyDataMappingscreen() throws InterruptedException, AWTException
	{
		logger=report.startTest("VerifyDataMappingscreen");
		objjobinduct.datamapping();
		report.endTest(logger);
	}
	@Test(testName="verifymappingicon", priority=5)
	public void Verifymappingicon() throws InterruptedException, AWTException
	{
		logger=report.startTest("Verifymappingicon");
		objjobinduct.MapingIcontoView();
		report.endTest(logger);
	}
	@Test(testName="verifyrecords", priority=6)
	public void VerifyViewrecordsgrid() throws InterruptedException, AWTException
	{
		logger=report.startTest("VerifyViewrecordsgrid");
		objjobinduct.viewjobs();
		objjobinduct.viewjobsrecords();
		logger.log(LogStatus.PASS, "Records Matched");
		report.endTest(logger);
	}
//	@Test
//	public void closebrowser()
//	{
//		objseldriver.close_browser();
//		
//		
//	}
	@AfterMethod
	 public void getResult(ITestResult result){	
	 if(result.getStatus() == ITestResult.FAILURE){
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	 }
	 else if(result.getStatus() == ITestResult.SKIP){
	 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }
	 else if(result.getStatus() == ITestResult.SUCCESS){
		 logger.log(LogStatus.PASS, "Test Case Passed is "+result.getName());
		 }
	 // ending test
	 //endTest(logger) : It ends the current test and prepares to create HTML report
	 report.endTest(logger);
	 }
//	@AfterTest
//	 public void endReport(){
//		
//	 // writing everything to document
//	 //flush() - to write or update test information to your report. 
//	                report.flush();
//	                //Call close() at the very end of your session to clear all resources. 
//	                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
//	                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
//	                //Once this method is called, calling any Extent method will throw an error.
//	                //close() - To close all the operation
//	                report.close();
//	    }
	@AfterSuite
	public void closebrowser()
	{
//		objseldriver.close_browser();
		report.flush();
        //Call close() at the very end of your session to clear all resources. 
        //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
        //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
        //Once this method is called, calling any Extent method will throw an error.
        //close() - To close all the operation
        report.close();
		
	}
	
	
	
	

}
