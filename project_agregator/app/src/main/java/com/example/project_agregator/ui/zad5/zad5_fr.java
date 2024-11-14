package com.example.project_agregator.ui.zad5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.project_agregator.R;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link zad5_fr#newInstance} factory method to
 * create an instance of this fragment.
 */
public class zad5_fr extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public zad5_fr() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment zad5_fr.
     */
    // TODO: Rename and change types and number of parameters
    public static zad5_fr newInstance(String param1, String param2) {
        zad5_fr fragment = new zad5_fr();
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
        View view = inflater.inflate(R.layout.fragment_zad5, container, false);
        Button prawa = view.findViewById(R.id.button_zad5_right);
        Button lewa = view.findViewById(R.id.button_zad5_left);
        ImageView zdjecie = view.findViewById(R.id.imageView_zad5);
        EditText mojtekst = view.findViewById(R.id.Multiline_zad5);
        String[][] array =
                {
                        {"0", "angel", "opis"},
                        {"1", "angy", "opis"},
                        {"2", "cool", "opis"},
                        {"3", "deadass", "opis"},
                        {"4", "thinky", "opis"},
                        {"5", "sureabt", "opis"},
                        {"6", "kitty", "opis"}
                };
        int[] licznik = {0};
        prawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licznik[0]++;
                if (licznik[0] == array.length - 1) {
                    prawa.setEnabled(false);
                } else {
                    prawa.setEnabled(true);
                }
                if (licznik[0] > 0) {
                    lewa.setEnabled(true);
                }
                if (licznik[0] >= 0 && licznik[0] < array.length) {
                    zdjecie.setImageResource(R.drawable.sureabt);
                }
                String beforeopis = mojtekst.getText().toString();
                array[(licznik[0] - 1)][2] = beforeopis;
                mojtekst.setText((array[licznik[0]][2]));
                String im = array[licznik[0]][1];
                int imageResource = getResources().getIdentifier(im, "drawable", getActivity().getPackageName());
                zdjecie.setImageResource(imageResource);
            }
            });
        lewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licznik[0]--;
                if (licznik[0] == 0) {
                    lewa.setEnabled(false);
                } else {
                    lewa.setEnabled(true);
                }
                if (licznik[0] < array.length - 1) {
                    prawa.setEnabled(true);
                }

                String beforeopis = mojtekst.getText().toString();
                array[(licznik[0] + 1)][2] = beforeopis;
                mojtekst.setText((array[licznik[0]][2]));
                String im = array[licznik[0]][1];
                int imageResource = getResources().getIdentifier(im, "drawable", getActivity().getPackageName());
                zdjecie.setImageResource(imageResource);
            }
        });
        lewa.setEnabled(false);
        return view;
    }
}