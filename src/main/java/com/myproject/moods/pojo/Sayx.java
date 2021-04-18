package com.myproject.moods.pojo;

import java.util.Arrays;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-18
 */
public class Sayx {
    Says says;
    String [] pictures;
    String ad;

    public Says getSays() {
        return says;
    }

    public void setSays(Says says) {
        this.says = says;
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Sayx{" +
                "says=" + says +
                ", pictures=" + Arrays.toString(pictures) +
                ", ad='" + ad + '\'' +
                '}';
    }
}
