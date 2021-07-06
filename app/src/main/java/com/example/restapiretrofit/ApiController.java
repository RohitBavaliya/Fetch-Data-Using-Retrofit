package com.example.restapiretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController
{
    /*
    * 1. Step-1 : define url
    * 2. Step-2 : Create an Objects of ApiController and Retrofit
    * 3. Step-3 : Create Constructor of ApiController and call retrofit object inside
    * 4. Step-4 : If ApiController object is null than create new object
    * 5. Step-5 : Call all Api
    * */
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
