package signIn;

import core.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
//import site.signIn.ISignIn;

/**
 * Created by valeria on 18.01.2017.
 */
public class SignInSignup3 extends Actions implements ISignIn {
    public SignInSignup3(WebDriver driver) {
        super(driver);
    }

    private By signinOnSignup3 = By.cssSelector(".contactus-link");
    private By userEmail = By.id("email");
    private By userPassword = By.id("password");
    private By loginButton = By.cssSelector(".b-btn.green.bt_si");

    @Step
    @Override
    public void clickButtonOpenLoginForm() {
        click(signinOnSignup3);
    }

    @Step
    public void cleanBrowser() {
        deleteCookies();
    }

    @Step
    @Override
    public void putEmail(String email) {
        type(userEmail, email);
    }

    @Step
    @Override
    public void putPassword(String password) {
        type(userPassword, password);
    }

    @Step
    @Override
    public void clickSignInButton() {
        click(loginButton);
    }

    @Step
    @Override
    public void login(String email, String password) {
        cleanBrowser();
        clickButtonOpenLoginForm();
        putEmail(email);
        putPassword(password);
        clickSignInButton();
    }
}
