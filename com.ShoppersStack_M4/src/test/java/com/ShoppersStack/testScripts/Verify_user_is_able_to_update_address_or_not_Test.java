package com.ShoppersStack.testScripts;

import org.testng.annotations.Test;

import com.ShoppersStack.GenericUtility.BaseTest;
import com.ShoppersStack.Pom.EditAddress_Page;
import com.ShoppersStack.Pom.MyAddress_Page;
import com.ShoppersStack.Pom.MyProfile_Page;

public class Verify_user_is_able_to_update_address_or_not_Test extends BaseTest {

	@Test
	public void updateAddress() throws InterruptedException {
		homePage.getAccountSettingsBtn().click();
		homePage.getMyProfileBtn().click();

		MyProfile_Page myProfilePage = new MyProfile_Page(driver);
		myProfilePage.getMyAddressBtn().click();

		MyAddress_Page myAddressPage = new MyAddress_Page(driver);
		myAddressPage.getUpdateBtn().click();

		EditAddress_Page editAddressPage = new EditAddress_Page(driver);
		Thread.sleep(1000);
		editAddressPage.getNameTF().clear();
		Thread.sleep(1000);
		editAddressPage.getCountryDD().click();
		Thread.sleep(1000);
		editAddressPage.getCanadaBtn().click();
		Thread.sleep(1000);
		editAddressPage.getStateDD().click();
		Thread.sleep(1000);
		editAddressPage.getAlbertaBtn().click();
		Thread.sleep(1000);
		editAddressPage.getCityDD().click();
		Thread.sleep(1000);
		editAddressPage.getBrooksBtn().click();
		Thread.sleep(1000);
		editAddressPage.getNameTF().click();
		editAddressPage.getNameTF().sendKeys("Jspiders");
		Thread.sleep(1000);

		editAddressPage.getUpdateAddressBtn().click();

	}

}
