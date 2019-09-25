package Generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Authenticator;

import org.eclipse.jetty.websocket.api.Session;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Test.RunTest;

import com.relevantcodes.extentreports.LogStatus;



public class GenericFunctions {
	
	static Xls_Reader xrj=new Xls_Reader(System.getProperty("user.dir")+"\\src\\TestData\\JobsTestData.xlsx");	
	static String binderyfilename=xrj.getCellData("JobFilePath", "Bindery FileName", 2);
	static String binderyfilepath=System.getProperty("user.dir")+"\\src\\TestData\\"+binderyfilename;
	static String jobfilename=xrj.getCellData("JobFilePath", "FileName", 2);
	static String jobfilepath=System.getProperty("user.dir")+"\\src\\TestData\\"+jobfilename;
	public static String date;
	public static String clientname;
	public static String clientdepartment;
	public static String serviceDepartment;
	public static String service;
	public static String jobID;
	public static String jobname;
	public static String specifications;
	public static String quantity;
	public static String unitprice;
	public static String ordervalue;
	public static String deliverby;
	public static String delivertype;
	public static String overexcel;
	public static String value;
	public static String clientcode;
	public static String jobStatus;
	public static String newstatus;
	 
public void Fn_DropDownValue(java.util.List<WebElement> vObjlist, String vVal) throws Throwable {
		
		boolean Found =false;
		
		try {

					for (WebElement vOption : vObjlist)
					{
				
						String vActVal = vOption.getText().trim();
						System.out.println(vActVal);
						if(vActVal.equals(vVal))
						{
							System.out.println(vVal);
							vOption.click();				
							Found =true;
							break;
						}
				
					}
			
		} catch (Exception e) {
//			Fn_screenshot(ds.driver,"Fn_DropDownValue");
			System.out.println(" dropdown Exception -FAIL");
		}
			
		
	}


//Read data from excel file
	public String ReadExcel(String filename,String sheetname,String Run,String column,int Startrange)
	{
		Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"\\src\\TestData\\"+filename);
		int rowcnt=xls.getRowCount(sheetname);
		String coldata = null;
		for(int i=Startrange; i<=rowcnt; i++)
		{
			String run=xls.getCellData(sheetname, Run, i);
			if(run.equalsIgnoreCase("ON"))
			{
				coldata=xls.getCellData(sheetname, column, i);				
				break;
			}			
		}
		return coldata;		
	}
	
//Write Data into excel file.
	public void writeintoexcel(String filename,String sheetname,String ColumnName,int range,String SetVal)
	{
	
		Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"\\src\\TestData\\"+filename+".xlsx");
		int rowcnt=xls.getRowCount(sheetname);
		System.out.println(ColumnName);
		System.out.println(rowcnt);		
		for(int i=range;i<=rowcnt;i++)
		{
			String run=xls.getCellData(sheetname, "Run", i);
			if(run.equalsIgnoreCase("ON"))
				{
					xls.setCellData(sheetname, ColumnName, i, SetVal);
				}
		}		
	}
	public void readinductjob()
	{
		ReadExcel(null, null, null, null, 0);
	}
	 public static String reverse(String str) {
	      if (str.length() <= 1) {
	         return str;
	      }
	      return reverse(str.substring(1)) + str.substring(0, 1);
	   }
	 
	 public String decimalremove(String number)
		{
			try {
				int num=number.indexOf(".");
				number=number.substring(0, num);
				return number;
			} catch (Exception e) {
				System.out.println("Number Format Issue");
			}
			return number;
		}
	 
	 
	 
	// UPLOAD RECORDS BY PROVIDING FILE PATH	
		 public void uploadrecords(String filename) throws InterruptedException, AWTException
		 {
			 Thread.sleep(3000);	
			 String jobfilepath=System.getProperty("user.dir")+"\\src\\TestData\\Bindery attachments\\"+filename;
			 
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
		 
//	READ EXCEL BINDERY
		 public void ReadExcelBINDERY()
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
						 quantity=decimalremove(xls.getCellData(sheetname, "Quantity", i));
						 unitprice=decimalremove(xls.getCellData(sheetname, "UnitPrice", i));
						 ordervalue=decimalremove(xls.getCellData(sheetname, "Ordervalue", i));
						 deliverby=xls.getCellData(sheetname, "Deliverby", i);
						 delivertype=xls.getCellData(sheetname, "Delivery type", i);
						 overexcel=xls.getCellData(sheetname, "Overs(tolerance)", i);
						 value=decimalremove(xls.getCellData(sheetname, "Value", i));
					}			
				}
			}
		 
		 public void ReadExcelInducted()
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
						
						
//				GET ROW DATA FROM EXCEL FILE	
						 date=xrji.getCellData(sheetname, "Date", i);
						 clientcode=xrji.getCellData("Sheet1", "Client", i);
//						 jobID=gm.decimalremove(xrji.getCellData("Sheet1", "Job ID", i));
						 jobname=xrji.getCellData(sheetname, "Job name", i);
						 specifications=xrji.getCellData(sheetname, "Specification", i);
						 quantity=decimalremove(xrji.getCellData("Sheet1", "Quantity", i));
						 ordervalue=decimalremove(xrji.getCellData("Sheet1", "Order value", i));
						 deliverby=xrji.getCellData("Sheet1", "Deliver by", i);
						 service=xrji.getCellData(sheetname, "Service", i);
						 serviceDepartment=xrji.getCellData("Sheet1", "Department", i);
						 jobStatus=xrji.getCellData("Sheet1", "Job status", i);

//			GET NEW STATUS from JOB TESTDATA excel file
						 newstatus =xrj.getCellData("JobFilePath", "NewStatus", 2);
						 break;
						
					}			
				}
			}
	 
//	 public void emailreport()
//	 {
//		//After complete execution send pdf report by email
//
//		  
//
//		        sendPDFReportByGMail("FROM@gmail.com", "password", "TO@gmail.com", "PDF Report", "");
//
//		        }

		    /**

		     * Send email using java

		     * @param from

		     * @param pass

		     * @param to

		     * @param subject

		     * @param body

		     */
	

	/*private static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {

		Properties props = System.getProperties();

		String host = "smtp.gmail.com";

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.host", host);

		props.put("mail.smtp.user", from);

		props.put("mail.smtp.password", pass);

		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.auth", "true");

		class PopupAuthenticator extends Authenticator {
	        public PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication("UserName", "Password");
	        }
	    }

		javax.mail.Session session = Session.getInstance(props);
		
		MimeMessage message = new MimeMessage(session);

		try {

		    //Set from address

		message.setFrom(new InternetAddress(from));

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		//Set subject

		message.setSubject(subject);

		message.setText(body);

		BodyPart objMessageBodyPart = new MimeBodyPart();

		objMessageBodyPart.setText("Please Find The Attached Report File!");

		Multipart multipart = new MimeMultipart();

		multipart.addBodyPart(objMessageBodyPart);

		objMessageBodyPart = new MimeBodyPart();

		//Set path to the pdf report file

		String filename = System.getProperty("user.dir")+"\\Default test.pdf";

		//Create data source to attach the file in mail

		DataSource source = new FileDataSource(filename);

		objMessageBodyPart.setDataHandler(new DataHandler(source));

		objMessageBodyPart.setFileName(filename);

		multipart.addBodyPart(objMessageBodyPart);

		message.setContent(multipart);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);

		transport.sendMessage(message, message.getAllRecipients());

		transport.close();

		}

		catch (AddressException ae) {

		ae.printStackTrace();

		}

		catch (MessagingException me) {

		me.printStackTrace();

		}

		}
 */
		
	 }
		
		
	

