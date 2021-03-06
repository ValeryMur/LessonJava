package core;

import org.testng.annotations.Test;

import java.util.Date;
import java.util.Random;

/**
 * Created by Inna_Hrydiakina on 17.09.2016.
 */
public class UniqueEmail {

    private static Random random = new Random((new Date()).getTime());

    public static String generateRandomString(int length) {
        char[] values = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
                '4', '5', '6', '7', '8', '9'};

        String out = "";

        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(values.length);
            out += values[idx];
        }
        return out;
    }

    public String uEmail() {
        String u = "autotestinna+" + generateRandomString(10) + "@gmail.com";
        System.out.println(u);
        return u;
    }

    @Test
    public void test(){
        uEmail();
    }

    /* другой рандом
    public Random random = new Random();
        int length = 10;
        String email = "autotest+"+ RandomStringUtils.randomNumeric(length) + "@gmail.com";
     */
}
