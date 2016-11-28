package testVictoriabrides;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by valeria on 28.11.2016.
 */
public class TestSoftAss {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void multiplyAsserts(){
        softAssert.assertTrue(false, "First false");
        softAssert.assertTrue(false, "First false");
        softAssert.assertTrue(false, "First false");
        softAssert.assertEquals(1, 2, "numbers error");
        softAssert.assertEquals(1, 1, "numbers error");
        softAssert.assertTrue(false, "First false");
        softAssert.assertTrue(false, "First false");
        softAssert.assertTrue(false, "First false");
        softAssert.assertTrue(false, "First false");
        softAssert.assertTrue(false, "First false");

        softAssert.assertAll();

    }


}
