package lesson15PageObject;

import lesson6.User;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.server.Authentication;
import ru.yandex.qatools.allure.annotations.Step;

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


@Step
        public  void login (User user) {
//            driver.findElement(userEmail).click();
//            driver.findElement(userEmail).sendKeys(user.email);
//            driver.findElement(userPassword).click();
//            driver.findElement(userPassword).sendKeys(user.password);
//            driver.findElement(submitBtn).click();

           type(userEmail, user.email);
           type(userPassword, user.password);
           click(submitBtn);


        }

        @Step
        public void click(By by){
            driver.findElement(by).click();
 }

        @Step
        public  void type(By by, String text){
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(text);
        }
    }
}
