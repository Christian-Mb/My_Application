package com.example.tp3_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listview;
    PlaneteAdapter adapter;
    private Button button = null;
    private int score = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listView);
        adapter = new PlaneteAdapter(MainActivity.this.getLayoutInflater(),MainActivity.this.getApplicationContext());
        listview.setAdapter(adapter);
        button= (Button) findViewById(R.id.button);

        button.setOnClickListener(check);
    }

    private View.OnClickListener check = new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            if(adapter.isVerif()){
                score =0;
                ViewGroup view;
                Spinner s;
                String text= "";

                System.out.println("oui");

                for (int i= 1; i< adapter.getPlanetes().size(); i++){

                     view = (ViewGroup) listview.getChildAt(i);
                     s= (Spinner) view.findViewById(R.id.spinner);
                     text = s.getSelectedItem().toString();

                     System.out.println(text);
                     if (text.equals(adapter.getData().getTaillePlanetes()[i-1])) score++;

                }



                if (score>=4)Toast.makeText(MainActivity.this,"Bravo, vous aviez obtenu le score de : "+score,Toast.LENGTH_SHORT).show();
                else   Toast.makeText(MainActivity.this,"Sorry, culture trop faible! "+score,Toast.LENGTH_SHORT).show();



            }
            else{
                System.out.println("non");
                Toast.makeText(MainActivity.this,"Veuillez crocher tous les résultats",Toast.LENGTH_SHORT).show();
            }

        }
    };



}

