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
    public Cookies cookies;

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
        public String Accept;
        @SerializedName("Accept-Encoding")
        public String acceptEncoding;
        @SerializedName("Accept-Language")
        public String acceptLanguage;
        public String Cookie;
        public String Host;
        public String Referer;
        @SerializedName("Upgrade-Insecure-Requests")
        public String upgradeInsecureRequests;

        @Override
        public String toString() {
            return "Headers{" +
                    "userAgent='" + userAgent + '\'' +
                    ", Accept='" + Accept + '\'' +
                    ", acceptEncoding='" + acceptEncoding + '\'' +
                    ", acceptLanguage='" + acceptLanguage + '\'' +
                    ", Cookie='" + Cookie + '\'' +
                    ", Host='" + Host + '\'' +
                    ", Refere='" + Referer + '\'' +
                    ", upgradeInsecureRequests='" + upgradeInsecureRequests + '\'' +
                    '}';
        }
    }

        public class Cookies {
            @SerializedName("_ga")
            public String ga;
            @SerializedName("_gat")
            public String gat;
            public String k1;
            public String k2;

            @Override
            public String toString() {
                return "Cookies{" +
                        "ga='" + ga + '\'' +
                        ", gat='" + gat + '\'' +
                        ", k1='" + k1 + '\'' +
                        ", k2='" + k2 + '\'' +
                        '}';
            }
        }



}
