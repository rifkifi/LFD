package com.rifkifi.lfd;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.rifkifi.lfd.api.RetrofitClient;
import com.rifkifi.lfd.models.LoginResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    RelativeLayout rootLayout;
    Button btn_login;
    EditText et_bp;
    EditText et_password;
    TextInputLayout til_bp, til_password;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_bp = findViewById(R.id.et_bp);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        rootLayout = findViewById(R.id.rootLayout);
        til_bp = findViewById(R.id.til_bp);
        til_password = findViewById(R.id.til_password);

        getSupportActionBar().hide();

        // kodingan untuk membuat animasi backgroudnnya bergerak
        animationDrawable = (AnimationDrawable) rootLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(LoginActivity.this, null, "Harap Tunggu...", true, false);
                requestLogin();
            }
        });
    }

    private void requestLogin() {
        if (isset(et_bp, til_bp) && isset(et_password, til_password)) {
            Call<LoginResponse> call = RetrofitClient
                    .getInstance().getApi().praktikanLogin(et_bp.getText().toString(), et_password.getText().toString());
            Log.println(Log.INFO, "cal", "Call");

            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    LoginResponse loginResponse = response.body();
                    Log.println(Log.INFO, "MSG", loginResponse.getMessage());

                    if (response.isSuccessful()){

                        Log.println(Log.INFO, "loginResponse", "sukses");
                        loading.dismiss();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        loading.dismiss();
                        Toast.makeText(LoginActivity.this, "gagaag", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            });
        }




    }

    private boolean isset(EditText editText, TextInputLayout textInputLayout) {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        }
        editText.requestFocus(); // set focus on fields
        textInputLayout.setError("Please Fill This.!!!"); // set error message
        loading.dismiss();
        return false;
    }
}
