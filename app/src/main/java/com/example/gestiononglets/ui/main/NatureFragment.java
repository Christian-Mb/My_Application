package com.example.gestiononglets.ui.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.gestiononglets.MainActivity;
import com.example.gestiononglets.R;

/**
 * une instance de NatureFragment contient ici juste un label
 */
public class NatureFragment extends Fragment {
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque NatureFragment instancié
    private String title;
    private int page;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static NatureFragment newInstance(int position, String title) {
        NatureFragment fragment = new NatureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(title.equals("Saisons")){

            View view = inflater.inflate(R.layout.fragment2_main, container, false);
            ImageView imageHiver = (ImageView) view.findViewById(R.id.imageView1);
            ImageView imagePrintemps= (ImageView) view.findViewById(R.id.imageView2);
            ImageView imageEte= (ImageView) view.findViewById(R.id.imageView3);
            ImageView imageAutomne= (ImageView) view.findViewById(R.id.imageView4);

            imageHiver.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(0);
                }
            });
            imagePrintemps.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(2);
                }
            });
            imageEte.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(1);
                }
            });
            imageAutomne.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(4);
                }
            });



            imageEte.setImageDrawable(SectionsPagerAdapter.getImage(1, getActivity().getApplicationContext()));
            imageHiver.setImageDrawable(SectionsPagerAdapter.getImage(3, getActivity().getApplicationContext()));
            imagePrintemps.setImageDrawable(SectionsPagerAdapter.getImage(2, getActivity().getApplicationContext()));


            return view;


        }
        else{
            View view = inflater.inflate(R.layout.fragment_main, container, false);
            TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
            tvLabel.setText(page + " -- " + title);
            ImageView image = (ImageView) view.findViewById(R.id.imageView);
            Drawable img = SectionsPagerAdapter.getImage(page, getActivity().getApplicationContext());

            image.setImageDrawable(img);
            return view;
        }





    }
}

