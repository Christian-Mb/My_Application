package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(loginOnClickListener);
    }


    View.OnClickListener loginOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(v.getContext(),Main4Activity.class);
            intent.putExtra("username",getTxtValeur());
            startActivity(intent);
        }
    };

    public String getTxtValeur() {
        EditText zoneValeur = (EditText) findViewById(R.id.username);
        return zoneValeur.getText().toString();
    }
}


