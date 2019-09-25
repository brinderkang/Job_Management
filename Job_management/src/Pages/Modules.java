package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.GenericFunctions;
import Generic.Xls_Reader;

public class Modules extends SeleniumWebDrivers {
	
//MANAGE CLIENTS
	By searchicon=By.xpath("//*[@id='dvClients']/div[1]/h3[1]");
	By clientddarrowsrc=By.xpath("//*[@id='dvClients']/div[1]/div[1]/div[1]/span[1]/span[1]/span[2]/span[1]");
	By clientddlistsrc=By.xpath("//*[@id='ddlClientName_listbox']/li");
//CLIENT SALES
	By headertxt=By.xpath("//*[@id='mastHeader']");
	By SearchiconCS=By.xpath("//*[@id='dvClients']/div[1]/h3[1]");
	By clientnameddarrowCS=By.xpath("//*[@id='dvClients']/div[1]/div[1]/div[1]/span[1]/span[1]/span[2]/span[1]");
	By ClientnameddlistCS=By.xpath("//*[@id='ddlClientName_listbox']/li");
	By SearchbtnCS=By.xpath("//input[@id='btnSearch']");
//	By ConfigiconCS=By.xpath("//*[@id='dvClientData']/div[2]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[2]/span[1]");
	By ConfigiconCS=By.xpath("//span[@class='icon_setting x2 remove-bottom set-icon-ons']");
//	By accountmgrtabCS=By.xpath("//a[contains(.,'ACCOUNT MANAGER')]");
	By accountmgrtabCS=By.xpath("//*[@id='tabMainSteps']/div[2]/li[3]/a[1]");
//	By accountmgrname=By.xpath("//*[@id='dvCenterAccountMnager']/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/span[1]/following-sibling::br[1]");
	By accountmgrname=By.xpath("//*[@id='dvCenterAccountMnager']/div[2]/table/tbody/tr[1]/td[3]/div/div[2]");
	By accountmgrname1=By.xpath("//*[@id='dvCenterAccountMnager']/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/child::*");
//	By accountmgrname=By.xpath("//*[@id='dvCenterAccountMnager']/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/text()[preceding-sibling::node()[1][self::br] and following-sibling::node()[1][self::br]]");
	GenericFunctions gm=new GenericFunctions();
	
	
	static String manageclients="http://oca-mel-test:8300/ClientManagement/ManageClient.aspx?i=3&pn=Manage%20clients&j=151&prn=Easy%20Print%20Manager";
	static String clientsales="http://oca-mel-test:8300/ClientManagement/BusManageClient.aspx?i=3&pn=Client%20sales&j=211&prn=Easy%20Print%20Manager";
	
//	WAIT METHOD
		 public void waitforelement(By ele)
		 {
			 WebDriverWait wait= new WebDriverWait(driver,60);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			 wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		 }
// GET ACCOUNT MANAGER NAME from CLIENT SALES MODULE
		public String clientaccountmgr(String cltname,String jobtype) throws InterruptedException
		{
			Actions action=new Actions(driver);
			int flag=0;
			if(jobtype=="Bindery")
			{
				gm.ReadExcelBINDERY();
			}
			else if(jobtype=="Inducted")
			{
				gm.ReadExcelInducted();
			}
			Thread.sleep(3000);
			driver.get(clientsales);
			Thread.sleep(4000);
			waitforelement(SearchiconCS);
			driver.findElement(SearchiconCS).click();
			driver.findElement(clientnameddarrowCS).click();
			List <WebElement> clientnameele=driver.findElements(ClientnameddlistCS);
			for(WebElement clientnameM:clientnameele)
			{
				if((clientnameM.getText()).equals(cltname))
				{
					
					clientnameM.click();
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("Client not found");
			}
			driver.findElement(SearchbtnCS).click();
			Thread.sleep(4000);
			waitforelement(ConfigiconCS);
//			driver.findElement(ConfigiconCS).click();
			WebElement conficon=driver.findElement(ConfigiconCS);
			action.moveToElement(conficon).click().perform();
			Thread.sleep(4000);
			waitforelement(accountmgrtabCS);
			WebElement accmgrtab=driver.findElement(accountmgrtabCS);
			action.moveToElement(accmgrtab).click().perform();
// ACCOUNT MANAGER NAME and EMAIL and POSITION
			String accmgr=driver.findElement(accountmgrname).getAttribute("innerText");
// FETCH ACCOUNT MANAGER'S NAME
			int index1=accmgr.indexOf("\n");
			int index=accmgr.indexOf("\n",(index1+1));
			String accountmanager= accmgr.substring((index1+1), index);
			System.out.println(accountmanager);
			return accountmanager;
			
		}

}
