package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.HiasMenuLocators;

public class PrimaryMemberMenu extends HiasMenuLocators {
	

	public PrimaryMemberMenu (WebDriver browserObject){
		this.browserObject= browserObject;
	}
	

	public void Nav_PrimaryMemberDetailsScreen() {
		
		browserObject.findElement(PrimaryMembers_HyberLink).click();
		WebDriverWait wait = new WebDriverWait(browserObject,30);
		wait.until(ExpectedConditions.titleContains("Primary"));
	}
	
	public void navigatetoPrimaryMemberDetailsScreen_Menu() {
		
		 Actions Action = new Actions(browserObject);
		WebElement element = (new WebDriverWait(browserObject, 50))
				   .until(ExpectedConditions.elementToBeClickable(By.linkText("Policies")));
		Action.moveToElement(element).build().perform();
		
		
		WebElement element1 = browserObject.findElement(PolicyManagement);
		browserObject.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		Action.moveToElement(element1).build().perform();
		
		
		 WebElement element2 = browserObject.findElement(PrimaryMembers_Menu);
		 browserObject.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		 element2.click();
	}
	
	
}
