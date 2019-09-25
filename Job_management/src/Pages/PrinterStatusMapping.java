package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Generic.GenericFunctions;

public class PrinterStatusMapping extends SeleniumWebDrivers {
	
	GenericFunctions gm=new GenericFunctions();
	
	By Nextpageicon=By.xpath("//*[@id='dvStatusData']/div[3]/a[3]/span");
	By Paginginfo=By.xpath("//*[@id='dvStatusData']/div[3]/span[2]");
	String url="http://oca-mel-test:8300/Job%20Management/ProductionManagment/ManageStatus.aspx?i=3&pn=Printer%20Status%20Mapping&j=444&prn=Easy%20Print%20Manager";
	
	public void PrinterStatusMappingTile()
	{
		driver.get(url);
	}
	public String GetPrinterStatus(String jobStatus)
	{
		driver.get(url);
		String StatusName = null;
		 String PGsize=driver.findElement(Paginginfo).getText();
		 gm.reverse(PGsize);
		String TotalItems1 = ((gm.reverse(PGsize)).substring(6, (PGsize.length()))).substring(0, 2).trim();
		String TotalItems=gm.reverse(TotalItems1);
//		int abc=((Integer.parseInt(TotalItems)/5));
		 int totalpages=((int) Math.ceil((Integer.parseInt(TotalItems)/5))+1);
		 outer:
		for(int k=1;k<=totalpages;k++)
		{
			int flag=k;
			int rem=Integer.parseInt(TotalItems) % 5;
			int p=5;
			if(flag==(totalpages)){p=rem;}
			for(int i=1;i<=p;i++)
			{
				for(int j=2;j<=3;j++)
				{
					String status=driver.findElement(By.xpath("//*[@id='dvStatusData']/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
					if(status.equalsIgnoreCase(jobStatus))
					{
						
						 StatusName=driver.findElement(By.xpath("//*[@id='dvStatusData']/div[2]/table/tbody/tr["+i+"]/td[1]")).getText();
						 System.out.println(StatusName);
						 break outer;
					}
				}
				if(i==5)
				{
					driver.findElement(Nextpageicon).click();
				}
			}
		}
		return StatusName;
	}

}
