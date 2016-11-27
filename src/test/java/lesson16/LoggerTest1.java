package lesson16;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by ASUS PC on 27.11.2016.
 */
public class LoggerTest1 {
    public WebDriver driver;

    //так можно логировать каждый шаг подписывая его, по сылке писано как это делать и сохранять инво в xml
    // http://toolsqa.wpengine.com/selenium-webdriver/testng-reporters-asserts/

    private static Logger logger = LoggerFactory.getLogger(LoggerTest1.class);

    @Test
    public void alalaalalal() {
        System.out.println("Jack");
        logger.info("we print Jack");
    }
}
