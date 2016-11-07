package lesson8TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by valeria on 24.10.2016.
 */
public class LoginTest {

    @Test
    @Parameters ({"email","password"})
    public void aTestLogin(@Optional("lalala")String email, @Optional("678687") String password) {
        System.out.println(email);
        System.out.println(password);
        //@Optional - парамеир по дефолту, не берет с эксемель, а бурет этот
    }

}
