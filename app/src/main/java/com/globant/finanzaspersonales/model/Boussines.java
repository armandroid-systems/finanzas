package com.globant.finanzaspersonales.model;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by armando.dominguez on 16/12/2015.
 */
public class Boussines<T> extends ConnectionFactory {
    private static final String TAG = Boussines.class.getName();

    private DaoSession daoSession;

    public Boussines(Context context) {
        super(context);
        daoSession = daoMaster.newSession();
    }

    /////////////INSERTS

    public void insertUser(user paramUser) throws Exception{
        Log.d(TAG, "INSERT NEW USER IN DATABASE...");

        daoSession.insertOrReplace(paramUser);

    }

    public void insertCategory(cat_category categoryParam) throws Exception{
        Log.d(TAG, "INSERT NEW CATEGORY ON DATABASE...");

        daoSession.insertOrReplace(categoryParam);
    }

    public void insertTdc(cat_tdc tdcParam) throws Exception{
        Log.d(TAG, "INSERT NEW TDC ON DATABASE...");

        daoSession.insertOrReplace(tdcParam);
    }

    public void insertBudget(budgets budgetParam) throws Exception{

        daoSession.insertOrReplace(budgetParam);
    }

    public void genericInsert(T param) throws Exception{
        daoSession.insertOrReplace(param);
    }

    ////////////QUERIES
    public List<T> getAllData(Class<T> a) throws Exception{
        return daoSession.loadAll(a);
    }
    
    public boolean isConfigured() throws Exception{
        userDao muserDao = daoSession.getUserDao();
        List<user> mList = muserDao.loadAll();
        if(mList.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    ///////////UPDATES

    ///////////DELETES
}
