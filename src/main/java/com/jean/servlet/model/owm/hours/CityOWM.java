package com.jean.servlet.model.owm.hours;

import com.jean.servlet.model.owm.CoordOWM;

/**
 * Created by Alex on 06.08.15.
 */
public class CityOWM {

    private long id;

    private String name;

    private CoordOWM coord;

    private String country;

    private long population;

    private int cod;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordOWM getCoord() {
        return coord;
    }

    public void setCoord(CoordOWM coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "CityOWM [id=" + id + ", name=" + name + ", coord=" + coord + ", country=" + country + ", population=" + population + ", cod=" + cod
                + "]";
    }
}
