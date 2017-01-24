package core;

import API.responsesJson.GetGeoResponse;
import API.responsesJson.PostAuthResponse;
import com.jdbc.PixelLog;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Created by Inna_Hrydiakina on 21.09.2016.
 */
public class AllureAttachments {

    @Attachment(value = "{1}", type = "text/plain")
    public static String txtAttachment(String text, String name) {
        System.out.println("(" + name + "): ");
        System.out.println(text);
        return text;
    }

    @Attachment(value = "{1}", type = "text/plain")
    public static PixelLog pixelLogAttachment(PixelLog pixelLog, String name) {
        System.out.println("(" + name + "): ");
        System.out.println(pixelLog);
        return pixelLog;
    }

    @Attachment(value = "{1}", type = "text/plain")
    public static PostAuthResponse postAuthResponseAttachment (PostAuthResponse postAuthResponse, String name) {
        System.out.println("(" + name + "): ");
        System.out.println(postAuthResponse);
        return postAuthResponse;
    }

    @Attachment(value = "{1}", type = "text/plain")
    public static GetGeoResponse getGeoResponse (GetGeoResponse getGeoResponse, String name) {
        System.out.println("(" + name + "): ");
        System.out.println(getGeoResponse);
        return getGeoResponse;
    }

}
