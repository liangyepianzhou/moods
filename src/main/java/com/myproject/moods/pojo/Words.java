package com.myproject.moods.pojo;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class Words implements Serializable {
    private Byte wordId;

    private String word;

    private Integer goodnums;

    private static final long serialVersionUID = 1L;

    public Byte getWordId() {
        return wordId;
    }

    public void setWordId(Byte wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getGoodnums() {
        return goodnums;
    }

    public void setGoodnums(Integer goodnums) {
        this.goodnums = goodnums;
    }
}