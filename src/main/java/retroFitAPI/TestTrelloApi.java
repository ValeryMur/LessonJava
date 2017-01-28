package retroFitAPI;

import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by valeria on 27.01.2017.
 */
public class TestTrelloApi {

    @Test
    public  void  alalala() throws IOException {
        TrelloRestClient restClient = new TrelloRestClient();
        restClient.trelloApi.getBoardInfo("gfpvcuaY", "open", "name", "name, desc",
                TrelloRestClient.KEY, TrelloRestClient.TOKEN).execute();
    }
}
