package com.unisuper.demo.steps;

import com.unisuper.demo.pageclassfiles.ConfigClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by pritig on 20/06/2017.
 */
public class HookClass {

    public static WebDriver driver;
    Properties prop;
    String website_url;
    String browser;

    @Before
    public void beforeScenario() {
        prop = ConfigClass.returnProp();
        website_url = prop.getProperty("website_url");
        browser = prop.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Automation/ChromeDriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "C:/Automation/InternetExplorerDriver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:/Automation/FirefoxDriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.get(website_url);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void afterScenario() {
        driver.close();
    }
}
