package com.jean.entity.owm.hour;

/**
 * Created by Alex on 06.08.15.
 */
public class SysOWM {

    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        return "Sys [pod=" + pod + "]";
    }
}
