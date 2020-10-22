package com.example.prove06;

/**
 * This is essentially an EntityBean that holds the information for the description of weather conditions:
 *
 * An example of the JSON we expect is:
 *  {
 *  "id": 800,
 *  "main": "Clear",
 *  "description": "clear sky",
 *  "icon": "01d"
 *  }
 */
public class WeatherDescription {
    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
