package com.globant.finanzaspersonales.model;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.globant.finanzaspersonales.model.budgets;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BUDGETS".
*/
public class budgetsDao extends AbstractDao<budgets, Long> {

    public static final String TABLENAME = "BUDGETS";

    /**
     * Properties of entity budgets.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "idBudget");
        public final static Property IdUser = new Property(1, long.class, "idUser", false, "ID_USER");
        public final static Property BudgetDate = new Property(2, java.util.Date.class, "budgetDate", false, "BUDGET_DATE");
        public final static Property Active = new Property(3, Integer.class, "active", false, "ACTIVE");
    };

    private DaoSession daoSession;

    private Query<budgets> user_UserBudgetsQuery;

    public budgetsDao(DaoConfig config) {
        super(config);
    }
    
    public budgetsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BUDGETS\" (" + //
                "\"idBudget\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ID_USER\" INTEGER NOT NULL ," + // 1: idUser
                "\"BUDGET_DATE\" INTEGER," + // 2: budgetDate
                "\"ACTIVE\" INTEGER);"); // 3: active
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BUDGETS\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, budgets entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getIdUser());
 
        java.util.Date budgetDate = entity.getBudgetDate();
        if (budgetDate != null) {
            stmt.bindLong(3, budgetDate.getTime());
        }
 
        Integer active = entity.getActive();
        if (active != null) {
            stmt.bindLong(4, active);
        }
    }

    @Override
    protected void attachEntity(budgets entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public budgets readEntity(Cursor cursor, int offset) {
        budgets entity = new budgets( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // idUser
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // budgetDate
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3) // active
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, budgets entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIdUser(cursor.getLong(offset + 1));
        entity.setBudgetDate(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setActive(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(budgets entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(budgets entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "userBudgets" to-many relationship of user. */
    public List<budgets> _queryUser_UserBudgets(long idUser) {
        synchronized (this) {
            if (user_UserBudgetsQuery == null) {
                QueryBuilder<budgets> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.IdUser.eq(null));
                queryBuilder.orderRaw("T.'BUDGET_DATE' DESC");
                user_UserBudgetsQuery = queryBuilder.build();
            }
        }
        Query<budgets> query = user_UserBudgetsQuery.forCurrentThread();
        query.setParameter(0, idUser);
        return query.list();
    }

}
