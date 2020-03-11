package com.example.tp6exo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LocationManager locationMgr = null;
    private LocationListener locationListener = new LocationListener() {


        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onLocationChanged(Location location) {

            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();

            Toast.makeText(getBaseContext(),
                    "Coordonnées  : " + latitude + " " + longitude,
                    Toast.LENGTH_LONG).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //retrouver le gestionnaire de géolocalisation
        locationMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

//enregistrer le locationListener pour procéder à la mise à jour
// de la géolocalisation, en se servant des points d'accès wifi,
//toutes les 10000 millisecondes, si la distance parcourue par rapport à
// la mesure précédente est supérieure à 0 mètre, en invoquant la méthode
// onLocationChanged( location) du locationListener
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationMgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, locationListener);

//enregistrer le locationListener pour procéder à la mise à jour
// de la géolocalisation, en se servant du gps,
//toutes les 10000 millisecondes, si la distance parcourue par rapport à
// la mesure précédente est supérieure à 0 mètre, en invoquant la méthode
// onLocationChanged( location) du locationListener
        locationMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, locationListener);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }



    public int onStartCommand(Intent intent, int flags, int startId)
    {
        return onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy()
    {
        super.onDestroy();
        locationMgr.removeUpdates(locationListener);
    }

}
