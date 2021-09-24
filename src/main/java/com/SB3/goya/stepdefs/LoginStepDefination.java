package com.SB3.goya.stepdefs;

import com.SB3.goya.GoyaBase;
import com.SB3.goya.GoyaConstants;
import com.SB3.goya.pageObject.DashBoardXpath;
import com.SB3.goya.pageObject.mainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginStepDefination extends GoyaBase {

	DashBoardXpath dashBoardXpath = new DashBoardXpath(driver);
	mainPage mainPage_xpath = new mainPage(driver);

	@Given("^I am on the Login page$")
	public void i_am_on_the_Login_page() throws Throwable  {
		driver.get(prop.getPropValues(GoyaConstants.URL));
		//waitHelper = new WaitHelper(driver);
		Thread.sleep(3000);
	}

	@When("^I should see Sign In Page$")
	public void i_should_see_Sign_In_Page() throws Throwable {
		String title = driver.getTitle();
		assertEquals("GOYA Food",title);
		System.out.println("GOYA Food: "+title);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}
	@Then("^I enter username$")
	public void i_enter_username() throws Throwable {
		mainPage_xpath.enterValue(mainPage_xpath.username,prop.getPropValues(GoyaConstants.username));
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}
	@Then("^I enter password$")
	public void i_enter_password() throws Throwable  {
		mainPage_xpath.enterValue(mainPage_xpath.password,prop.getPropValues(GoyaConstants.password));
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		mainPage_xpath.clickOn(mainPage_xpath.submitButton);
		driver.manage().timeouts().implicitlyWait(320, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	@Then("^user is logged in$")
	public void user_is_logged_in() throws Throwable {
		String actualTitle = driver.getTitle();
		assertEquals("GOYA Food" , actualTitle);
		System.out.println("GOYA Food: "+actualTitle);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	@Given("^user is home page$")
	public void user_is_home_page() throws Throwable {
		user_is_logged_in();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}

	@When("^I should customers tab click$")
	public void i_should_customers_tab_click() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.Customers);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}

	@Then("^customers Page verify$")
	public void customers_Page_verify() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String actualTitle = dashBoardXpath.Customers_Page.getText();
		assertEquals("Customers" , actualTitle);
		System.out.println("Customers: " + actualTitle);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}

	@Then("^given input search customer textbox$")
	public void given_input_search_customer_textbox() throws Throwable  {
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.enterValue(dashBoardXpath.Search_Customer,prop.getPropValues(GoyaConstants.Search_customer));
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}

	@Then("^chose customer$")
	public void chose_customer() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.RadioButton);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}
	@Then("^select button click$")
	public void select_button_click() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.Select);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		String expectedFinalMessage = prop.getPropValues(GoyaConstants.Pop_Up_Massage);
		System.out.println("expectedFinalMessage: "+ expectedFinalMessage);
		Thread.sleep(3000);

//        wholeModuleXpath.checkElementVisibility(wholeModuleXpath.invoiceData,240);
//                if (wholeModuleXpath.invoiceData.isEnabled()){
//            finalInvoiceMessage =finalInvoiceMessage.concat(wholeModuleXpath.invoiceData.getText());
//        }
//        invoiceNumberDetails =wholeModuleXpath.findStringUsingRegex(finalInvoiceMessage,wholeModuleXpath.invoicePattern);
//        giNumber=wholeModuleXpath.findStringUsingRegex(finalInvoiceMessage,wholeModuleXpath.giPattern);
//
//        System.out.println("Invoice number generated : " + invoiceNumberDetails);
//        System.out.println("GI number generated : " + giNumber);
//        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
//        String expectedFinalMessage = prop.getPropValues(goyaConstants.Pop_Up_Massage);
//        System.out.println("expectedFinalMessage: "+ expectedFinalMessage);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

	}
	@Then("^then process button click$")
	public void then_process_button_click() throws Throwable{
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.process);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	@Then("^you have enter home page verify$")
	public void you_have_enter_home_page_verify() throws Throwable  {
		// Write code here that turns the phrase above into concrete actions
		user_is_logged_in();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}

	@Then("^header file change name verify$")
	public void header_file_change_name_verify() throws Throwable  {
		// Write code here that turns the phrase above into concrete actions
		String expectedFinalMessage = prop.getPropValues(GoyaConstants.Pop_Up_Massage);
		String acctualFinalMessage = dashBoardXpath.HeaderTitle.getText();
		assertEquals(expectedFinalMessage,acctualFinalMessage);
		Thread.sleep(3000);
	}

}