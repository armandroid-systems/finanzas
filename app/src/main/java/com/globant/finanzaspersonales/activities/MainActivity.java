package com.globant.finanzaspersonales.activities;


import android.os.Bundle;

import com.globant.finanazaspersonales.R;
import com.globant.finanzaspersonales.fragments.FragmentConfiguration;
import com.globant.finanzaspersonales.utils.Constants;
import com.globant.finanzaspersonales.utils.ScreenManager;

public class MainActivity extends BaseActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.mainActivityWrapper) != null){
            if(savedInstanceState == null){
                try {
                    ScreenManager.screenChange(MainActivity.this,R.id.mainActivityWrapper, FragmentConfiguration.class,null, Constants.VIEW_CONFIGURATION,Constants.BIN_TRUE);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
