package retroFitAPI;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by valeria on 27.01.2017.
 */
public interface TrelloApiInterface {

    @GET("/1/boards/{board_id}")
    Call<ResponseBody> getBoardInfo(@Path("board_id") String board_id, @Query("list") String lists,
                                    @Query("list_fields") String list_fields, @Query("fields") String fields,
                                    @Query("key") String key, @Query("token") String token);
}
