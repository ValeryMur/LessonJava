package vkApi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Inna_Hrydiakina on 22.01.2017.
 */
public class UploadUrlResponse {
    //{"response":{"upload_url":"https:\/\/pu.vk.com\/c626520\/upload.php?act=do_add&mid=15892555&aid=240501230&gid=0&hash=74b435d83be429a5de5f1986a77092b5
    // &rhash=ff4e2deedc67678a41199fa27393fdad&swfupload=1&api=1","aid":240501230,"mid":15892555}}

    public Response response;

    public class Response {

        @SerializedName("upload_url")
        public String uploadUrl;

        @SerializedName("aid")
        public int aid;

        @SerializedName("mid")
        public int mid;

        @Override
        public String toString() {
            return "Response{" +
                    "uploadUrl='" + uploadUrl + '\'' +
                    ", aid=" + aid +
                    ", mid=" + mid +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UploadUrlResponse{" +
                "response=" + response +
                '}';
    }
}
