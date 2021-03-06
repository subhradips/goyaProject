package com.goya.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class goyaBase {

    public  static WebDriver driver;
    public  static goyaGetPropertyValues prop = new goyaGetPropertyValues();

    static {
        //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
//
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
//
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();

//        System.setProperty("webdriver.chrome.driver","driver/chromedriver2.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
