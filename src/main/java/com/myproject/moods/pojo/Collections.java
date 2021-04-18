package com.myproject.moods.pojo;

import lombok.Builder;

import java.io.Serializable;
@Builder
public class Collections implements Serializable {
    private Long sayId;

    private String username;

    private static final long serialVersionUID = 1L;

    public Long getSayId() {
        return sayId;
    }

    public void setSayId(Long sayId) {
        this.sayId = sayId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}