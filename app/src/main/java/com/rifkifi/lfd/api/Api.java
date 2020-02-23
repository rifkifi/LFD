package com.rifkifi.lfd.api;

import com.rifkifi.lfd.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("/login")
    Call<LoginResponse> praktikanLogin(
            @Field("noBP") String noBP,
            @Field("password") String password
    );
}
