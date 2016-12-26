package lesson19.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by valeria on 26.12.2016.
 */
public class GetResponse {
    public String origin;
    public String url;
    public Headers headers;
    public Args args;

    @Override
    public String toString() {
        return "GetResponse{" +
                "origin='" + origin + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", args=" + args +
                '}';
    }

    public class Args {

    }

    public class Headers {
        @SerializedName("User-Agent")
        public String userAgent;

        @Override
        public String toString() {
            return "Headers{" +
                    "userAgent='" + userAgent + '\'' +
                    '}';
        }
    }

}
