package com.myproject.moods.pojo;


import java.util.HashMap;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-21
 */
public class WordNode {

    /**
     * 下一级节点，可以有很多个不同的
     */
    private  HashMap<String,WordNode>  nextNode;

    private String value ;

    public HashMap<String, WordNode> getNextNode() {
        return nextNode;
    }

    public void setNextNode(HashMap<String, WordNode> nextNode) {
        this.nextNode = nextNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
