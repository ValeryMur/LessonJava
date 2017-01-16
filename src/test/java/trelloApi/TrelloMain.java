package trelloApi;


import okhttp3.OkHttpClient;

import okhttp3.Request;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 13.01.2017.
 */
public class TrelloMain {

    private static final String KEY = "db63b6b343e70176d0978f46a39d29b6";
    private static final String TOKEN = "52dcff78f8d9b3f972e347311089c2e2473f48f11ee21a86170fda015617d9cd";

    private static final String BOARD_ID= "gfpvcuaY";

    OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build();

    public  static  String host = "api.trello.com";
    protected  static  String scheme = "https";

    protected URIBuilder uriBuilder = new URIBuilder().setScheme(scheme).setHost(host);

    protected URIBuilder getUriBuilder(){
        return new URIBuilder().setScheme(scheme).setHost(host).setParameter("key", KEY).setParameter("token", TOKEN);
    }

    public String getBords()throws URISyntaxException, IOException{
        //https://api.trello.com/1/boards/4eea4ffc91e31d1746000046?lists=open&list_fields=name&fields=name,desc&key=[application_key]&token=[optional_auth_token]
        URI uri = getUriBuilder().setPath("/1/boards/"+BOARD_ID).setParameter("lists", "open").setParameter("list_fields", "name").setParameter("fields", "name,desc").build();
        Request request = new Request.Builder().get().url(uri.toURL()).build();
        String json = client.newCall(request).execute().body().string();
        System.out.print(json);
        return  json;
    }

    @Test
    public void getBoardTest() throws URISyntaxException, IOException {
        getBords();
    }

}
