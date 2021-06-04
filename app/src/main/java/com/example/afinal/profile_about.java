package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afinal.Response.AboutResponse;
import com.example.afinal.Response.DashBorardResponse;
import com.example.afinal.RetrofitAPI.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profile_about extends AppCompatActivity {

    SharedPref sp = SharedPref.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_about);

        //hide action bar
        getSupportActionBar().hide();

        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView User_Name = findViewById(R.id.userName);
        TextView User_Type = findViewById(R.id.User_Type);
        TextView EmailTextV = findViewById(R.id.EmailTextV);
        TextView Account_Status = findViewById(R.id.Account_Status);
        TextView CNIC_TextV = findViewById(R.id.CNIC_TextV);

        Call<AboutResponse> call = RetrofitClient.getInstance().getApi().about(sp.getKey());
        call.enqueue(new Callback<AboutResponse>() {
            @Override
            public void onResponse(Call<AboutResponse> call, Response<AboutResponse> response) {

                if(response.body().getMessage().equals("authenticated")){

                    String name = response.body().getUser().getName().toUpperCase();
                    String UserT = response.body().getUser().getUserType();
                    String Email = response.body().getUser().getEmail();
                    String accountStatus = response.body().getUser().getAccountStatus();
                    String cnic = response.body().getUser().getCnicCardNumber();

                    User_Name.setText(name);
                    User_Type.setText(UserT);
                    EmailTextV.setText(Email);
                    Account_Status.setText(accountStatus);
                    CNIC_TextV.setText(cnic);



                }

            }

            @Override
            public void onFailure(Call<AboutResponse> call, Throwable t) {

            }
        });

        //back button
        ImageView imageView = findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profile_about.this,home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });




    }


}