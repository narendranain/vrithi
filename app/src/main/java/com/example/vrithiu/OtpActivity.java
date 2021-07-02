package com.example.vrithiu;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vrithiu.model.CallAPI;
import com.example.vrithiu.model.LoginUser;
import com.example.vrithiu.model.OtpModel;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {
    View login;
    TextView time_duration;
    EditText mobile1,otp;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "My_Token" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        login=(View)findViewById(R.id.login);
        mobile1=(EditText)findViewById(R.id.mobile1);
        otp=(EditText)findViewById(R.id.otp);
        time_duration=(TextView)findViewById(R.id.time_duration);
        time_duration.setOnClickListener(this);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        login.setOnClickListener(this);
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                time_duration.setText(" " + millisUntilFinished / 1000+" sec");
            }

            public void onFinish() {
                time_duration.setText("resend");
                time_duration.setTextColor(Color.parseColor("#ff0000"));
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.login){
            otplogin();
        }
        if(v.getId()==R.id.time_duration){
            Intent i=new Intent(OtpActivity.this,MainActivity.class);
            startActivity(i);
        }
    }
    private void otplogin()
    {
        String mobile_no = "+91"+mobile1.getText().toString();
        int fotp=Integer.parseInt(otp.getText().toString());


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiList.verifyotp)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CallAPI api = retrofit.create(CallAPI.class);
        Call<OtpModel> call = api.otplogin(mobile_no,fotp);
        System.out.println("check:"+call);
        final ProgressDialog progressDialog = ProgressDialog.show(OtpActivity.this,
                "Please wait...", "Proccessing...", true);
        call.enqueue(new Callback<OtpModel>() {
            @Override
            public void onResponse(Call<OtpModel> call, Response<OtpModel> response) {
                progressDialog.dismiss();
                System.out.println("check"+response.body());
                if (response.isSuccessful())
                {
                    OtpModel login_model = response.body();


                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("token", login_model.getToken());
                    editor.commit();
                    Intent in = new Intent(OtpActivity.this,Notes.class);
                        startActivity(in);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Please enter correct otp",Toast.LENGTH_SHORT).show();
                    }
                }


            @Override
            public void onFailure(Call<OtpModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(OtpActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}