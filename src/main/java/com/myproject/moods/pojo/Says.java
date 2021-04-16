package com.myproject.moods.pojo;

import java.io.Serializable;

public class Says implements Serializable {
    private Long sayId;

    private String saywords;

    private String picture;

    private String var;

    private static final long serialVersionUID = 1L;

    public Long getSayId() {
        return sayId;
    }

    public void setSayId(Long sayId) {
        this.sayId = sayId;
    }

    public String getSaywords() {
        return saywords;
    }

    public void setSaywords(String saywords) {
        this.saywords = saywords;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
}