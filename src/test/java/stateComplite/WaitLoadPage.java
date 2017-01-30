package stateComplite;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static testMultiplyBrowsers.BrowserFactoryM.driver;

/**
 * Created by valeria on 30.01.2017.
 */
public class WaitLoadPage {

    public static ExpectedCondition pageLoaded() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete");
            }

            @Override
            public String toString() {
                return "Page loading...";
            }
        };
    }

    @Test
    public void ddd() {
        driver().get("https://victoriabrides.com/land/f/27_pc1/?rf=4&rfm=2_1&partner=3&skip_reg=1");
        WebDriverWait wait = new WebDriverWait(driver(), 15);
        wait.until(pageLoaded());
        //Object o = ((JavascriptExecutor) driver()).executeScript("return document.readyState");
        //System.out.println(o);
    }

}