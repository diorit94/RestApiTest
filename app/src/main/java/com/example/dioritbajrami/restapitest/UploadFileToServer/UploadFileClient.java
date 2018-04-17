package com.example.dioritbajrami.restapitest.UploadFileToServer;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by dioritbajrami on 17.04.18.
 */

public interface UploadFileClient {

    //We add the Photo with the description, where the Photo is devided into Parts
    @Multipart
    @POST("upload")
    Call<ResponseBody> uploadPhoto(
            @Part ("description")RequestBody description,
            @Part MultipartBody.Part photo
            );
}
