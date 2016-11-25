package testVictoriabrides;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import victoriabrides.Browser;
import victoriabrides.PageObjectLoginVB;

/**
 * Created by ASUS PC on 23.11.2016.
 */
public class LoginVB extends Browser {
    public PageObjectLoginVB loginVictoriabrides = new PageObjectLoginVB(driver);
    /*
    String email;   //= "vbvaleramail+35@mail.ru";
    String password; //="test_123";
    String url; //= "https://victoriabrides.com/#auth/login";
*/
    @Test
    @Parameters ({"email", "password", "url"})
    public void loginVBpageSignUp(String email, String password, String url){
       loginVictoriabrides.loginVB(email, password, url);
        Assert.assertTrue(driver.findElement(By.cssSelector(".item:nth-of-type(1)")).isDisplayed(), "Не залогинится");
        // By.xpath .//*[@class='b-main_menu b-main_menu_region']/li[1]/a
    }

    @Test
    @Parameters ({"email", "password", "url"})
    public void loginVBpopupSignUp(String email, String password, String url){
        loginVictoriabrides.loginPopupVB(email, password, url);
        Assert.assertTrue(driver.findElement(By.cssSelector(".item:nth-of-type(1)")).isDisplayed(), "Не залогинится");
    }

    @Test
    @Parameters ({"email", "password", "url"})
    public void loginFemale (String email, String password, String url){
        loginVictoriabrides.loginVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.urlContains("#wizard/moderation"));
        Assert.assertTrue(driver.getCurrentUrl().contains("#wizard/moderation"));
    }

    @Test
    @Parameters ({"email", "password", "url"})
    public void wrongEmailLoginVBpopup(String email, String password, String url){
        loginVictoriabrides.loginPopupVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form[class='lf-cont']>div[class='email error']")));
        //Assert.assertTrue(driver.findElement(By.cssSelector("form[class='lf-cont']>div[class='email error']")).isDisplayed(), "Нет валидации на ввод некорректного эмейла");
    }
    @Test
    @Parameters ({"email", "password", "url"})
    public void wrongPasswordLoginVBpopup(String email, String password, String url){
        loginVictoriabrides.loginPopupVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form[class='lf-cont']>div[class='email error']")));
       // Assert.assertTrue(driver.findElement(By.cssSelector("form[class='lf-cont']>div[class='email error']")).isDisplayed(), "Нет валидации на ввод некорректного пароля");
    }

    @Test
    @Parameters ({"email", "password", "url"})
    public void wrongEmailLoginVBpageSignUp(String email, String password, String url){
        loginVictoriabrides.loginVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error")));
       // Assert.assertTrue(driver.findElement(By.cssSelector(".error")).isDisplayed(), "Нет валидации на ввод некорректного эмейла");
    }

    @Test
    @Parameters ({"email", "password", "url"})
    public void wrongPasswordLoginVBpageSignUp(String email, String password, String url){
        loginVictoriabrides.loginVB(email, password, url);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error")));
       // Assert.assertTrue(driver.findElement(By.cssSelector(".error")).isDisplayed(), "Нет валидации на ввод некорректного пароля");
    }
}
