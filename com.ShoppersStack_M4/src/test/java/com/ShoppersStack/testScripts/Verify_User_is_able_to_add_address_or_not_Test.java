package com.ShoppersStack.testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ShoppersStack.GenericUtility.BaseTest;
import com.ShoppersStack.Pom.AddressForm_Page;
import com.ShoppersStack.Pom.MyAddress_Page;
import com.ShoppersStack.Pom.MyProfile_Page;

public class Verify_User_is_able_to_add_address_or_not_Test extends BaseTest{
	
	@Test
	public void addAddress() throws EncryptedDocumentException, IOException {
		homePage.getAccountSettingsBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfile_Page myProfilePage=new MyProfile_Page(driver);
		myProfilePage.getMyAddressBtn().click();
		
		MyAddress_Page myAddressPage=new MyAddress_Page(driver);
		myAddressPage.getAddAddressBtn().click();
		
		AddressForm_Page addressFormPage=new AddressForm_Page(driver);
		addressFormPage.getOfficeRBtn().click();
		addressFormPage.getNameTF().sendKeys(file.readExcelData("Sheet1", 1, 0));
		addressFormPage.getHouseTF().sendKeys(file.readExcelData("Sheet1", 1, 1));
		addressFormPage.getStreetTF().sendKeys(file.readExcelData("Sheet1", 1, 2));
		addressFormPage.getLandmarkTF().sendKeys(file.readExcelData("Sheet1", 1, 3));
		webdriverUtil.selectByValue(addressFormPage.getCountryDD(), file.readPropertyData("country"));
		webdriverUtil.selectByValue(addressFormPage.getStateDD(), file.readPropertyData("state"));
		webdriverUtil.selectByValue(addressFormPage.getCityDD(), file.readPropertyData("city"));
		addressFormPage.getPincodeTF().sendKeys(file.readExcelData("Sheet1", 1, 4));
		addressFormPage.getPhonenumberTF().sendKeys(file.readExcelData("Sheet1", 1, 5));
		addressFormPage.getAddAddressBtn().click();
		
	}

}
