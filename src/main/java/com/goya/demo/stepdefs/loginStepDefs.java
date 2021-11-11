package com.goya.demo.stepdefs;

import com.goya.demo.goyaBase;
import com.goya.demo.goyaConstants;
import com.goya.demo.pageObject.dashBoardXpath;
import com.goya.demo.pageObject.driverStorage;
import com.goya.demo.pageObject.xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.util.Asserts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.goya.demo.pageObject.removerSpace.removeSpaces;
import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;

public class loginStepDefs extends goyaBase {
    com.goya.demo.pageObject.dashBoardXpath dashBoardXpath = new dashBoardXpath(driver);
    xls_Reader reader = new xls_Reader("src/test/resources/Data.xlsx");
    driverStorage driverStorage_xpath = new driverStorage(driver);
    String CustomerInvoiceMessage = new String();

    @Given("I am on the Login page")
    public void i_am_on_the_login_page()throws Exception {
        driver.get(prop.getPropValues(goyaConstants.URL));
        System.out.println("URL given: "+ goyaConstants.URL);
        //waitHelper = new WaitHelper(driver);
        Thread.sleep(1000);
        }
    @When("I should see Sign In Page")
    public void i_should_see_sign_in_page()throws Exception {
        String title = driver.getTitle();
        assertEquals("GOYA Food", title);
        System.out.println("GOYA Food: " + title);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(1000);
    }
    @Then("I enter username")
    public void i_enter_username()throws Exception {
        driverStorage_xpath.enterValue(driverStorage_xpath.username, reader.getCellData("goya","UserName",2));
        System.out.println(reader.getCellData("goya","UserName",2));
        Thread.sleep(2000);
    }

    @Then("I enter wrong username")
    public void i_enter_wrong_username()throws Exception {
        driverStorage_xpath.enterValue(driverStorage_xpath.username, reader.getCellData("goya","UserName",3));
        System.out.println(reader.getCellData("goya","UserName",3));
        Thread.sleep(2000);
    }

    @Then("I enter password")
    public void i_enter_password()throws Exception {
        driverStorage_xpath.enterValue(driverStorage_xpath.password, reader.getCellData("goya","Password",2));
        System.out.println(reader.getCellData("goya","Password",2));
        Thread.sleep(2000);
    }

    @Then("I enter wrong password")
    public void i_enter_wrong_password()throws Exception {
        driverStorage_xpath.enterValue(driverStorage_xpath.password, reader.getCellData("goya","Password",3));
        System.out.println(reader.getCellData("goya","Password",3));
        Thread.sleep(2000);
    }
    @Then("user clicks on login button")
    public void user_clicks_on_login_button()throws Exception {
        driverStorage_xpath.clickOn(driverStorage_xpath.submitButton);
        Thread.sleep(2000);
        String expect = driverStorage_xpath.submitButton.getText();
        String accual = driver.getTitle();
        assertEquals(expect,accual);
        System.out.println("Dahboard page is:  "+driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    @Given("user is home page")
    public void user_is_home_page()throws Exception {
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.HomePage_Tab);
        System.out.println("HomePage_Tab Click");
        driver.navigate().refresh();
        Thread.sleep(4000);
    }
    @When("i click customers tab")
    public void i_click_customers_tab()throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Customers);
        Thread.sleep(2000);
    }
    @Then("customers Page verify")
    public void customers_page_verify()throws Exception {
        String actualTitle = dashBoardXpath.Customers_Page.getText();
        assertEquals("Customers", actualTitle);
        System.out.println("Customers: " + actualTitle);
        Thread.sleep(2000);

    }
    @Then("given input search customer textbox")
    public void given_input_search_customer_textbox()throws Exception {
        String customer1 = reader.getCellData("goya", "CustomerID", 2);
        dashBoardXpath.enterValue(dashBoardXpath.Search_Customer, customer1);
        System.out.println("given input search customer textbox: " + customer1);
        Thread.sleep(2000);
    }
    @Then("choose customer")
    public void choose_customer()throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.RadioButton);
        System.out.println("Radio Button Click: " + "Press Radio Button");
        Thread.sleep(2000);
    }
    @Then("click on select button")
    public void click_on_select_button()throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Select);
        System.out.println("Select Button Click: " + "Select Button Click");
        Thread.sleep(4000);

    }
    @Then("click on process button")
    public void click_on_process_button()throws Exception {

        WebElement Pop_up_message = dashBoardXpath.Pop_upmessage;
        if (Pop_up_message.isDisplayed()) {
            String s = Pop_up_message.getText();
            System.out.println(" Customer Value Save is: "+s);
            Thread.sleep(4000);
            System.out.println("******* Value Save in Excel: ************ "+reader.setCellData("goya", "CustomerSelectValue", 2, s));
            Thread.sleep(4000);

        } else {
            System.out.println(" Not Showing value "+Pop_up_message.getText());
        }
        dashBoardXpath.clickOn(dashBoardXpath.process);
        driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        Thread.sleep(1000);
        System.out.println("process button click: " + "press the button");
    }
    @Then("you have enter home page verify")
    public void you_have_enter_home_page_verify()throws Exception {
        String acctualFinalMessage = dashBoardXpath.HeaderTitle.getText();
        String expectFinalMessage = reader.getCellData("goya","CustomerSelectValue",2);
        char str[] = acctualFinalMessage.toCharArray();
        int i = removeSpaces(str);
        String value = (String) valueOf(str).subSequence(0, i);

        char str1[] = expectFinalMessage.toCharArray();
        int j = removeSpaces(str1);
        String value1 = (String) valueOf(str1).subSequence(0, j);

        assertEquals(value1, value);
        System.out.println("********* Header file change name ************ : " + acctualFinalMessage);
        Thread.sleep(2000);
    }


    @When("click on Order tab")
    public void click_on_order_tab()throws Exception {
        if (dashBoardXpath.Order.isDisplayed()) {
            dashBoardXpath.Order.click();
            Thread.sleep(2000);
            System.out.println("Order Button Display");
    }
    }
    @Then("order Page verify")
    public void order_page_verify()throws Exception {
        String accual = dashBoardXpath.Search_Iteam.getText();
        String expect = "Search Item";
        assertEquals(expect, accual);
        System.out.println(expect + accual);
    }
    @Then("customer dropdown select Customer")
    public void customer_dropdown_select_customer()throws Exception {
        Thread.sleep(2000);
        dashBoardXpath.moveToElementAndCLikOn(dashBoardXpath.Customer_Dropdown);
        dashBoardXpath.iterateWebElementListAndSelectValue(dashBoardXpath.Customer_Dropdown_Value, reader.getCellData("goya","CustomerID",3));
        Thread.sleep(2000);
    }
    @Then("click on Search Item Button")
    public void click_on_search_item_button()throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Search_Iteam);
        System.out.println("dashBoardXpath.Search_Iteam click");
        Thread.sleep(3000);
    }
    @Then("search Items value in the textBox")
    public void search_items_value_in_the_text_box()throws Exception {
        dashBoardXpath.Search_Iteam_textBox.clear();
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.Search_Iteam_textBox, reader.getCellData("goya","Search Items Value",2));
        System.out.println("************Search Items Value is:************ "+reader.getCellData("goya","Search Items Value",2));
        Thread.sleep(3000);
    }

    @Then("search Items negative value in the textBox")
    public void search_items_negative_value_in_the_text_box()throws Exception {
        dashBoardXpath.Search_Iteam_textBox.clear();
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.Search_Iteam_textBox, reader.getCellData("goya","Search Items Value",3));
        System.out.println("************Search Items Value is:************ "+reader.getCellData("goya","Search Items Value",3));
        Thread.sleep(3000);
    }
    @Then("click on Add to Cart Button")
    public void click_on_add_to_cart_button()throws Exception {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Add_To_Cart);
        System.out.println("dashBoardXpath.Add_To_Cart click");
        Thread.sleep(3000);
    }
    @Then("enter Quantity")
    public void enter_quantity()throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Add_Product);
        System.out.println("dashBoardXpath.Add_Product click");
        Thread.sleep(5000);
    }
    @Then("click on pop_up Add to Cart Button")
    public void click_on_pop_up_add_to_cart_button()throws Exception {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Pop_up_Add_To_Cart);
        System.out.println("dashBoardXpath.Pop_up_Add_To_Cart click");
        Thread.sleep(5000);
    }
    @Then("click on continue Button")
    public void click_on_continue_button()throws Exception {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Continue);
        System.out.println("dashBoardXpath.Continue click");
        Thread.sleep(5000);
    }
    @Then("store EOR Data")
    public void store_eor_data()throws Exception {
        String s = ((JavascriptExecutor) driver).executeScript("return document.getElementById('eor').value").toString();
        System.out.println("EOR Invoice Number is: "+s);
        reader.setCellData("goya", "InvoiceNumber", 2, s);
        Thread.sleep(5000);

    }
    @Then("negative store EOR Data")
    public void negative_store_eor_data()throws Exception {
        String s = ((JavascriptExecutor) driver).executeScript("return document.getElementById('eor').value").toString();
        System.out.println("EOR Invoice Number is: "+s);
        reader.setCellData("goya", "InvoiceNumber", 3, s);
        Thread.sleep(5000);

        String Red_background = driver.findElement(By.xpath("//tr[@class='font-size2 ng-scope itemBackground']")).getCssValue("background-color");
        String hex = Color.fromString(Red_background).asHex();
        System.out.println("Read Red_background Color:  " + hex);
        if (hex.equals("#ffb3b3")) {
            assertEquals("#ffb3b3", hex);
            WebElement color_delete = driver.findElement(By.xpath("//tbody/tr[1]//td[@name='deleteItem']"));
            color_delete.click();
            Thread.sleep(2000);
            Alert action = driver.switchTo().alert();
            reader.setCellData("goya","Restricted Order place Message",2,action.getText());
            action.accept();
            Thread.sleep(2000);
            click_on_search_item_button();
            search_items_value_in_the_text_box();
            click_on_add_to_cart_button();
            enter_quantity();
            click_on_pop_up_add_to_cart_button();
            click_on_continue_button();

        }
    }

    @Then("click on Submit button")
    public void click_on_submit_button()throws Exception {
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Submit);
        Thread.sleep(3000);
        WebElement popup1 = dashBoardXpath.Continue_Merge2;
        WebElement Submit1 = dashBoardXpath.Submit1;
        if(Submit1.isDisplayed()){
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Submit1);
            System.out.println("******** Click Submit button: ***********"+Submit1.isDisplayed());
//            Thread.sleep(2000);
//            dashBoardXpath.clickOn(dashBoardXpath.pop_up_Submit);
            System.out.println("pop_up_Submit click");
            Thread.sleep(5000);
            Alert abc = driver.switchTo().alert();
            Thread.sleep(4000);
            System.out.println("********Alert massage read:*******"+abc.getText());
            reader.setCellData("goya","Successful Order place Message",2,abc.getText());
            abc.dismiss();
            Thread.sleep(2000);

        }
        else {
            dashBoardXpath.clickOn(dashBoardXpath.Continue_Merge);
            String EOR = reader.getCellData("goya", "InvoiceNumber", 3);
            List<WebElement> dynamicElement = driver.findElements(By.xpath("//body/div[1]/div[4]/div[9]/div[2]/div[1]/div[2]"));
            if (dynamicElement.size() > 0) {
                System.out.println("Test:=------========== " + EOR + "-----------========= is present ");

                for (int iLoop = 0; iLoop < dynamicElement.size(); iLoop++) {
                    System.out.println("Column " + iLoop + " : '" + dynamicElement.get(iLoop).getText().toString() + "'");

                    WebElement MergeOrder = dashBoardXpath.Marge_order;
                    if (MergeOrder.isDisplayed()) {
                        dashBoardXpath.clickOnAfterElementIsVisible(MergeOrder);
                        System.out.println("Click Checkbox: " + MergeOrder.isDisplayed());
                        Thread.sleep(4000);
                        popup1.click();
                        System.out.println("Display MergeOrder Button and click:  " + popup1.isDisplayed());
                        Thread.sleep(4000);
                        WebElement Confirm_MergeOrder = dashBoardXpath.Confirm_Marge_order;
                        if (Confirm_MergeOrder.isDisplayed()) {
                            dashBoardXpath.clickOnAfterElementIsVisible(Confirm_MergeOrder);
                            System.out.println("Confirm_Marge_order Click:  " + Confirm_MergeOrder.isDisplayed());
                            Thread.sleep(7000);
                            Alert abc = driver.switchTo().alert();
                            System.out.println("********Alert massage read:*******"+abc.getText());
                            reader.setCellData("goya","Successful Order place Message",2,abc.getText());
                            if (abc.getText().equals(abc.getText())){
                                abc.dismiss();
                                System.out.println(" pop up alart accept ");
                                Thread.sleep(2000);
                                dashBoardXpath.clickOn(dashBoardXpath.pop_up_Submit_order);
                            }else {
                                System.out.println(" Pop up alart not accept ");}
                            System.out.println("********Alert massage read:*******"+abc.getText());

                        }
                    }
                    else {
                        Alert alert = driver.switchTo().alert();
                        if(alert.getText().equals(alert.getText())){

                            System.out.println(" **** All selected order has been merged.********  " + alert.getText());
                            Thread.sleep(3000);
                            alert.accept();}

                        else{
                            System.out.println("===================PopUp not showing=====================");
                            Thread.sleep(4000);
                        }
                    }


//							Alert alert = driver.switchTo().alert();
//							if(alert.equals(alert)) {
//								alert.accept();
//								System.out.println(" **** All selected order has been merged.********  " + alert.getText());
//								Thread.sleep(4000);
//							} else {
//								System.out.println("===================PopUp not showing====================="+alert.getText());
//								Thread.sleep(4000);
//							}
//						}
                    Alert alert1 = driver.switchTo().alert();
                    if (alert1.equals(alert1)){
                        System.out.println(" ************ Restriction Pop up showing. ***************  " + alert1.getText());
                        Thread.sleep(4000);
                        alert1.accept();
                        Thread.sleep(2000);

                    }
                    else {
                        System.out.println(" **** Restriction Pop up not showing. ********  " + alert1.getText());

                    }
                    WebElement Submit = dashBoardXpath.Submit1;
                    if (Submit.isDisplayed()){
                        dashBoardXpath.clickOnAfterElementIsVisible(Submit);
                        Thread.sleep(5000);
                        System.out.println("Found Submit button");
                    }

                    try {
                        Alert abc = driver.switchTo().alert();
                        System.out.println("********Alert massage read:*******"+abc.getText());
                        reader.setCellData("goya","Successful Order place Message",2,abc.getText());
                        if(abc.getText().equals(abc.getText())){
                            abc.dismiss();
                            System.out.println("Pop up alart accept");}else {
                            System.out.println("Pop up alart not accept");}
                        System.out.println("********Alert massage read:*******"+abc.getText());

                    }catch (Exception e){
                        System.out.println("Alert massage not read");
                    }

                }
            }
        }
    }

    @When("i click on Order Status tab")
    public void i_click_on_order_status_tab()throws Exception {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.OrderStatus_page);
        Thread.sleep(3000);
    }
    @Then("customer Order Status dropdown select Customer")
    public void customer_order_status_dropdown_select_customer()throws Exception {
        dashBoardXpath.moveToElementAndCLikOn(dashBoardXpath.Customer_Oder_Status_Dropdown);
        Thread.sleep(4000);
        dashBoardXpath.iterateWebElementListAndSelectValue(dashBoardXpath.Customer_Oder_Status_Dropdown_Value, prop.getPropValues(goyaConstants.dropdownValue));
        Thread.sleep(7000);
    }
    @Then("Store EOR Data input")
    public void store_eor_data_input()throws Exception {
        WebElement EOR_SearchBox = dashBoardXpath.Oder_Status_EOR;
        EOR_SearchBox.click();
        dashBoardXpath.enterValue(EOR_SearchBox,reader.getCellData("goya","InvoiceNumber",2));
        Thread.sleep(20000);
    }

    @Then("user clicks on Negative_login button")
    public void user_clicks_on_negative_login_button()throws Exception {

        driverStorage_xpath.clickOn(driverStorage_xpath.submitButton);
        Thread.sleep(2000);

        String expect = driverStorage_xpath.submitButton.getText();
        String accual = driver.getTitle();
        assertEquals(expect,accual);
        WebElement message = dashBoardXpath.Wrong_message;
        if(message.isDisplayed())
        {
            String message1 = message.getText();
            reader.setCellData("goya","Wrong message",2,message1);
        }else {

            System.out.println("Dahboard page is:  "+driver.getTitle());
            Thread.sleep(3000);}
        driver.navigate().refresh();

    }

}
