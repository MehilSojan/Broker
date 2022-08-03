package org.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.TestBase;

public class Search_Functionality_pojo extends TestBase{
	
	
	public Search_Functionality_pojo() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[text()='Buy']")
	private WebElement buy_Property;
	
	@FindBy(xpath = "//div[contains(@class,'css-v2nw5i-control nb-select__control')]")
	private WebElement SelectCity;
	
	@FindBy(id = "listPageSearchLocality")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[contains(@class,'prop-search-button btn btn-primary btn-lg')]")
	private WebElement searchButton;
	
	@FindBy(css = "div.leave-intent-close-icon")
	private WebElement PopUp;
	
	@FindBy(xpath = "//div[text()='2 BHK']")
	private WebElement two_bhk;
	
	@FindBy(xpath = "//div[text()='3 BHK']")
	private WebElement three_bhk;
	
	
	@FindBy(xpath = "(//div[@class='nb__7nqQI'])[4]")
	private WebElement forthproperty;

	@FindBy(id = "description")
	private WebElement descriptionCheck;
	
	public WebElement getBuy_Property() {
		return buy_Property;
	}


	public WebElement getSelectCity() {
		return SelectCity;
	}


	public WebElement getSearchBox() {
		return searchBox;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}
	


	public WebElement getPopUp() {
		return PopUp;
	}


	public WebElement getTwo_bhk() {
		return two_bhk;
	}


	public WebElement getThree_bhk() {
		return three_bhk;
	}


	public WebElement getForthproperty() {
		return forthproperty;
	}


	public WebElement getDescriptionCheck() {
		return descriptionCheck;
	}
	
	
	
	
	
	
	

	
	

}
