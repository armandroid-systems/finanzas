package com.globant.finanzaspersonales.presenter;

import android.content.Context;
import android.util.Log;

import com.globant.finanzaspersonales.interactor.CatalogInteractorImpl;
import com.globant.finanzaspersonales.interfaces.ProcessCallback;
import com.globant.finanzaspersonales.interfaces.ViewCallback;

/**
 * Created by armando.dominguez on 17/12/2015.
 */
public class PresenterCatalogImpl implements PresenterCatalog, ProcessCallback{
    private final static String TAG = PresenterCatalogImpl.class.getSimpleName();

    private CatalogInteractorImpl interactor;
    private ViewCallback viewCallback;
    private Context context;

    public PresenterCatalogImpl(ViewCallback viewCallback, Context context) {
        this.interactor = new CatalogInteractorImpl();
        this.viewCallback = viewCallback;
        this.context = context;
    }

    @Override
    public void checkForUsers() {
        interactor.checkUser(context,this);
    }


    @Override
    public void checkBudgets() {
        interactor.checkBudget(context,this);
    }

    @Override
    public void success(Object param) {
        Log.d(TAG,"DONE...");
        viewCallback.navigate(param);
    }

    @Override
    public void error(String message) {
        Log.d(TAG,"NOT DONE...");
        viewCallback.showMessage();
    }

}
