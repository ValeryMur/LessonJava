package lesson16;

import lesson5.Constants;
import listenerLesson16.DriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by valeria on 25.11.2016.
 */

@Listeners({TestListener.class})
public class LoggerTest {
    public WebDriver driver;

    @Test
    public void alal(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constants.DEFAULT_WAIT_LONG_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver = new EventFiringWebDriver(driver).register(new DriverListener());
        driver.get("https://www.google.com.ua/");
    }

    @Test
    public void FailedTest(){
        Assert.fail("alalalal");
    }

    @AfterTest
    public void done(){
        driver.quit();
    }
}
