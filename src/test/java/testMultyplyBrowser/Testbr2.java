package testMultyplyBrowser;

import org.testng.annotations.Test;
import testMultiplyBrowsers.BrowserFactoryM;

/**
 * Created by valeria on 23.01.2017.
 */
public class Testbr2 extends BrowserFactoryM{

    @Test
    public void alala() throws InterruptedException {
        driver().get("https://www.google.com.ua/");
        Thread.sleep(10000);
        driver().get("https://kismia.com/");
    }
}
