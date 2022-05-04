package com.example.inventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.LinkedList;

public class MyToolsDataBase {

    public static void addNewTool(Context context, Tool tool){
        DataBaseHelper dbHelper;
        SQLiteDatabase db;
        ContentValues values;
        long newRowId;

        dbHelper = new DataBaseHelper(context);
        db = dbHelper.getWritableDatabase();

        values = new ContentValues();
        values.put(DataBaseSchema.NAME, tool.getName());
        values.put(DataBaseSchema.TYPE, tool.getType());
        values.put(DataBaseSchema.BRAND, tool.getBrand());
        values.put(DataBaseSchema.MODEL, tool.getModel());
        values.put(DataBaseSchema.STATUS, tool.getOut());

        newRowId = db.insert(DataBaseSchema.TABLE_NAME, null, values);
        System.out.println("*New data inserted at row ID: " + newRowId);
    }

    private static LinkedList<Tool> select(Context context, String table, String[] columns, String selection, String[] selectionArgs, String sortOrder){

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

        dbHelper = new DataBaseHelper(context);
        db = dbHelper.getReadableDatabase();

        cursor = db.query(DataBaseSchema.TABLE_NAME, columns, selection, selectionArgs, null, null, sortOrder);

        result = new LinkedList<Tool>();

        while(cursor.moveToNext()){
            id = cursor.getLong(cursor.getColumnIndexOrThrow(DataBaseSchema._ID));
            name = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.NAME));
            type = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.TYPE));
            brand = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.BRAND));
            model = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.MODEL));
            status = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseSchema.STATUS));
            tool = new Tool(name, type, brand, model, status);
            result.add(tool);
        }

        cursor.close();
        return result;
    }

    public static LinkedList<Tool> selectAll(Context context){
        String table;
        String selection;
        String sortOrder;
        LinkedList<Tool> result;

        table = DataBaseSchema.TABLE_NAME;
        String[] columns =
                {
                        BaseColumns._ID,
                        DataBaseSchema.NAME,
                        DataBaseSchema.TYPE,
                        DataBaseSchema.BRAND,
                        DataBaseSchema.MODEL,
                        DataBaseSchema.STATUS
                };
        selection = "";
        String[] selectionArgs = {};
        sortOrder = DataBaseSchema.NAME + " ASC";

        result = select(context, table, columns, selection, selectionArgs, sortOrder);
        return result;
    }

    public static LinkedList<Tool> selectWhereNameIs(Context context, String aName){
        String table;
        String selection;
        String sortOrder;
        LinkedList<Tool> result;
        table = DataBaseSchema.TABLE_NAME;
        String[] columns = {
                BaseColumns._ID,
                DataBaseSchema.NAME,
                DataBaseSchema.TYPE,
                DataBaseSchema.BRAND,
                DataBaseSchema.MODEL,
                DataBaseSchema.STATUS
        };
        selection = DataBaseSchema.NAME + " = ?";
        String[] selectionArgs = {
                aName
        };
        sortOrder = DataBaseSchema.NAME + " DESC";
        result = select(context, table, columns, selection, selectionArgs, sortOrder);
        return result;
    }
}
