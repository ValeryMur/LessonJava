package signIn;

import core.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
//import site.signIn.ISignIn;

/**
 * Created by valeria on 17.01.2017.
 */
public class PopupSignIn extends Actions implements ISignIn {
    public PopupSignIn(WebDriver driver) {
        super(driver);
    }

    private By signinButtonPopup = By.cssSelector(".b-btn.grey.sign-btn");
    private By userEmailPopup = By.id("reg_email");
    private By userPasswordPopup = By.id("reg_pass");
    private By loginButtonPopup = By.cssSelector("form[class='lf-cont']>button");

    @Step
    public void cleanBrowser() {
        deleteCookies();
    }

    @Step
    @Override
    public void clickButtonOpenLoginForm() {
        click(signinButtonPopup);
    }

    @Step
    @Override
    public void putEmail(String email) {
        type(userEmailPopup, email);
    }

    @Step
    @Override
    public void putPassword(String password) {
        type(userPasswordPopup, password);
    }

    @Step
    @Override
    public void clickSignInButton() {
        click(loginButtonPopup);
    }

    @Step
    @Override
    public void login(String email, String password) {
        cleanBrowser();
        //clickButtonOpenLoginForm();
        putEmail(email);
        putPassword(password);
        clickSignInButton();
    }
}
