package signIn;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by valeria on 17.01.2017.
 */
public interface ISignIn {

    @Step
    public void clickButtonOpenLoginForm();
    @Step
    public  void putEmail(String email);
    @Step
    public  void putPassword(String password);
    @Step
    public void clickSignInButton();
    @Step
    public void login(String email, String password) throws InterruptedException;

}
