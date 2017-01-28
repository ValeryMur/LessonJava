package signIn;


import core.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
//import site.signIn.PageObjectLoginVB;

import java.io.IOException;

/**
 * Created by ASUS PC on 23.11.2016.
 */
@Listeners({ListenerSignIn.class})
public class LoginVB extends Browser {
    public PageObjectLoginVB loginVictoriabrides = new PageObjectLoginVB(driver);

    String email = "vbvaleramail+35@mail.ru";
    String password ="test_123";
    String url = "https://victoriabrides.com/#auth/login";

    @Features("Login VB")
    @Stories("Login VB by man from sign up page")
    @Test
   // @Parameters ({"email", "password", "url"})
    public void loginVBpageSignUp() throws IOException {
        fireAllureParameterVariable("Browser","Chrome");
        fireAllureParameterVariable("URL","https://victoriabrides.com/#auth/login");
        driver = new EventFiringWebDriver(driver).register(new DriverListener());
        loginVictoriabrides.loginVB("vbvaleramail+35@mail.ru", "test_123", "https://victoriabrides.com/#auth/login");
        Assert.assertTrue(driver.findElement(By.cssSelector(".item:nth-of-type(1)")).isDisplayed(), "Не залогинится");
        // By.xpath .//*[@class='b-main_menu b-main_menu_region']/li[1]/a
        makeScreenshot("AfterLogin screen");
    }

    @Features("Login VB")
    @Stories("Login VB by man from popup on page sign in 1")
    @Test
    @Parameters ({"email", "password", "url"})
    public void loginVBpopupSignUp(String email, String password, String url) throws IOException {
        fireAllureParameterVariable("Browser","Chrome");
        fireAllureParameterVariable("URL","https://victoriabrides.com/signup/1?partner=0");
        driver = new EventFiringWebDriver(driver).register(new DriverListener());
        loginVictoriabrides.loginPopupVB(email, password, url);
        Assert.assertTrue(driver.findElement(By.cssSelector(".item:nth-of-type(1)")).isDisplayed(), "Не залогинится");
        makeScreenshot("AfterLogin screen");
    }

    @Features("Login VB")
    @Stories("Login VB by female from sign up page")
    @Test
    @Parameters ({"email", "password", "url"})
    public void loginFemale (String email, String password, String url) throws IOException {
        fireAllureParameterVariable("Browser","Chrome");
        fireAllureParameterVariable("URL","https://victoriabrides.com/#auth/login");
        driver = new EventFiringWebDriver(driver).register(new DriverListener());
        loginVictoriabrides.loginVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.urlContains("#wizard/moderation"));
        Assert.assertTrue(driver.getCurrentUrl().contains("#wizard/moderation"));
        makeScreenshot("AfterLogin screen");
    }

    @Features("Login VB")
    @Stories("Login VB by man from popup on page sign in 1 with wrong login")
    @Test
    @Parameters ({"email", "password", "url"})
    public void wrongEmailLoginVBpopup(String email, String password, String url) throws IOException {
        fireAllureParameterVariable("Browser","Chrome");
        fireAllureParameterVariable("URL","https://victoriabrides.com/signup/1?partner=0");
        driver = new EventFiringWebDriver(driver).register(new DriverListener());
        loginVictoriabrides.loginPopupVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form[class='lf-cont']>div[class='email error']")));
        //Assert.assertTrue(driver.findElement(By.cssSelector("form[class='lf-cont']>div[class='email error']")).isDisplayed(), "Нет валидации на ввод некорректного эмейла");
        makeScreenshot("AfterLogin screen");
    }

    @Features("Login VB")
    @Stories("Login VB by man from popup on page sign in 1 with wrong password")
    @Test
    @Parameters ({"email", "password", "url"})
    public void wrongPasswordLoginVBpopup(String email, String password, String url) throws IOException {
        fireAllureParameterVariable("Browser","Chrome");
        fireAllureParameterVariable("URL","https://victoriabrides.com/signup/1?partner=0");
        driver = new EventFiringWebDriver(driver).register(new DriverListener());
        loginVictoriabrides.loginPopupVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form[class='lf-cont']>div[class='email error']")));
       // Assert.assertTrue(driver.findElement(By.cssSelector("form[class='lf-cont']>div[class='email error']")).isDisplayed(), "Нет валидации на ввод некорректного пароля");
        makeScreenshot("AfterLogin screen");
    }

    @Features("Login VB")
    @Stories("Login VB by man from sign up page with wrong login")
    @Test
    @Parameters ({"email", "password", "url"})
    public void wrongEmailLoginVBpageSignUp(String email, String password, String url) throws IOException {
        fireAllureParameterVariable("Browser","Chrome");
        fireAllureParameterVariable("URL","https://victoriabrides.com/#auth/login");
        driver = new EventFiringWebDriver(driver).register(new DriverListener());
        loginVictoriabrides.loginVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error")));
       // Assert.assertTrue(driver.findElement(By.cssSelector(".error")).isDisplayed(), "Нет валидации на ввод некорректного эмейла");
        makeScreenshot("AfterLogin screen");
    }


    @Features("Login VB")
    @Stories("Login VB by man from sign up page with wrong password")
    @Test
    @Parameters ({"email", "password", "url"})
    public void wrongPasswordLoginVBpageSignUp(String email, String password, String url) throws IOException {
        fireAllureParameterVariable("Browser","Chrome");
        fireAllureParameterVariable("URL","https://victoriabrides.com/#auth/login");
        driver = new EventFiringWebDriver(driver).register(new DriverListener());
        loginVictoriabrides.loginVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error")));
       // Assert.assertTrue(driver.findElement(By.cssSelector(".error")).isDisplayed(), "Нет валидации на ввод некорректного пароля");
        makeScreenshot("AfterLogin screen");
    }
}
