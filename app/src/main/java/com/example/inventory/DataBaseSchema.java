package com.example.inventory;

import android.provider.BaseColumns;

//Database schema for the definition of the database columns.
//Implementing the BaseColumns library adds the id and count values to our schema.
public class DataBaseSchema implements BaseColumns{
    public static final String TABLE_NAME = "inventario";
    public static final String NAME = "Nombre";
    public static final String TYPE = "Tipo";
    public static final String BRAND = "Marca";
    public static final String MODEL = "Modelo";
    public static final String STATUS = "Estado";
}
