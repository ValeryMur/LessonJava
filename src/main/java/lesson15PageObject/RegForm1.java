package lesson15PageObject;

import lesson6.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.server.Authentication;

/**
 * Created by valeria on 21.11.2016.
 */
public class RegForm1 {
    WebDriver driver;
    public Login loginForm;

    public  RegForm1 (WebDriver driver){
        this.driver=driver;
        loginForm = new Login(driver);
    }

    private  By regTab = By.cssSelector("#form-registration");
    private By genderMale = By.cssSelector("label[for='iam-boy']");
    private By genderFemale = By.cssSelector("label[for='iam-girl']");

    public void clickRegTab(){
        driver.findElement(regTab).click();
    }
    public void selectGender(char gender) {
        if (gender == 'm') {
            driver.findElement(genderMale).click();
        } else {
            driver.findElement(genderFemale).click();
        }
    }
    public void regNewUser(User user) {
        clickRegTab();
        selectGender(user.gender);
    }

    public class Login {
        WebDriver driver;
        public Login(WebDriver driver){
            this.driver=driver;
        }
        By userEmail = By.cssSelector("#user-email");
        By userPassword = By.cssSelector("#user-password");
        By submitBtn =  By.cssSelector("#sign-in-form .submit");

        public  void login (User user) {
            driver.findElement(userEmail).click();
            driver.findElement(userEmail).sendKeys(user.email);
            driver.findElement(userPassword).click();
            driver.findElement(userPassword).sendKeys(user.password);
            driver.findElement(submitBtn).click();


        }
    }
}
