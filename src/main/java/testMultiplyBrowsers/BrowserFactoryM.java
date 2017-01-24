package testMultiplyBrowsers;

import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 23.01.2017.
 */
public class BrowserFactoryM {

    private WebDriver myDriver;
    public static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public  static WebDriver driver(){
        return DRIVER.get();
    }

    @BeforeTest
    public void setUp(){
        myDriver = new ChromeDriver();
        myDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        myDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public  void tesrDown(){
        driver().quit();
    }
}
