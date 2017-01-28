package retroFitAPI;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by valeria on 27.01.2017.
 */
public class TrelloRestClient {
    public  TrelloApiInterface trelloApi;

    public static final String KEY = "db63b6b343e70176d0978f46a39d29b6";
    public static final String TOKEN = "52dcff78f8d9b3f972e347311089c2e2473f48f11ee21a86170fda015617d9cd";

    private  static  final  String BASE_URL = "https://api.trello.com";

    public TrelloRestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new HTTPLogInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        trelloApi = retrofit.create(TrelloApiInterface.class);
    }
}
