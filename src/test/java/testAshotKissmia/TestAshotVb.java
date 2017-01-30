package testAshotKissmia;

import core.Browser;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Inna_Hrydiakina on 30.01.2017.
 */
public class TestAshotVb extends Browser {

    private static String RESOURCES_LAYOUT_DIR = "C:/testScreensoots";

    private static String expectedDir = RESOURCES_LAYOUT_DIR+"/expected/";
    private static String actualDir = RESOURCES_LAYOUT_DIR+"/actual/";
    private static String diffDir = RESOURCES_LAYOUT_DIR+"/diff/";
    private static String resultGifs = RESOURCES_LAYOUT_DIR+"/gifs/";

    @Test
    public void mainPageVb() throws IOException, InterruptedException, AWTException {

        Robot bot = new Robot();
        bot.mouseMove(0, 0);

        driver().manage().window().setSize(new Dimension(1366, 768));
        driver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver().get("https://victoriahearts.com");
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver());

        createFolder(actualDir);
        createFolder(expectedDir);
        createFolder(diffDir);

        File actualFile = new File(actualDir + "mainPage.png");
        ImageIO.write(screenshot.getImage(), "png", actualFile);

        File expectedFile = new File(expectedDir + "mainPage.png");
        if(!expectedFile.exists()){
            ImageIO.write(screenshot.getImage(), "png", expectedFile);
        }

        Screenshot expectedScreenshot = new Screenshot(ImageIO.read(new File(expectedDir + "mainPage.png")));

        ImageDiff diff = new ImageDiffer().withColorDistortion(15)
                .makeDiff(expectedScreenshot, screenshot);

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
