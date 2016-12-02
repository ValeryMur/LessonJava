package lesson17Alur;

import lesson6.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by valeria on 28.11.2016.
 */
public class TryAlurePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

  /*  //зачем писать метод test1 если у нас есть класс class TryAllure где мы вызываем все степы ниже
    @Test
    public void test1() {
        step1();
        step2();
        step3();
    }*/

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

//    @Step
//    public void step3() {
//        logger.info("step3 in progress");
//    }

    @Step("Залогиниться с имейлом {0} и паролем {1}")
    public void login(String email, String password){
        logger.info("step LOGIN");
    }

    @Step("this)Registration {0}")
    public void  registration(User user){
        logger.info("reg user: "+user);

    }

    @Override
    public String toString(){
        return "TryAllurePageClass!!!";
    }


}
