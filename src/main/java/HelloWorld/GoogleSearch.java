package HelloWorld;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 26.09.2016.
 */


        public class GoogleSearch {

    String mySearchWorld = "Hello world!!!";

    @Test
    public void findSomeWorldInGoogle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

//запускаем брузер

        driver.get("https://www.google.com.ua");

        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys(mySearchWorld);

        driver.findElement(By.name("btnG")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#search .g .rc a")).click();
        Thread.sleep(3000);

        String title = driver.getTitle();
        System.out.println(title);

        driver.close();
        driver.quit();
    }
}
