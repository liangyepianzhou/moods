package com.myproject.moods.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 初始化敏感词库，将敏感词加入到HashMap中，构建DFA算法模型
 */
public class SensitiveWordInit {
    /**
     * 字符编码
     */
    private static String ENCODING = "UTF-8";
    @SuppressWarnings("rawtypes")
    public static HashMap sensitiveWordMap;

    public static Map initKeyWord(String wordPath) {
        try {
            Set<String> keyWordSet = readSensitiveWordFile(wordPath);
            addSensitiveWordToHashMap(keyWordSet);
            System.out.println("敏感词库初始化成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveWordMap;
    }

    /**
     * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br>
     *
     */
    private static void addSensitiveWordToHashMap(Set<String> keyWordSet) {
        sensitiveWordMap = new HashMap(keyWordSet.size());
        String key = null;
        //迭代keyWordSet
        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            addSensitiveWordToHashMap(key);
        }
    }

    public static void addSensitiveWordToHashMap(String keyWordSet) {
        String key;
        Map nowMap;
        Map<String, String> newWorMap;
        //迭代keyWordSet
        key = keyWordSet;    //关键字
        nowMap = sensitiveWordMap;
        for (int i = 0; i < key.length(); i++) {
            char keyChar = key.charAt(i);       //转换成char型
            Object wordMap = nowMap.get(keyChar);       //获取

            if (wordMap != null) {        //如果存在该key，直接赋值
                nowMap = (Map) wordMap;
            } else {     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                newWorMap = new HashMap<>();
                newWorMap.put("isEnd", "0");     //不是最后一个
                nowMap.put(keyChar, newWorMap);
                nowMap = newWorMap;
            }

            if (i == key.length() - 1) {
                nowMap.put("isEnd", "1");    //最后一个
            }
        }
    }

    /**
     * 读取敏感词库中的内容，将内容添加到set集合中
     *
     * @return Set<String>
     * @throws Exception
     */
    private static Set<String> readSensitiveWordFile(String wordPath) throws Exception {
        Set<String> set = null;

        File file = new File(wordPath);
        //读取文件
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), ENCODING);
        try {
            if (file.isFile() && file.exists()) {
                //文件流是否存在
                set = new HashSet<String>();
                BufferedReader bufferedReader = new BufferedReader(read);
                String txt = null;
                //读取文件，将文件内容放入到set中
                while ((txt = bufferedReader.readLine()) != null) {
                    set.add(txt);
                }
            } else {
                throw new Exception("敏感词库文件不存在");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            read.close();
        }
        return set;
    }
}
