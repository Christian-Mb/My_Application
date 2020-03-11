package com.example.heureservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int n =0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button serviceBtn = (Button) findViewById(R.id.serviceBtn);


        serviceBtn.setOnClickListener( new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, HeureService.class);

                if (n ==0){
                    serviceBtn.setText("Arrêter le service");
                    startService(intent);
                    n++;

                }
                else{
                    serviceBtn.setText("Quelle heure?");

                    stopService(intent);
                    n--;
                }
            }
        });
    }

}
