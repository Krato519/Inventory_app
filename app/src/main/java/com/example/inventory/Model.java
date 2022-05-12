package com.example.inventory;

import android.app.Activity;

import java.util.LinkedList;

//Basic model for the database.
public class Model {
    //Database created with the class MyToolsDataBase
    static MyToolsDataBase myDatabase;
    //Linked list that contains tools.
    static LinkedList<Tool> tools;
    //Context activity.
    static Activity activity;

    //Function for model initialization inside an activity.
    public static void initialize(Activity anActivity){
        activity = anActivity;
    }

    //Function created to display all the current values from the database as an organized text.
    public static String showToolList(){
        int i;
        String toolList = "";
        System.out.println("*********TOOLS*********");
        i=0;
        while(i < Model.tools.size()){
            //System.out.println(Model.tools.get(i));
            toolList = toolList +
                    "---------------------------------------------------------\n" +
                       "Nombre: " + Model.tools.get(i).getName() + "\n" +
                       "Tipo: " + Model.tools.get(i).getType() + "\n" +
                       "Marca: " + Model.tools.get(i).getBrand() + "\n" +
                       "Modelo: " + Model.tools.get(i).getModel() + "\n" +
                       "Estado: " + Model.tools.get(i).getOut() +
                    "\n---------------------------------------------------------\n";
            i = i + 1;
        }
        System.out.println("**********************");
        return toolList;
    }

}
