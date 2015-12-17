package com.globant.finanzaspersonales.interactor;

import android.content.Context;

import com.globant.finanzaspersonales.interfaces.ProcessCallback;

/**
 * Created by armando.dominguez on 16/12/2015.
 */
public interface CatalogInteractor {

    void checkUser(Context ctx, ProcessCallback param);
}
