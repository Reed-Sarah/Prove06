package com.example.prove06;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tempOnclick(View view) {
        EditText cityInput = findViewById(R.id.city);
        String city = cityInput.getText().toString();
        Temp temp = new Temp(city, this);
        Thread thread = new Thread(temp);
        thread.start();
    }

    public void forecastOnclick(View view) {
        EditText cityInput = findViewById(R.id.city);
        String city = cityInput.getText().toString();
        Forecast forecast = new Forecast(city, this);
        Thread thread = new Thread(forecast);
        thread.start();
    }
}