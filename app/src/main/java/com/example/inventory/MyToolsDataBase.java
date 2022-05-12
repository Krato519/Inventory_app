package com.example.inventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.LinkedList;

public class MyToolsDataBase {

    //Database function for adding a new tool.
    public static void addNewTool(Context context, Tool tool){
        //Help values and tools for database manipulation.
        DataBaseHelper dbHelper;
        SQLiteDatabase db;
        ContentValues values;
        long newRowId;

        //Database and database helper function local creation.
        dbHelper = new DataBaseHelper(context);
        db = dbHelper.getWritableDatabase();

        //Value retrieval from the object tool given as a parameter in the function.
        values = new ContentValues();
        values.put(DataBaseSchema.NAME, tool.getName());
        values.put(DataBaseSchema.TYPE, tool.getType());
        values.put(DataBaseSchema.BRAND, tool.getBrand());
        values.put(DataBaseSchema.MODEL, tool.getModel());
        values.put(DataBaseSchema.STATUS, tool.getOut());

        //Value insertion into the database plus confirmation from the inserted value.
        newRowId = db.insert(DataBaseSchema.TABLE_NAME, null, values);
        System.out.println("*New data inserted at row ID: " + newRowId);
    }

    //Database select option creation with a returning of a linked list that will contain the matching values.
    private static LinkedList<Tool> select(Context context, String table, String[] columns, String selection, String[] selectionArgs, String sortOrder){

        //Help values and tools for database manipulation.
        DataBaseHelper dbHelper;
        SQLiteDatabase db;
        Cursor cursor;
        LinkedList<Tool> result;
        Tool tool;
        long id;
        String name;
        String type;
        String brand;
        String model;
        String status;

        //Database and database helper function local creation.
        dbHelper = new DataBaseHelper(context);
        db = dbHelper.getReadableDatabase();

        //Database cursor for traveling through the database values of the selection based on the arguments.
        cursor = db.query(DataBaseSchema.TABLE_NAME, columns, selection, selectionArgs, null, null, sortOrder);

        //Result variable creation.
        result = new LinkedList<Tool>();

        //While loop for traversing each database value retrieved.
        while(cursor.moveToNext()){
            id = cursor.getLong(cursor.getColumnIndexOrThrow(DataBaseSchema._ID));
            name = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.NAME));
            type = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.TYPE));
            brand = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.BRAND));
            model = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.MODEL));
            status = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.STATUS));
            //creation of a local tool with tha values of the current row.
            tool = new Tool(name, type, brand, model, status);
            //addition of the tool to the result.
            result.add(tool);
        }
        //Result returning with the closure of the cursor.
        cursor.close();
        return result;
    }

    //Select all database function.
    public static LinkedList<Tool> selectAll(Context context){
        //Arguments for the selection with the variable for storing the results.
        String table;
        String selection;
        String sortOrder;
        LinkedList<Tool> result;

        //Database identification.
        table = DataBaseSchema.TABLE_NAME;
        //Column identification for the selection.
        String[] columns =
                {
                        BaseColumns._ID,
                        DataBaseSchema.NAME,
                        DataBaseSchema.TYPE,
                        DataBaseSchema.BRAND,
                        DataBaseSchema.MODEL,
                        DataBaseSchema.STATUS
                };
        //Arguments creation.
        selection = "";
        String[] selectionArgs = {};
        sortOrder = DataBaseSchema.NAME + " ASC";

        //Result request using the select function with arguments created for selecting the complete database in alphabetic order.
        result = select(context, table, columns, selection, selectionArgs, sortOrder);
        //Result return.
        return result;
    }
}
