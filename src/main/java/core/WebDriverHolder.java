package core;

import org.openqa.selenium.WebDriver;

/**
 * Created by Inna_Hrydiakina on 28.11.2016.
 */
public class WebDriverHolder {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        WebDriverHolder.driver = driver;
    }
}
