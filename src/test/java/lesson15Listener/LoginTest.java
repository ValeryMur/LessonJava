package lesson15Listener;

import lesson15PageObject.RegForm1;
import lesson5.Constants;
import lesson6.User;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.Parameter;
import ru.yandex.qatools.allure.model.ParameterKind;
import ru.yandex.qatools.allure.model.TestCaseResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 21.11.2016.
 */

@Features("Login")
@Stories("Login by not premium user")
public class LoginTest {
    WebDriver driver;

    User userForTest = new User("loliktest1@mail.ru", "qwe1rty2");

    @BeforeTest
    public void setUpBrowsers() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Step
    public  void get (String url){
        driver.get(url);
    }

    @Test
    public void loginUser() throws IOException {
        fireAllureParameterVariable("Browser","Chrome");
        fireAllureParameterVariable("URL","https://kismia.com/");
        fireAllureParameterVariable("User",userForTest.toString());
        fireAllureParameterVariable("BOs","Wind");
        RegForm1 regForm = new RegForm1(driver);
       get("https://kismia.com/");
        makeScreenshot("BeforeLogin screen");
        regForm.loginForm.login(userForTest);
       // System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(By.cssSelector("[href='/sign/out']")).isDisplayed(), "Не залогинится");
        makeScreenshot("AfterLogin screen");

    }

    @Attachment(value="{0}", type ="image/png")
    public byte[] makeScreenshot(String name) throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private static Parameter parameter(String name, String value) {
        Parameter param = new Parameter();
        param.setName(name);
        param.setValue(value);
        param.setKind(ParameterKind.ENVIRONMENT_VARIABLE);
        return param;
    }

    public static void fireAllureParameterVariable(final String name, final String value) {
        //logger.info(name+": "+value);
        Allure.LIFECYCLE.fire(new TestCaseEvent() {
            @Override
            public void process(TestCaseResult testCaseResult) {
                testCaseResult.getParameters().add(parameter(name, value));

            }
        });
    }

    @AfterTest
    public void tearDown() {
        System.out.println("tearDown");
        driver.close();
        driver.quit();
    }
}
