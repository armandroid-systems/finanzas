package com.globant.finanzaspersonales.interactor;

import android.content.Context;
import android.util.Log;

import com.globant.finanzaspersonales.interfaces.ProcessCallback;
import com.globant.finanzaspersonales.model.Boussines;
import com.globant.finanzaspersonales.model.user;

/**
 * Created by armando.dominguez on 16/12/2015.
 */
public class CatalogInteractorImpl implements CatalogInteractor {
    private final static String TAG = CatalogInteractorImpl.class.getSimpleName();

    @Override
    public void checkUser(Context ctx, ProcessCallback processCallback) {
        try{
            Log.d(TAG,"SENDING USER OBJECT");
            processCallback.success(new Boussines(ctx).isConfigured());
        }catch(Exception e){
            Log.d(TAG,"WTF error...");
            processCallback.error(e.getMessage());
        }

    }

    @Override
    public void checkBudget(Context ctx, ProcessCallback param) {
        try{
            param.success(new Boussines(ctx).getCurrentBalance());
        }catch(Exception e){
            param.error(e.getMessage());
        }
    }
}
