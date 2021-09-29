package com.SB3.goya.stepdefs;

import com.SB3.goya.GoyaBase;
import com.SB3.goya.GoyaConstants;
import com.SB3.goya.pageObject.DashBoardXpath;
import com.SB3.goya.pageObject.Xls_Reader;
import com.SB3.goya.pageObject.mainPage;
import com.SB3.goya.pageObject.removeSpaces;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.SB3.goya.pageObject.removeSpaces.removeSpaces;
import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;

public class LoginStepDefination extends GoyaBase {

	DashBoardXpath dashBoardXpath = new DashBoardXpath(driver);
	Xls_Reader reader = new Xls_Reader("src/test/resources/Data.xlsx.xlsx");
	mainPage mainPage_xpath = new mainPage(driver);
	String CustomerInvoiceMessage = new String();

	@Given("^I am on the Login page$")
	public void i_am_on_the_Login_page() throws Throwable  {
		driver.get(prop.getPropValues(GoyaConstants.URL));
		//waitHelper = new WaitHelper(driver);
		Thread.sleep(1000);
	}

	@When("^I should see Sign In Page$")
	public void i_should_see_Sign_In_Page() throws Throwable {
		String title = driver.getTitle();
		assertEquals("GOYA Food",title);
		System.out.println("GOYA Food: "+title);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);

	}
	@Then("^I enter username$")
	public void i_enter_username() throws Throwable {
		mainPage_xpath.enterValue(mainPage_xpath.username,prop.getPropValues(GoyaConstants.username));
		Thread.sleep(1000);

	}
	@Then("^I enter password$")
	public void i_enter_password() throws Throwable  {
		mainPage_xpath.enterValue(mainPage_xpath.password,prop.getPropValues(GoyaConstants.password));
		Thread.sleep(1000);

	}
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		mainPage_xpath.clickOn(mainPage_xpath.submitButton);
		Thread.sleep(2000);
	}
	@Then("^user is logged in$")
	public void user_is_logged_in() throws Throwable {
		String actualTitle = dashBoardXpath.CARLOS_MORATO.getText();
		assertEquals("013506-CARLOS MORATO" , actualTitle);
		System.out.println("013506-CARLOS MORATO: "+actualTitle);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}
	@Given("^user is home page$")
	public void user_is_home_page() throws Throwable {
		user_is_logged_in();
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
		assertEquals("Customers" , actualTitle);
		System.out.println("Customers: " + actualTitle);
		Thread.sleep(1000);

	}

	@Then("^given input search customer textbox$")
	public void given_input_search_customer_textbox() throws Throwable  {
		// Write code here that turns the phrase above into concrete actions
		String customer1 = reader.getCellData("goya","CustomerID",2);
		dashBoardXpath.enterValue(dashBoardXpath.Search_Customer,customer1);
		System.out.println("given input search customer textbox: "+customer1);
		Thread.sleep(1000);

	}

	@Then("^chose customer$")
	public void chose_customer() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.RadioButton);
		System.out.println("Radio Button Click: "+ "Press Radio Button");
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
		} else {
			System.out.println(CustomerInvoiceMessage + " Not Showing value ");
		}
		String invoiceNumber = DashBoardXpath.findStringUsingRegex(CustomerInvoiceMessage, DashBoardXpath.invoicePattern);
		String giNumber = DashBoardXpath.findStringUsingRegex(CustomerInvoiceMessage, DashBoardXpath.giPattern);
		System.out.println("Invoice number generated : " + invoiceNumber);
		System.out.println("GI number generated : " + giNumber);
		if (CustomerInvoiceMessage.contentEquals("712450-SHOP RITE 130")) {
			String Massage = reader.getCellData("goya", "Massage", 2);
			String expectedFinalMessage = Massage;
			Assert.assertEquals(expectedFinalMessage.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		}
		if (CustomerInvoiceMessage.contentEquals("712453-SHOP RITE 130 FROZEN")) {
			String Massage1 = reader.getCellData("goya", "Massage", 3);
			String expectedFinalMessage1 = Massage1;
			Assert.assertEquals(expectedFinalMessage1.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		}
		if (CustomerInvoiceMessage.contentEquals("712457-RUMBA CUBANA OF TONNELLE CORP")) {
			String Massage2 = reader.getCellData("goya", "Massage", 4);
			String expectedFinalMessage2 = Massage2;
			Assert.assertEquals(expectedFinalMessage2.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		}
		if (CustomerInvoiceMessage.contentEquals("712590-FENIX 1 AND 2 /DGH BAKERY CORP")) {
			String Massage3 = reader.getCellData("goya", "Massage", 5);
			String expectedFinalMessage3 = Massage3;
			Assert.assertEquals(expectedFinalMessage3.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		}
		if (CustomerInvoiceMessage.contentEquals("712957-WAL-MART #3795")) {
			String Massage4 = reader.getCellData("goya", "Massage", 6);
			String expectedFinalMessage4 = Massage4;
			Assert.assertEquals(expectedFinalMessage4.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		}
		if (CustomerInvoiceMessage.contentEquals("712958-WAL-MART 3795 FROZEN")) {
			String Massage5 = reader.getCellData("goya", "Massage", 7);
			String expectedFinalMessage5 = Massage5;
			Assert.assertEquals(expectedFinalMessage5.replace("invoiceNumber", invoiceNumber)
					.replace("giNumber", giNumber), CustomerInvoiceMessage);
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		}

	}


		@Then("^then process button click$")
	public void then_process_button_click() throws Throwable{
		// Write code here that turns the phrase above into concrete actions
		dashBoardXpath.clickOn(dashBoardXpath.process);
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(1000);
		System.out.println("process button click: "+ "press the button");
	}
	@Then("^you have enter home page verify$")
	public void you_have_enter_home_page_verify() throws Throwable  {
		// Write code here that turns the phrase above into concrete actions
		this.user_is_logged_in();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		Thread.sleep(500);
	}

	@Then("^header file change name verify$")
	public void header_file_change_name_verify() throws Throwable  {
		// Write code here that turns the phrase above into concrete actions

		String acctualFinalMessage = dashBoardXpath.HeaderTitle.getText();
		String expectFinalMessage = CustomerInvoiceMessage;
		char str[] = acctualFinalMessage.toCharArray();
		int i = removeSpaces(str);
		String value = (String) valueOf(str).subSequence(0, i);

		char str1[] = expectFinalMessage.toCharArray();
		int j = removeSpaces(str1);
		String value1 = (String) valueOf(str1).subSequence(0, j);

		assertEquals(value1,value);
		System.out.println("header file change name : "+acctualFinalMessage);
		Thread.sleep(500);

	}

	@When("I should Order tab click")
	public void i_should_order_tab_click()throws Exception {
		if(dashBoardXpath.Order.isDisplayed()){
			dashBoardXpath.Order.click();
			System.out.println("Order Button Click:  "+dashBoardXpath.Order.getText());
			Thread.sleep(500);
		}

	}

	@Then("Order Page verify")
	public void order_page_verify()throws Exception {
		String accual = dashBoardXpath.Search_Iteam.getText();
		String expect = "Search Item";
		assertEquals(expect,accual);
		System.out.println(expect + accual);
		Thread.sleep(500);

	}

	@Then("Customer dropdown select Customer")
	public void customer_dropdown_select_customer()throws Exception {
		//Select customer_DropDown = new Select(dashBoardXpath.Customer_Dropdown);
		dashBoardXpath.moveToElementAndCLikOn(dashBoardXpath.Customer_Dropdown);
		Thread.sleep(3000);
		dashBoardXpath.iterateWebElementListAndSelectValue(dashBoardXpath.Customer_Dropdown_Value,prop.getPropValues(GoyaConstants.dropdownValue));
		Thread.sleep(2000);
	}
	@Then("Search Item Button click")
	public void search_item_button_click()throws Exception {
		dashBoardXpath.clickOn(dashBoardXpath.Search_Iteam);
		Thread.sleep(2000);
	}

	@Then("Search Items value in the textBox")
	public void search_items_value_in_the_text_box()throws Exception {
		dashBoardXpath.enterValue(dashBoardXpath.Search_Iteam_textBox,prop.getPropValues(GoyaConstants.SearchItemsValue));
		Thread.sleep(500);
	}

	@Then("Click Add to Cart Button")
	public void click_add_to_cart_button()throws Exception {
		if(dashBoardXpath.Add_To_Cart.isDisplayed()){
		dashBoardXpath.clickOn(dashBoardXpath.Add_To_Cart);
		Thread.sleep(500);}
		else {
			driver.navigate().refresh();
			Thread.sleep(500);
			dashBoardXpath.Search_Iteam_textBox.clear();
			Thread.sleep(500);
			this.search_items_value_in_the_text_box();
		}
		if(dashBoardXpath.Add_To_Cart.isDisplayed()){
			dashBoardXpath.clickOn(dashBoardXpath.Add_To_Cart);
			Thread.sleep(500);}
		else {
			System.out.println("Not Found: "+ dashBoardXpath.Search_Iteam_textBox.getText());
		}
		}
	}