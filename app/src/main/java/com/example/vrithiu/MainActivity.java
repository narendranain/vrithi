package com.example.vrithiu;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vrithiu.model.CallAPI;
import com.example.vrithiu.model.LoginUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  View continue1;
  EditText editnumber;
  ProgressDialog pdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continue1=(View)findViewById(R.id.continue1);
        editnumber=(EditText)findViewById(R.id.editnumber);
        continue1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.continue1){
            login();
        }
    }
    private void login()
    {
        String mobile_no = "+91"+editnumber.getText().toString();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiList.loginapi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CallAPI api = retrofit.create(CallAPI.class);
        Call<LoginUser> call = api.userlogin(mobile_no);
        System.out.println("check:"+call);
        final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this,
                "Please wait...", "Proccessing...", true);
        call.enqueue(new Callback<LoginUser>() {
            @Override
            public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                progressDialog.dismiss();
                System.out.println("check"+response.body());
                if (response.isSuccessful())
                {
                    LoginUser login_model = response.body();
                    if (login_model.isStatus()==true)
                    {
                       // Toast.makeText(getApplicationContext()",Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(MainActivity.this,OtpActivity.class);
                        startActivity(in);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Please enter correct Mobile no",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginUser> call, Throwable t) {
               progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
