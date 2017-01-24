package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Inna_Hrydiakina on 16.09.2016.
 */
public class Actions extends Browser {

    public Actions(WebDriver driver) {
        this.driver = driver;
    }

    // is one of elements displayed on page
/*    @Step
    public boolean isElementPresent(By ...bys) {
        for (By by : bys)
            try {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                return true;
            } catch (Exception e) {
            }
        return false;
    }*/

    @Step
    public boolean isElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        List<WebElement> elements = driver.findElements(by);
        if (elements.size() > 0) {
            return elements.get(0).isDisplayed();
        } else {
            return false;
        }
    }

    // click on element on page
    @Step
    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // type with text in element
    @Step
    public void type(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
    }

}
