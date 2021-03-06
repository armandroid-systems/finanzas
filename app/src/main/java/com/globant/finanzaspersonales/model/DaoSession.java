package com.globant.finanzaspersonales.model;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.globant.finanzaspersonales.model.user;
import com.globant.finanzaspersonales.model.cat_category;
import com.globant.finanzaspersonales.model.cat_tdc;
import com.globant.finanzaspersonales.model.budgets;
import com.globant.finanzaspersonales.model.expenses;

import com.globant.finanzaspersonales.model.userDao;
import com.globant.finanzaspersonales.model.cat_categoryDao;
import com.globant.finanzaspersonales.model.cat_tdcDao;
import com.globant.finanzaspersonales.model.budgetsDao;
import com.globant.finanzaspersonales.model.expensesDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig cat_categoryDaoConfig;
    private final DaoConfig cat_tdcDaoConfig;
    private final DaoConfig budgetsDaoConfig;
    private final DaoConfig expensesDaoConfig;

    private final userDao userDao;
    private final cat_categoryDao cat_categoryDao;
    private final cat_tdcDao cat_tdcDao;
    private final budgetsDao budgetsDao;
    private final expensesDao expensesDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(userDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        cat_categoryDaoConfig = daoConfigMap.get(cat_categoryDao.class).clone();
        cat_categoryDaoConfig.initIdentityScope(type);

        cat_tdcDaoConfig = daoConfigMap.get(cat_tdcDao.class).clone();
        cat_tdcDaoConfig.initIdentityScope(type);

        budgetsDaoConfig = daoConfigMap.get(budgetsDao.class).clone();
        budgetsDaoConfig.initIdentityScope(type);

        expensesDaoConfig = daoConfigMap.get(expensesDao.class).clone();
        expensesDaoConfig.initIdentityScope(type);

        userDao = new userDao(userDaoConfig, this);
        cat_categoryDao = new cat_categoryDao(cat_categoryDaoConfig, this);
        cat_tdcDao = new cat_tdcDao(cat_tdcDaoConfig, this);
        budgetsDao = new budgetsDao(budgetsDaoConfig, this);
        expensesDao = new expensesDao(expensesDaoConfig, this);

        registerDao(user.class, userDao);
        registerDao(cat_category.class, cat_categoryDao);
        registerDao(cat_tdc.class, cat_tdcDao);
        registerDao(budgets.class, budgetsDao);
        registerDao(expenses.class, expensesDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        cat_categoryDaoConfig.getIdentityScope().clear();
        cat_tdcDaoConfig.getIdentityScope().clear();
        budgetsDaoConfig.getIdentityScope().clear();
        expensesDaoConfig.getIdentityScope().clear();
    }

    public userDao getUserDao() {
        return userDao;
    }

    public cat_categoryDao getCat_categoryDao() {
        return cat_categoryDao;
    }

    public cat_tdcDao getCat_tdcDao() {
        return cat_tdcDao;
    }

    public budgetsDao getBudgetsDao() {
        return budgetsDao;
    }

    public expensesDao getExpensesDao() {
        return expensesDao;
    }

}
