package vkApi;

import com.google.gson.Gson;
import okhttp3.*;
import org.apache.http.client.utils.URIBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Inna_Hrydiakina on 22.01.2017.
 */
public class VkApi {

    OkHttpClient client = new OkHttpClient();

    public static String host = "api.vk.com/method/";
    protected static String scheme = "https";

    private static final String ACCESS_TOKEN = "свой ACCESS_TOKEN";
    private static final String ALBUM_ID = "свой ALBUM_ID";

    protected URIBuilder getUriBuilder(){
        return new URIBuilder().setScheme(scheme).setHost(host);
    }

    private String strUploadUrl;
    private String strPhotosList;
    private int intServer;
    private String strHash;

    public void getUploadUrl() throws IOException, URISyntaxException {
        //https://api.vk.com/method/photos.getUploadServer?
        // access_token=12345
        // &album_id=123
        String thisMethod = "photos.getUploadServer";
        URI url = getUriBuilder().setPath(thisMethod)
                .setParameter("access_token", ACCESS_TOKEN)
                .setParameter("album_id", ALBUM_ID)
                .build();
        Request request = new Request.Builder().get().url(url.toURL()).build();
        String responseUploadUrl = client.newCall(request).execute().body().string();
        //System.out.println("Upload_url: " + jsonBodyResult);
        Gson gson = new Gson();
        UploadUrlResponse uploadUrlResponse = gson.fromJson(responseUploadUrl, UploadUrlResponse.class);
        strUploadUrl = uploadUrlResponse.response.uploadUrl;
        System.out.println("String uploadUrl " + strUploadUrl);
    }

    public void transferFile() throws IOException {
        //https://pu.vk.com/c626520/upload.php?act=do_add&mid=15892555&aid=240501230&gid=0&hash=74b435d83be429a5de5f1986a77092b5&rhash=ff4e2deedc67678a41199fa27393fdad&swfupload=1&api=1
        File sourceFile = new File("C:\\7.jpg");
        String filename = sourceFile.getName();
        //System.out.println(filename);
        final MediaType MEDIA_TYPE_JPG = MediaType.parse("image/*");
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file1", filename, RequestBody.create(MEDIA_TYPE_JPG, sourceFile))
                .build();
        Request request = new Request.Builder()
                .url(strUploadUrl)
                .post(requestBody)
                .build();
        String responsePhotosList = client.newCall(request).execute().body().string();
        //System.out.println("responsePhotosList: " + responsePhotosList);
        Gson gson = new Gson();
        PhotosListResponse photosListResponse = gson.fromJson(responsePhotosList, PhotosListResponse.class);
        strPhotosList = photosListResponse.photosList;
        intServer = photosListResponse.server;
        strHash = photosListResponse.hash;
        System.out.println("String strPhotosList " + strPhotosList);
    }

    public void savePhoto() throws URISyntaxException, IOException {
        //https://api.vk.com/method/photos.save?
        // access_token=12345&
        // album_id=123
        // &server=626520
        // &photos_list=[{"photo":"0c403477ff:w","sizes":[["s","626520555","4f712","RUua7s7rB4c",75,47],["m","626520555","4f713","AcRWs6EexzY",130,81],["x","626520555","4f714","3KEgBEY9NJc",604,377],["y","626520555","4f715","INkrv0gjwtY",807,504],["z","626520555","4f716","Iy5olbWQpcA",1280,800],["w","626520555","4f717","uTD6EYpN47w",2560,1600],["o","626520555","4f718","IE7cOHV02YI",130,87],["p","626520555","4f719","2dqlx30SF70",200,133],["q","626520555","4f71a","Qz_CeosWJ-k",320,213],["r","626520555","4f71b","8o5OK9so33A",510,340]],"kid":"6fa4179af344651a7522a39556e492a0","debug":"xswmwxwywzwwwowpwqwrw"}]
        // &hash=085ad08e8425378589fb4e55c30e0ea4
        String thisMethod = "photos.save";
        URI url = getUriBuilder().setPath(thisMethod)
                .setParameter("access_token", ACCESS_TOKEN)
                .setParameter("album_id", ALBUM_ID)
                .setParameter("server", String.valueOf(intServer))
                .setParameter("photos_list", strPhotosList)
                .setParameter("hash", strHash)
                .build();
        Request request = new Request.Builder().get().url(url.toURL()).build();
        String responseSavedPhoto = client.newCall(request).execute().body().string();
        System.out.println(responseSavedPhoto);
    }

    @Test
    public void testUploadPhoto() throws IOException, URISyntaxException {
        getUploadUrl();
        transferFile();
        savePhoto();
    }
}
