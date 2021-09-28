package com.SB3.goya.pageObject;

import com.SB3.goya.helpers.WaitHelper;
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

public class DashBoardXpath extends UserHomePage {
    public DashBoardXpath(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public static final String invoicePattern = "[A-Z]{1}[0-9]{5,}";
    public static final String giPattern = "[GI]{2}[0-9]{5,}";

    private WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id=\"profile-mob\"]/ul/li/div/button")
    public WebElement CARLOS_MORATO;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Customers')]")
    public WebElement Customers_Page;

    //    @FindBy(how = How.XPATH,using = "//body/div[1]/div[4]/div[1]/section[1]/div[2]/div[1]")
//    public WebElement HeaderTitle;
    @FindBy(how = How.XPATH, using = "//body/div[1]/div[4]/div[1]/section[1]/div[2]/div[1]")
    public WebElement HeaderTitle;


    @FindBy(how = How.XPATH, using = "//div[@class='modal-body ftr-align']//b[contains(text(),'712450-SHOP RITE 130')]")
    public static WebElement invoiceData;

    @FindBy(how = How.XPATH, using = "//div[@class='form-group']//input[@type='text']")
    public WebElement username;

    @FindBy(how = How.XPATH, using = "//div[@class='form-group']//input[@type='password']")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
    public WebElement submitButton;

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
