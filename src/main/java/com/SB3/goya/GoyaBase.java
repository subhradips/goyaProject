package com.SB3.goya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoyaBase {

    public  static WebDriver driver;
    public  static GoyaGetPropertyValues prop = new GoyaGetPropertyValues();

    static {
        //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
}
