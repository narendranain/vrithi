package com.example.vrithiu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.vrithiu.model.CallAPI;
import com.example.vrithiu.model.OtpModel;
import com.example.vrithiu.model.UserDetails;

import org.json.JSONArray;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Notes extends AppCompatActivity implements View.OnClickListener {
        View himg,himg1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.notes);
                getUserDetail();
                himg=(View)findViewById(R.id.himg);
                himg.getBackground().setAlpha(50);

                himg1=(View)findViewById(R.id.himg1);
                himg1.getBackground().setAlpha(30);


        }

        @Override
        public void onClick(View v) {
                if (v.getId() == R.id.continue1) {
                        Intent i = new Intent(Notes.this, OtpActivity.class);
                        startActivity(i);
                }
        }

        private void getUserDetail()
        {


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ApiList.getProfillist)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                CallAPI api = retrofit.create(CallAPI.class);
                SharedPreferences shared = getSharedPreferences("My_Token", MODE_PRIVATE);
                String token = (shared.getString("token", ""));
                Call<JSONArray> call = api.getuserdetails("Bearer"+token);
                System.out.println("check:"+call);
                final ProgressDialog progressDialog = ProgressDialog.show(Notes.this,
                        "Please wait...", "Proccessing...", true);
                call.enqueue(new Callback<JSONArray>() {

                        @Override
                        public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                                progressDialog.dismiss();
                                System.out.println("Notes response"+response.body());
                                if (response.isSuccessful())
                                {
                                        JSONArray login_model = response.body();

                                }
                                else
                                {
                                        Toast.makeText(getApplicationContext(),"token expired",Toast.LENGTH_SHORT).show();
                                }
                        }

                        @Override
                        public void onFailure(Call<JSONArray> call, Throwable t) {
                                progressDialog.dismiss();
                                Toast.makeText(Notes.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                });

        }
}
