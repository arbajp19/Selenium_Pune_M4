package com.ShoppersStack.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddress_Page {
	
	public MyAddress_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressBtn;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiButton')])[2]")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "(//button[text()='Yes'])[1]")
	private WebElement yesBtn;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiButton')])[1]")
	private WebElement updateBtn;

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}

	public WebElement getAddAddressBtn() {
		return addAddressBtn;
	}
	

}
