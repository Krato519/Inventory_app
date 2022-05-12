package com.example.inventory;

//Defined values for all the tools stored in the main database.
public class Tool {
    private String name;
    private String type;
    private String brand;
    private String model;
    private String out;

    //Function for creating a new tool.
    public Tool(String T_name, String T_type, String T_brand, String T_model, String T_Status){
        name = T_name;
        type = T_type;
        brand = T_brand;
        model = T_model;
        out = T_Status;
    }
    //Functions for retrieving any value from a tool.
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public String getOut(){
        return out;
    }
    //Function for writing down and storing the values from a tool in a string.
    public String toString(){
        String string;
        string = "(" + name + ", " + type + ", " + brand + ", " + model + ", " + out + ").";
        return string;
    }

}
