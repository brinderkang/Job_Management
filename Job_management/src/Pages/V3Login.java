package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Generic.Xls_Reader;
import Test.RunTest;

public class V3Login extends SeleniumWebDrivers {
	
	By bpologo=By.xpath("//img[@src='Login/images/logo.jpg']");
	By usernamelogin=By.xpath("//*[@id='txtLogin']");
	By userpassword=By.xpath("//*[@id='txtPassword']");
	By headertext=By.xpath("//*[text()='LOGIN TO ASCENT ONE']");
	By loginbutton=By.xpath("//a[contains(.,'Login')]");
	By logoutlink=By.xpath("//*[@id='topProfileSection']/div[1]/ul[1]/li[4]/a[1]/span[1]");
	By legalnameobj=By.xpath("//*[@id='hdrSection']/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]");
	
	 Xls_Reader xrs=new Xls_Reader(System.getProperty("user.dir")+"\\src\\TestData\\JobsTestData.xlsx");
	public static String legalname=null;
	
	public void clearusername()
	{
		driver.findElement(usernamelogin).clear();
	}
	public void clearpassword()
	{
		driver.findElement(userpassword).clear();
	}
//	set username
	public void setusername(String setusername)
	{
//		System.out.println("Setuser");
//		WebElement abc=driver.findElement(By.xpath("//input[@id='txtLogin']"));
//		abc.sendKeys(username);
		driver.findElement(usernamelogin).sendKeys(setusername);
		
	}
//	set password
	public void setpassword(String setpassword)
	{
//		driver.findElement(userpassword).clear();
		driver.findElement(userpassword).sendKeys(setpassword);
	}
//	click login button
	public void loginbutton()
	{
		driver.findElement(loginbutton).click();
	}
//	Get title
	public String gettitle()
	{
		return(driver.getTitle());
	}
	// Check logo exist
	public int imgbpologo(){
			
		int a= driver.findElements(bpologo).size();
		return a;
	}
	//verify Objects
	public String verifyHeaderText(){
			
		String Actual=driver.findElement(headertext).getText().trim();
		return Actual;
		}
	
	public void login(){
			try {
				int rowcount=xrs.getRowCount("V3");
				for(int i=1;i<=rowcount;i++)
					{
						String V3run=xrs.getCellData("V3", "Run",i);
						if(V3run.equalsIgnoreCase("ON"))
							{
								String strUserName = xrs.getCellData("V3", "PrinterLogin", i);
								String strPassword = xrs.getCellData("V3", "PrinterPwd", i);
								this.setusername(strUserName);
								RunTest.logger.log(LogStatus.PASS," Username Entered");
								this.setpassword(strPassword);
								RunTest.logger.log(LogStatus.PASS," Password Entered");
							}
					}

					this.loginbutton();
					RunTest.logger.log(LogStatus.PASS," Login button clicked");
					WebDriverWait wait=new WebDriverWait(driver,30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(logoutlink));
					wait.until(ExpectedConditions.presenceOfElementLocated(logoutlink));
					int a=driver.findElements(logoutlink).size();
					if(a>0)
					{
						RunTest.logger.log(LogStatus.PASS," Logged In Successfully");
					}
			} catch (Exception e) {
				driver.switchTo().alert().accept();
				System.out.println("Please Re Run your test.");
				RunTest.logger.log(LogStatus.FAIL,"Please Re Run your test.");
			}
				
	}
	 public void getlegalname()
	 {
		legalname= driver.findElement(legalnameobj).getText();
		System.out.println(legalname);
	 }
	

}
