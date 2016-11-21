package lesson15Listener;

import lesson15PageObject.RegForm1;
import lesson5.Constants;
import lesson6.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 21.11.2016.
 */
public class LoginTest {
    WebDriver driver;

    User userForTest = new User("ghgj@hg.kj", "12344556");

    @BeforeTest
    public void setUpBrowsers() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void loginUser(){
        RegForm1 regForm = new RegForm1(driver);
        driver.get("https://kismia.com/");
        regForm.loginForm.login(userForTest);
       // System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(By.cssSelector("[href='/sign/out']")).isDisplayed(), "Не залогинится");


    }

    @AfterTest
    public void tearDown() {
        System.out.println("tearDown");
        driver.close();
        driver.quit();
    }
}
