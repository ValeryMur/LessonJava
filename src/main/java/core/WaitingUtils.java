package core;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Inna_Hrydiakina on 28.11.2016.
 */
public class WaitingUtils {


    public static void setImplicitWait(long time, TimeUnit unit){
        WebDriverHolder.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static FluentWait waitFor(ExpectedCondition<Boolean> condition){
        return new FluentWait(WebDriverHolder.getDriver()).withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).withMessage("FluentWait Error");
    }

    public static WebDriverWait waitConditions(ExpectedCondition<Boolean> condition) {
        return (WebDriverWait) new WebDriverWait(WebDriverHolder.getDriver(), 10).withMessage("WebDriverWait error");
    }
}


