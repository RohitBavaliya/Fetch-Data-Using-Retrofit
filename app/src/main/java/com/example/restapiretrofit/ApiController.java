package com.example.restapiretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController
{
    private final static String url = "http://192.168.46.146/api/";
    private static ApiController apiController;
    private static Retrofit retrofit;

    ApiController()
    {
        retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }

    public static synchronized ApiController getInstance()
    {
        if(apiController == null)
            apiController = new ApiController();
        return apiController;
    }

    ApiSet getApi()
    {
        return retrofit.create(ApiSet.class);
    }
}
