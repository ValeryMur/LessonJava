package lesson19;

import com.google.gson.Gson;
import lesson19.models.GetResponse;
import okhttp3.*;
import okhttp3.Request;
import org.junit.runner.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by valeria on 26.12.2016.
 */
public class TestOkHttp {
    Gson gson= new Gson();
    String url= "http://httpbin.org/get?a=b";

    @Test
    public void okMethod()  throws IOException {
        System.out.println(run(url));
        String resp = run(url);
        GetResponse getResp = gson.fromJson(resp, GetResponse.class);
        System.out.println(getResp.origin);
        System.out.println(getResp.url);
        System.out.println(getResp);
        }

        @Test
        public void testPost() throws IOException{
            System.out.println(run1("http://httpbin.org/post"));

        }

    String run1(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("alalal", "3")
                .add("jack", "Sparrow")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Jack", "Sparow")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Jack","Sparow")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
