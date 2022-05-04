package com.example.inventory;

import android.app.Activity;

import java.util.LinkedList;

public class Model {
    static MyToolsDataBase myDatabase;
    static LinkedList<Tool> tools;
    static Activity activity;

    public static void initialize(Activity anActivity){
        activity = anActivity;
    }

    public static String showToolList(){
        int i;
        String toolList = "";
        System.out.println("*********TOOLS*********");
        i=0;
        while(i < Model.tools.size()){
            System.out.println(Model.tools.get(i));
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
