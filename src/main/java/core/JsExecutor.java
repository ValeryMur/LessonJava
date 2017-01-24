package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by lolik on 12.08.2016.
 */
public class JsExecutor {

    public WebDriver driver(){
        return Browser.driver;
    }

    private Logger logger = LoggerFactory.getLogger(JsExecutor.class);

    private JavascriptExecutor executor(){
        return (JavascriptExecutor) driver();
    }

    public Object executeScript(String script, Object... args){
        return executor().executeScript(script, args);
    }

    public void highlightElement(WebElement element){
        highlightElement(element, "red");
    }

    public void highlightElement(WebElement element, String color){
        ((JavascriptExecutor) driver()).executeScript("arguments[0].style.border='3px solid "+color+"'", element);
    }

    public void setElementAttribute(By by, String attr, String value){
        List<WebElement> elementList = driver().findElements(by);
        for(WebElement element : elementList ) {
            executor().executeScript("arguments[0].setAttribute('" + attr + "', '" + value + "');", element);
        }
    }

    public void setElementText(By by, String text){
        setElementText(by, text, text);
    }

    public void setElementText(By by, String text, String expectedText){
        List<WebElement> elementList = driver().findElements(by);
        for(WebElement element : elementList ){
            executor().executeScript("arguments[0].innerHTML = \""+text+"\";", element);
            WebDriverWait wait = new WebDriverWait(driver(), 5);
            wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
        }
    }
    public void removeElement(By by){
        List<WebElement> elementList = driver().findElements(by);
        for(WebElement element : elementList ) {
            executor().executeScript("arguments[0].remove();", element);
        }
    }


}
