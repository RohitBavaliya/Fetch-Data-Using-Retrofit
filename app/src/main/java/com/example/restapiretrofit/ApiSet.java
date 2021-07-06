package com.example.restapiretrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

// Contains all api methods
public interface ApiSet {
    @FormUrlEncoded
    @POST("user_registration.php")
    Call<ResponseModel> getRegister
            (
               @Field("name") String name,
               @Field("email") String email,
               @Field("password") String password
            );
}
