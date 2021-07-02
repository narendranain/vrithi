package com.example.vrithiu.model;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CallAPI {
    @FormUrlEncoded
    @POST("phone_number_login")
    Call<LoginUser> userlogin(
            @Field("number") String mobileno
    );
    @FormUrlEncoded
    @POST("verify_otp")
    Call<OtpModel> otplogin(
            @Field("number") String mobileno,
            @Field("otp") Integer otp
    );
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("test_profile_list")
    Call<JSONArray> getuserdetails(
            @Header("Authorization") String token
    );

}
