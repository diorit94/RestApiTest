package com.example.dioritbajrami.restapitest.AuthenticationREST;

import com.example.dioritbajrami.restapitest.CreateUserAPI.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by dioritbajrami on 17.04.18.
 */

public interface AuthenticationClient {

    @GET("user")
    Call<UserLogin> getUser(@Header("Authorization") String authHeader);

}
