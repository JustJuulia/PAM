package com.example.project_agregator.ui.zad7;

import android.media.Image;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_agregator.R;

import kotlin.random.Random;

public class zad7_fr extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static zad7_fr newInstance(String param1, String param2) {
        zad7_fr fragment = new zad7_fr();
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
        View view = inflater.inflate(R.layout.fragment_zad7, container, false);
        final int[] fullwynik = {0};
        final int[] tenwynik = {0};
        final Button[] rzuc = {view.findViewById(R.id.button_rzuc)};
        Button resetuj = view.findViewById(R.id.button_resetuj);
        ImageView kostka1 = view.findViewById(R.id.kostka1);
        ImageView kostka2 = view.findViewById(R.id.kostka2);
        ImageView kostka3 = view.findViewById(R.id.kostka3);
        ImageView kostka4 = view.findViewById(R.id.kostka4);
        ImageView kostka5 = view.findViewById(R.id.kostka5);
        ImageView kostka6 = view.findViewById(R.id.kostka6);
        TextView wynik_losu = view.findViewById(R.id.wynik_losu);
        TextView wynik_gry = view.findViewById(R.id.wynik_gry);
        String[][] array =
                {
                        {"0", "kostka1"},
                        {"0", "kostka2"},
                        {"0", "kostka3"},
                        {"0", "kostka4"},
                        {"0", "kostka5"},
                        {"0", "kostka6"}
                };
        int[] tabliczka={
            R.drawable.oczko1,R.drawable.oczko2,R.drawable.oczko3,R.drawable.oczko4,R.drawable.oczko5,R.drawable.oczko6};
        rzuc[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tenwynik[0] = 0;
                int i = 0;
                while (i < 6) {
                    int liczba = Random.Default.nextInt(6) + 1;
                    array[i][0] = String.valueOf(liczba - 1);
                    fullwynik[0] = fullwynik[0] + liczba;
                    tenwynik[0] = tenwynik[0] + liczba;
                    i++;
                }
                wynik_losu.setText("Wynik tego losu: "+tenwynik[0]+" ");
                wynik_gry.setText("Wynik tej całej gry: "+fullwynik[0]+" ");
                setkostki(tabliczka, array, kostka1, kostka2, kostka3, kostka4, kostka5, kostka6);
            }
        });
        resetuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                tenwynik[0] = 0;
                fullwynik[0] = 0;
                wynik_losu.setText("Wynik tego losu: "+tenwynik[0]+" ");
                wynik_gry.setText("Wynik tej całej gry: "+fullwynik[0]+" ");
                kostka1.setImageResource(R.drawable.question);
                kostka2.setImageResource(R.drawable.question);
                kostka3.setImageResource(R.drawable.question);
                kostka4.setImageResource(R.drawable.question);
                kostka5.setImageResource(R.drawable.question);
                kostka6.setImageResource(R.drawable.question);
            }
        });
        return view;
    }
    private void setkostki(int[] t,String[][] arr, ImageView k1, ImageView k2, ImageView k3, ImageView k4, ImageView k5, ImageView k6){
        int counter = 0;
        while(counter < 6){
            String oczko = "";
            int num = Integer.parseInt(arr[counter][0]);
            switch(counter){
                case 0:
                    k1.setImageResource(t[num]);
                    break;
                case 1:
                    k2.setImageResource(t[num]);
                    break;
                case 2:
                    k3.setImageResource(t[num]);
                    break;
                case 3:
                    k4.setImageResource(t[num]);
                    break;
                case 4:
                    k5.setImageResource(t[num]);
                    break;
                case 5:
                    k6.setImageResource(t[num]);
                    break;
            }
            counter++;
        }

    }
}
