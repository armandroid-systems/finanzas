package com.globant.finanzaspersonales.activities;


import android.os.Bundle;
import android.util.Log;

import com.globant.finanazaspersonales.R;
import com.globant.finanzaspersonales.fragments.FragmentMain;
import com.globant.finanzaspersonales.interfaces.ViewCallback;
import com.globant.finanzaspersonales.presenter.PresenterCatalogImpl;
import com.globant.finanzaspersonales.utils.Constants;
import com.globant.finanzaspersonales.utils.ScreenManager;

public class MainActivity extends BaseActivity implements ViewCallback{
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new PresenterCatalogImpl(this, MainActivity.this).checkForUsers();

       /* if(findViewById(R.id.mainActivityWrapper) != null){
            if(savedInstanceState == null){
                try {
                    if(getIntent().getExtras() != null){

                        ScreenManager.screenChange(MainActivity.this,R.id.mainActivityWrapper,
                               FragmentMain.class, getIntent().getExtras().getInt("something"),
                               Constants.VIEW_CONFIGURATION,
                               Constants.BIN_TRUE);
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }

    @Override
    public void showMessage() {
        Log.d(TAG,"ERROR...");
    }

    @Override
    public void navigate(Object param) {
            try {
                ScreenManager.screenChange(MainActivity.this,R.id.mainActivityWrapper,
                        FragmentMain.class, param,
                        Constants.VIEW_CONFIGURATION,
                        Constants.BIN_TRUE);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
    }

}
