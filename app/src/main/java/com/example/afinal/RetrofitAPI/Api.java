package com.example.afinal.RetrofitAPI;


import com.example.afinal.Response.AboutResponse;
import com.example.afinal.Response.DashBorardResponse;
import com.example.afinal.Response.LoginRespose;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {


    //login
    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("login")
    Call<LoginRespose> login(

            @Field("email") String email,
            @Field("password") String password

    );


    //Dashboard
    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("dashboard")
    Call<DashBorardResponse> dashboard(

            @Field("api_token") String api_token

    );

    //About
    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("about")
    Call<AboutResponse> about(

            @Field("api_token") String api_token

    );



}
