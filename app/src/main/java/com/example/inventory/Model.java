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

    public static void showToolList(){
        int i;
        System.out.println("*********TOOLS*********");
        i=0;
        while(i < Model.tools.size()){
            System.out.println(Model.tools.get(i));
            i = i + 1;
        }
        System.out.println("**********************");
    }

}
