package com.globant.finanzaspersonales.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.globant.finanazaspersonales.R;
import com.globant.finanzaspersonales.interfaces.ViewCallback;
import com.globant.finanzaspersonales.presenter.PresenterCatalog;
import com.globant.finanzaspersonales.presenter.PresenterCatalogImpl;

public class SplashActivity extends AppCompatActivity implements ViewCallback {

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
        Log.d("ACTIVITY","NAVIGATE....");
        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
        finish();
    }
}
