package lesson8TestNG;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by valeria on 24.10.2016.
 */
public class TestNgDataProvider {



    @DataProvider
    public Object[][]emails(){
        return new Object[][]{
                {"email@gf.com", "ghjg"},
                {"email1@gf.com", "ghjj"},
                {"email2@gf.com", "ghiui"},
        };
    }

    @Test (dataProvider= "emails")
    public void emailValidationLogin(String emails, String password) {
        System.out.println(emails + password);

    }
}
