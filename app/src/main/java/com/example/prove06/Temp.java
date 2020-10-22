package com.example.prove06;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.io.IOException;

public class Temp implements Runnable {
    private static final String TAG = "Temp Activity" ;
    private String city;
    private String temp;
    private Activity activity;


    public Temp(String city, Activity activity) {
        this.activity = activity;
        this.city = city;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void run() {
        String message = "getting the temperature for " + city + " on a background thread.";
        Log.d(TAG, message);

        WeatherDataLoader loader = new WeatherDataLoader();
        try {
            WeatherConditions conditions = loader.getWeather(city);
            temp = "The temperature in " + city + " is " + conditions.getMeasurements().get("temp").toString() + "\u00b0F";

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, temp);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // This is the code that will run on the UI thread.
                Toast toast = Toast.makeText(activity, temp, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}