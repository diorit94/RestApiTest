package com.example.dioritbajrami.restapitest.CreateUserAPI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dioritbajrami.restapitest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateUserActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name,email,interests,age;
    Button addToServerBtn;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        name = (EditText)findViewById(R.id.nameEditText);
        email = (EditText)findViewById(R.id.emailEditText);
        interests = (EditText)findViewById(R.id.interestsEditText);
        age = (EditText)findViewById(R.id.ageEditText);
        addToServerBtn = (Button)findViewById(R.id.addToServerBtn);

        user = new User(
                name.getText().toString(),
                email.getText().toString(),
                Integer.parseInt(age.getText().toString()),
                interests.getText().toString().split(",")
        );

        addToServerBtn.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        if(view == addToServerBtn){
            createAccount(user);
        }
    }

    public void createAccount(User user){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("BASE URL")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.createAccount(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getApplicationContext(), "ID: " + response.body().getId() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error" , Toast.LENGTH_SHORT).show();
            }
        });

    }


}
