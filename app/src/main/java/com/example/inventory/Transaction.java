package com.example.inventory;

import java.util.Date;

//Defined model for a second database created for the tool loaning.
public class Transaction {
    private int transaction_id;
    private Tool tool;
    private String transaction_type;
    private String petitioner;
    private Date date;
    private int counter = 1;

    //Function for creating a new transaction.
    public Transaction(Tool aTool, String aType, String aPetitioner, Date aDate){
        transaction_id = counter;
        tool = aTool;
        transaction_type = aType;
        petitioner = aPetitioner;
        date = aDate;
    }
}
