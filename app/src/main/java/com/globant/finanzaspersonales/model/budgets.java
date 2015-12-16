package com.globant.finanzaspersonales.model;

import java.util.List;
import com.globant.finanzaspersonales.model.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "BUDGETS".
 */
public class budgets {

    private Long id;
    private long idUser;
    private java.util.Date budgetDate;
    private Integer active;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient budgetsDao myDao;

    private List<expenses> expenseToBudget;

    public budgets() {
    }

    public budgets(Long id) {
        this.id = id;
    }

    public budgets(Long id, long idUser, java.util.Date budgetDate, Integer active) {
        this.id = id;
        this.idUser = idUser;
        this.budgetDate = budgetDate;
        this.active = active;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBudgetsDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public java.util.Date getBudgetDate() {
        return budgetDate;
    }

    public void setBudgetDate(java.util.Date budgetDate) {
        this.budgetDate = budgetDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<expenses> getExpenseToBudget() {
        if (expenseToBudget == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            expensesDao targetDao = daoSession.getExpensesDao();
            List<expenses> expenseToBudgetNew = targetDao._queryBudgets_ExpenseToBudget(id);
            synchronized (this) {
                if(expenseToBudget == null) {
                    expenseToBudget = expenseToBudgetNew;
                }
            }
        }
        return expenseToBudget;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetExpenseToBudget() {
        expenseToBudget = null;
    }

    /** Convenient call for {@linkAbstractDao #delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@linkAbstractDao #update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@linkAbstractDao #refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}