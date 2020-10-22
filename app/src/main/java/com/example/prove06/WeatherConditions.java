package com.example.prove06;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * This is essentially an EntityBean that holds the information for a single city's current weather
 */
public class WeatherConditions {
    private String id;
    private String name;

    @SerializedName("main")
    private Map<String, Float> measurements;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }
}
