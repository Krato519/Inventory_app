package com.example.inventory;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Register_tool#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register_tool extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;
    //TextInputs for the tool values used for the registration.
    TextInputEditText toolNameText;
    TextInputEditText brandText;
    TextInputEditText typeText;
    TextInputEditText modelText;

    //Register tool button variable.
    Button registarButton;
    //Default status string.
    String status = "En almacen";

    public Register_tool() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Register_tool.
     */
    // TODO: Rename and change types and number of parameters
    public static Register_tool newInstance(String param1, String param2) {
        Register_tool fragment = new Register_tool();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register_tool, container, false);
        return view;
    }

    // Initialize the view
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //
        initializeView();
    }//end onViewCreated

    private void initializeView(){
        //View elements identification.
        toolNameText = (TextInputEditText) view.findViewById(R.id.ToolNameText);
        brandText = (TextInputEditText) view.findViewById(R.id.BrandText);
        typeText = (TextInputEditText) view.findViewById(R.id.TypeText);
        modelText = (TextInputEditText) view.findViewById(R.id.ModelText);
        registarButton = view.findViewById(R.id.button_register_tool);
        insertToDatabaseButton(view);
    }

    //Function for getting the TextInput values and storing them into the database.
    private void insertToDatabaseButton(View view){

        registarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tool tool;
                //String test;
                // test = toolNameText.getText().toString() + " / " +  typeText.getText().toString() + " / " + brandText.getText().toString() + " / " + modelText.getText().toString() + " / " + status;
                //System.out.println(test);
                //Creation of a tool based on the text fields.
                tool = new Tool(toolNameText.getText().toString(), typeText.getText().toString(),
                        brandText.getText().toString(), modelText.getText().toString(), status);

                //Insertion of the tool into the database.
                Model.myDatabase.addNewTool(Model.activity, tool);

                //Model.tools = Model.myDatabase.selectAll(Model.activity);
                //Model.showToolList();
                //Text inputs clear for new insertion.
                toolNameText.setText("");
                brandText.setText("");
                typeText.setText("");
                modelText.setText("");
            }
        });
    }
}