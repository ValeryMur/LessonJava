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

    @Test
    @Parameters ({"password","email","url"})
    public void loginVBpageSignUp(){
       // loginVictoriabrides.loginVB(email, password, url);
    }


}
