package com.myproject.moods.pojo;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;
@Builder
public class Barrage implements Serializable {
    private Long barId;

    private String username;

    private Date extime;

    private String runtime;

    private Byte goodnum;

    private String contexts;

    private Byte fontsize;

    private Byte speed;

    private String color;

    private String var;

    private static final long serialVersionUID = 1L;

    public Long getBarId() {
        return barId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getExtime() {
        return extime;
    }

    public void setExtime(Date extime) {
        this.extime = extime;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Byte getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(Byte goodnum) {
        this.goodnum = goodnum;
    }

    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    public Byte getFontsize() {
        return fontsize;
    }

    public void setFontsize(Byte fontsize) {
        this.fontsize = fontsize;
    }

    public Byte getSpeed() {
        return speed;
    }

    public void setSpeed(Byte speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
}