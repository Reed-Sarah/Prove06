package com.example.prove06;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WeatherForecast {
    @SerializedName("list")
    private List<WeatherForecastItem> forecastItems;

    public List<WeatherForecastItem> getForecastItems() {
        return forecastItems;
    }

    public void setForecastItems(List<WeatherForecastItem> forecastItems) {
        this.forecastItems = forecastItems;
    }
}