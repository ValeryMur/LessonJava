package lesson17allure;

import lesson17Alur.TryAlurePage;
import org.testng.annotations.Test;

/**
 * Created by valeria on 28.11.2016.
 */
public class TryAllure {

    @Test
    public void testAllure(){
        TryAlurePage allurePage = new TryAlurePage();
        allurePage.step1();
        allurePage.step2();
        allurePage.step3();
    }
}
