package com.ShoppersStack.testScripts;

import org.testng.annotations.Test;

import com.ShoppersStack.GenericUtility.BaseTest;
import com.ShoppersStack.Pom.MyAddress_Page;
import com.ShoppersStack.Pom.MyProfile_Page;

public class Verify_User_is_able_to_delete_address_or_not_Test extends BaseTest{
	
	@Test
	public void deleteAddress() throws InterruptedException {
		homePage.getAccountSettingsBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfile_Page myProfilePage=new MyProfile_Page(driver);
		myProfilePage.getMyAddressBtn().click();
		
		MyAddress_Page myAddressPage=new MyAddress_Page(driver);
		Thread.sleep(2000);
		myAddressPage.getDeleteBtn().click();
		Thread.sleep(2000);
		myAddressPage.getYesBtn().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
	}

}
