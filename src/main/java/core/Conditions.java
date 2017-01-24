package core;


import com.google.common.base.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;


/**
 * Created by lolik on 15.08.2016.
 */
public final class Conditions {

    private Conditions() {}

    public static Function<? super WebDriver, Boolean> pageLoaded = new ExpectedCondition<Boolean>() {

        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        }

        @Override
        public String toString() {
            return "Page loading...";
        }

    };

    public static ExpectedCondition click(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            String exceptionMessage = "";
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    element.click();
                    return true;
                } catch (Exception e){
                    exceptionMessage = e.getMessage();
                    return false;
                }
            }

            @Override
            public String toString() {
                return "Exception: " + exceptionMessage + "Problem with clicking" + element;
            }
        };
    }




}
