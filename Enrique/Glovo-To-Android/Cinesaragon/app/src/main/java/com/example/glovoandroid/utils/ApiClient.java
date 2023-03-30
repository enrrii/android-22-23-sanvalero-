package com.example.glovoandroid.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    /*public static final String BASE_URL =
            "http://172.21.3.34:8080/RakutenTV/webresources/";*/

    public static final String BASE_URL1 = //"http://192.168.104.64:8080/GlovoNetBeans/webresources/";
             "http://192.168.104.65:8080/GlovoNetBeans/webresources/";
            //"http://192.168.104.78:8080/GlovoNetBeans/webresources/"; -> Fila de atrás






    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL1)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

