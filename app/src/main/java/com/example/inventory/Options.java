package com.example.inventory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Options#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Options extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    //Button variables for options.
    private Button botonRegistro;
    private Button botonInventario;
    private Button botonTransaccion;
    private Button botonPrestamos;

    public Options() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Options.
     */
    // TODO: Rename and change types and number of parameters
    public static Options newInstance(String param1, String param2) {
        Options fragment = new Options();
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
        view = inflater.inflate(R.layout.fragment_options, container, false);

        //Identification of the buttons in the view.
        botonRegistro = view.findViewById(R.id.register_button);
        botonInventario = view.findViewById(R.id.tools_button);
        botonTransaccion = view.findViewById(R.id.button_transaction);
        botonPrestamos = view.findViewById(R.id.loansButton);

        //Register button click listener assignation.
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Navigation from options fragment to register fragment.
                NavHostFragment.findNavController(Options.this).navigate(R.id.action_options_to_register_tool);
            }
        });
        //Inventory button click listener assignation.
        botonInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Navigation from options fragment to inventory fragment.
                NavHostFragment.findNavController(Options.this).navigate(R.id.action_options_to_inventory);
            }
        });
        //Transaction button click listener assignation.
        botonTransaccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Navigation from options fragment to transaction tool fragment.
                NavHostFragment.findNavController(Options.this).navigate(R.id.action_options_to_transaction_tool);
            }
        });
        //Current Loans button click listener assignation.
        botonPrestamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Navigation from options fragment to current loans fragment.
                NavHostFragment.findNavController(Options.this).navigate(R.id.action_options_to_current_loans);
            }
        });
        return view;
    }
}