package com.example.dioritbajrami.restapitest.GetDataFromServer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dioritbajrami on 13.04.18.
 */

public interface GitHubClient {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user); //we tell retrofit that whatever we pass here will be replaced one line above

}
