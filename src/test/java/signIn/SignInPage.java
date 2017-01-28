package signIn;

import core.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
//import site.signIn.ISignIn;

/**
 * Created by valeria on 17.01.2017.
 */
public class SignInPage extends Actions implements ISignIn{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private By userEmail = By.id("email");
    private By userPassword = By.id("password");
    private By loginButton = By.cssSelector(".b-btn.green.bt_si");


    @Override
    public void clickButtonOpenLoginForm() {
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
        putEmail(email);
        putPassword(password);
        clickSignInButton();
    }
}
