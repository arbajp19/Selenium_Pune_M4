package com.ShoppersStack.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAddress_Page {
	
	public EditAddress_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Update Address")
	private WebElement updateAddressBtn;
	
	@FindBy(xpath =  "//label[text()='Country']/../div")
	private WebElement countryDD;
	
	@FindBy(xpath = "//li[text()='Canada']")
	private WebElement canadaBtn;
	
	@FindBy(xpath =  "//label[text()='State']/../div")
	private WebElement stateDD;
	
	@FindBy(xpath = "//li[text()='Alberta']")
	private WebElement albertaBtn;
	
	@FindBy(xpath =  "//label[text()='City']/../div")
	private WebElement cityDD;
	
	@FindBy(xpath = "//li[text()='Brooks']")
	private WebElement brooksBtn;
	
	@FindBy(id = "Name")
	private WebElement nameTF;

	public WebElement getNameTF() {
		return nameTF;
	}

	public WebElement getUpdateAddressBtn() {
		return updateAddressBtn;
	}

	public WebElement getCountryDD() {
		return countryDD;
	}

	public WebElement getCanadaBtn() {
		return canadaBtn;
	}

	public WebElement getStateDD() {
		return stateDD;
	}

	public WebElement getAlbertaBtn() {
		return albertaBtn;
	}

	public WebElement getCityDD() {
		return cityDD;
	}

	public WebElement getBrooksBtn() {
		return brooksBtn;
	}
	
	
	
}
