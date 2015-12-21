package com.globant.finanzaspersonales.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.globant.finanazaspersonales.R;
import com.globant.finanzaspersonales.interfaces.ViewCallback;
import com.globant.finanzaspersonales.presenter.PresenterCatalog;
import com.globant.finanzaspersonales.presenter.PresenterCatalogImpl;
import com.globant.finanzaspersonales.utils.Constants;

public class SplashActivity extends AppCompatActivity implements ViewCallback {
    private final static String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new PresenterCatalogImpl(this, SplashActivity.this).checkForUsers();

    }

    @Override
    public void showMessage() {
        Log.d("ACTIVITY","MESSAGE...");
    }

    @Override
    public void navigate(Object param) {
        Log.d("ACTIVITY", "NAVIGATE....");
        if(param != null){
            Log.d(TAG, "DATA FOUND REDIRECT TO MAIN SCREEN...");
            startActivity(new Intent(SplashActivity.this, MainActivity.class).putExtra("something", Constants.BIN_TRUE));
        }else{
            Log.d(TAG,"NO DATA FOUND REDIRECT TO SING IN SCREEN...");
            startActivity(new Intent(SplashActivity.this,LoginActivity.class).putExtra("something", Constants.BIN_FALSE));
        }
        finish();
    }
}
