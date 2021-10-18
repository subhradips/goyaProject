package com.SB3.goya.pageObject;

import com.SB3.goya.helpers.waitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dashBoardXpath extends userHomePage {
    public dashBoardXpath(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        waitHelper = new waitHelper(driver);
    }

    public static final String invoicePattern = "[A-Z]{1}[0-9]{5,}";
    public static final String giPattern = "[GI]{2}[0-9]{5,}";

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"profile-mob\"]/ul/li/div/button")
    public WebElement CARLOS_MORATO;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Customers')]")
    public WebElement Customers_Page;

    @FindBy(how = How.XPATH, using = "//body/div[1]/div[4]/div[1]/section[1]/div[2]/div[1]")
    public WebElement HeaderTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='ng-scope']//input[@value='Customers']")
    public WebElement Customers;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Customers')]")
    public WebElement Title;

    @FindBy(how = How.XPATH, using = "//div[@class='col-xs-4 col-lg-4 ']//input[@id='exampleInputEmail1']")
    public WebElement Search_Customer;

    @FindBy(how = How.XPATH, using = "//input[@name='1']")
    public WebElement RadioButton;

    @FindBy(how = How.XPATH, using = "//div[@class='col-md-12 details-submit clear-site-1']//button[@type='button']")
    public WebElement Select;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Proceed')]")
    public WebElement process;

    @FindBy(how = How.XPATH, using = "//*[@id='hide-for-print']/div[2]/div[2]/div/div[2]/h4/b")
    public WebElement CustomerinvoicesuccessMessageElement;
    @FindBy(how = How.XPATH, using = "//b[contains(text(),'712450-SHOP RITE 130')]")
    public WebElement Pop_upmessage;

    @FindBy(how = How.XPATH,using = "//*[@id='idd']/div[1]/div[4]/div[1]/section/div[3]/ul/li[9]/div/a")
    public WebElement OrderStatus;

    @FindBy(how = How.XPATH,using = "//input[@value='Order Status']")
    public WebElement OrderStatus_page;

    @FindBy(how = How.XPATH,using = "//ul[@class='nav navbar-nav navbar-center']//a[.='Home']")
    public WebElement HomePage_Tab;

    @FindBy(how = How.XPATH, using = "//*[@id='idd']/div/div[4]/div[1]/section/div[3]/ul/li[7]/div/a/input")
    public WebElement Order;
    @FindBy(how = How.XPATH, using = "//a[@title='Search items list']")
    public WebElement Search_Iteam;
    @FindBy(how = How.XPATH, using = "//*[@id='qk-remove-space']/form/div/ul/li[2]/div/div")
    public WebElement Customer_Dropdown;
    @FindBy(how = How.XPATH, using = "//b[contains(text(),'712450-SHOP RITE 130')]")
    public List<WebElement>  Customer_Dropdown_Value;

    @FindBy(how = How.XPATH, using = "//body/div[1]/div[4]/div[1]/section[3]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]")
    public WebElement Customer_Oder_Status_Dropdown;
    @FindBy(how = How.XPATH, using = "//b[contains(text(),'712450-SHOP RITE 130')]")
    public List<WebElement> Customer_Oder_Status_Dropdown_Value;
    @FindBy(how = How.XPATH, using = "//body/div[1]/div[4]/div[1]/div[3]/div[1]/div[1]/div[2]/p[2]/input[1]")
    public WebElement Search_Iteam_textBox;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add to Cart')]")
    public WebElement Add_To_Cart;
    @FindBy(how = How.XPATH, using = "//*[@id='idd']/div[1]/div[4]/div/div[5]/div/div/div[3]/button[1]")
    public WebElement Pop_up_Add_To_Cart;
    @FindBy (how = How.XPATH,using = "//body/div[1]/div[4]/div[1]/div[5]/div[2]/div[1]/div[2]/h4[1]/button[2]")
    public WebElement Add_Product;
    @FindBy (how = How.XPATH,using = "//*[@id='exampleInputName2']")
    public WebElement Oder_Status_EOR;

    @FindBy (how = How.XPATH,using = "//tbody/tr[1]/td[12]/a[1]")
    public WebElement Order_Status_edit;


    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue')]")
    public WebElement Continue;

    @FindBy(how = How.XPATH, using = "//input[@name='submitAll']")
    public WebElement Submit;
    @FindBy(how = How.XPATH, using = "//input[@id='']")
    public WebElement checkbox_click;

    @FindBy(how = How.XPATH, using = "//*[@id='mergeOrderModal']/div/div/div[3]/button[2]")
    public WebElement Continue_Merge;

    @FindBy(how = How.XPATH, using = "//body/div[1]/div[4]/div[9]/div[2]/div[1]/div[3]/button[2]")
    public WebElement Continue_Merge2;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
    public WebElement Submit1;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[4]/div[9]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]")
    public WebElement Marge_order;


    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Confirm Merge Order')]")
    public WebElement Confirm_Marge_order;


    public void enterValue(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void clickOn(WebElement submitButton) throws InterruptedException {
        submitButton.click();
        Thread.sleep(2000);
    }

    public void checkElementVisibility(WebElement element, long timeinMillisecond) {
        waitHelper.WaitForElement(element, timeinMillisecond);
    }

    public void iterateWebElementListAndSelectValue(List<WebElement> webElementList, String elementValue) {
        for (int i = 0; i <= webElementList.size() - 1; i++) {
            if (webElementList.get(i).getText().contains(elementValue)) {
                webElementList.get(i).click();
                break;
            }
        }
    }

    public void clickOnAfterElementIsVisible(WebElement element) {
        waitHelper.WaitForElementToClick(element, 30);
        element.click();
    }

    public void moveToElementAndCLikOn(WebElement paymentMode) {
        actions.moveToElement(paymentMode).click().perform();
    }

    public static BigDecimal getExpectedItemGrossAmount(String unitCount, String quantity) {
        BigDecimal uc = new BigDecimal(unitCount);
        BigDecimal quant = new BigDecimal(quantity);
        return uc.multiply(quant);
    }

    public static String findStringUsingRegex(String input, String regex) {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(input);
        String output = new String();
        while (matcher.find()) {
            output = output.concat(matcher.group(0));
        }
        return output;
    }



}
