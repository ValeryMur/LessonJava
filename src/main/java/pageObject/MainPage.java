package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by valeria on 10.10.2016.
 */
public class MainPage {
    private WebDriver driver;

    //public void setDriver (WebDriver driver){this.driver = driver;}

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    public void typeEmail(String email){
        driver.findElement(By.cssSelector("#user-email")).clear();
        driver.findElement(By.cssSelector("#user-email")).sendKeys(email);
    }

    public void typePassword(String password){
        driver.findElement(By.cssSelector("#user-password")).clear();
        driver.findElement(By.cssSelector("#user-password")).sendKeys(password);
    }


    public void clickLoginButton(){
        driver.findElement(By.cssSelector("#sign-in-form .submit")).click();
    }


    public void login(String email, String password){
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

}
