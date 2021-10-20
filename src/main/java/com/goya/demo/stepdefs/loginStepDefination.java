//package com.goya.demo.stepdefs;
//
//import com.goya.demo.goyaBase;
//import com.goya.demo.goyaConstants;
//import com.goya.demo.pageObject.dashBoardXpath;
//import com.goya.demo.pageObject.xls_Reader;
//import com.goya.demo.pageObject.driverStorage;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.*;
//
//import java.util.List;
//
//import java.util.concurrent.TimeUnit;
//
//import static com.goya.demo.pageObject.removerSpace.removeSpaces;
//import static java.lang.String.valueOf;
//import static org.junit.Assert.assertEquals;
//
//public class loginStepDefination extends goyaBase {
//
//	com.goya.demo.pageObject.dashBoardXpath dashBoardXpath = new dashBoardXpath(driver);
//	xls_Reader reader = new xls_Reader("D:\\goyaProject\\src\\test\\resources\\Data.xlsx");
//	driverStorage driverStorage_xpath = new driverStorage(driver);
//	String CustomerInvoiceMessage = new String();
//
//
//	@Given("I am on the Login page")
//	public void i_am_on_the_login_page()throws Exception{
//		driver.get(prop.getPropValues(goyaConstants.URL));
//		//waitHelper = new WaitHelper(driver);
//		Thread.sleep(1000);
//	}
//
//	@When("I should see Sign In Page")
//	public void i_should_see_sign_in_page()throws Exception {
//		String title = driver.getTitle();
//		assertEquals("GOYA Food", title);
//		System.out.println("GOYA Food: " + title);
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		Thread.sleep(1000);
//
//	}
//
//	@Then("I enter username")
//	public void i_enter_username()throws Exception {
//		driverStorage_xpath.enterValue(driverStorage_xpath.username, prop.getPropValues(goyaConstants.username));
//		Thread.sleep(1000);
//
//	}
//
//	@Then("I enter password")
//	public void i_enter_password()throws Exception {
//		driverStorage_xpath.enterValue(driverStorage_xpath.password, prop.getPropValues(goyaConstants.password));
//		Thread.sleep(1000);
//
//	}
//
//	@Then("user clicks on login button")
//	public void user_clicks_on_login_button()throws Exception {
//		driverStorage_xpath.clickOn(driverStorage_xpath.submitButton);
//		Thread.sleep(2000);
//	}
//
//
//	@Given("user is home page")
//	public void user_is_home_page()throws Exception {
//		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.HomePage_Tab);
//		Thread.sleep(4000);
//		dashBoardXpath.equals(dashBoardXpath.Title);
//		Thread.sleep(3000);
//	}
//
//	@When("click on Order tab")
//	public void click_on_order_tab()throws Exception {
//		// Write code here that turns the phrase above into concrete actions
//		dashBoardXpath.clickOn(dashBoardXpath.Customers);
//		Thread.sleep(1000);
//	}
//	@Then("order Page verify")
//	public void order_page_verify()throws Exception{
//		// Write code here that turns the phrase above into concrete actions
//		String actualTitle = dashBoardXpath.Customers_Page.getText();
//		assertEquals("Customers", actualTitle);
//		System.out.println("Customers: " + actualTitle);
//		Thread.sleep(1000);
//
//	}
//
//	@Then("given input search customer textbox")
//	public void given_input_search_customer_textbox() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		String customer1 = reader.getCellData("goya", "CustomerID", 2);
//		dashBoardXpath.enterValue(dashBoardXpath.Search_Customer, customer1);
//		System.out.println("given input search customer textbox: " + customer1);
//		Thread.sleep(1000);
//
//	}
//
//	@Then("choose customer")
//	public void choose_customer() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		dashBoardXpath.clickOn(dashBoardXpath.RadioButton);
//		System.out.println("Radio Button Click: " + "Press Radio Button");
//		Thread.sleep(1000);
//	}
//
//	@Then("click on select button")
//	public void click_on_select_button()throws Throwable {
//		dashBoardXpath.clickOn(dashBoardXpath.Select);
//		System.out.println("Select Button Click: " + "Select Button Click");
//		Thread.sleep(4000);
//
//	}
//
//	@Then("click on process button")
//	public void click_on_process_button() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//
//		WebElement Pop_up_message = dashBoardXpath.Pop_upmessage;
//		if (Pop_up_message.isDisplayed()) {
//			String s = Pop_up_message.getText();
//			System.out.println(" Customer Value Save is: "+s);
//			Thread.sleep(4000);
//			System.out.println("******* Value Save in Excel: ************ "+reader.setCellData("goya", "CustomerSelectValue", 2, s));
//			Thread.sleep(4000);
//
//		} else {
//			System.out.println(" Not Showing value "+Pop_up_message.getText());
//		}
//		dashBoardXpath.clickOn(dashBoardXpath.process);
//		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
//		Thread.sleep(1000);
//		System.out.println("process button click: " + "press the button");
//	}
//
//	@Then("you have enter home page verify")
//	public void you_have_enter_home_page_verify()throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		this.user_is_home_page();
//		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
//		Thread.sleep(500);
//	}
//
//	@Then("header file change name verify")
//	public void header_file_change_name_verify() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//
//		String acctualFinalMessage = dashBoardXpath.HeaderTitle.getText();
//		String expectFinalMessage = reader.getCellData("goya","CustomerSelectValue",2);
//		char str[] = acctualFinalMessage.toCharArray();
//		int i = removeSpaces(str);
//		String value = (String) valueOf(str).subSequence(0, i);
//
//		char str1[] = expectFinalMessage.toCharArray();
//		int j = removeSpaces(str1);
//		String value1 = (String) valueOf(str1).subSequence(0, j);
//
//		assertEquals(value1, value);
//		System.out.println("********* Header file change name ************ : " + acctualFinalMessage);
//		Thread.sleep(500);
//
//	}
//
//	@When("click on Order tab")
//	public void click_on_Order_tab() throws Exception {
//		if (dashBoardXpath.Order.isDisplayed()) {
//			dashBoardXpath.Order.click();
//			System.out.println("Order Button Click:  " + dashBoardXpath.Order.getText());
//			Thread.sleep(500);
//		}
//
//	}
//
//	@Then("order Page verify")
//	public void order_Page_verify() throws Exception {
//		String accual = dashBoardXpath.Search_Iteam.getText();
//		String expect = "Search Item";
//		assertEquals(expect, accual);
//		System.out.println(expect + accual);
//		Thread.sleep(500);
//
//	}
//
//	@Then("customer dropdown select Customer")
//	public void customer_dropdown_select_customer()  throws Exception {
//		//Select customer_DropDown = new Select(dashBoardXpath.Customer_Dropdown);
//		dashBoardXpath.moveToElementAndCLikOn(dashBoardXpath.Customer_Dropdown);
//		Thread.sleep(4000);
//		dashBoardXpath.iterateWebElementListAndSelectValue(dashBoardXpath.Customer_Dropdown_Value, prop.getPropValues(goyaConstants.dropdownValue));
//		Thread.sleep(7000);
//	}
//
//	@Then("click on Search Item Button")
//	public void click_on_search_item_button() throws Exception {
//		dashBoardXpath.clickOn(dashBoardXpath.Search_Iteam);
//		Thread.sleep(5000);
//	}
//
//	@Then("search Items value in the textBox")
//	public void search_items_value_in_the_text_box()throws Exception {
//		dashBoardXpath.Search_Iteam_textBox.clear();
//		Thread.sleep(5000);
//		dashBoardXpath.enterValue(dashBoardXpath.Search_Iteam_textBox, prop.getPropValues(goyaConstants.SearchItemsValue));
//		Thread.sleep(5000);
//	}
//
//	@Then("click on Add to Cart Button")
//	public void click_on_add_to_cart_button() throws Exception {
//		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Add_To_Cart);
//		Thread.sleep(5000);
//	}
//
//	@Then("enter Quantity")
//	public void enter_quantity() throws Exception {
//		dashBoardXpath.clickOn(dashBoardXpath.Add_Product);
//		Thread.sleep(5000);
//	}
//
//	@Then("click on pop_up Add to Cart Button")
//	public void click_on_pop_up_add_to_cart_button() throws Exception {
//		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Pop_up_Add_To_Cart);
//		Thread.sleep(5000);
//	}
//
//	@Then("click on continue Button")
//	public void click_on_continue_button() throws Exception {
//		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Continue);
//		Thread.sleep(5000);
//	}
//
//	@Then("store EOR Data")
//	public void store_eor_data()throws Exception {
//		String s = ((JavascriptExecutor) driver).executeScript("return document.getElementById('eor').value").toString();
//		System.out.println("EOR Invoice Number is: "+s);
//		reader.setCellData("goya", "InvoiceNumber", 2, s);
//		Thread.sleep(5000);
//	}
//
//	@Then("click on Submit button")
//	public void click_on_submit_button() throws Exception {
//		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Submit);
//		Thread.sleep(3000);
//		WebElement popup1 = dashBoardXpath.Continue_Merge2;
//		WebElement Submit1 = dashBoardXpath.Submit1;
//		if(Submit1.isDisplayed()){
//			dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Submit1);
//			System.out.println("******** Click Submit button: ***********"+Submit1.isDisplayed());
//			Thread.sleep(2000);
//			Alert abc = driver.switchTo().alert();
//			System.out.println("********Alert massage read:*******"+abc.getText());
//			reader.setCellData("goya","Successful Order place Message",2,abc.getText());
//			abc.dismiss();
//			Thread.sleep(2000);
//
//		}
//		else {
//			dashBoardXpath.clickOn(dashBoardXpath.Continue_Merge);
//			String EOR = reader.getCellData("goya", "InvoiceNumber", 2);
//			List<WebElement> dynamicElement = driver.findElements(By.xpath("//body/div[1]/div[4]/div[9]/div[2]/div[1]/div[2]"));
//			if (dynamicElement.size() > 0) {
//				System.out.println("Test:=------========== " + EOR + "-----------========= is present ");
//
//				for (int iLoop = 0; iLoop < dynamicElement.size(); iLoop++) {
//					System.out.println("Column " + iLoop + " : '" + dynamicElement.get(iLoop).getText().toString() + "'");
//
//					WebElement MergeOrder = dashBoardXpath.Marge_order;
//					if (MergeOrder.isDisplayed()) {
//						dashBoardXpath.clickOnAfterElementIsVisible(MergeOrder);
//						System.out.println("Click Checkbox: " + MergeOrder.isDisplayed());
//						Thread.sleep(4000);
//						popup1.click();
//						System.out.println("Display MergeOrder Button and click:  " + popup1.isDisplayed());
//						Thread.sleep(4000);
//						WebElement Confirm_MergeOrder = dashBoardXpath.Confirm_Marge_order;
//						if (Confirm_MergeOrder.isDisplayed()) {
//							dashBoardXpath.clickOnAfterElementIsVisible(Confirm_MergeOrder);
//							System.out.println("Confirm_Marge_order Click:  " + Confirm_MergeOrder.isDisplayed());
//							Thread.sleep(7000);
//							Alert abc = driver.switchTo().alert();
//							System.out.println("********Alert massage read:*******"+abc.getText());
//							reader.setCellData("goya","Successful Order place Message",2,abc.getText());
//							if (abc.getText().equals(abc.getText())){
//							abc.dismiss();
//								System.out.println(" pop up alart accept ");}else {
//							System.out.println(" Pop up alart not accept ");}
//							System.out.println("********Alert massage read:*******"+abc.getText());
//
//						}
//					}
//					else {
//						Alert alert = driver.switchTo().alert();
//						if(alert.getText().equals(alert.getText())){
//
//						System.out.println(" **** All selected order has been merged.********  " + alert.getText());
//						Thread.sleep(3000);
//						alert.accept();}
//
//					else{
//						System.out.println("===================PopUp not showing=====================");
//						Thread.sleep(4000);
//						}
//				}
//
//
////							Alert alert = driver.switchTo().alert();
////							if(alert.equals(alert)) {
////								alert.accept();
////								System.out.println(" **** All selected order has been merged.********  " + alert.getText());
////								Thread.sleep(4000);
////							} else {
////								System.out.println("===================PopUp not showing====================="+alert.getText());
////								Thread.sleep(4000);
////							}
////						}
//						Alert alert1 = driver.switchTo().alert();
//						if (alert1.equals(alert1)){
//							System.out.println(" ************ Restriction Pop up showing. ***************  " + alert1.getText());
//							Thread.sleep(4000);
//							alert1.accept();
//							Thread.sleep(2000);
//
//						}
//						else {
//							System.out.println(" **** Restriction Pop up not showing. ********  " + alert1.getText());
//
//						}
//						WebElement Submit = dashBoardXpath.Submit1;
//						if (Submit.isDisplayed()){
//							dashBoardXpath.clickOnAfterElementIsVisible(Submit);
//							Thread.sleep(5000);
//							System.out.println("Found Submit button");
//						}
//
//						try {
//							Alert abc = driver.switchTo().alert();
//							System.out.println("********Alert massage read:*******"+abc.getText());
//							reader.setCellData("goya","Successful Order place Message",2,abc.getText());
//							if(abc.getText().equals(abc.getText())){
//							abc.dismiss();
//							System.out.println("Pop up alart accept");}else {
//							System.out.println("Pop up alart not accept");}
//							System.out.println("********Alert massage read:*******"+abc.getText());
//
//						}catch (Exception e){
//							System.out.println("Alert massage not read");
//						}
//
//					}
//				}
//			}
//	}
//	@When("i click on Order Status tab")
//	public void i_click_on_order_status_tab()throws Exception {
//		dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.OrderStatus_page);
//		Thread.sleep(3000);
//	}
//	@Then("Order status Page verify")
//	public void order_status_page_verify() {
//		WebElement Order_Status_Page_veryfy = dashBoardXpath.OrderStatus_page;
//		Order_Status_Page_veryfy.getText();
//		dashBoardXpath.checkElementVisibility(Order_Status_Page_veryfy,30);
//		assertEquals("Order History",Order_Status_Page_veryfy);
//
//	}
//
//	@Then("customer Order Status dropdown select Customer")
//	public void customer_order_status_dropdown_select_customer()throws Exception {
//
//		dashBoardXpath.moveToElementAndCLikOn(dashBoardXpath.Customer_Oder_Status_Dropdown);
//		Thread.sleep(4000);
//		dashBoardXpath.iterateWebElementListAndSelectValue(dashBoardXpath.Customer_Oder_Status_Dropdown_Value, prop.getPropValues(goyaConstants.dropdownValue));
//		Thread.sleep(7000);
//
//	}
//	@Then("Search EOR number")
//	public void search_eor_number()throws Exception {
//		WebElement EOR_SearchBox = dashBoardXpath.Oder_Status_EOR;
//		EOR_SearchBox.click();
//		dashBoardXpath.enterValue(EOR_SearchBox,reader.getCellData("goya","InvoiceNumber",2));
//		Thread.sleep(10000);
//	}
//	@Then("Product Edit")
//	public void product_edit()throws Exception {
//		dashBoardXpath.clickOn(dashBoardXpath.Order_Status_edit);
//		Thread.sleep(10000);
//
//	}
//
//	@Then("Store EOR Data input")
//	public void store_eor_data_input()throws Exception {
//
//		Thread.sleep(2000);
//		dashBoardXpath.enterValue(dashBoardXpath.exampleInputName,reader.getCellData("goya","InvoiceNumber",2));
//		Thread.sleep(3000);
//		System.out.println("************ Value is**************"+reader.getCellData("goya","InvoiceNumber",2));
//
//	}
//
//}