package listenerLesson16;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

/**
 * Created by valeria on 25.11.2016.
 */
public class TestListener extends TestListenerAdapter{
    private static Logger logger = LoggerFactory.getLogger(TestListener.class);

    public void onTestSuccess(ITestResult tr) {
        logger.info("success");
    }

    public void onTestFailure(ITestResult tr) {
        //File screenshotAs = ((TakesScreenshot) ((LoggerTest) result.getInstance()).driver).getScreenshotAs(OutputType.FILE);
        logger.error("fail");
    }

    public void onTestSkipped(ITestResult tr) {
        logger.info("skip");
    }
}
