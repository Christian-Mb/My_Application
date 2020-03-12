package com.example.heureservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int n =0;
    private  Intent intent = null ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button serviceBtn = (Button) findViewById(R.id.serviceBtn);
        final Button serviceBtn2 = (Button) findViewById(R.id.serviceBtn2);

        serviceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isServiceRunning("com.example.heureservice.HeureService")){
                    serviceBtn2.setText("Service En cours");

                }
                else{
                    serviceBtn2.setText("Demarrer le service");
                }


            }
        });




        serviceBtn.setOnClickListener( new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                intent = new Intent(MainActivity.this, HeureService.class);
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

    private boolean isServiceRunning(String nomService) {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (nomService.equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isServiceRunning("com.example.heureservice.HeureService"))stopService(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
       if(n==1)  startService(intent);
    }
}
