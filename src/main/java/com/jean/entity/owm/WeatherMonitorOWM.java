package com.jean.entity.owm;

/**
 * Created by Alex on 06.08.15.
 */
public class WeatherMonitorOWM {
    private long id;

    private String main;

    private String description;

    private String icon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "WeatherMonitorOWM [id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + "]";
    }

}
