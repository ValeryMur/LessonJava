package signIn;

import core.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
//import site.signIn.ISignIn;

/**
 * Created by valeria on 18.01.2017.
 */
public class SignInLand extends Actions implements ISignIn {
    public SignInLand(WebDriver driver) {
        super(driver);
    }

    private By signinButtonPopup = By.cssSelector(".b-btn.grey.sign-btn.vbsinginbtn");
    //private By signinButtonPopup = By.xpath(".//div[@class=\"popup-trigger\"]/button");
    private By userEmailPopup = By.id("reg_email");
    private By userPasswordPopup = By.id("reg_pass");
    private By loginButtonPopup = By.xpath("//div/form[1]/button[1]");

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
