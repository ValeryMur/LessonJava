package signIn;

import core.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
//import site.signIn.ISignIn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 15.01.2017.
 */
@Listeners({ListenerSignIn.class})
public class SignInVBDataprovider extends Browser {

    //UserVB user = new UserVB("vbvaleramail+35@mail.ru", "test_123");

    @DataProvider(name = "signInVB")
    public Object[][] signInVB() {
        return new Object[][]{
//               {"https://victoriabrides.com/signup/1?partner=0&subid=iuh", new PopupSignIn(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/#auth/login", new SignInPage(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/signup/9?partner=3&ad=1&force_visit=1&skip_reg=1", new PopupSignIn(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/signup/7?partner=3&skip_reg=1", new PopupSignIn(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/signup/3/new?partner=3&skip_reg=1", new PopupSignIn(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/signup/5?partner=3&skip_reg=1", new SignInSignup5(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/land/f/27_pc1/index.php?rf=14&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},
//              {"https://victoriabrides.com/land/f/j4_10_pc1/index.php?rf=14&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/land/f/j4_14/index.php?rf=14&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/land/f/j4_10_pc1/index.php?rf=14&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},
               {"https://victoriabrides.com/land/f/27_pc1/index.php?rf=14&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/land/f/j4_4_pc1/index.php?rf=14&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/land/f/j4_4_pc1/index.php?rf=4&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/land/f/j4_10_pc1/index.php?rf=4&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/land/f/27_pc1/index.php?rf=4&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},
//               {"https://victoriabrides.com/land/f/j4_14/index.php?rf=4&rfm=2_1", new SignInLand(driver), "vbvaleramail+35@mail.ru", "test_123"},

        };
    }

    @Features("Login VB")
    @Stories("Login VB by man from page sign in and popup from actual signups and landings")
    @Test (dataProvider = "signInVB", dataProviderClass = SignInVBDataprovider.class)
        public void allSignIn(String url, ISignIn signIn, String email, String password) throws IOException, InterruptedException {
            driver.manage().deleteAllCookies();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            fireAllureParameterVariable("Browser","Chrome");
          //  driver = new EventFiringWebDriver(driver).register(new DriverListener());
            signIn.clickButtonOpenLoginForm();
            Thread.sleep(3000);
            signIn.login(email, password);
            Assert.assertTrue(driver.findElement(By.cssSelector(".item:nth-of-type(1)")).isDisplayed(), "Не залогинится");
            makeScreenshot("After Login screen");
    }

    @DataProvider(name = "signInPageVBInvalidData")
    public Object[][] signInPageVBInvalidData() {
        return new Object[][]{
                {"https://victoriabrides.com/#auth/login", new SignInPage(driver), "vbvaleramail+35@mail.ru", ""},
                {"https://victoriabrides.com/#auth/login", new SignInPage(driver), "", ""},
                {"https://victoriabrides.com/#auth/login", new SignInPage(driver), "", "test_123"},
                {"https://victoriabrides.com/#auth/login", new SignInPage(driver), "vbva@mail.ru", "test_123"},
                {"https://victoriabrides.com/#auth/login", new SignInPage(driver), "vbvaleramail+35@mail.ru", "12345678"},
        };
    }

    @Features("Login VB")
    @Stories("Login VB by man from sign in page with invalid data")
    @Test (dataProvider = "signInPageVBInvalidData", dataProviderClass = SignInVBDataprovider.class)
    public void SignInPageInvalidData(String url, ISignIn signIn, String email, String password) throws IOException, InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        fireAllureParameterVariable("Browser","Chrome");
       // driver = new EventFiringWebDriver(driver).register(new DriverListener());
        signIn.clickButtonOpenLoginForm();
        signIn.login(email, password);
        Thread.sleep(3000);
        String invalidData = driver.findElement(By.cssSelector(".error")).getText();
        Assert.assertTrue(invalidData.contains("Wrong login or password"));
        makeScreenshot("After Login screen");
    }

    @DataProvider(name = "signInPopupVBInvalidData")
    public Object[][] signInPopupVBInvalidData() {
        return new Object[][]{
                {"https://victoriabrides.com/signup/1?partner=0&subid=iuh", new PopupSignIn(driver), "vbvaleramail+35@mail.ru", ""},
                {"https://victoriabrides.com/signup/1?partner=0&subid=iuh", new PopupSignIn(driver), "", "test_123"},
                {"https://victoriabrides.com/signup/1?partner=0&subid=iuh", new PopupSignIn(driver), "", ""},
                {"https://victoriabrides.com/signup/1?partner=0&subid=iuh", new PopupSignIn(driver), "vbva@gmail.com", "test_123"},
                {"https://victoriabrides.com/signup/1?partner=0&subid=iuh", new PopupSignIn(driver), "vbvaleramail+35@mail.ru", "lalala"},
        };
    }

    @Features("Login VB")
    @Stories("Login VB by man from popup with invalid data")
    @Test (dataProvider = "signInPopupVBInvalidData", dataProviderClass = SignInVBDataprovider.class)
    public void SignInPopupInvalidData(String url, ISignIn signIn, String email, String password) throws IOException, InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        fireAllureParameterVariable("Browser","Chrome");
       // driver = new EventFiringWebDriver(driver).register(new DriverListener());
        signIn.clickButtonOpenLoginForm();
        signIn.login(email, password);
        Thread.sleep(3000);
        String invalidData = driver().findElement(By.xpath("//div[@class=\"login-form\"]//div[@class=\"email error\"]")).getText();
        Assert.assertTrue(invalidData.contains("Wrong login or password"));
        makeScreenshot("After Login screen");
    }

    //Заглушка для девушек не работает
    @DataProvider(name = "signInVBFemale")
    public Object[][] signInVBFemale() {
        return new Object[][]{
                {"https://victoriabrides.com/signup/1?partner=0&subid=iuh", new PopupSignIn(driver), "valerytestvb+210@gmail.com", "test_123"},
                {"https://victoriabrides.com/#auth/login", new SignInPage(driver), "valerytestvb+210@gmail.com", "test_123"},
        };
    }
    //Заглушка для девушек не работает
    @Features("Login VB")
    @Stories("Login VB by female from page sign in and popup")
    @Test (dataProvider = "signInVBFemale", dataProviderClass = SignInVBDataprovider.class, enabled = false)
    public void SignInFemale(String url, ISignIn signIn, String email, String password) throws IOException, InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        fireAllureParameterVariable("Browser","Chrome");
     //   driver = new EventFiringWebDriver(driver).register(new DriverListener());
        signIn.clickButtonOpenLoginForm();
        signIn.login(email, password);
        WebDriverWait wait = new WebDriverWait(driver(), 30);
        wait.until(ExpectedConditions.urlContains("#wizard/moderation"));
        Assert.assertTrue(driver.getCurrentUrl().contains("#wizard/moderation"));
        makeScreenshot("After Login screen");
    }

}
