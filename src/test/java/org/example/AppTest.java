package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 

{
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setupDriver (String browser, String link) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get("https://www.github.com/login/");
        driver.manage().window().maximize();
    }
    @Test
    void gitHubLogin() throws InterruptedException{
        driver.findElement(By.cssSelector("input#login_field")).sendKeys("SaurabhKansal");
        driver.findElement(By.cssSelector("input#password")).sendKeys("Skansal2@");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[name=commit]"));
        Thread.sleep(1000);
    }
    @AfterClass
    void closeDriver () {
        driver.close();
    }
}
