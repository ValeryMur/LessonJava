package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 18.01.2017.
 */
public class TestSignInLand {
    WebDriver driver;
    String email = "vbvaleramail+35@mail.ru";
    String password = "test_123";


    @BeforeTest
    public void setUpBrowsers() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //private By signinButtonPopup = By.xpath("html/body/div[3]/div/div/div/button");
    //private By signinButtonPopup = By.xpath("//div[@class=\"popup-container\"]/div/button[1]");
    private By signinButtonPopup = By.cssSelector(".b-btn.grey.sign-btn.vbsinginbtn");
    private By userEmailPopup = By.id("reg_email");
    private By userPasswordPopup = By.id("reg_pass");
    private By loginButtonPopup = By.xpath("//div/form[1]/button[1]");


    public void clickButtonOpenLoginForm() {
        driver.findElement(signinButtonPopup).click();
    }

    public void putEmail(String email) {
        driver.findElement(userEmailPopup).clear();
        driver.findElement(userEmailPopup).sendKeys(email);
    }

    public void putPassword(String password) {
        driver.findElement(userPasswordPopup).clear();
        driver.findElement(userPasswordPopup).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(loginButtonPopup).click();
    }

    public void login(String email, String password) throws InterruptedException {
       // driver.get("https://victoriabrides.com/land/f/j4_14/index.php?rf=14&rfm=2_1");
        clickButtonOpenLoginForm();
        Thread.sleep(3000);
        putEmail(email);
        putPassword(password);
        clickSignInButton();
    }

    @Test
    public  void loginLand() throws InterruptedException {
        driver.get("https://victoriabrides.com/land/f/j4_14/index.php?rf=14&rfm=2_1");
        login(email, password);
       // Assert.assertTrue(driver.findElement(By.cssSelector(".item:nth-of-type(1)")).isDisplayed(), "Не залогинится");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("tearDown");
        driver.close();
        driver.quit();
    }

}
