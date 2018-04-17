package com.example.dioritbajrami.restapitest.CreateUserAPI;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by dioritbajrami on 17.04.18.
 */

public interface UserClient {

    @POST ("user")
    Call<User> createAccount(@Body User user);

}
