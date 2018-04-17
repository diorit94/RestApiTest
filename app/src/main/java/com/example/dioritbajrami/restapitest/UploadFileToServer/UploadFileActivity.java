package com.example.dioritbajrami.restapitest.UploadFileToServer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dioritbajrami.restapitest.R;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadFileActivity extends AppCompatActivity implements View.OnClickListener{

    EditText description;
    Button uploadBtn;

    private int IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file);

        description = (EditText)findViewById(R.id.descriptionID);
        uploadBtn = (Button)findViewById(R.id.uploadBtnID);
        uploadBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == uploadBtn){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);

            startActivityForResult(Intent.createChooser(intent, "Select Picture"), IMAGE_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data!=null && data.getData() != null){
            Uri uri = data.getData();
            uploadFile(uri);
        }
    }

    public void uploadFile(Uri fileUri){
        String descriptionString = description.getText().toString();

        File originalFile = FileUtils.getFile(this, fileUri);

        //The Description Part of the File
        RequestBody descriptionPart = RequestBody.create(MultipartBody.FORM, descriptionString);


        RequestBody filePart = RequestBody.create(
                MediaType.parse(getContentResolver().getType(fileUri)),
                originalFile
        );
        //The Photo or File Part of the Multipart
        MultipartBody.Part file = MultipartBody.Part.createFormData("photo", originalFile.getName(), filePart);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("BASE URL")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        UploadFileClient client = retrofit.create(UploadFileClient.class);

        Call<ResponseBody> call = client.uploadPhoto(descriptionPart,file);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getApplicationContext(), "File Uploaded into Server", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed to Upload File", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
