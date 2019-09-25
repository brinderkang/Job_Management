package Pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.Wait;

import Generic.GenericFunctions;
import Generic.Xls_Reader;
import Test.RunTest;

public class JobInducted extends SeleniumWebDrivers{
	By importicon=By.xpath("//i[contains(.,'IMPORT')]");
	By fieldname=By.xpath("//div[@id='dvFiledNames']/parent::div/h4");
	By excelMapHeader=By.xpath("//div[@id='dvExcelColumnsMap']/parent::div/h4");
	By datalinkbtn=By.xpath("//span[@class='icon_link x2']");
	By SaveClosebtn= By.xpath("//*[@id='btnSaveClose']");
	By CancelClosebtn = By.xpath("//*[@id='btnCancel']");
	By datalinkbtnView=By.xpath("//*[@id='dvJobLoadData']/div[2]/table/tbody/tr[1]/td[2]/div/div[1]/a/span");
	By PageNextClick=By.xpath("//*[@id='dvJobInductedData']/div[4]/a[3]/span");
	By PagingInfo=By.xpath("//span[@class='k-pager-info k-label']");
	By JobinductTile=By.xpath("//*[@id='mastHeader']");
	By JobInductGrid=By.xpath("//*[@id='dvJobInductedGrid']");
	By warningalertwin=By.xpath("//*[@id='dlgAlertWin']");
	By recordcount=By.xpath("//*[@id='hdrRcrdCnt']");
	
	 static Xls_Reader xrj=new Xls_Reader(System.getProperty("user.dir")+"\\src\\TestData\\JobsTestData.xlsx");
	 static String jobfilename=xrj.getCellData("JobFilePath", "FileName", 2);
	 static String jobfilepath=System.getProperty("user.dir")+"\\src\\TestData\\"+jobfilename;
	 static int result;
	 GenericFunctions gm=new GenericFunctions();
	 PrinterStatusMapping psm=new PrinterStatusMapping();
	 String path = null;
	 String url="http://oca-mel-test:8300/Job%20Management/JobsInducted/JobInducted.aspx?i=3&pn=Jobs%20Inducted&j=440&prn=Easy%20Print%20Manager";
	 public static int flag,flag1;
	 public static String totalrecordsadded,flashrecords;
	 SoftAssert softAssertion= new SoftAssert();
//	 static{
//		 
//		 Xls_Reader xrji=new Xls_Reader("C:\\Users\\brinderjeet.singh\\Desktop\\FRS\\Job Induct\\JobInductTemplate26.xlsx");
//		 int rowcntji=xrji.getRowCount("Sheet1");
//		 String clientnamelg = null;
//		 String ClientNameViewJobs = null;
//		 for (int i=2;i<=rowcntji;i++)
//		 {
//			 String ccji=xrji.getCellData("Sheet1", "Client", i);
//			 String clientcodeji[]=new String[rowcntji+1];
//			 clientcodeji[i]=ccji;
//			 System.out.println(clientcodeji[i]);
//			 
////			 Client code sheet
//			 Xls_Reader xrlg=new Xls_Reader("C:\\Users\\brinderjeet.singh\\Desktop\\FRS\\Job Induct\\Lgl_ClientsData_Cl_Code.xlsx");
//			 int rowcntlg=xrlg.getRowCount("KKS Printer");
//			 clientname:
//			 for (int j=2;j<=rowcntlg;j++)
//			 {
//				 String cclg=xrlg.getCellData("KKS Printer", "Client code", j);
//				 String clientcodelg[]=new String[rowcntlg];
//				 clientcodelg[j]=cclg;
//				 System.out.println(clientcodelg[j]);
//				 if( clientcodelg[j].equals(clientcodeji[i]))
//				 {
//					 clientnamelg=xrlg.getCellData("KKS Printer", "Client", j);
//					 System.out.println(clientnamelg);
//					 break clientname;
//				 }
//			 }
//			 List<WebElement> cmViewjobs=driver.findElements(By.xpath("//*[@id='dvJobInductedData']/div[3]/table/tbody/tr/td[2]/span[2]"));
//			 for (WebElement ObcmViewjobs:cmViewjobs)
//			 {
//				 ClientNameViewJobs=ObcmViewjobs.getText();
//			 }
//			 assertEquals(clientnamelg, ClientNameViewJobs,"String Matched");
//		 }
//		 
//		
//	 }
	 
// NAVIGATE TO JOB INDUCTION TILE 
	public void jobinducttile()
	{
		driver.get("http://oca-mel-test:8300/Job%20Management/JobsInducted/JobInducted.aspx?i=3&pn=Jobs%20Inducted&j=440&prn=Easy%20Print%20Manager");
		RunTest.logger.log(LogStatus.PASS,"Url entered");
		String jobinducttile=driver.findElement(JobinductTile).getText();
		Assert.assertEquals(jobinducttile, "Jobs Inducted", "Navigated to Jobs Inducted tile");
		if(jobinducttile.equalsIgnoreCase("Jobs Inducted"))
		{
			RunTest.logger.log(LogStatus.PASS,"Navigated to Jobs Inducted tile");
		}
	
	}
// UPLOAD RECORDS BY PROVIDING FILE PATH	
	 public void uploadrecords() throws InterruptedException, AWTException
	 {
		 Thread.sleep(3000);
		 WebDriverWait wait= new WebDriverWait(driver,60);
		 wait.until(ExpectedConditions.presenceOfElementLocated(importicon));
		 
		 WebElement eleImport=driver.findElement(importicon);
		 
		 Actions actions = new Actions(driver);
		 actions.moveToElement(eleImport).click().perform();
		 
//		 int rowcount=xrj.getRowCount("JobFilePath");
//			for(int i=1;i<=rowcount;i++)
//				{
//					String V3run=xrj.getCellData("V3", "Run",i);
//					if(V3run.equalsIgnoreCase("ON"))
//						{
//							 path=xrj.getCellData("JobFilePath", "Path", i);
//							 System.out.println(path);
//						}
//				}
//		 String jobfilename=xrj.getCellData("JobFilePath", "FileName", 2);
//		 jobfilepath=System.getProperty("user.dir")+"\\src\\TestData\\"+jobfilename;
		 
		// Specify the file location with extension
			StringSelection sel=new StringSelection(jobfilepath);
			
			//Copy to clipboard
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
			Thread.sleep(1000);
			Robot r=new Robot();
			//Press CTRL+V
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			
			//Release CTRL+V
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			
			//Press Enter
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			RunTest.logger.log(LogStatus.PASS, "File Uplaoded");
	 }
//	CLICK ON DATA LINK BUTTON TO NAVIGATE TO DATA MAPPING WINDOW 
	 public void datalinkbutton()
	 {
		 WebElement linkbtn=driver.findElement(datalinkbtn);
		 Actions actions=new Actions(driver);
		 actions.moveToElement(linkbtn).click().perform();
	 }
// 	VERIFY DATA MAPPING OF FIELD NAME AND EXCEL COLUMNS.
//	ALSO VERIFY VALIDATION ON SAVE BUTTON CLICK
//	VERIFY UPLOADED RECORDS 
	 public void datamapping()
	 {
//	GET and VERIFY Field Names		 
		 String fieldheader=driver.findElement(fieldname).getAttribute("innerHTML");
		 System.out.println(fieldheader);
		 Assert.assertEquals(fieldheader, "FIELD NAME");
		 RunTest.logger.log(LogStatus.PASS, "Column header is verified :-FIELD NAME");		 
		 int totalrows=driver.findElements(By.xpath("//*[@id='dvFiledNames']/div/span")).size();
		 for (int i=1;i<=totalrows;i++)
		 {
			 try {
				String mapFL=driver.findElement(By.xpath("//*[@id='dvFiledNames']/div["+i+"]/span")).getText();
				 String mapstrFL=mapFL.substring(10, mapFL.length());
				 System.out.println(mapstrFL);
				 String maptoFL=driver.findElement(By.xpath("//*[@id='dvFiledNames']/div["+i+"]/div")).getText();
				 System.out.println(maptoFL);
				 if(!mapstrFL.equalsIgnoreCase(maptoFL))
				 {
					 System.out.println("Fail");
					 RunTest.logger.log(LogStatus.FAIL, mapstrFL+" Column names not matched");
					 
				 }
				 else
				 {
					 RunTest.logger.log(LogStatus.PASS, mapstrFL+" Column names matched");
				 }
			} catch (Exception e) {
				String maptoFL=driver.findElement(By.xpath("//*[@id='dvFiledNames']/div["+i+"]/div")).getText();
				RunTest.logger.log(LogStatus.FAIL, maptoFL+" Column names not matched");
			}
		 }
//	VERIFY Excel column names
		 String ColHeader=driver.findElement(excelMapHeader).getAttribute("innerHTML");
		 System.out.println(ColHeader);
		 Assert.assertEquals(ColHeader, "SELECT EXCEL SHEEET COLUMN TO MAP");
		 RunTest.logger.log(LogStatus.PASS, "Column header is verified :-SELECT EXCEL SHEEET COLUMN TO MAP");
		 for(int j=1;j<=14;j++)
		 {
			 try {
				String map=driver.findElement(By.xpath("//*[@id='dvExcelColumnsMap']/div["+j+"]/span")).getText();
				 String mapstr=map.substring(10, map.length());
				 System.out.println(mapstr);
				 String mapto=driver.findElement(By.xpath("//*[@id='dvExcelColumnsMap']/div["+j+"]/div")).getText();
				 System.out.println(mapto);
				 if(!mapstr.equalsIgnoreCase(mapto))
				 {
					 System.out.println("Fail");
					 RunTest.logger.log(LogStatus.FAIL, mapstr+" Column names not matched");
				 }
				 else
				 {
					 RunTest.logger.log(LogStatus.PASS, mapstr+" Column names matched");
				 }
			} catch (Exception e) {
				String mapto=driver.findElement(By.xpath("//*[@id='dvExcelColumnsMap']/div["+j+"]/div")).getText();
				 RunTest.logger.log(LogStatus.FAIL, mapto+" Column names not matched");
			}
		 }
// CLICK AND VERIFY SAVE&CLOSE BUTTON		 
		 int SaveClose=driver.findElements(SaveClosebtn).size();
		 if(SaveClose>0)
		 {
			 System.out.println("Save & Close button present");
			 
			 RunTest.logger.log(LogStatus.PASS, "Save & Close button clicked");
		 }
		 else{
			 System.out.println("Save & Close button not present");
			 RunTest.logger.log(LogStatus.FAIL, "Save & Close button clicked");
		 }
// VERIFY CANCEL CLOSE BUTTON		 
		 int CancelClose=driver.findElements(CancelClosebtn).size();
		 if(CancelClose>0)
		 {
			 System.out.println("Cancel & Close button present");
			 RunTest.logger.log(LogStatus.PASS, "Cancel & Close button present");
		 }
		 else{
			 System.out.println("Cancel & Close button not present");
			 RunTest.logger.log(LogStatus.FAIL, "Cancel & Close button not present");
		 }

		 try {
//	CALL METHOD TO COMPARE EXCEL UPLOADED RECORDS AND ADDED RECORDS 
			 recordcompare();
			 if(result==1)
			 {
				 System.out.println("All "+flashrecords+" Records Added");
				 RunTest.logger.log(LogStatus.PASS, "All "+flashrecords+" Records Added");
			 }
			 else if(result==0)
			 {
				 
				 System.out.println("All Records not Added. Only "+flashrecords+" out of "+totalrecordsadded+" records added");
				 RunTest.logger.log(LogStatus.FAIL, "All Records not Added. Only "+flashrecords+" out of "+totalrecordsadded+" records added");
			 }

		} catch (Exception e) {
// VERIFY WARNING FOR "All columns not mapped"			
			int warningalert= driver.findElements(warningalertwin).size();
			 if(warningalert>=0)
			 {
				 
				 System.out.println("All columns are not mapped.");
				 RunTest.logger.log(LogStatus.FAIL, "All columns are not mapped."); 
			 }
			
			}
		 
	 	}
// COMPARE NUMBER of EXCEL UPLOADED RECORDS AND ADDED RECORDS DISPLAY IN FLASH MESSAGE INTO THE SYSTEM	 
	 public void recordcompare()
	 {
		 WebElement countheader=driver.findElement(recordcount);
		 String str= countheader.getText();
		String str1=str.substring((str.indexOf(","))+2);
		totalrecordsadded=str1.substring(0, str1.indexOf(" "));
//	Get record count from flash bar
		driver.findElement(SaveClosebtn).click();
		WebElement ELflr=driver.findElement(By.xpath("//*[@id='Form1']/div[5]/span[1]"));
		String flr=ELflr.getText();
		int in2=flr.indexOf(" ");
		flashrecords=flr.substring(0,in2);
//		Assert.assertEquals(totalrecordsadded, flashrecords);
		if(totalrecordsadded.equals(flashrecords))
		{
		result= 1;
		}
		else{
			 result= 0;
		}
	 }
	 
//	TO VERIFY DATA MAPPED SUCCESSFULLY 
	 public void MapingIcontoView() throws InterruptedException
	 {
		 WebDriverWait wait= new WebDriverWait(driver,60);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(datalinkbtnView));
		 wait.until(ExpectedConditions.presenceOfElementLocated(datalinkbtnView));
		 Thread.sleep(3000);
		String mapiconclass=driver.findElement(datalinkbtnView).getAttribute("class");
		if((Integer.parseInt(flashrecords)>0)&&(mapiconclass.equals("icon_view x2")))
		{
			System.out.println("Data mapped successfully");
			RunTest.logger.log(LogStatus.PASS, "Data mapped successfully");
			
		}
		else
		{
			System.out.println("Data not mapped successfully");
			RunTest.logger.log(LogStatus.FAIL, "Data not mapped successfully");
		}
	 }
//	CLICK VIEW JOBS BUTTON TO NAVIGATE VIEW JOBS SCREEN 
	 public void viewjobs() throws InterruptedException
	 {
		 WebElement viewbtn=driver.findElement(datalinkbtnView);
		 Actions actions=new Actions(driver);
		 actions.moveToElement(viewbtn).click().perform();
		 Thread.sleep(2000);
		 RunTest.logger.log(LogStatus.INFO, "View jobs button clicked");
		 int grid=driver.findElements(JobInductGrid).size();
		 if(grid>0)
		 {
			 RunTest.logger.log(LogStatus.PASS, "View jobs button clicked and focus moved to Job Induct Grid");
		 }
	 }
	 
	 public void viewjobsgrid() throws InterruptedException
	 {
		
		 System.out.println(path);
//	Job InductSheet starts
//		 String path=System.getProperty("user.dir")+"\\src\\TestData\\JobInductTemplate30.xlsx";
		 Xls_Reader xrji=new Xls_Reader(jobfilepath);
		 int rowcntji=xrji.getRowCount("Sheet1");
		 String clientnamelg = null;
//		 String ClientNameViewJobs = null;
		 for (int i=2;i<=rowcntji;i++)
		 { 
			 String ccji=xrji.getCellData("Sheet1", "Client", i);
			 String clientcodeji[]=new String[rowcntji+1];
			 clientcodeji[i]=ccji;
			 System.out.println(clientcodeji[i]);
			 String date=xrji.getCellData("Sheet1", "Date", i);
//			 DateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
//			 try {
//				Date abc=new SimpleDateFormat("dd/MM/yyyy").parse(date);
//				System.out.println(""+abc);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			 
//	GET ROW DATA FROM EXCEL FILE		 
			 String jobID=gm.decimalremove(xrji.getCellData("Sheet1", "Job ID", i));
			 String quantity=gm.decimalremove(xrji.getCellData("Sheet1", "Quantity", i));
			 String OrderValue=gm.decimalremove(xrji.getCellData("Sheet1", "Order value", i));
			 String DeliverBy=xrji.getCellData("Sheet1", "Deliver by", i);
			 String Department=xrji.getCellData("Sheet1", "Department", i);
			 String jobStatus=xrji.getCellData("Sheet1", "Job status", i);
			String Printerstatus= psm.GetPrinterStatus(jobStatus);
			Thread.sleep(3000);
			 driver.get(url);
			 Thread.sleep(4000);
			 viewjobs();
// OPEN AND GET CLIENT CODES FORM Client code sheet
			 Xls_Reader xrlg=new Xls_Reader("C:\\Users\\brinderjeet.singh\\Desktop\\FRS\\Job Induct\\Lgl_ClientsData_Cl_Code.xlsx");
			 int rowcntlg=xrlg.getRowCount("KKS Printer");
			 clientname:
			 for (int j=2;j<rowcntlg;j++)
			 {
				 String cclg=xrlg.getCellData("KKS Printer", "Client code", j);
				 String clientcodelg[]=new String[rowcntlg];
				 clientcodelg[j]=cclg;
//				 System.out.println(clientcodelg[j]);
				 if( clientcodelg[j].equals(clientcodeji[i]))
				 {
					 clientnamelg=xrlg.getCellData("KKS Printer", "Client", j);
					 System.out.println(clientnamelg);
					 
//	VIEW JOBS GRID STARTS
					 String PGsize=driver.findElement(PagingInfo).getText();
					 gm.reverse(PGsize);
//					 String sizeeee=(gm.reverse(PGsize)).substring(6, (PGsize.length()));
					 @SuppressWarnings("static-access")
					String TotalItems = ((gm.reverse(PGsize)).substring(6, (PGsize.length()))).substring(0, 2).trim();
					 int TotalPages=(int) Math.ceil((Integer.parseInt(TotalItems)/10));
					 for( int m=1;m<=TotalPages+1;m++)
					 {
						 int flag1=m;
							int rem=Integer.parseInt(TotalItems) % 10;
							int p=10;
							if(flag1==(TotalPages)){p=rem;}
						 nextpage:							 
						 for(int k=1;k<=p;k++)
						 {
							 
//	GET Client Name FROM GRID 													
							 String JobDetailsVJ=driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table/tbody/tr["+(k)+"]/td[3]/span[1]")).getText();
//							 WebElement cmViewjobs=driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table/tbody/tr["+(i-1)+"]/td[2]/span[2]"));
//							 ClientNameViewJobs=cmViewjobs.getText();
							 
							 if(jobID.equalsIgnoreCase(JobDetailsVJ))
								 {
								 System.out.println(jobID);
								 System.out.println(JobDetailsVJ);
								 System.out.println("Row i = "+(i-1));
								 System.out.println("Row k = "+(k));
								 softAssertion.assertEquals(jobID, JobDetailsVJ,"Job ID Matched");
									 
// GET Date,JobDetails,Quantity,OrderValue,Deliver By,Current Status FROM GRID
							 String ClientNameViewJobs=driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table/tbody/tr["+(k)+"]/td[2]/span[2]")).getText();
							 String dateVJ=driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table/tbody/tr["+(k)+"]/td[1]/span[2]")).getText();
//							 String JobDetailsVJ=driver.findElement(By.xpath(" //*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr["+(k)+"]/td[3]/span[1]")).getText();
							 String JobNameVJ=driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr["+(k)+"]/td[3]/span[2]")).getText();												
							 String QuantityVJ=driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table/tbody/tr["+(k)+"]/td[4]/span[2]")).getText();
							 String OrderValueVJ1=driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table/tbody/tr["+(k)+"]/td[5]/span[2]")).getText();
							 String OrderValueVJ2= OrderValueVJ1.substring(1);
							 String OrderValueVJ= gm.decimalremove(OrderValueVJ2.replace(",", ""));
							 String DeliverByVJ=driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table/tbody/tr["+(k)+"]/td[6]/span[2]")).getText();
							 String DepartmentVJ= driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table[1]/tbody[1]/tr["+(k)+"]/td[6]/span[1]")).getText();
							 String CurrentStatusVJ=driver.findElement(By.xpath("//*[@id='dvJobInductedData']/div[3]/table/tbody/tr["+(k)+"]/td[7]/span[2]")).getText();
							 
//							 System.out.println(dateVJ);
//							 System.out.println(JobDetailsVJ);
//							 System.out.println(QuantityVJ);
//							 System.out.println(OrderValueVJ);
//							 System.out.println(DeliverByVJ);
//							 System.out.println(CurrentStatusVJ);
							 
//							 Assert.assertTrue(date.equalsIgnoreCase(dateVJ),"Pass");
							 
//	SOFT ASSERSTION TO COMPARE DATE,JOBID,QUANTITY, ORDER VALUE, DELIVER BY, DEPARTMENT , CURRENT STATUS
							 try {
								 if(date.equals(dateVJ))
								 {
								 softAssertion.assertEquals(date, dateVJ,"Date Matched");
								 RunTest.logger.log(LogStatus.PASS, date+" Date Matched");
								 }
								 else
								 {
									 RunTest.logger.log(LogStatus.FAIL, date+" Date not Matched with grid date "+dateVJ);
								 }
							} catch (Exception e) {
								 RunTest.logger.log(LogStatus.FAIL, date+" Date not Matched with grid date "+dateVJ);
							}
							 
							 try {
								 if(jobID.equals(JobDetailsVJ))
								 {
								 softAssertion.assertEquals(jobID, JobDetailsVJ,"Job ID Matched");
								 RunTest.logger.log(LogStatus.PASS, jobID+" Job ID Matched");
								 }
								 else
								 {
									 RunTest.logger.log(LogStatus.FATAL, jobID+" jobID not Matched");
								 }
							} catch (Exception e) {
								RunTest.logger.log(LogStatus.FATAL, jobID+" Job ID not Matched");
							}
							 
							 try {
								 if(quantity.equals(QuantityVJ))
								 {
								 softAssertion.assertEquals(quantity, QuantityVJ,"Quantity Matched");
								 RunTest.logger.log(LogStatus.PASS, quantity+" Quantity Matched for jobID "+jobID);
								 }
								 else
								 {
									 RunTest.logger.log(LogStatus.FAIL, quantity+" quantity not Matched for jobID "+jobID);
								 }
							} catch (Exception e) {
								RunTest.logger.log(LogStatus.FAIL, quantity+" Quantity not Matched for jobID "+jobID);
							}
							 
							 try {
								 if(OrderValue.equals(OrderValueVJ))
								 {
								 softAssertion.assertEquals(OrderValue, OrderValueVJ,"String Matched");
								 RunTest.logger.log(LogStatus.PASS, OrderValue+" Order Value Matched for jobID "+jobID);
								 }
								 else
								 {
									 RunTest.logger.log(LogStatus.FAIL, OrderValue+" Order Value not Matched for jobID "+jobID);
								 }
							} catch (Exception e) {
								 RunTest.logger.log(LogStatus.FAIL, OrderValue+" Order Value not Matched for jobID "+jobID);
							}
							 
							 try {
								 if(DeliverBy.equals(DeliverByVJ))
								 {
									 softAssertion.assertEquals(DeliverBy, DeliverByVJ,"String Matched");
									 RunTest.logger.log(LogStatus.PASS, DeliverBy+" Deliver By Date Matched for jobID "+jobID);
								 }
								 else
								 {
									 RunTest.logger.log(LogStatus.FAIL, DeliverBy+" Deliver By Date not Matched with grid date "+DeliverByVJ+" for jobID "+jobID );
								 }
								 
							} catch (Exception e) {
								 RunTest.logger.log(LogStatus.FAIL, DeliverBy+" Deliver By Date not Matched with grid date "+DeliverByVJ+"for jobID "+jobID);
							}
							 try {
								 if(Department.equals(DepartmentVJ))
								 {
									 softAssertion.assertEquals(Department, DepartmentVJ,"String Matched");
									 RunTest.logger.log(LogStatus.PASS, Department+" Department Matched for jobID "+jobID);
								 }
								 else
								 {
									 RunTest.logger.log(LogStatus.FAIL, Department+" Department not Matched for jobID "+jobID);
								 }
								 
							} catch (Exception e) {
								RunTest.logger.log(LogStatus.FAIL, Department+" Department not Matched for jobID "+jobID);
							}
							 try {
								 if(Printerstatus.equals(CurrentStatusVJ))
								 {
								 softAssertion.assertEquals(Printerstatus, CurrentStatusVJ,"String Matched");
								 RunTest.logger.log(LogStatus.PASS, Printerstatus+" Status Matched for jobID "+jobID);
								 }
								 else
								 {
									 RunTest.logger.log(LogStatus.FAIL, Printerstatus+" Status not Matched for jobID "+jobID);
								 }
							} catch (Exception e) {
								 RunTest.logger.log(LogStatus.FAIL, Printerstatus+" Status not Matched for jobID "+jobID);
							}
							 
							 
							 
							 flag= flag+1;
							 RunTest.logger.log(LogStatus.PASS, "Row "+(i-1)+" Matched");
							 break clientname;
								 }
								 if(k==10)
								 	{
									 	driver.findElement(PageNextClick).click();
									 	System.out.println("NextButton Clickedd at "+k);
//									 	break nextpage;
									 }							
						 }
					 
					 }
					 
// VIEW JOB GRID ENDS
	
				 }
				 }
//			 if(i>=10)
//			 {
//				 int remji=(i%10);
//				 if (remji==0)
//				 {
//					 driver.findElement(PageNextClick).click();
//				 }
//			 }
//	CLIENT CODE SHEET ENDS
		 }
//	JOB INDUCT SHEET ENDS
		 softAssertion.assertAll();
	 }
	

}
