package com.myproject.moods.pojo;

import java.io.Serializable;

public class Words implements Serializable {
    private Byte wordId;

    private String word;

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
}