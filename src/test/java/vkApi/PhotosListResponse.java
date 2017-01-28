package vkApi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Inna_Hrydiakina on 23.01.2017.
 */
public class PhotosListResponse {

    @SerializedName("server")
    public int server;

    @SerializedName("photos_list")
    public String photosList;

    @SerializedName("aid")
    public int aid;

    @SerializedName("hash")
    public String hash;

    @Override
    public String toString() {
        return "PhotosListResponse{" +
                "server=" + server +
                ", photosList='" + photosList + '\'' +
                ", aid=" + aid +
                ", hash='" + hash + '\'' +
                '}';
    }
}
