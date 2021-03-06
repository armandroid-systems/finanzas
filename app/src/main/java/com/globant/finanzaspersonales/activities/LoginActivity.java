package com.globant.finanzaspersonales.activities;

import android.os.Bundle;
import android.util.Log;

import com.globant.finanazaspersonales.R;
import com.globant.finanzaspersonales.fragments.FragmentSingin;
import com.globant.finanzaspersonales.utils.Constants;
import com.globant.finanzaspersonales.utils.ScreenManager;

public class LoginActivity extends BaseActivity {
    private final static String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(findViewById(R.id.authScreenWrapper)!= null){
            if(savedInstanceState == null){
                try {
                    ScreenManager.screenChange(LoginActivity.this,R.id.authScreenWrapper,FragmentSingin.class,null,Constants.VIEW_SINGIN,Constants.BIN_TRUE);
                } catch (IllegalAccessException e) {
                    Log.e(TAG,"ERROR "+e);
                } catch (InstantiationException e) {
                    Log.e(TAG, "ERROR " + e);
                }
            }
        }
    }
}
