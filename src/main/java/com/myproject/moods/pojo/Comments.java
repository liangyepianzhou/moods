package com.myproject.moods.pojo;

import lombok.Builder;

import java.io.Serializable;
@Builder
public class Comments implements Serializable {
    private Long commentId;

    private Long sayId;

    private String contexts;

    private Byte goodnum;

    private String username;

    private static final long serialVersionUID = 1L;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getSayId() {
        return sayId;
    }

    public void setSayId(Long sayId) {
        this.sayId = sayId;
    }

    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    public Byte getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(Byte goodnum) {
        this.goodnum = goodnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}