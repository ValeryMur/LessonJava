package mailSent;

import mail.EmailSender;
import org.testng.annotations.Test;

/**
 * Created by valeria on 16.01.2017.
 */
public class SentMailTest {

    @Test
    public void sentEmailToMe() {
        EmailSender emailSender = new EmailSender("valery7ko@gmail.com");
        emailSender.sendEmail("Test email", "My lovely test email");
    }

}
