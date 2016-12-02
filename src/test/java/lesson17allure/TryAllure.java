package lesson17allure;

import lesson17Alur.TryAlurePage;
import lesson6.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by valeria on 28.11.2016.
 */
public class TryAllure {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testAllure(){
        TryAlurePage allurePage = new TryAlurePage();
        allurePage.step1();
        allurePage.step2();
        allurePage.step3();
        allurePage.login("JACK@hg.kj","132142323");
        allurePage.registration(new User("JACK@hg.kj",24));
    }
}
