package com.example;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class GreenDaoGenerator {
    public static void main(String args[]) throws Exception{
        Schema schema = new Schema(1, "com.globant.finanzaspersonales.model");

        /////USER ENTITY
        Entity user = schema.addEntity("user");
        user.addIdProperty().columnName("idUser");
        user.addStringProperty("name");
        user.addFloatProperty("monthAmount");

        //////TDC ENTITY
        Entity catTdc = schema.addEntity("cat_tdc");
        catTdc.addIdProperty().columnName("idTdc");
        Property idUser = catTdc.addLongProperty("idUser").notNull().getProperty();
        ToMany userToTdc = user.addToMany(catTdc,idUser);
        userToTdc.setName("tdcCards");

        catTdc.addStringProperty("tdcName");
        catTdc.addFloatProperty("credit");
        catTdc.addFloatProperty("balance");
        catTdc.addIntProperty("active");

        //////BUDGET ENTITY
        Entity budget = schema.addEntity("budgets");

        budget.addIdProperty().columnName("idBudget");
        Property budgetUser = budget.addLongProperty("idUser").notNull().getProperty();
        ToMany userToBudget = user.addToMany(budget,budgetUser);
        userToBudget.setName("userBudgets");
        userToBudget.orderDesc(budget.addDateProperty("budgetDate").getProperty());

        //////EXPENSES ENTITY

        Entity expenses = schema.addEntity("expenses");

        expenses.addIdProperty().columnName("idExpense");


    }
}
