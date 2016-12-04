package victoriabrides;

import lesson5.Constants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.Parameter;
import ru.yandex.qatools.allure.model.ParameterKind;
import ru.yandex.qatools.allure.model.TestCaseResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by valeria on 23.11.2016.
 */
public class Browser {
    public static WebDriver driver;

    public WebDriver driver() {
        return driver;
    }

    @BeforeTest
    public void setUp() {
        System.out.println("SetUp Chrome");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        if(proxy.equalsIgnoreCase("bmp")){
//            BMProxyManager.startServer();
//            capabilities.setCapability("proxy", BMProxyManager.getProxy());
//        }
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

        //Выставить ожидание элементов
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        // Ожидание страницы загрузки
        driver.manage().timeouts().pageLoadTimeout(Constants.DEFAULT_WAIT_LONG_TIME, TimeUnit.SECONDS);
        //Открыть браузер на весь экран
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        System.out.println("tearDown");
        //BMProxyManager.stopServer();
        driver.close(); // закрывает окно  браузера, вкладку
        driver.quit(); // закрывает процесс
    }
/*
    @BeforeTest
    @Parameters({"before","proxy"})
    public void beforeTest(@Optional("Test")String before, @Optional("none")String proxy) {
        if(before.equalsIgnoreCase("TEST")){
            setUp();
        }
    }

    @BeforeMethod
    @Parameters({"before","proxy"})
    public void beforeMethod(@Optional("Test")String before, @Optional("none")String proxy){
        if(before.equalsIgnoreCase("METHOD")) {
            setUp();
        }
    }

    @AfterTest
    @Parameters({"before"})
    public void afterTest(@Optional("Test")String before) {
        if(before.equalsIgnoreCase("TEST")){
            tearDown();
        }
    }

    @AfterMethod
    @Parameters({"before"})
    public void afterMethod(@Optional("Test")String before){
        if(before.equalsIgnoreCase("METHOD")) {
            tearDown();
        }
    }
    */

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
        Allure.LIFECYCLE.fire(new TestCaseEvent() {
            @Override
            public void process(TestCaseResult testCaseResult) {
                testCaseResult.getParameters().add(parameter(name, value));
            }
        });
    }

}
