package com.example.prove06;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Forecast implements Runnable {
    private static final String TAG = "Temp Activity" ;
    private String city;
    private String forecastListItem;
    List<String> forecastList = new ArrayList<String>();
    private Activity activity;


    public Forecast(String city, Activity activity) {
        this.activity = activity;
        this.city = city;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void run() {
        String message = "getting the forecast for " + city + " on a background thread.";
        Log.d(TAG, message);

        WeatherDataLoader loader = new WeatherDataLoader();
        try {
            WeatherForecast forecast = loader.getForecast(city);
            for (WeatherForecastItem item : forecast.getForecastItems()) {
                String time = item.getDateText();
                float temp = item.getMeasurements().get("temp");

                String conditions = "";
                if (item.getDescriptions().size() > 0) {
                    conditions = item.getDescriptions().get(0).getDescription();
                }

                float wind = item.getWind().get("speed");

                forecastListItem = String.format("%nTime: %s%nTemp: %s\u00b0F%nConditions: %s%nWind Speed: %smph%n",
                        time, temp, conditions, wind);
                //Log.d(TAG, forecastListItem);

                forecastList.add(forecastListItem);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
       Log.d(TAG, forecastList.toString());

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // This is the code that will run on the UI thread.
                ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, forecastList);
                ListView listView = activity.findViewById(R.id.forecast);
                listView.setAdapter(itemsAdapter);

            }
        });
    }
}
