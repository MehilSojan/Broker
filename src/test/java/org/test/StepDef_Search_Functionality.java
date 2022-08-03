package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.pageobject.Search_Functionality_pojo;
import org.testng.annotations.BeforeClass;
import org.utility.ExcelUtils;
import org.utility.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Search_Functionality extends TestBase{
	
	public String path = "C:\\Users\\yuva\\Desktop\\NoBroker\\target\\ExcelSheet\\NoBrokerdata.xlsx";
	public String sheetName = "data";
	
	@Given("User Should Launch Browser and Load Url")
	public void user_Should_Launch_Browser_and_Load_Url() throws IOException {
		lanuchChrome();
		maxWin();
		ExcelUtils r = new ExcelUtils();
		passURL(r.excelRead(path, sheetName, 0, 1));
	    
	}

	@When("User Should Click on the Buy Property Option")
	public void user_Should_Click_on_the_Buy_Property_Option() {
		Search_Functionality_pojo yu = new Search_Functionality_pojo();
		clickbtn(yu.getBuy_Property());
	   
	}

	@When("User Should Select Mumbai from DropDown Option")
	public void user_Should_Select_Mumbai_from_DropDown_Option() throws AWTException {
		Search_Functionality_pojo yu = new Search_Functionality_pojo();
		clickbtn(yu.getSelectCity());
		robotUp();
		robotENTERCall();
	   
		
	
			
		}
	@When("User Should Enter the Value as Malad in Search Box and select multiple Location from DropDown")
	public void user_Should_Enter_the_Value_as_Malad_in_Search_Box_and_select_multiple_Location_from_DropDown() throws AWTException, InterruptedException, IOException {
		Search_Functionality_pojo yu = new Search_Functionality_pojo();
		ExcelUtils r = new ExcelUtils();

		   sendKeyCall(yu.getSearchBox(), r.excelRead(path, sheetName, 1, 1));
		   Thread.sleep(3000);
		  for(int i =0;i<=2;i++) {
			  
			  robotDown();
			  
		  }
		  robotENTERCall();
		  Thread.sleep(3000);
		 
		  sendKeyCall(yu.getSearchBox(), "Malad");
		  Thread.sleep(6000);
		  for(int i =0;i<=3;i++) {
			 robotDown(); 
		  }
		  
		  Thread.sleep(2000);
		  robotENTERCall();
		  
		  takeScreenshotFullCall("Location");
		}
	


	


	@When("User Should Click on Search button")
	public void user_Should_Click_on_Search_button() {
		Search_Functionality_pojo yu = new Search_Functionality_pojo();
		clickbtn(yu.getSearchButton());
		
	    
	}

	@Then("User Should navigate to criteria page")
	public void user_Should_navigate_to_criteria_page() throws InterruptedException {
		
		String actual = getUrlcall();
		 
		Assert.assertTrue(actual.contains("sale"));
		
		
	   
	}

	@When("User Should Select Multiple BHK type from Filter")
	public void user_Should_Select_Multiple_BHK_type_from_Filter() throws InterruptedException, IOException {
		Search_Functionality_pojo yu = new Search_Functionality_pojo();
		siwtchIntoWindow();
	WebElement popUp = yu.getPopUp();
	
	FluentWait<WebDriver> wait = WaitFluentCall(65, 3, "Pop is Unhandle");
		wait.until(ExpectedConditions.visibilityOfAllElements(popUp));
		clickbtn(popUp);
		clickbtn(yu.getTwo_bhk());
		clickbtn(yu.getThree_bhk());
		
		takeScreenshotFullCall("BHK_Type");
		
	    
	}

	@When("User Should Scroll Down to listing of Property")
	public void user_Should_Scroll_Down_to_listing_of_Property() throws IOException {
		Search_Functionality_pojo yu = new Search_Functionality_pojo();
		WebElement forthproperty = yu.getForthproperty();
		FluentWait<WebDriver> wait = WaitFluentCall(40, 3, "Pop is Unhandle");
		wait.until(ExpectedConditions.visibilityOfAllElements(forthproperty));
		
		javaScriptExecutorScrollTopcall(forthproperty);
		
		takeScreenshotFullCall("forthproperty");
	   
	}

	@When("User Should Click on fourth Property")
	public void user_Should_Click_on_fourth_Property() throws InterruptedException {
		Search_Functionality_pojo yu = new Search_Functionality_pojo();
		Thread.sleep(3000);
		clickbtn(yu.getForthproperty());
	    
	}

	@Then("User Should navigate to fourth Property Details")
	public void user_Should_navigate_to_fourth_Property_Details() {
		String actual = getUrlcall();
		 
		Assert.assertTrue(actual.contains("property"));
	    
	}

	@When("User Should scroll down upto Description section")
	public void user_Should_scroll_down_upto_Description_section() throws AWTException, IOException {
		robotENTERCall();
		
		Search_Functionality_pojo yu = new Search_Functionality_pojo();
		siwtchIntoWindow();
		WebElement check = yu.getDescriptionCheck();
		javaScriptExecutorScrollTopcall(check);
		
		takeScreenshotFullCall("Description");
	}

	@When("User Should check for Description section")
	public void user_Should_check_for_Description_section() {
		Search_Functionality_pojo yu = new Search_Functionality_pojo();
		WebElement check = yu.getDescriptionCheck();
		check.isDisplayed();
		
		Assert.assertTrue(check.isDisplayed());
	}



}
