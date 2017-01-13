package lesson19;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by valeria on 12.01.2017.
 */
public class TestTrelloApi {
    Gson gson= new Gson();

    String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Jack","Sparow")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Accept-Encoding", "gzip, deflate, sdch")
                .header("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4")
                .header("Cookie", "k2=v2; k1=v1; _gat=1; _ga=GA1.2.764998044.1482737465")
                .header("Host", "httpbin.org")
                .header("Referer", "http://httpbin.org/")
                .header("Upgrade-Insecure-Requests", "1")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Test
    public void testPost() throws IOException{
        System.out.println(run("https://api.trello.com/1/boards/gfpvcuaY?lists=open&list_fields=name&fields=name,desc&key=db63b6b343e70176d0978f46a39d29b6&token=52dcff78f8d9b3f972e347311089c2e2473f48f11ee21a86170fda015617d9cd"));
    }
}
