package lesson8TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by valeria on 24.10.2016.
 */
public class TestNGMethodDepend {
    @Test (priority=3)
    public void aTest(){
        System.out.println("a Test");
    }

    @Test (priority=2, invocationCount = 2)
    public void bTest(){
        System.out.println("b Test");
    }

    @Test (priority=1)
    public void cTest(){
        Assert.fail();
        System.out.println("c Test");
    }

    @Test (dependsOnMethods = "cTest", alwaysRun = true)
    public void noTest(){

        System.out.println("no Test");
    }

}
