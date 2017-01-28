package signIn;

import core.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
//import site.signIn.ISignIn;

/**
 * Created by valeria on 18.01.2017.
 */
public class SignInSignup5 extends Actions implements ISignIn {
    public SignInSignup5(WebDriver driver) {
        super(driver);
    }
    //private By signinOnSignup5 = By.cssSelector(".show_login_popup");
    private By signinOnSignup5 = By.xpath("//div/p/a[@class='show_login_popup']");
    private By userEmail = By.id("email");
    private By userPassword = By.id("password");
    private By loginButton = By.cssSelector(".b-btn.green.bt_si");

    @Step
    @Override
    public void clickButtonOpenLoginForm() {
        click(signinOnSignup5);
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
    public void login(String email, String password) throws InterruptedException {
        cleanBrowser();
        //clickButtonOpenLoginForm();
        //Thread.sleep(3000);
        putEmail(email);
        putPassword(password);
        clickSignInButton();
    }
}
