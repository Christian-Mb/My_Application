package com.example.tp6exo4;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.util.logging.Logger;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class Geolocalisation extends Service {
    public Geolocalisation() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

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
    public void onCreate() {

        //retrouver le gestionnaire de géolocalisation
        locationMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);



        super.onCreate();
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        return super.onStartCommand(intent, flags, startId);
    }



    @Override
    public void onDestroy()
    {
        super.onDestroy();
        //locationMgr.removeUpdates(onLocationChange);
    }




}
