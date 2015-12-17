package com.globant.finanzaspersonales.interfaces;

/**
 * Created by armando.dominguez on 17/12/2015.
 */
public interface ProcessCallback {
    void success(Object param);
    void error(String message);
}
