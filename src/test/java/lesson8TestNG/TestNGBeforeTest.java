package lesson8TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by valeria on 24.10.2016.
 */
public class TestNGBeforeTest {
    WebDriver driver;


    @BeforeTest
    public void setUpBrowser(){
        System.out.println("SetUp Chrome");
        driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(Constants.DEFAULT_WAIT_LONG_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void trySelenium() throws InterruptedException {
        System.out.println("TEST");
        driver.get("https://kismia.com");
        //Assert.assertTrue(driver.getTitle().equals(Constants.KISMIA_MAIN_PAGE_TITLE));

        // Assert.assertEquals(driver.getTitle(), Constants.KISMIA_MAIN_PAGE_TITLE);
    }
    @Test
    public void trySelenium1() throws InterruptedException {
        System.out.println("TEST");
        driver.get("https://www.facebook.com/");
    }

    @AfterTest
    public void tearDown(){
        System.out.println("tearDown");
        driver.close();
        driver.quit();
    }



}
