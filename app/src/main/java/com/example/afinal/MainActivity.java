package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.afinal.Response.LoginRespose;
import com.example.afinal.RetrofitAPI.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    String text;
    String api_token;

    EditText email,password;
    Button register;

    SharedPref sp = SharedPref.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide action bar
        getSupportActionBar().hide();

        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        email=findViewById(R.id.Email);
        password=findViewById(R.id.Password);
        register=findViewById(R.id.btn_login);





    }

    public void Login(View view){
        switch(view.getId()){
            case R.id.btn_login:
                userLogin();
                break;

        }
    }

    public void userLogin() {

        String userEmail=email.getText().toString();
        String userPassword=password.getText().toString();



        if(userEmail.isEmpty()){
            email.requestFocus();
            email.setError("please enter your email");
            return;
        }
        //email pattern checker
        if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            email.requestFocus();
            email.setError("please enter correct email");
            return;
        }

        if(userPassword.isEmpty()){
            password.requestFocus();
            password.setError("please enter your Password");
            return;
        }
        if(userPassword.length()<8){
            password.requestFocus();
            password.setError("please enter your password");
            return;
        }


        Call<LoginRespose> call= RetrofitClient.getInstance().getApi().login(userEmail,userPassword);
        call.enqueue(new Callback<LoginRespose>() {
            @Override
            public void onResponse(Call<LoginRespose> call, Response<LoginRespose> response) {

                LoginRespose loginResponse=response.body();
                api_token = loginResponse.getKey();

                //Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                try {
                    if(response.body().getMessage().equals("Login Successful")){

                        safeApiToken();

                        Intent intent=new Intent(MainActivity.this,home.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, loginResponse.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    else if (response.body().getCode() == 404){
                        Toast.makeText(MainActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    else
                    if(response.body().getMessage().equals("Invalid Password or Email")){
                        Toast.makeText(MainActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<LoginRespose> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }


    //Shared pref
    public void safeApiToken(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, api_token);
        this.sp.setKey(api_token);
        editor.apply();

    }

    public void loadDate(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");

    }




}