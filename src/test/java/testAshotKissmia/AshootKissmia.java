package testAshotKissmia;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static testMultiplyBrowsers.BrowserFactoryM.driver;

/**
 * Created by valeria on 30.01.2017.
 */
public class AshootKissmia {
    WebDriver driver = new ChromeDriver();

    private static String RESOURCES_LAYOUT_DIR = "C:/testScreensoots";

    private static String expectedDir = RESOURCES_LAYOUT_DIR+"/expected/";
    private static String actualDir = RESOURCES_LAYOUT_DIR+"/actual/";
    private static String diffDir = RESOURCES_LAYOUT_DIR+"/diff/";
    private static String resultGifs = RESOURCES_LAYOUT_DIR+"/gifs/";

    @Test
    public void mainPageKissmia() throws IOException {
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("https://kismia.com/");
        Screenshot screenchot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver());
        createFolder(actualDir);
        createFolder(expectedDir);
        createFolder(diffDir);
        File actualFile = new File(actualDir+"mainPage.png");
        ImageIO.write(screenchot.getImage(), "png", actualFile);

        File expectedFile = new File(expectedDir + "mainPage1.png");
        if(!expectedFile.exists()){
            ImageIO.write(screenchot.getImage(), "png", expectedFile);
        }

        Screenshot expectedScreenshot = new Screenshot(ImageIO.read(new File(expectedDir+"mainPage.png")));

        ImageDiff diff = new ImageDiffer().withColorDistortion(15)
        .makeDiff(expectedScreenshot, screenchot);

        File diffFile = new File(diffDir + "mainPage.png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);

        int diffSize = diff.getDiffSize();

        System.out.println(diffSize);
        Assert.assertEquals(diffSize, 0, "Alallala");
    }

    private static void createFolder(String path){
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
    }
}
