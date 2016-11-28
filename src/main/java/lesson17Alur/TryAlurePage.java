package lesson17Alur;

import lesson15PageObject.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by valeria on 28.11.2016.
 */
public class TryAlurePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test1() {
        step1();
        step2();
        step3();
    }

    @Step
    public void step1() {
        System.out.println("lala1");
        logger.info("step1 ok");
    }
    @Step
    public void step2() {
        System.out.println("lala2");
        logger.info("step2 ok");
    }
    @Step
    public void step3() {
        System.out.println("lala3");
        logger.info("step3 ok");
    }

}
