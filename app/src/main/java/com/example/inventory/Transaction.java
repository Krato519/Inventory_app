package com.example.inventory;

import java.util.Date;

public class Transaction {
    private int transaction_id;
    private Tool tool;
    private String transaction_type;
    private String petitioner;
    private Date date;
    private int counter = 1;

    public Transaction(Tool aTool, String aType, String aPetitioner, Date aDate){
        transaction_id = counter;
        tool = aTool;
        transaction_type = aType;
        petitioner = aPetitioner;
        date = aDate;
    }
}
