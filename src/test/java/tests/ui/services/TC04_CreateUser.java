package tests.ui.services;

import org.testng.annotations.Test;

import com.force.ui.utility.TempMailer;

import java.util.Arrays;

import org.testng.annotations.BeforeTest;

import page.base.HomePage;
import page.base.SalesforceHooks;
import page.services.UsersPage;

public class TC04_CreateUser extends SalesforceHooks{
	
	@BeforeTest
	public void setReportValues() {
		testcaseName = "TC04 - Create User";
		testDescription = "Create a new user in admin";
		authors = "Babu";
		category = "Service";
	}
	
	@Test
	public void editAccount() {
		
		new HomePage()
		.clickLeftMenu("Users")
		.clickLeftSubMenu("Users", "Users");
		
		new UsersPage()
		.clickNewUser()
		.verifyMandatoryFields(Arrays.asList("Last Name","Email", "Alias"))
		.typeFirstName()
		.typeLastName()
		.typeEmail()
		.chooseProfile()
		.clickSave();
		
		String registrationLink = TempMailer.getRegistrationLink(email.get());
		System.out.println(registrationLink);
	}

}
