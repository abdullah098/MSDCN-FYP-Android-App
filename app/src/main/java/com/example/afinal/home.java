package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afinal.Response.DashBorardResponse;
import com.example.afinal.Response.LoginRespose;
import com.example.afinal.RetrofitAPI.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home extends AppCompatActivity {

    SharedPref sp = SharedPref.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //hide action bar
        getSupportActionBar().hide();

        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Get elements by id
        TextView Total_Revenue = findViewById(R.id.Total_Revenue);
        TextView Total_NO_Sale = findViewById(R.id.Total_NSale);
        TextView Today_Revenue = findViewById(R.id.Today_Revenue);
        TextView Today_Sale = findViewById(R.id.Today_Sale);



        //api instance
        Call<DashBorardResponse> call= RetrofitClient.getInstance().getApi().dashboard(sp.getKey());
        call.enqueue(new Callback<DashBorardResponse>() {
            @Override
            public void onResponse(Call<DashBorardResponse> call, Response<DashBorardResponse> response) {
                if(response.body().getMessage().equals("authenticated")){
                    //get data from api
                    //Toast.makeText(home.this, response.body().getTotalRevenue(), Toast.LENGTH_LONG).show();
                    //String convert = response.body().toString();
                    try {

                        float TotalRevenue = response.body().getTotalRevenue();
                        int TotalSale = response.body().getTotalSales();
                        int TodaySale = response.body().getTodaySales();
                        float TodayRevenue = response.body().getTodayRevenue();

                        //Show data in text fields
                        Total_Revenue.setText(String.valueOf(TotalRevenue));
                        Total_NO_Sale.setText(String.valueOf(TotalSale));
                        Today_Revenue.setText(String.valueOf(TodayRevenue));
                        Today_Sale.setText(String.valueOf(TodaySale));



                    } catch (Resources.NotFoundException e){
                        Toast.makeText(home.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<DashBorardResponse> call, Throwable t) {

            }
        });



        //to go to about page
        ImageView imageView = findViewById(R.id.About);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home.this,profile_about.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });



        //logout
        Button logout = findViewById(R.id.btn_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                sp.setKey("");
                finish();
                Toast.makeText(home.this, sp.getKey(), Toast.LENGTH_LONG ).show();
                Toast.makeText(home.this, "Logout Successful", Toast.LENGTH_LONG ).show();
            }
        });


        //page refresh

        ImageView refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(home.this, home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });



        //Call<LoginRespose> call= RetrofitClient.getInstance().getApi().login(userEmail,userPassword);

    }
}