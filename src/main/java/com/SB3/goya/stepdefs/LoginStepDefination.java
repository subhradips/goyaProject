package com.SB3.goya.stepdefs;

import com.SB3.goya.GoyaBase;
import com.SB3.goya.GoyaConstants;
import com.SB3.goya.pageObject.DashBoardXpath;
import com.SB3.goya.pageObject.Screenshot_File;
import com.SB3.goya.pageObject.Xls_Reader;
import com.SB3.goya.pageObject.mainPage;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.SB3.goya.pageObject.removeSpaces.removeSpaces;
import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;

public class LoginStepDefination extends GoyaBase {

	DashBoardXpath dashBoardXpath = new DashBoardXpath(driver);
	Xls_Reader reader = new Xls_Reader("D:\\Automation\\goyaProject\\src\\test\\resources\\Data.xlsx");
	mainPage mainPage_xpath = new mainPage(driver);
	String CustomerInvoiceMessage = new String();

	@Given("^I am on the Login page$")
	public void i_am_on_the_Login_page() throws Throwable {
		driver.get(prop.getPropValues(GoyaConstants.URL));
		//waitHelper = new WaitHelper(driver);
		Thread.sleep(1000);
	}

	@When("^I should see Sign In Page$")
	public void i_should_see_Sign_In_Page() throws Throwable {
		String title = driver.getTitle();
		assertEquals("GOYA Food", title);
		System.out.println("GOYA Food: " + title);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);

	}

	@Then("^I enter username$")
	public void i_enter_username() throws Throwable {
		mainPage_xpath.enterValue(mainPage_xpath.username, prop.getPropValues(GoyaConstants.username));
		Thread.sleep(1000);

	}

	@Then("^I enter password$")
	public void i_enter_password() throws Throwable {
		mainPage_xpath.enterValue(mainPage_xpath.password, prop.getPropValues(GoyaConstants.password));
		Thread.sleep(1000);

	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		mainPage_xpath.clickOn(mainPage_xpath.submitButton);
		Thread.sleep(2000);
	}


	@Given("^user is home page$")
	public void user_is_home_page() throws Throwable {
		dashBoardXpath.equals(dashBoardXpath.Title);
	}

	@When("^I should customers tab click$")
	public void i_should_customers_tab_click() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.Customers);
		Thread.sleep(1000);
	}

	@Then("^customers Page verify$")
	public void customers_Page_verify() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String actualTitle = dashBoardXpath.Customers_Page.getText();
		assertEquals("Customers", actualTitle);
		System.out.println("Customers: " + actualTitle);
		Thread.sleep(1000);

	}

	@Then("^given input search customer textbox$")
	public void given_input_search_customer_textbox() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String customer1 = reader.getCellData("goya", "CustomerID", 2);
		dashBoardXpath.enterValue(dashBoardXpath.Search_Customer, customer1);
		System.out.println("given input search customer textbox: " + customer1);
		Thread.sleep(1000);

	}

	@Then("^chose customer$")
	public void chose_customer() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.RadioButton);
		System.out.println("Radio Button Click: " + "Press Radio Button");
		Thread.sleep(1000);


	}

	@Then("^select button click$")
	public void select_button_click() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.Select);
		System.out.println("Select Button Click: " + "Select Button Click");
		Thread.sleep(1000);

		dashBoardXpath.checkElementVisibility(dashBoardXpath.CustomerinvoicesuccessMessageElement, 90);
		if (dashBoardXpath.CustomerinvoicesuccessMessageElement.isDisplayed()) {
			CustomerInvoiceMessage = CustomerInvoiceMessage.concat(dashBoardXpath.CustomerinvoicesuccessMessageElement.getText());
			String acctualFinalMessage = CustomerInvoiceMessage;
			char str[] = acctualFinalMessage.toCharArray();
			int i = removeSpaces(str);
			String value = (String) valueOf(str).subSequence(0, i);

			char str1[] = acctualFinalMessage.toCharArray();
			int j = removeSpaces(str1);
			String value1 = (String) valueOf(str1).subSequence(0, j);

			assertEquals(value1, value);
			System.out.println("header file change name : " + acctualFinalMessage);
			Thread.sleep(500);

		} else {
			System.out.println(CustomerInvoiceMessage + " Not Showing value ");
		}
		String invoiceNumber = DashBoardXpath.findStringUsingRegex(CustomerInvoiceMessage, DashBoardXpath.invoicePattern);
		String giNumber = DashBoardXpath.findStringUsingRegex(CustomerInvoiceMessage, DashBoardXpath.giPattern);
		System.out.println("Invoice number generated : " + invoiceNumber);
		System.out.println("GI number generated : " + giNumber);

		if (CustomerInvoiceMessage.contentEquals("712450-SHOP RITE 130")) {
			String Message = reader.getCellData("goya","Massage",2);
			Assert.assertEquals(Message.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		}
		if (CustomerInvoiceMessage.contentEquals("712453-SHOP RITE 130 FROZEN")) {
			String Message1 = reader.getCellData("goya", "Massage", 3);
			Assert.assertEquals(Message1.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		}
		if (CustomerInvoiceMessage.contentEquals("712457-RUMBA CUBANA OF TONNELLE CORP")) {
			String Message2 = reader.getCellData("goya", "Massage", 4);
			Assert.assertEquals(Message2.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		}
		if (CustomerInvoiceMessage.contentEquals("712590-FENIX 1 AND 2 /DGH BAKERY CORP")) {
			String Message3 = reader.getCellData("goya", "Massage", 5);
			Assert.assertEquals(Message3.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		}
		if (CustomerInvoiceMessage.contentEquals("712957-WAL-MART #3795")) {
			String Message4 = reader.getCellData("goya", "Massage", 6);
			Assert.assertEquals(Message4.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		}
		if (CustomerInvoiceMessage.contentEquals("712958-WAL-MART 3795 FROZEN")) {
			String Message5 = reader.getCellData("goya", "Massage", 7);
			Assert.assertEquals(Message5.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		}

	}

	@Then("^then process button click$")
	public void then_process_button_click() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.process);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(1000);
		System.out.println("process button click: " + "press the button");
	}

	@Then("^you have enter home page verify$")
	public void you_have_enter_home_page_verify() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		this.user_is_home_page();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(500);
	}

	@Then("^header file change name verify$")
	public void header_file_change_name_verify() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		String acctualFinalMessage = dashBoardXpath.HeaderTitle.getText();
		String expectFinalMessage = CustomerInvoiceMessage;
		char str[] = acctualFinalMessage.toCharArray();
		int i = removeSpaces(str);
		String value = (String) valueOf(str).subSequence(0, i);

		char str1[] = expectFinalMessage.toCharArray();
		int j = removeSpaces(str1);
		String value1 = (String) valueOf(str1).subSequence(0, j);

		assertEquals(value1, value);
		System.out.println("header file change name : " + acctualFinalMessage);
		Thread.sleep(500);

	}

	@When("I should Order tab click")
	public void i_should_order_tab_click() throws Exception {
		if (dashBoardXpath.Order.isDisplayed()) {
			dashBoardXpath.Order.click();
			System.out.println("Order Button Click:  " + dashBoardXpath.Order.getText());
			Thread.sleep(500);
		}

	}

	@Then("Order Page verify")
	public void order_page_verify() throws Exception {
		String accual = dashBoardXpath.Search_Iteam.getText();
		String expect = "Search Item";
		assertEquals(expect, accual);
		System.out.println(expect + accual);
		Thread.sleep(500);

	}

	@Then("Customer dropdown select Customer")
	public void customer_dropdown_select_customer() throws Exception {
		//Select customer_DropDown = new Select(dashBoardXpath.Customer_Dropdown);
		dashBoardXpath.moveToElementAndCLikOn(dashBoardXpath.Customer_Dropdown);
		Thread.sleep(3000);
		dashBoardXpath.iterateWebElementListAndSelectValue(dashBoardXpath.Customer_Dropdown_Value, prop.getPropValues(GoyaConstants.dropdownValue));
		Thread.sleep(2000);
	}

	@Then("Search Item Button click")
	public void search_item_button_click() throws Exception {
		dashBoardXpath.clickOn(dashBoardXpath.Search_Iteam);
		Thread.sleep(2000);
	}

	@Then("Search Items value in the textBox")
	public void search_items_value_in_the_text_box() throws Exception {
		dashBoardXpath.enterValue(dashBoardXpath.Search_Iteam_textBox, prop.getPropValues(GoyaConstants.SearchItemsValue));
		Thread.sleep(2000);
	}

	@Then("Click Add to Cart Button")
	public void click_add_to_cart_button() throws Exception {
		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Add_To_Cart);
		Thread.sleep(5000);
	}

	@Then("Enter Quality amount")
	public void enter_quality_amount() throws Exception {
		dashBoardXpath.clickOn(dashBoardXpath.Add_Product);
		Thread.sleep(3000);
	}

	@Then("pop_up Add to Cart Button Click")
	public void pop_up_add_to_cart_button_click() throws Exception {
		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Pop_up_Add_To_Cart);
		Thread.sleep(4000);
	}

	@Then("Continue Button Click")
	public void continue_button_click() throws Exception {
		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Continue);
		Thread.sleep(3000);
	}

	@Then("Store EOR Data")
	public void store_eor_data() throws Exception {
		String s = ((JavascriptExecutor) driver).executeScript("return document.getElementById('eor').value").toString();
		System.out.println("EOR Invoice Number is: "+s);
		reader.setCellData("goya", "InvoiceNumber", 2, s);
		Thread.sleep(3000);
	}

	@Then("Submit button click")
	public void submit_button_click() throws Exception {
		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Submit);
		Thread.sleep(3000);

		dashBoardXpath.clickOn(dashBoardXpath.Continue_Merge);
		Thread.sleep(3000);

		WebElement popup1 = dashBoardXpath.Continue_Merge2;
		if(popup1.isDisplayed()){
			Thread.sleep(5000);
			String EOR = reader.getCellData("goya","InvoiceNumber",2);
			List<WebElement> dynamicElement = driver.findElements(By.xpath("//body/div[1]/div[4]/div[9]/div[2]/div[1]/div[2]"));
			if (dynamicElement.size()>0){
				System.out.println("Test: "+EOR+" is present ");
				dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.checkbox_click);
				popup1.click();
			}
			else {
				System.out.println("Test: "+EOR+" is not present ");
			}

		}

	}


	@When("I should Order Status tab click")
	public void i_should_order_status_tab_click()throws Exception {
		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.OrderStatus);
		Thread.sleep(3000);
	}
	@Then("Order status Page verify")
	public void order_status_page_verify() {
		WebElement Order_Status_Page_veryfy = dashBoardXpath.OrderStatus_page;
		Order_Status_Page_veryfy.getText();
		dashBoardXpath.checkElementVisibility(Order_Status_Page_veryfy,30);
		assertEquals("Order History",Order_Status_Page_veryfy);

	}
	@Then("Search EOR number")
	public void search_eor_number()throws Exception {
		dashBoardXpath.enterValue(dashBoardXpath.Oder_Status_EOR,reader.getCellData("goya","InvoiceNumber",2));
		Thread.sleep(5000);
	}
	@Then("Product Edit")
	public void product_edit()throws Exception {
		dashBoardXpath.clickOn(dashBoardXpath.Order_Status_edit);

	}
}