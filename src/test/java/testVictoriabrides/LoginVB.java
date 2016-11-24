package testVictoriabrides;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import victoriabrides.Browser;
import victoriabrides.PageObjectLoginVB;

/**
 * Created by ASUS PC on 23.11.2016.
 */
public class LoginVB extends Browser {
    public PageObjectLoginVB loginVictoriabrides = new PageObjectLoginVB(driver);
    /*
    String email;   //= "vbvaleramail+35@mail.ru";
    String password; //="test_123";
    String url; //= "https://victoriabrides.com/#auth/login";
*/
    @Test
    @Parameters ({"email", "password", "url"})
    public void loginVBpageSignUp(String email, String password, String url){
       loginVictoriabrides.loginVB(email, password, url);
    }

    @Test
    @Parameters ({"email", "password", "url"})
    public void loginVBpopupSignUp(String email, String password, String url){
        loginVictoriabrides.loginPopupVB(email, password, url);
    }

}
