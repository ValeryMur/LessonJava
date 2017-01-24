package core;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;


/**
 * Created by lolik on 15.08.2016.
 */
public class Elem extends Browser {

    //public WebDriver driver(){return Browser.driver;}
    public Elem(WebDriver driver) {
        this.driver = driver;
    }

    private Logger logger = LoggerFactory.getLogger(Elem.class);

    private int waitTime = 15;

    private By by;
    private String name = "";

    public Elem(By by, String name){
        this.by = by;
        this.name = name;
    }

    public Elem(By by){
        this.by = by;
    }

    public By getBy(){
        return by;
    }

    public void setBy(By by){
        this.by = by;
    }


    public String getName(){
        return name;
    }

    @Step("Find Element: {this}")
    public WebElement find(){
        WebDriverWait wait = new WebDriverWait(driver(), waitTime);
        try {
            return wait.withMessage(name).until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e){
            if(e.getCause().toString().contains("org.openqa.selenium.NoSuchElementException")){
                logger.error("Element: '"+toString()+"' not found on page: "+driver().getCurrentUrl());
                NoSuchElementException ne = new NoSuchElementException("Element: '"+toString()+"' not found on page: "+driver().getCurrentUrl());
                ne.setStackTrace(e.getStackTrace());
                throw ne;
            }
            throw e;
        }
    }

    @Step("Find Elements: {this}")
    public List<WebElement> finds(){
        WebDriverWait wait = new WebDriverWait(driver(), waitTime);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }


    @Step("{this} type text: {0}")
    public void type(String text){
        WebDriverWait wait = new WebDriverWait(driver(), waitTime);
        WebElement filed = wait.until(ExpectedConditions.elementToBeClickable(find()));
        filed.clear();
        filed.sendKeys(text);
        wait.until(ExpectedConditions.textToBePresentInElementValue(by, text));
    }


    @Step("Click {this}")
    public void click(){
       WebDriverWait wait = new WebDriverWait(driver(), waitTime);
       wait.until(Conditions.click(find()));
    }

    public void hoverAndClick(By clickLocator) {
        WebDriverWait wait = new WebDriverWait(driver(), waitTime);
        Actions builder = new Actions(driver());
        Actions hoverOverRegistrar = builder.moveToElement(find());
        hoverOverRegistrar.build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(clickLocator));
        driver().findElement(clickLocator).click();
    }

    @Step("Is element present: {this}")
    public boolean isPresent(int sec){
        WebDriverWait wait = new WebDriverWait(driver(), sec);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    @Step("Is element clickable: {this}")
    public boolean isClickable() {
        WebDriverWait wait = new WebDriverWait(driver(), 15);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Is element NOT present: {this}")
    public boolean isNotPresent(int sec){
        WebDriverWait wait = new WebDriverWait(driver(), sec);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    @Step("Is element present: {this}")
    public boolean isPresent(){
        return isPresent(0);
    }

    @Step("Get text from: {this}")
    public String getText(){
       return find().getText();
    }

    @Step("Get attribute '{0}' from: {this}")
    public String getAttribute(String name){
        return find().getAttribute(name);
    }


    @Step("Get CssValue '{0}' from: {this}")
    public String getCssValue(String propertyName){
       return find().getCssValue(propertyName);
    }



    @Override
    public String toString() {
        return "\""+name+"\""+" "+by;
    }

}
