package com.example.tp6exo4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class MainActivity extends AppCompatActivity {

    private LocationManager locationMgr = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(MainActivity.this, Geolocalisation.class));


//enregistrer le locationListener pour procéder à la mise à jour
// de la géolocalisation, en se servant des points d'accès wifi,
//toutes les 10000 millisecondes, si la distance parcourue par rapport à
// la mesure précédente est supérieure à 0 mètre, en invoquant la méthode
// onLocationChanged( location) du locationListener
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET ) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.INTERNET},
                        222);


                requestPermissions(new String[] {Manifest.permission.ACCESS_COARSE_LOCATION},
                        222);


                requestPermissions(new String[] {Manifest.permission.INTERNET},
                        222);





            }


            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        else {
            locationMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationMgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, locationListener);

        }

//enregistrer le locationListener pour procéder à la mise à jour
// de la géolocalisation, en se servant du gps,
//toutes les 10000 millisecondes, si la distance parcourue par rapport à
// la mesure précédente est supérieure à 0 mètre, en invoquant la méthode
// onLocationChanged( location) du locationListener
//        locationMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, locationListener);




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 222:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, " Permission Granted", Toast.LENGTH_SHORT)
                            .show();
                    // Permission Granted put your code here




                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

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
}
