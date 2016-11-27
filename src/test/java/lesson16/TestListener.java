package lesson16;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.util.Arrays;

/**
 * Created by valeria on 25.11.2016.
 */

//используется в ТeatNG и прсто пишем в нашем тесте анотацию @Listener({НазваниеНашегоКлассаListener.class})
// также можно посмотреть в пример xml ExampleListener16

public class TestListener extends TestListenerAdapter{
    private static Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result){
        logger.info("-----------------------Test started: "+result.getTestClass().getName()+" Test:"+result.getName()+"---------------------------");
    }

    public void onTestSuccess(ITestResult result) {
       //logger.info("success");
        logger.info(result.getTestClass().getName()+" Test:"+result.getName()+" "+ Arrays.toString(result.getParameters())+"...........................................SUCCESS");
    }

    public void onTestFailure(ITestResult result) {
       File screenshotAs = ((TakesScreenshot) ((LoggerTest) result.getInstance()).driver).getScreenshotAs(OutputType.FILE);
        logger.error("FAILED: "+result.getTestClass().getName()+" Test:"+result.getName());
        logger.error("Reason: "+result.getThrowable().getMessage());
        //logger.error("fail");
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("             skipped: " + result.getTestClass().getName()+" Test:"+result.getName() +" SkipReason: "+result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext result) {
        logger.info("Test Finished");
    }
}
