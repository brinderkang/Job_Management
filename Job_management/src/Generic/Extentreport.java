package Generic;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.Optional;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreport {
	
	private ExtentReports report;
	private ExtentTest logger;

	public Extentreport(ExtentReports report1,ExtentTest logger1){
	
		this.report=report1;
		this.logger=logger1;
	}
	
	 public void create_report()
	 {
		//ExtentReports(String filePath,Boolean replaceExisting) 
		 //filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		 //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		 //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		 //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		 report = new ExtentReports ("D:\\Eclipse\\workspace\\Job_management\\src\\Logs\\extentreport.html", true);
		 //extent.addSystemInfo("Environment","Environment Name")
		 report
		                .addSystemInfo("Host Name", "Software Automation Testing")
		                .addSystemInfo("Environment", "Test V3")
		                .addSystemInfo("User Name", "Brinder Kang");
		                //loading the external xml file (i.e., extent-config.xml) which was placed at below path     
		                report.loadConfig(new File("D:\\Eclipse\\workspace\\Job_management\\src\\Logs\\extent-config.xml"));
		
	 }
	 
	 public void start_test(String name)
	 {
		 logger=report.startTest("name");
	 }
	 public void logstatus_pass(String message)
	 {
		 logger.log(LogStatus.PASS, message);
	 }
	 public void logstatus_fail(String message)
	 {
		 logger.log(LogStatus.FAIL, message);
	 }
	 
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
	 
	 public void end_test()
	 {
		 report.endTest(logger);
	 }
	 
	 public void close_report()
	 {
		 report.flush();
	        //Call close() at the very end of your session to clear all resources. 
	        //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
	        //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
	        //Once this method is called, calling any Extent method will throw an error.
	        //close() - To close all the operation
	        report.close();
	 }

}
