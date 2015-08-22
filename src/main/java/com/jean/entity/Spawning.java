package com.jean.entity;

import java.util.Date;

/**
 * Created by stas on 22.08.15.
 */
public class Spawning {

    private int id;

    private Date spawning;

    private Date gluttony;

    private Date sick;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSpawning() {
        return spawning;
    }

    public void setSpawning(Date spawning) {
        this.spawning = spawning;
    }

    public Date getGluttony() {
        return gluttony;
    }

    public void setGluttony(Date gluttony) {
        this.gluttony = gluttony;
    }

    public Date getSick() {
        return sick;
    }

    public void setSick(Date sick) {
        this.sick = sick;
    }
}
