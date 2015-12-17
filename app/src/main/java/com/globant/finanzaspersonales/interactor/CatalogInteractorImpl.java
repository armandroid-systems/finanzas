package com.globant.finanzaspersonales.interactor;

import android.content.Context;
import android.util.Log;

import com.globant.finanzaspersonales.interfaces.ProcessCallback;
import com.globant.finanzaspersonales.model.Boussines;

/**
 * Created by armando.dominguez on 16/12/2015.
 */
public class CatalogInteractorImpl implements CatalogInteractor {
    private final static String TAG = CatalogInteractorImpl.class.getSimpleName();

    @Override
    public void checkUser(Context ctx, ProcessCallback processCallback) {
        try{
            if(new Boussines(ctx).isConfigured()){
                processCallback.success(null);
            }else{
                Log.d(TAG,"NO USER...");
                processCallback.success(null);
            }
        }catch(Exception e){
            Log.d(TAG,"WTF error...");
            processCallback.error(e.getMessage());
        }

    }
}
