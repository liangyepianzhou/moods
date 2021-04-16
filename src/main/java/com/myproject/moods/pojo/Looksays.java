package com.myproject.moods.pojo;

import java.io.Serializable;

public class Looksays implements Serializable {
    private String username;

    private Long sayId;

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSayId() {
        return sayId;
    }

    public void setSayId(Long sayId) {
        this.sayId = sayId;
    }
}