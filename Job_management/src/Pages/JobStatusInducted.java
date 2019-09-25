package Pages;

import java.util.List;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Generic.GenericFunctions;
import Generic.Xls_Reader;
import Test.RunTest;

public class JobStatusInducted extends SeleniumWebDrivers{
	
	By header=By.xpath("//*[@id='mastHeader']");
	By depttab=By.xpath("//*[@id='tabDepartments']/div[2]/li");
	By exporttoexcelbtn=By.xpath("//*[@id='btnExport']");
	By closebtn=By.xpath("//*[@id='btnClose']");
//SEARCH PANEL
	By searchiconsrc=By.xpath("//*[@id='dvMainContainer']/div[1]/div[1]/div[1]/h3[1]");
	By jobidsrc=By.xpath("//*[@id='txtJobId']");
	By jobnameddarrowsrc=By.xpath("//*[@id='dvMainContainer']/div[1]/div[1]/div[1]/div[1]/div[3]/span[1]/span[1]/span[2]/span[1]");
	By jobnametxtsrc=By.xpath("//*[@id='ddlJobName-list']/span[1]/input[1]");
	By jobnameddlistsrc=By.xpath("//ul[@id='ddlJobName_listbox']/li");
	By jobnamesrc=By.xpath("//*[@id='txtJobName']");
	By clientddarrowsrc=By.xpath("//*[@id='dvMainContainer']/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/span[1]/span[2]/span[1]");	
	By clientddlistsrc=By.xpath("//*[@id='ddlClient_listbox']/li");
	By accmgrddarrowsrc=By.xpath("//*[@id='dvMainContainer']/div[1]/div[1]/div[1]/div[1]/div[4]/span[1]/span[1]/span[2]/span[1]");
	By accmgrddlistsrc=By.xpath("//*[@id='ddlAccountMgr_listbox']/li");
	By statusddarrowsrc=By.xpath("//*[@id='dvMainContainer']/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[2]/span[1]");
	By statusddlistsrc=By.xpath("//*[@id='ddlStatus_listbox']/li");
	By duedateddarrowsrc=By.xpath("//*[@id='dvMainContainer']/div[1]/div[1]/div[1]/div[2]/div[2]/span[1]/span[1]/span[2]/span[1]");
	By duedateddlistsrc=By.xpath("//*[@id='ddlJobDueDate_listbox']/li");
	By deliveredchk=By.xpath("//*[@id='dvMainContainer']/div[1]/div[1]/div[1]/div[3]/div[1]/label[1]");
	By pickedupchk=By.xpath("//*[@id='dvMainContainer']/div[1]/div[1]/div[1]/div[3]/div[2]/label[1]");
	By groupbyAM=By.xpath("//*[@id='dvMainContainer']/div[1]/div[1]/div[1]/div[3]/div[3]/label[1]");
	By searchbtn=By.xpath("//*[@id='btnSearch']");
//GRID
	By accmgrgrd=By.xpath("//*[@id='dvJobData']/div[3]/table[1]/tbody[1]/tr[1]/td[2]/span[1]");
	By clientgrd=By.xpath("//*[@id='dvJobData']/div[3]/table[1]/tbody[1]/tr[1]/td[2]/span[2]");
	By jobidgrd=By.xpath("//*[@id='dvJobData']/div[3]/table[1]/tbody[1]/tr[1]/td[3]/span[1]");
	By jobnamegrd=By.xpath("//*[@id='dvJobData']/div[3]/table[1]/tbody[1]/tr[1]/td[3]/span[2]");
	By quantitygrd=By.xpath("//*[@id='dvJobData']/div[3]/table[1]/tbody[1]/tr[1]/td[4]/span[2]");
	By duedategrd=By.xpath("//*[@id='dvJobData']/div[3]/table[1]/tbody[1]/tr[1]/td[5]/span[2]");
	By statusgrd=By.xpath("//*[@id='dvJobData']/div[3]/table[1]/tbody[1]/tr[1]/td[6]/span[2]");
						   
//CHANGE STATUS
	By changedateicon=By.xpath("//*[@id='btnJobVaryDate']");
	By changestatusicon=By.xpath("//a[@id='btnJobUpdateStatus']");
//	By changestatusicon=By.xpath("//span[@class='icon_edit x3']");
	By statusediticon=By.xpath("//span[@class='icon_edit x2']");
	By headerstatuspopup=By.xpath("//h2[contains(.,'Change status')]");
	By jobnameCS=By.xpath("//span[@id='hdrStsJobName']");
	By jobidCS=By.xpath("//span[@id='lblStsJobId']");
	By specsiconCS=By.xpath("//*[@id='btnStsCmnt']/span[1]");
	By clientnameCS=By.xpath("//*[@id='hdrStsClntName']/span[1]");
	By currentstatuslblCS=By.xpath("//*[@id='dvStsUpdate']/div[1]/div[1]/div[1]/div[1]/div[1]");
	By currentstatusCS=By.xpath("//*[@id='lblCrntStatus']");
	By newstatusddarrowCS=By.xpath("//*[@id='dvStsUpdate']/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[2]/span[1]");
	By newstatusddlistCS=By.xpath("//*[@id='ddlNewSts_listbox']/li");
	By statusdatetimeCS=By.xpath("//input[@id='txtStatusDate']");
//	By statusdatetimeCS=By.xpath("//*[@id='dvStsUpdate']/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/span[1]");
	
	By commentCS=By.xpath("//*[@id='txtStatusCmnt']");
	By statussavebtnCS=By.xpath("//*[@id='btnStatusSave']");
	By statusclosebtnCS=By.xpath("//*[@id='btnStatusUpdtn']");
//	VARIATION HISTORY
	By newstatusVH=By.xpath("//*[@id='dvStatusGrdData']/div[2]/table[1]/tbody[1]/tr[1]/td[2]");
	
	
	
	
	
	static Xls_Reader xrj=new Xls_Reader(System.getProperty("user.dir")+"\\src\\TestData\\JobsTestData.xlsx");
	static String jobfilename=xrj.getCellData("JobFilePath", "FileName", 2);
	static String jobfilepath=System.getProperty("user.dir")+"\\src\\TestData\\"+jobfilename;
	
	 SoftAssert softAssertion= new SoftAssert();
	 GenericFunctions gm=new GenericFunctions();
	 Modules md=new Modules();
	 JobInducted ji=new JobInducted();
	 V3Login objv3login=new V3Login();
	
	 
	 
	 
	static String url="http://oca-mel-test:8300/Job%20Management/ProductionManagment/ProdManagment.aspx?daol=1&i=3&pn=Job%20Status&j=445&prn=Easy%20Print%20Manager";
	static String binderyfilename=xrj.getCellData("JobFilePath", "Bindery FileName", 2);
	static String binderyfilepath=System.getProperty("user.dir")+"\\src\\TestData\\"+binderyfilename;
//STATIC EXCEL VARIABLES
	static String date,clientcode,clientname,clientdepartment,serviceDepartment,service,jobID,jobname,specifications,quantity,unitprice,ordervalue,deliverby,delivertype,overexcel,value,jobStatus,newstatus;
//STATIC GRID VARIABLES 
	static String accmgrJ,clientnameJ,jobidJ,jobnameJ,quantityJ,duedateJ,statusJ,newstatusJ;
	static String jobstatus="Material Awaited from Client"; 
	
	
	
	
//***********READ EXCEL JOB DATA***********
	 public void ReadExcel()
		{
		 Xls_Reader xrji=new Xls_Reader(jobfilepath);
		 String sheetname="Sheet1";
		 int rowcnt=xrji.getRowCount("Sheet1");
			String coldata = null;
			for(int i=1; i<=rowcnt; i++)
			{
				 jobID =xrj.getCellData("JobFilePath", "JobId", 2);
				 String JobID=xrji.getCellData(sheetname, "Job ID", i);
				if(JobID.equalsIgnoreCase(jobID))
				{
					
					
//			GET ROW DATA FROM EXCEL FILE	
					 date=xrji.getCellData(sheetname, "Date", i);
					 clientcode=xrji.getCellData("Sheet1", "Client", i);
//					 jobID=gm.decimalremove(xrji.getCellData("Sheet1", "Job ID", i));
					 jobname=xrji.getCellData(sheetname, "Job name", i);
					 specifications=xrji.getCellData(sheetname, "Specification", i);
					 quantity=gm.decimalremove(xrji.getCellData("Sheet1", "Quantity", i));
					 ordervalue=gm.decimalremove(xrji.getCellData("Sheet1", "Order value", i));
					 deliverby=xrji.getCellData("Sheet1", "Deliver by", i);
					 service=xrji.getCellData(sheetname, "Service", i);
					 serviceDepartment=xrji.getCellData("Sheet1", "Department", i);
					 jobStatus=xrji.getCellData("Sheet1", "Job status", i);
					 clientname=getclientname(clientcode);
					 
					 
//					 clientname=xls.getCellData(sheetname, "Clientname", i);
					
					 
		 
//		GET NEW STATUS from JOB TESTDATA excel file
					 newstatus =xrj.getCellData("JobFilePath", "NewStatus", 2);
					 break;
					
				}			
			}
		}
// OPEN AND GET CLIENT CODES FORM Client code sheet
	 public String getclientname(String clientcode)
	 {
		
		 Xls_Reader xrlg=new Xls_Reader("C:\\Users\\brinderjeet.singh\\Desktop\\FRS\\Job Induct\\Lgl_ClientsData_Cl_Code.xlsx");
		 String abc=objv3login.legalname;
		 int rowcntlg=xrlg.getRowCount(objv3login.legalname);
		 cn:
		 for (int j=2;j<rowcntlg;j++)
		 {
			 String cclg=xrlg.getCellData(objv3login.legalname, "Client code", j);
			 String clientcodelg[]=new String[rowcntlg];
			 clientcodelg[j]=cclg;
//			 System.out.println(clientcodelg[j]);
			 if( cclg.equals(clientcode))
			 {
				 clientname=xrlg.getCellData(objv3login.legalname, "Client", j);
				 System.out.println(clientname);
				break cn;
			 }
		 }
		return clientname;
	 }
//***********GENERIC WAIT METHOD***********
	public void waitforelement(By ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		
	}
//***********NAVIGATE TO JOB STATUS TILE***********
	public void jobstatustile()
	{
		driver.get(url);
		RunTest.logger.log(LogStatus.INFO, "URL Entered for JOB STATUS tile");
// VERIFY HEADER TEXT
		waitforelement(header);
		String jobstatustitle=driver.findElement(header).getText();
		if(jobstatustitle.equals("Job Status"))
		{
			RunTest.logger.log(LogStatus.PASS, "Successfully navigated to JOB STATUS tile");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Not navigated to JOB STATUS tile");
		}
//	VISIBILITY OF EXPORT TO EXCEL AND CLOSE BUTTON
		waitforelement(exporttoexcelbtn);
		boolean abc=driver.findElement(exporttoexcelbtn).isDisplayed();
		if (driver.findElement(exporttoexcelbtn).isDisplayed())
		{
			RunTest.logger.log(LogStatus.PASS, "Export to excel button exists");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Export to excel button does not exists");
		}
		boolean close=driver.findElement(closebtn).isDisplayed();
		if(driver.findElement(closebtn).isDisplayed())
		{
			RunTest.logger.log(LogStatus.PASS, "Close button exist");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Close button does not exist");
		}
		waitforelement(changedateicon);
		boolean chdate=driver.findElement(changedateicon).isDisplayed();
		if(driver.findElement(changedateicon).isDisplayed())
		{
			RunTest.logger.log(LogStatus.PASS, "Change Date icon exist");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Change Date icon does not exist");
		}
		boolean chstatus=driver.findElement(changestatusicon).isDisplayed();
		if(driver.findElement(changestatusicon).isDisplayed())
		{
			RunTest.logger.log(LogStatus.PASS, "Change Status icon exist");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Change Status icon does not exist");
		}
		
	}
	
//***********FIND REQUIRED DEPARTMENT***********
		public void departmenttab() throws InterruptedException
		{
			ReadExcel();
			List<WebElement> deptele=driver.findElements(depttab);
			for(WebElement dept:deptele)
			{
				String dt=dept.getText();
				System.out.println(dept.getText());
				if((dept.getText()).equalsIgnoreCase(serviceDepartment))
				{
					dept.click();
					break;
				}
			}
//			searchpanel();
//			System.out.println("Grid");
//			grid();
		}
//***********SEARCH PANEL***********
		public void searchpanel() throws InterruptedException
		{
			Thread.sleep(4000);
			waitforelement(searchiconsrc);
			driver.findElement(searchiconsrc).click();
			driver.findElement(jobidsrc).sendKeys(jobID);
//			driver.findElement(jobnamesrc).sendKeys(jobname);
//		SELECT CLIENT NAME
			driver.findElement(clientddarrowsrc).click();
			List<WebElement> clientsrcele=driver.findElements(clientddlistsrc);
			for(WebElement clientnameJ:clientsrcele)
			{
				String ct=clientnameJ.getText();
				System.out.println(ct);
				if((clientnameJ.getText()).equals(clientname))
				{
					clientnameJ.click();
					break;
				}
			}
//		SELECT JOB NAME
			driver.findElement(jobnameddarrowsrc).click();
			waitforelement(jobnametxtsrc);
			driver.findElement(jobnametxtsrc).sendKeys(jobname);
			List<WebElement> jobnamesrcele=driver.findElements(jobnameddlistsrc);
			int jbcnt=jobnamesrcele.size();
			for(WebElement jobnamenameJ:jobnamesrcele)
			{
				
				String jb=jobnamenameJ.getAttribute("innerText");
				System.out.println(jb);
				if((jobnamenameJ.getText()).equals(jobname))
				{
					jobnamenameJ.click();
					break;
				}
			}
			Thread.sleep(2000);
			driver.findElement(pickedupchk).click();
			driver.findElement(deliveredchk).click();
			driver.findElement(searchbtn).click();
		}
//***********RESULT GRID***********
		public void grid() throws InterruptedException
		{
			Thread.sleep(2000);
			waitforelement(accmgrgrd);
			 accmgrJ=driver.findElement(accmgrgrd).getText();
			 clientnameJ=driver.findElement(clientgrd).getText();
			 jobidJ=driver.findElement(jobidgrd).getText();
			 jobnameJ=driver.findElement(jobnamegrd).getText();
			 quantityJ=driver.findElement(quantitygrd).getText();
			 duedateJ=driver.findElement(duedategrd).getText();
			 statusJ=driver.findElement(statusgrd).getText();
			
			

//		ACCOUNT MANAGER - grid
//		Get account manager info from CLIENT SALES module
			String accountmgr=md.clientaccountmgr(clientname,"Inducted");
			if(accmgrJ.equals(accountmgr))
			{
				driver.get(url);
				departmenttab();
				searchpanel();
				
				softAssertion.assertEquals(accmgrJ, accountmgr);
				RunTest.logger.log(LogStatus.PASS, "Account manager matched");
				System.out.println("Pass -Account manager matched");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "Account manager not matched");
				System.out.println("FAIL -Account manager not matched");
			}
//		CLIENT NAME - grid
			if(clientnameJ.equals(clientname))
			{
				softAssertion.assertEquals(clientnameJ, clientname);
				RunTest.logger.log(LogStatus.PASS, "Client name matched");
				System.out.println("PASS -Client name matched");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "Client name not matched");
				System.out.println("FAIL -Client name not matched");
			}
//		JOB ID -grid
			if(jobidJ.equals(jobID))
			{
				softAssertion.assertEquals(jobidJ, jobID);
				RunTest.logger.log(LogStatus.PASS, "Job ID matched");
				System.out.println("Pass -Job ID matched");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "Job ID not matched");
				System.out.println("FAIL -Job ID not matched");
			}
//		JOB NAME - grid
			if(jobnameJ.equals(jobname))
			{
				softAssertion.assertEquals(jobnameJ, jobname);
				RunTest.logger.log(LogStatus.PASS, "Job name matched");
				System.out.println("PASS -Job name matched");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "Job name not matched");
				System.out.println("FAIL -Job name not matched");
			}
//		QUANTITY - grid
			quantityJ=quantityJ.replace(",", "");
			if(quantityJ.equals(quantity))
			{
				softAssertion.assertEquals(quantityJ, quantity);
				RunTest.logger.log(LogStatus.PASS, "Quantity matched");
				System.out.println("PASS -Quantity matched");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "Quantity not matched");
				System.out.println("FAIL -Quantity not matched");
			}
//		DUE DATE - grid	
			deliverby=deliverby.substring(0, 11);
			if(duedateJ.equals(deliverby))
			{
				softAssertion.assertEquals(duedateJ, deliverby);
				RunTest.logger.log(LogStatus.PASS, "Due Date matched");
				System.out.println("PASS -Due Date matched");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "Due Date not matched");
				System.out.println("FAIL -Due Date not matched");
			}
//		STATUS - grid
			if(statusJ.equals(jobstatus))
			{
				softAssertion.assertEquals(statusJ,jobstatus );
				RunTest.logger.log(LogStatus.PASS, "Status matched");
				System.out.println("PASS -Status matched");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "Status not matched");
				System.out.println("FAIL -Status not matched");
			}

		}
		
//***********CHANGE STATUS***********
		public void changestatus() throws InterruptedException
		{
//	GET NEW STATUS from JOB TESTDATA excel file
			newstatus =xrj.getCellData("JobFilePath", "NewStatus", 2);
			Thread.sleep(4000);
			waitforelement(changestatusicon);
			driver.findElement(changestatusicon).click();
			RunTest.logger.log(LogStatus.INFO, "Change Status icon clicked ");
			driver.findElement(statusediticon).click();
//	HEADER TEXT
			waitforelement(headerstatuspopup);
			String header=driver.findElement(headerstatuspopup).getText();
			
			if((driver.findElement(headerstatuspopup).getText()).equals("Change status"))
			{
				RunTest.logger.log(LogStatus.INFO, "Header text matched ");
			}
//	JOB NAME
			WebElement jobnameC=driver.findElement(jobnameCS); 
			String jobnameC1=jobnameC.getText();
			if((jobnameC.isDisplayed())&&((jobnameC.getText()).equals(jobname)))
			{
				RunTest.logger.log(LogStatus.PASS, "Job Name is dispalying");
			}
			else 
			{
				RunTest.logger.log(LogStatus.FAIL, "Job Name is not displaying");
			}
//	JOB ID 
			WebElement jobidC=driver.findElement(jobidCS);
			String jobidC1=jobidC.getText();
			if((jobidC.isDisplayed())&&((jobidC.getText()).equals(jobID)))
			{
				RunTest.logger.log(LogStatus.PASS, "Job ID is displaying");
			}
			else 
			{
				RunTest.logger.log(LogStatus.FAIL, "Job ID is not displaying");
			}
//	SPECIFICATION ICON
			if(driver.findElement(specsiconCS).isDisplayed())
			{
				RunTest.logger.log(LogStatus.PASS, "Specification icon is displaying");
			}
			else 
			{
				RunTest.logger.log(LogStatus.FAIL, "Specification icon is not displaying");
			}
//	CLIENT NAME
			WebElement clientnameC=driver.findElement(clientnameCS);
			String clientnameC1=clientnameC.getText();
			if((clientnameC.isDisplayed())&&((clientnameC.getText()).equals(clientname)))
			{
				RunTest.logger.log(LogStatus.PASS, "Client name is displaying");
			}
			else 
			{
				RunTest.logger.log(LogStatus.FAIL, "Client name is not displaying");
			}
//	CURRENT STATUS LABLE
			WebElement currentstatuslblC=driver.findElement(currentstatuslblCS);
			String currentstatuslblC1=currentstatuslblC.getText();
			if((currentstatuslblC.isDisplayed())&&((currentstatuslblC.getText()).equals("Current Status")))
			{
				RunTest.logger.log(LogStatus.PASS, "Current status lable is displaying");
			}
			else 
			{
				RunTest.logger.log(LogStatus.FAIL, "Current status lable is not displaying");
			}
//	PRESENT STATUS 
			waitforelement(currentstatusCS);
			WebElement currentstatusC=driver.findElement(currentstatusCS);
			String currentstatusC1=currentstatusC.getText();
			if((currentstatusC.isDisplayed())&&((currentstatusC.getText()).equals(jobstatus)))
			{
				RunTest.logger.log(LogStatus.PASS, "Job Status is displaying");
			}
			else 
			{
				RunTest.logger.log(LogStatus.FAIL, "Job Status is not displaying");
			}
//	CHANGE JOB STATUS
			String newstatusC = null;
			driver.findElement(newstatusddarrowCS).click();
			List<WebElement> newstatusele=driver.findElements(newstatusddlistCS);
			for(WebElement newstatus1C:newstatusele)
			{
				String abc=newstatus1C.getText();
				if((newstatus1C.getText()).equals(newstatus))
				{
					newstatusC=newstatus1C.getText();
					newstatus1C.click();
					break;
				}
			}
			driver.findElement(statusdatetimeCS).click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String statusdatetimeC= (String) js.executeScript("return arguments[0].value;",driver.findElement(statusdatetimeCS));
//			String theTextIWant = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",driver.findElement(statusdatetimeCS));
//			String statusdatetimeC=driver.findElement(statusdatetimeCS).getAttribute("innerText");
			System.out.println(statusdatetimeC);
			int len=statusdatetimeC.length();
			String statusdateC=statusdatetimeC.substring(0, 11);
			String statustimeC=statusdatetimeC.substring((statusdateC.length()+1),statusdatetimeC.length());
			
			driver.findElement(commentCS).sendKeys("Status update comments");
			driver.findElement(statussavebtnCS).click();
			Thread.sleep(3000);
		
//	VARIATION HISTORY- VERIFY NEW JOB STATUS
			String newstatusV1=driver.findElement(newstatusVH).getText();
			System.out.println("Status :-  "+newstatusV1);
			int ind=newstatusV1.indexOf("\n");
			int ind1=newstatusV1.indexOf("\n", (ind+1));
			String newstatusV=newstatusV1.substring((ind+1), ind1);
			String statusupdatetimeV=newstatusV1.substring(0, ind);
			String statusupdatedateV=newstatusV1.substring((ind1+1),newstatusV1.length() );
			if(newstatusV.equals(newstatus))
			{
				RunTest.logger.log(LogStatus.PASS, "New job Status updated in Variation History");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "New job Status not updated in Variation History");
			}
			if(statusdateC.equals(statusupdatedateV))
			{
				RunTest.logger.log(LogStatus.PASS, "New job Status date updated in Variation History");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "New job Status date not updated in Variation History");
			}
			if(statustimeC.equals(statusupdatetimeV))
			{
				RunTest.logger.log(LogStatus.PASS, "New job Status time updated in Variation History");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "New job Status time not updated in Variation History");
			}
//	CLICK CLOSE BUTTON
			driver.findElement(statusclosebtnCS).click();
			
//	STATUS - grid
			Thread.sleep(3000);
			waitforelement(statusgrd);
//			statusJ=driver.findElement(statusgrd).getText();
			newstatusJ=driver.findElement(statusgrd).getText();
			if(newstatusJ.equals(newstatus))
			{
				RunTest.logger.log(LogStatus.PASS, "New job Status updated in grid");
			}
			else
			{
				RunTest.logger.log(LogStatus.FAIL, "New job Status not updated in grid");
			}

		}

			

}
