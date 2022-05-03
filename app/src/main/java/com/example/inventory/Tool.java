package com.example.inventory;

public class Tool {
    private String name;
    private String type;
    private String brand;
    private String model;
    private String out;

    public Tool(String T_name, String T_type, String T_brand, String T_model, String T_Status){
        name = T_name;
        type = T_type;
        brand = T_brand;
        model = T_model;
        out = T_Status;
    }

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

    public String toString(){
        String string;
        string = "(" + name + ", " + type + ", " + brand + ", " + model + ", " + out + ").";
        return string;
    }

}
