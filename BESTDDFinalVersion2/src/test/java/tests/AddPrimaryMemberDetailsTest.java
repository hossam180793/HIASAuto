package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.ExcelLib;

import pages.AddPrimaryMemberDetails;
import pages.CustomerDetailsScreen;
import pages.CustomerMenu;
import pages.HiasLoginPage;
import pages.PrimaryMemberMenu;

public class AddPrimaryMemberDetailsTest {
	
	WebDriver browserObject ;
	HiasLoginPage HIASLOGIN;
	CustomerMenu CMenu ;
	CustomerDetailsScreen CustDetailsScreen ;
	PrimaryMemberMenu PMScreen ;
	AddPrimaryMemberDetails PMDPScreen ;
	
	@BeforeMethod
	  public void beforeClass() {
		  
		  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		 browserObject = new ChromeDriver();
		 browserObject .manage().window().maximize();			
		 HIASLOGIN = new HiasLoginPage(browserObject);
		 HIASLOGIN.NavigatetoURL();
		 
	  }
	
	
	  @Test(dataProvider = "AddPriamryMember",dataProviderClass = ExcelLib.class)
	  public void Addnewprimarymember(String username,String password, String CustomerNum,String Firstname,String Lastname,String emailaddress,String P_Address,String ZiPCode,String Agee , String Gender,String Maritalstatus, String SSN) throws InterruptedException{

		  HIASLOGIN = new HiasLoginPage(browserObject);
		  HIASLOGIN.Login(username , password);	  
			  
		  CMenu = new CustomerMenu(browserObject);
		  CMenu.navigatetoCustomerScreen();
		  CustDetailsScreen = new CustomerDetailsScreen(browserObject);
		  try {
				Thread.sleep(1000);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		  CustDetailsScreen.search(CustomerNum);
			try {
				Thread.sleep(1000);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
			PMDPScreen = new AddPrimaryMemberDetails(browserObject);
			PMDPScreen.Addnewprimarymember(Firstname, Lastname, emailaddress, P_Address, ZiPCode, Agee, Gender, Maritalstatus, SSN, Gender, Maritalstatus, SSN);
	  }
}
