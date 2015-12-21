package com.globant.finanzaspersonales.model;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by armando.dominguez on 16/12/2015.
 */
public class Boussines<T> extends ConnectionFactory {
    private static final String TAG = Boussines.class.getName();

    private DaoSession daoSession;

    private static final String BALANCE_QUERY = "SELECT SUM(T1.monto) AS EXPENSE, (T2.ingreso - SUM(T1.monto)) AS BALANCE FROM expenses AS T1" +
            "INNER JOIN budgets AS T3 ON T1.id_presupuesto = T3.idcatpresupuestos" +
            "INNER JOIN user AS T2 ON T2.idUsuario = T3.idUsuario" +
            "WHERE T1.id_presupuesto = 1;";

    public Boussines(Context context) {
        super(context);
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
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

    public List<user> getProfile(int idUser) throws Exception{
        userDao mUserDao = daoSession.getUserDao();
        List<user> mList = mUserDao.queryBuilder().where(userDao.Properties.Id.eq(idUser)).list();
        if(mList.isEmpty()){
            return mList;
        }else{
            return mList;
        }
    }

    /**
     * Get current budget
     */
    public Balance getCurrentBalance() throws Exception{
        Cursor c = daoSession.getDatabase().rawQuery(BALANCE_QUERY,null);
        Balance mBalance = new Balance();
        if (c.moveToFirst()) {
            do {
                mBalance.expenses = c.getFloat(0);
                mBalance.balance = c.getFloat(1);
            } while (c.moveToNext());
        }else{
            mBalance = null;
        }
        c.close();
        return mBalance;
    }

    ///////////UPDATES

    ///////////DELETES
}
