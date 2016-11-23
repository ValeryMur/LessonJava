package victoriabrides;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private By validationMsg = By.cssSelector("form[class='lf-cont']>div[class='email error']");

    public void cleanBrowser() {
        deleteCookies();
    }
    public  void openSignUp1(String url){
        get("https://victoriabrides.com/signup/1?partner=0&subid=iuh");
    }
    public void openLoginPage(String url){
        get("https://victoriabrides.com/#auth/login");
    }
    public void typeEmail(String email){
        type(userEmail, email);
    }
    public void typePassword(String password){
        type(userPassword, password);
    }
    public void clickLoginButton(){
        click(loginButton);
    }
    public void clickSignInButton(){
        click(signinButtonPopup);
    }
    public void typeEmailPopup(String email){
        type(userEmailPopup, email);
    }
    public void typePasswordPopup(String password){
        type(userPasswordPopup, password);
    }
    public void clickLoginButtonPopup(){
        click(loginButtonPopup);
    }

    public void loginVB(String email, String password, String url){
        cleanBrowser();
        openLoginPage(url);
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

    public void loginPopupVB(String email, String password, String url){
        cleanBrowser();
        openSignUp1(url);
        clickSignInButton();
        typeEmailPopup(email);
        typePasswordPopup(password);
        clickLoginButtonPopup();
    }

    //проверки что заалогинилась делать в тесте или в pageObject???

}
