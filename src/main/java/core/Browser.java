package core;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.Parameter;
import ru.yandex.qatools.allure.model.ParameterKind;
import ru.yandex.qatools.allure.model.TestCaseResult;

import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static core.WebDriverHolder.getDriver;

/**
 * Created by Inna_Hrydiakina on 16.09.2016.
 */
public class Browser extends TestListenerAdapter {

    public static WebDriver driver;

    public WebDriver driver() {
        return driver;
    }

//    public void setUp(String proxy, String size) {
//        System.out.println("SetUp Chrome");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        if (proxy.equalsIgnoreCase("bmp")) {
//            BMProxyManager.startServer();
//            capabilities.setCapability("proxy", BMProxyManager.getProxy());
//        }
//        driver = new ChromeDriver(capabilities);
//        //driver = new FirefoxDriver();
//
//        WebDriverHolder.setDriver(driver);
//
//        //Выставить ожидание элементов
//        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
//        // Ожидание страницы загрузки
//        driver.manage().timeouts().pageLoadTimeout(Constants.DEFAULT_WAIT_LONG_TIME, TimeUnit.SECONDS);
//        //Открыть браузер на весь экран
//        driver.manage().window().maximize();
//        if (size.equalsIgnoreCase("Iphone5")) {
//            Dimension d = new Dimension(320, 618);// 568 must be
//            driver.manage().window().setSize(d);
//        }
//    }

//    public void tearDown() {
//        System.out.println("tearDown");
//        BMProxyManager.stopServer();
//        driver.close(); // закрывает окно  браузера, вкладку
//        driver.quit(); // закрывает процесс
//    }
//
//    @BeforeTest
//    @Parameters({"before", "proxy", "size"})
//    public void beforeTest(@Optional("Test") String before, @Optional("none") String proxy, @Optional("none") String size) {
//        if (before.equalsIgnoreCase("TEST")) {
//            setUp(proxy, size);
//        }
//    }
//
//    @BeforeMethod
//    @Parameters({"before", "proxy", "size"})
//    public void beforeMethod(@Optional("Test") String before, @Optional("none") String proxy, @Optional("none") String size) {
//        if (before.equalsIgnoreCase("METHOD")) {
//            setUp(proxy, size);
//        }
//    }

//    @AfterTest
//    @Parameters({"before"})
//    public void afterTest(@Optional("Test") String before) {
//        if (before.equalsIgnoreCase("TEST")) {
//            tearDown();
//        }
//    }
//
//    @AfterMethod
//    @Parameters({"before"})
//    public void afterMethod(@Optional("Test") String before) {
//        if (before.equalsIgnoreCase("METHOD")) {
//            tearDown();
//        }
//    }

    @Attachment(value = "{0}", type = "image/png")
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

    // delete cookies
    @Step
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
        //driver.navigate().refresh();
    }

    // sleep )
    @Step
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // get web page
    @Step
    public static void goTo(String url) {
        getDriver().get(url);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        //SuccessRegForm4 instance = (SuccessRegForm4) result.getInstance();

        String browserErrorLogs = "";
        //Capture errors
        LogEntries logEntries = driver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            browserErrorLogs += new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + "\n";
        }
        AllureAttachments.txtAttachment(browserErrorLogs, "Browser Logs");

        String cookiesText = "";
        Set<Cookie> cookies = driver().manage().getCookies();
        for (Cookie cookie : cookies) {
            cookiesText += cookie;
        }
        AllureAttachments.txtAttachment(cookiesText, "Browser Cookies");

        try {
            makeScreenshot("ScreenshotOnFailure", driver());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] makeScreenshot(String name, WebDriver driver) throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestSuccess(ITestResult result) {

        //SuccessRegForm14 instance = (SuccessRegForm14) result.getInstance();

        String browserErrorLogs = "";
        //Capture errors
        LogEntries logEntries = driver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            browserErrorLogs += new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + "\n";
        }
        AllureAttachments.txtAttachment(browserErrorLogs, "Browser Logs");

        String cookiesText = "";
        Set<Cookie> cookies = driver().manage().getCookies();
        for (Cookie cookie : cookies) {
            cookiesText += cookie;
        }
        AllureAttachments.txtAttachment(cookiesText, "Browser Cookies");

        try {
            makeScreenshot("ScreenshotOnSuccess", driver());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
