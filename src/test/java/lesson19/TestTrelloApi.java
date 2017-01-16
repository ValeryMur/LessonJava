package lesson19;

import com.google.gson.Gson;
import okhttp3.*;
import org.apache.http.client.utils.URIBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 12.01.2017.
 */
public class TestTrelloApi {
    Gson gson= new Gson();
    private static final String BOARD_ID= "58775801980359d04a818709";
    private static final String KEY = "db63b6b343e70176d0978f46a39d29b6";
    private static final String TOKEN = "52dcff78f8d9b3f972e347311089c2e2473f48f11ee21a86170fda015617d9cd";
    private static final String LIST_ID= "587bdaa75263a91287813d31";


    @Test
    public void createList () throws IOException {
        String listName ="HomeTestList";
        String url = "https://api.trello.com/1/lists";
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("name", listName)
                .add("idBoard", BOARD_ID)
                .add("key", KEY)
                .add("token", TOKEN)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
    @Test
    public void createCard () throws IOException {
        String cardName ="TestCard1";
        String url = "https://api.trello.com/1/cards";
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("name", cardName)
                .add("idList", LIST_ID)
                .add("key", KEY)
                .add("token", TOKEN)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }



}
