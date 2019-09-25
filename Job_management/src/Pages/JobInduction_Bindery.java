package Pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Generic.GenericFunctions;
import Generic.Xls_Reader;
import Test.RunTest;

public class JobInduction_Bindery extends SeleniumWebDrivers{
	
	By binderyTile=By.xpath("//*[@id='mastHeader']");
//SEARCH PANEL
	By searchtext=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/h3[1]");
	By jobidsrctxt=By.xpath("//*[@id='txtJobId']");
	By jobnamesrctxt=By.xpath("//*[@id='txtJobName']");
	By clientddarrowsrc=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/div[1]/div[3]/span[1]/span[1]/span[2]/span[1]");
	By clientddlistsrc=By.xpath("//*[@id='ddlClient_listbox']/li");
	By accountmgrddarrowsrc=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/div[1]/div[4]/span[1]/span[1]/span[2]/span[1]");
	By accountmgrddlistsrc=By.xpath("//*[@id='ddlAccountManager_listbox']/li");
	By serviceddarrowsrc=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[2]/span[1]");
	By serviceddlistsrc=By.xpath("//*[@id='ddlService_listbox']/li");
	By statusddarrowsrc=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/div[2]/div[2]/span[1]/span[1]/span[2]/span[1]");
	By statusddlistsrc=By.xpath("//*[@id='ddlStatus_listbox']/li");
	By jobduedateddarrowsrc=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/div[2]/div[3]/span[1]/span[1]/span[2]/span[1]");
	By jobduedateddlistsrc=By.xpath("//*[@id='ddlJobDueDate_listbox']/li");
	By showjobswithoutchksrc=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/div[3]/div[1]/label[1]");
	By showjobswithoutddarrowsrc=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[2]/span[1]");
	By showjobswithoutddlistsrc=By.xpath("//*[@id='ddlAttachmentType_listbox']/li");
	By includedeliveredjobschk=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/div[4]/div[1]/label[1]");
	By includepickedjobs=By.xpath("//*[@id='dvJobInductedParent']/div[1]/div[1]/div[1]/div[4]/div[2]/label[1]");
	By searchbtn=By.xpath("//*[@id='btnSearch']");
	By clearbtn= By.xpath("//*[@id='btnClear']");
//RESULT GRID
	By dategrd=By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[2]");
	By accountmgrgrd=By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr[1]/td[2]/span[1]");
	By clientnamegrd= By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr[1]/td[2]/span[2]");
	By jobidgrd=By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr[1]/td[3]/span[1]");
	By jobnamegrd=By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr[1]/td[3]/span[2]");
	By servicesgrd=By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr[1]/td[4]/span[2]");
	By ordervaluegrd=By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr[1]/td[6]/div[1]/span[2]");
	By departmentgrd=By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr[1]/td[7]/span[1]");
	By deliverbygrd=By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr[1]/td[7]/span[2]");
	
//ADD JOB
	By addbutton=By.xpath("//*[@id='btnAddJobInducted']/span[1]");
	By addheader=By.xpath("//*[@id='hdrRow1']");
	By jobheader=By.xpath("//*[@id='hdrRow2']");
	By jobdetails=By.xpath("//a[text()='Job Details']");
	By attachment=By.xpath("//a[text()='Attachments']");
	By datepicker=By.xpath("//span[@class='k-picker-wrap k-state-default']//input[@id='txtJIDate']/following-sibling::span[@class='k-select']//span[@class='k-icon k-i-calendar']");
	By datetxtbox=By.xpath("//input[@id='txtJIDate']");
	By clientddarrow=By.xpath("//*[@id='dvJobDetail']/div[1]/div[2]/span[1]/span[1]/span[2]/span[1]");
//	By clientddarrow=By.xpath("//*[@id='dvJobDetail']/div[1]/div[2]/span/span/span[2]/span");
	By clienttxtbox=By.xpath("//input[@aria-owns='ddlJIClient_listbox']");
	//*[@id='ddlJIClient-list']/span[1]/input[1]
	By clientddlist=By.xpath("//*[@id='ddlJIClient_listbox']/li");
	By clientdeptddarrow=By.xpath("//*[@id='dvJobDetail']/div[2]/div[1]/span/span/span[2]/span");
	By clientdeptddtxt=By.xpath("//input[@aria-owns='ddlJIClDept_listbox']");
	By clientdeptddlist=By.xpath("//*[@id='ddlJIClDept_listbox']/li[1]");
	By servicereqdddarrow=By.xpath("//*[@id='dvJobDetail']/div[2]/div[2]/span/span/span[2]/span");
	By servicereqdddtxt=By.xpath("//input[@aria-owns='ddlJISrvcReq_listbox']");
	By sevicereqdddlist=By.xpath("//*[@id='00539584-829b-42e7-bfca-fd86f8d1e65c']/div");
	By jobidtxt=By.xpath("//input[@id='txtJIJobId']");
	By jobnametxt=By.xpath("//input[@id='txtJIJobName']");
	By specificationtxt=By.xpath("//textarea[@id='txtJISpecification']");
//	By quantitytxt=By.xpath("//input[@id='txtJIQty']");
	By quantitytxt=By.xpath("//input[@class='k-formatted-value k-input']/preceding::input[@class='k-formatted-value k-input']");
	By unitpricetxt=By.xpath("//*[@id='dvJobDetail']/div[5]/div[2]/span[1]/span[1]/input[1]");
	By ordervaluetxt=By.xpath("//*[@id='dvJobDetail']/div[5]/div[3]/span[1]/span[1]/input[1]");
//	By ordervaluetxt=By.xpath("//input[@class='k-formatted-value k-input']/following::input[@class='k-formatted-value k-input']");
	By deliverbydate=By.xpath("//input[@id='txtJIDelBy']");
	By pickupchk=By.xpath("//label[@for='chkPickup']");
	By deliverchk=By.xpath("//label[@for='chkDelivery']");
	By overddaroww=By.xpath("//*[@id='dvJobDetail']/div[6]/div[1]/div[1]/span[1]/span[1]/span[2]/span[1]");
	By overddlist=By.xpath("//*[@id='ddlJITolerance_listbox']/li");
	By valuetxt=By.xpath("//*[@id='dvTolVal']/span[1]/span[1]/input[1]");
	By nextbtn=By.xpath("//button[@id='btnJINext']");
	By saveclose=By.xpath("//button[@id='btnJISaveClose']");
	By cancelclose=By.xpath("//button[@id='btnJICancel']");
//ATTACHMENT TAB
	By documenttype=By.xpath("//th[@data-title='Document Type']");
	By attcheddocument =By.xpath("//th[@data-title='Attached Document']");
	By invoice=By.xpath("//td[contains(.,'Invoice')]");
	By invoicefile=By.xpath("//a[@id='btnAttach_1253']");
	By purchaseorder=By.xpath("//td[contains(.,'Purchase order')]");
//	By purchaceorderfile=By.xpath("//input[@id='htmlFilesGrd_1254']");
	By purchaseorderfile=By.xpath("//a[@id='btnAttach_1254']");
	By quote=By.xpath("//td[contains(.,'Quote')]");
//	By quotefile=org.openqa.selenium.By.xpath("//*[@id='dvUploadCntrl_1254']/div[1]");
	By quotefile=org.openqa.selenium.By.xpath("//a[@id='btnAttach_1255']");
	By signedconfirm=By.xpath("//td[contains(.,'Signed confirmation')]");
	By signedconfirmfile=By.xpath("//input[@id='htmlFilesGrd_1256']");
	By worksheet=By.xpath("//td[contains(.,'Worksheet')]");
	By worksheetfile=By.xpath("//input[@id='htmlFilesGrd_1257']");
	By artwork=By.xpath("//td[contains(.,'Artwork')]");
	By artworkfile=By.xpath("//input[@id='htmlFilesGrd_1262']");
	By previousbtn=By.xpath("//button[@id='btnJIPrevious']");
	By closebtn=By.xpath("//*[@id='btnJICancel']");
	
	
	 static Xls_Reader xrj=new Xls_Reader(System.getProperty("user.dir")+"\\src\\TestData\\JobsTestData.xlsx");
	 SoftAssert softAssertion= new SoftAssert();
	 GenericFunctions gm=new GenericFunctions();
	 Modules md=new Modules();
	 
	 static String binderyfilename=xrj.getCellData("JobFilePath", "Bindery FileName", 2);
	 static String binderyfilepath=System.getProperty("user.dir")+"\\src\\TestData\\"+binderyfilename;
//	 static Xls_Reader xri=new Xls_Reader(binderyfilepath);
	 String url= "http://oca-mel-test:8300/Job%20Management/JobsInducted/MngJobInduction.aspx?i=3&pn=Job%20Induction%20-%20Bindery&j=468&prn=Easy%20Print%20Manager";
	 static String date,clientname,clientdepartment,serviceDepartment,service,jobID,jobname,specifications,quantity,unitprice,ordervalue,deliverby,delivertype,overexcel,value;
	 
	 
	 public void ReadExcel()
		{
			Xls_Reader xls=new Xls_Reader(binderyfilepath);
			String sheetname="Bindery";
			int rowcnt=xls.getRowCount(sheetname);
			String coldata = null;
			for(int i=1; i<=rowcnt; i++)
			{
				String run=xls.getCellData(sheetname, "Run", i);
				if(run.equalsIgnoreCase("ON"))
				{
					 date=xls.getCellData(sheetname, "Date", i);
					 clientname=xls.getCellData(sheetname, "Clientname", i);
					 clientdepartment=xls.getCellData(sheetname, "Department", i);
					 serviceDepartment=xls.getCellData(sheetname, "ServiceDepartment", i);
					 service=xls.getCellData(sheetname, "Service", i);
					 jobID=xls.getCellData(sheetname, "JobID", i);
					 jobname=xls.getCellData(sheetname, "Jobname", i);
					 specifications=xls.getCellData(sheetname, "Specifications", i);
					 quantity=gm.decimalremove(xls.getCellData(sheetname, "Quantity", i));
					 unitprice=gm.decimalremove(xls.getCellData(sheetname, "UnitPrice", i));
					 ordervalue=gm.decimalremove(xls.getCellData(sheetname, "Ordervalue", i));
					 deliverby=xls.getCellData(sheetname, "Deliverby", i);
					 delivertype=xls.getCellData(sheetname, "Delivery type", i);
					 overexcel=xls.getCellData(sheetname, "Overs(tolerance)", i);
					 value=gm.decimalremove(xls.getCellData(sheetname, "Value", i));
				}			
			}
		}
	 
	 public void waitforelement(By ele)
	 {
		 WebDriverWait wait= new WebDriverWait(driver,60);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		 wait.until(ExpectedConditions.presenceOfElementLocated(ele));
	 }
	 
	 
//	 NAVIGATE TO JOBINDUCTION-BINDERY TILE
	 public void jobinduction_binderytile()
	 {
		 driver.get(url);
		 RunTest.logger.log(LogStatus.INFO, "URL Entered for JOB INDUCTION-BINDERY tile");
		 waitforelement(binderyTile);
		 String binderytile=driver.findElement(binderyTile).getText();
		 Assert.assertEquals(binderytile, "Job Induction - Bindery");
		 if(binderytile.equalsIgnoreCase("Job Induction - Bindery"))
		 {
			 RunTest.logger.log(LogStatus.PASS, "Navigated to Job Induction-Bindery tile");
		 }
		 
	 }
	 
//	 *************SEARCH JOB*************
	 public void searchjob() throws InterruptedException
	 {
		 ReadExcel();
		 Thread.sleep(2000);
		 waitforelement(searchtext);
		 driver.findElement(searchtext).click();
		 RunTest.logger.log(LogStatus.INFO, "Search icon clicked");
		 driver.findElement(jobidsrctxt).sendKeys(jobID);
		 RunTest.logger.log(LogStatus.INFO, "JOBID entered");
		 driver.findElement(jobnamesrctxt).sendKeys(jobname);
		 RunTest.logger.log(LogStatus.INFO, "JOB Name entered");
		 driver.findElement(clientddarrowsrc).click();
		List <WebElement> clientelesrc=driver.findElements(clientddlistsrc);
		for(WebElement clientsrc:clientelesrc )
		{
			if((clientsrc.getText()).equals(clientname))
			{
				clientsrc.click();
				RunTest.logger.log(LogStatus.INFO, "Client name entered");
			}
		}
		driver.findElement(searchbtn).click();
		RunTest.logger.log(LogStatus.INFO, "Search button clicked");
	 }
	 
//	RESULT GRID RECORDS
	 public void resultgrid() throws InterruptedException
	 {
		 Thread.sleep(3000);
		String datebj= driver.findElement(dategrd).getText();
		String accountmgrbj= driver.findElement(accountmgrgrd).getText();
		String clintnamebj= driver.findElement(clientnamegrd).getText();
		String jobidbj=driver.findElement(jobidgrd).getText();
		String jobnamebj=driver.findElement(jobnamegrd).getText();
		String servicesbj=driver.findElement(servicesgrd).getText();
		String ordervaluebj=driver.findElement(ordervaluegrd).getText();
		String servicedeptbj=driver.findElement(departmentgrd).getText();
		String deliverbybj=driver.findElement(deliverbygrd).getText();
		 
		
//	DATE - grid
		softAssertion.assertEquals(datebj, date);
		if(datebj.equals(date))
		{
			softAssertion.assertEquals(datebj, date);
			RunTest.logger.log(LogStatus.PASS, "Grid date matched");
			System.out.println(" PASS -Grid date matched");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Grid date not matched");
			System.out.println("FAIL -Grid date not matched");
		}
//	ACCOUNT MANAGER - grid
		String accountmgr=md.clientaccountmgr(clientname,"Bindery");
		if(accountmgrbj.equals(accountmgr))
		{
			driver.get(url);
			searchjob();
			softAssertion.assertEquals(accountmgrbj, accountmgr);
			RunTest.logger.log(LogStatus.PASS, "Grid account manager matched");
			System.out.println("Pass -Grid account manager matched");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Grid account manager not matched");
			System.out.println("FAIL -Grid account manager not matched");
		}
//	CLIENT NAME - grid
		if(clintnamebj.equals(clientname))
		{
			softAssertion.assertEquals(clintnamebj, clientname);
			RunTest.logger.log(LogStatus.PASS, "Client name matched");
			System.out.println("PASS -Client name matched");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Client name not matched");
			System.out.println("FAIL -Client name not matched");
		}
//	JOB ID -grid
		if(jobidbj.equals(jobID))
		{
			softAssertion.assertEquals(jobidbj, jobID);
			RunTest.logger.log(LogStatus.PASS, "Job ID matched");
			System.out.println("Pass -Job ID matched");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Job ID not matched");
			System.out.println("FAIL -Job ID not matched");
		}
//	JOB NAME - grid
		if(jobnamebj.equals(jobname))
		{
			softAssertion.assertEquals(jobnamebj, jobname);
			RunTest.logger.log(LogStatus.PASS, "Job name matched");
			System.out.println("PASS -Job name matched");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Job name not matched");
			System.out.println("FAIL -Job name not matched");
		}
//	SERVICES - grid
		if(servicesbj.equals(service))
		{
			softAssertion.assertEquals(servicesbj, service);
			RunTest.logger.log(LogStatus.PASS, "Service name matched");
			System.out.println("PASS -Service name matched");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Service name not matched");
			System.out.println("FAIL -Service name not matched");
		}
//	ORDER VALUE - grid
		String ordervaluebjN=ordervaluebj.substring(1, ordervaluebj.indexOf("."));
		if(ordervaluebjN.equals(ordervalue))
		{
			softAssertion.assertEquals(ordervaluebjN, ordervalue);
			RunTest.logger.log(LogStatus.PASS, "Order Value matched");
			System.out.println("PASS -Order Value matched");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Order Value not matched");
			System.out.println("FAIL -Order Value not matched");
		}
//	SERVICE DEPARTMENT - grid
		if(servicedeptbj.equals(clientdepartment))
		{
			softAssertion.assertEquals(servicedeptbj, serviceDepartment);
			RunTest.logger.log(LogStatus.PASS, "Department matched");
			System.out.println("PASS -Department matched");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Department not matched");
			System.out.println("FAIL -Department not matched");
		}
//	DELIVER BY - grid
		String deliverbyxl=deliverby.substring(0, 11);
		if(deliverbybj.equals(deliverbyxl))
		{
			softAssertion.assertEquals(deliverbybj, deliverbyxl);
			RunTest.logger.log(LogStatus.PASS, "Deliver By date matched");
			System.out.println("PASS -Deliver By date matched");
		}
		else
		{
			RunTest.logger.log(LogStatus.FAIL, "Deliver By date not matched");
			System.out.println("FAIL -Deliver By date not matched");
		}
	
	 }
	 
	 
//	 *************ADD JOB**********************
	 public void addjob() throws InterruptedException, AWTException
	 {
		 ReadExcel();
//	CLICK ADD BUTTON
		 waitforelement(addbutton);
		 driver.findElement(addbutton).click();
		 Thread.sleep(4000);
		 String headertext=driver.findElement(addheader).getText();
		 softAssertion.assertEquals(headertext, "Add","Header Matched");
//  MATCH HEADER TEXT
		 if(headertext.equalsIgnoreCase("Add"))
		 {
			 RunTest.logger.log(LogStatus.PASS, "Header text matched");
		 }
		 else{
			 RunTest.logger.log(LogStatus.FAIL, "Header text not matched");
		 }
//	MATCH SUB HEADER TEXT
		 String hdrrow2=driver.findElement(jobheader).getText();
		 softAssertion.assertEquals(hdrrow2, "Job");
		 if(hdrrow2.equalsIgnoreCase("Job"))
		 {
			 RunTest.logger.log(LogStatus.PASS, "Sub Header text matched");
		 }
		 else{
			 RunTest.logger.log(LogStatus.FAIL, "Sub Header text not matched");
		 }	 
//	VERIFY JOB DETAILS TAB
		 String jobdetailstab=driver.findElement(jobdetails).getText();
		 softAssertion.assertEquals(jobdetailstab, "Job Details","Job details tab text Matched");
		 if(jobdetailstab.equalsIgnoreCase("Job Details"))
		 {
			 RunTest.logger.log(LogStatus.PASS, "Job details tab text Matched");
		 }
		 else{
			 RunTest.logger.log(LogStatus.FAIL, "Job details tab text not Matched");
		 }
//	ADD DATE
		 driver.findElement(datetxtbox).sendKeys(date);
		 RunTest.logger.log(LogStatus.PASS, "Date entered");
//	ADD CLIENT NAME
		 driver.findElement(clientddarrow).click();
		 Thread.sleep(3000);
		 waitforelement(clientddlist);
		 List<WebElement> eleclient=driver.findElements(clientddlist);
		 int flag = 0;
		 for(WebElement client:eleclient)
		 {
			String clientnamedd= client.getText();
			if(clientnamedd.equals(clientname))
			{
				System.out.println(clientnamedd);
				client.click();
				flag=1;
				RunTest.logger.log(LogStatus.PASS, "Client name found and clicked successfully");
				break;
			}
		 }
		 if(flag==0)
		 {
			 RunTest.logger.log(LogStatus.FAIL, "Client name not found");
		 }
//	ADD CLIENT DEPARTMENT 
		 Thread.sleep(3000);
		 driver.findElement(clientdeptddarrow).click();
		List< WebElement> clientdeptele=driver.findElements(clientdeptddlist);
		for (WebElement clientdept:clientdeptele)
		{
//			String clientdeptname=clientdept.getText();
			if((clientdept.getText()).equals(clientdepartment))
			{
				System.out.println(clientdept.getText());
				clientdept.click();
				RunTest.logger.log(LogStatus.PASS, "'"+clientdepartment+"'"+" department found and clicked");
			}
			else{
				System.out.println(clientdepartment+" department not found in dropdownlist");
				RunTest.logger.log(LogStatus.FAIL, clientdepartment+" department not found in dropdownlist");
			}
		}
//	ADD SERVICE-DEPARTMENT FROM DROPDOWN
		 selectservice();
//	ADD JOB ID and JOB NAME
		 driver.findElement(jobidtxt).sendKeys(jobID);
		 driver.findElement(jobnametxt).sendKeys(jobname);
		 driver.findElement(specificationtxt).sendKeys(specifications);
		 waitforelement(quantitytxt);
		 driver.findElement(quantitytxt).sendKeys(quantity);
		 driver.findElement(unitpricetxt).sendKeys(unitprice);
		 driver.findElement(ordervaluetxt).sendKeys(ordervalue);
		 driver.findElement(deliverbydate).clear();
		 driver.findElement(deliverbydate).sendKeys(deliverby);
//	ADD DELIVERY TYPE
		 if(delivertype.equals("Pickup"))
		 {
			 driver.findElement(pickupchk).click();
		 }
		 else if (delivertype.equals("Delivery"))
		 {
			 driver.findElement(deliverchk).click();
		 }
//	ADD OVERS(TOLERANCE)
		 driver.findElement(overddaroww).click();
		 List<WebElement> oversele=driver.findElements(overddlist);
		 for(WebElement overs: oversele)
		 {
			 String overs1=overs.getText();
			 if(overs1.equals(overexcel))
			 {
				 overs.click();
			 }
		 }
		 driver.findElement(valuetxt).sendKeys(value);
		 Thread.sleep(2000);
		 driver.findElement(nextbtn).click();
		 attachments();
		 Thread.sleep(1000);
		 driver.findElement(closebtn).click();
	 }
	 

	 
//		*************ADD SERVICE-DEPARTMENT FROM DROPDOWN*******************
			 public void selectservice() throws InterruptedException
			 {
				 String d1;
//				 list of departments
				 driver.findElement(servicereqdddarrow).click();
				 Thread.sleep(1000);
				 driver.findElement(servicereqdddtxt).sendKeys(service);
				 Thread.sleep(2000);
				 RunTest.logger.log(LogStatus.INFO, "Service name entered");
				 String departmentdd= driver.findElement(By.xpath("//*[@id='ddlJISrvcReq-list']/div[2]")).getText();
					if(departmentdd.equals(serviceDepartment))
					{
						WebElement dept1=driver.findElement(By.xpath("//*[@id='ddlJISrvcReq_listbox']/li[1]/div"));
						dept1.click();
						System.out.println("Service "+service + " for "+serviceDepartment +"  department found and clicked");
						RunTest.logger.log(LogStatus.PASS, "Service '"+service + "' for '"+serviceDepartment +"'  department found and clicked");
					}
					else
					{
				 
				int deptcnt= driver.findElements(By.xpath("//*[@id='ddlJISrvcReq_listbox']/li/div[2]")).size();
				if(deptcnt>0)
				{
//			 SERVICE DEPARTMENT
				 for(int i=2;i<=deptcnt;i++)
				 {
						 WebElement dept=driver.findElement(By.xpath("//*[@id='ddlJISrvcReq_listbox']/li["+i+"]/div[2]"));
						  d1=dept.getText();
						 if(d1.equals(serviceDepartment))
						 {
							 WebElement serviceele=driver.findElement(By.xpath("//*[@id='ddlJISrvcReq_listbox']/li["+i+"]/div[1]"));
							 String servicename= serviceele.getText();
							 serviceele.click();
							 System.out.println("Service '"+ service + "' for '"+serviceDepartment +"'  department found and clicked");
							 RunTest.logger.log(LogStatus.PASS, "Service '"+ service + "' for '"+serviceDepartment +"'  department found and clicked");
						 }
					}
				}
				else if(deptcnt==0)
				{
					System.out.println("'"+serviceDepartment + "' department not found" );
					RunTest.logger.log(LogStatus.FAIL, "'"+serviceDepartment + "' department not found"); 
				}
				 }
					
				 
			 }
			 
//		*************VERIFY and ADD ATTACHMENTS************* 
			 public void attachments() throws InterruptedException, AWTException
			 {
//				 driver.findElement(attachment).click();
				 waitforelement(documenttype);
				 Boolean abc=driver.findElement(documenttype).isDisplayed();
//				 driver.findElement(attcheddocument).isDisplayed();
//		UPLOAD INVOICE
				 WebElement invoiceupload=driver.findElement(invoicefile);
				 Actions action=new Actions(driver);
				 action.moveToElement(invoiceupload).click().perform();
//				 driver.findElement(invoicefile).click();
				 gm.uploadrecords("000A+Blank");
				 Thread.sleep(2000);
				 try {
					 List<WebElement> invoicespecs=driver.findElements(By.xpath("//*[@id='specDownload_1253']/span[1]"));
					int specs= invoicespecs.size();
					 if(specs>0)
							 {
						 		RunTest.logger.log(LogStatus.PASS, "Invoice File Uploaded successfully");
						 		System.out.println("Invoice File Uploaded successfully");
							 }
				} catch (Exception e) {
					RunTest.logger.log(LogStatus.FAIL, "Invoice File not Uploaded");
					System.out.println("Invoice File not Uploaded");
				}
//		UPLOAD PURCHASE ORDER
				 Thread.sleep(3000);
				 WebElement POupload=driver.findElement(purchaseorderfile);
				 action.moveToElement(POupload).click().perform();
//				 driver.findElement(purchaseorderfile).click();
				 gm.uploadrecords("000A+Blank");
				 Thread.sleep(2000);
				 try {
						int specs= driver.findElements(By.xpath("//*[@id='specDownload_1254']/span[1]")).size();
						 if(specs>0)
								 {
							 		RunTest.logger.log(LogStatus.PASS, "Signed confirmation / Purchase order File Uploaded successfully");
							 		System.out.println("Sgned confirmation / Purchase order File Uploaded successfully");
								 }
					} catch (Exception e) {
						RunTest.logger.log(LogStatus.FAIL, "Signed confirmation / Purchase order File not Uploaded");
						System.out.println("Signed confirmation / Purchase order File not Uploaded ");
					}
			 }
			 

}
