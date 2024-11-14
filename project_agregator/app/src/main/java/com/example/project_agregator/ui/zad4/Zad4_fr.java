package com.example.project_agregator.ui.zad4;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.project_agregator.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Zad4_fr#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Zad4_fr extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public Zad4_fr() {

    }

    public static Zad4_fr newInstance(String param1, String param2) {
        Zad4_fr fragment = new Zad4_fr();
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
        View view = inflater.inflate(R.layout.fragment_zad4, container, false);
        EditText mojtekst = view.findViewById(R.id.text_zad4);
        Button mojprzycisk = view.findViewById(R.id.button_zad4);
        CheckBox mojcheckbox = view.findViewById(R.id.checkBox_zad4);
        mojprzycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = mojtekst.getText().toString();
                if (mojcheckbox.isChecked()) {
                    Snackbar.make(view, inputText, Snackbar.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), inputText, Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
