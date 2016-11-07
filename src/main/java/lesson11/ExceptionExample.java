package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 04.11.2016.
 */
public class ExceptionExample {
    WebDriver driver;
//    public void sleep() throws InterruptedException {
//        Thread.sleep(1000);
//
//    }
    public void sleep(int milles)  {
        try {
            Thread.sleep(milles);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void  alala(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://kismia.com/");

        driver.findElement(By.id("lst-ib"));

        try{
            driver.findElement(By.id("lst-ib")); //если в первом ошибка, то к другой части кода даж не дойдет
            driver.findElement(By.id("lst"));
            driver.findElement(By.id("lib"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("no such element");
        }
    }

    @Test
    public void mutchException(){
        int result=0;
        try {
            result = 5 / 0;
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("final blick");
        }
        System.out.println(result);
    }

    //try->finally можно писать без catch

    public void chackSearchPresents() throws Exception{
        driver.get("https://www.google.com.ua");

        driver = new ChromeDriver();

        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("Jack Sparrow");
        driver.findElement(By.name("btnG")).click();
        sleep(3000);
        List<WebElement> elements = driver.findElements(By.cssSelector(".srg .g"));

        int searchResultSize = elements.size();

        if (searchResultSize > 8) {
            throw new Exception("JACK is more then 8!");
        }
        System.out.println(searchResultSize);
    }

    @AfterTest
    public void tearDown(){
        System.out.println("tearDown");
        driver.close();
        driver.quit();
    }
}
