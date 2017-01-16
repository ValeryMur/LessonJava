package victoriabrides;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by valeria on 23.11.2016.
 */
public class PageObjectLoginVB extends ActionWithWebelement {

    public  PageObjectLoginVB(WebDriver driver){
        super(driver);
    }

    private By userEmail = By.id("email");
    private By userPassword = By.id("password");
    private By loginButton = By.cssSelector(".b-btn.green.bt_si");
    private By signinButtonPopup = By.cssSelector(".b-btn.grey.sign-btn");
    private By userEmailPopup = By.id("reg_email");
    private By userPasswordPopup = By.id("reg_pass");
    private By loginButtonPopup = By.cssSelector("form[class='lf-cont']>button");
    private By validationMsgPopup = By.cssSelector("form[class='lf-cont']>div[class='email error']");

    @Step
    public void cleanBrowser() {
        deleteCookies();
    }
    public  void openSignUp1(String url){
        driver.get("https://victoriabrides.com/signup/1?partner=0&subid=iuh");
    }
    @Step
    public void openLoginPage(String url){
        driver.get("https://victoriabrides.com/#auth/login");
    }
    @Step
    public void typeEmail(String email){
        type(userEmail, email);
    }
    @Step
    public void typePassword(String password){
        type(userPassword, password);
    }
    @Step
    public void clickLoginButton(){
        click(loginButton);
    }
    @Step
    public void clickSignInButton(){
        click(signinButtonPopup);
    }
    @Step
    public void typeEmailPopup(String email){
        type(userEmailPopup, email);
    }
    @Step
    public void typePasswordPopup(String password){
        type(userPasswordPopup, password);
    }
    @Step
    public void clickLoginButtonPopup(){
        click(loginButtonPopup);
    }

    @Step
    public void loginVB(String email, String password, String url){
        cleanBrowser();
        openLoginPage(url);
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

    @Step
    public void loginPopupVB(String email, String password, String url){
        cleanBrowser();
        openSignUp1(url);
        clickSignInButton();
        typeEmailPopup(email);
        typePasswordPopup(password);
        clickLoginButtonPopup();
    }
}
