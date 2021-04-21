package com.myproject.moods.filter;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * 敏感词过滤器
 */

public class SensitiveWordFilter {
    @SuppressWarnings("rawtypes")
    public static Map sensitiveWordMap = null;
    /**
     * 最小匹配规则
     */
    public static int minMatchTYpe = 1;
    /**
     * 最大匹配规则
     */
    public static int maxMatchType = 2;

    public  final String wordPath ="src/main/resources/file/sensitiveWord/";
    /**
     * 构造函数，初始化敏感词库
     */
    private   static void initKeyWord(String wordPath) {
        File file =new File(wordPath);
        sensitiveWordMap = SensitiveWordInit.initKeyWord(file.getAbsolutePath());
    }

    /**
     * 判断文字是否包含敏感字词
     * @param txt       文字
     * @param matchType 匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
     * @return 若包含返回true，否则返回false
     * @version 1.0
     */
    public static boolean isContaintSensitiveWord(String txt, int matchType) {
        boolean flag = false;
        if (txt == null) {
            return flag;
        }
        txt = txt.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "");

        for (int i = 0; i < txt.length(); i++) {
            //判断是否包含敏感字符
            int matchFlag = CheckSensitiveWord(txt, i, matchType);
            if (matchFlag > 0) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取文字中的敏感词
     *
     * @param txt       文字
     * @param matchType 匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
     * @return Set<String>
     */
    public static Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordList = new HashSet<String>();
        txt = txt.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "");

        for (int i = 0; i < txt.length(); i++) {
            //判断是否包含敏感字符
            int length = CheckSensitiveWord(txt, i, matchType);
            if (length > 0) {
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;
            }
        }
        return sensitiveWordList;
    }
    /**
     * 替换敏感字字符
     *
     * @param txt
     * @param matchType
     * @param replaceChar 替换字符，默认*
     */
    public static String replaceSensitiveWord(String txt, int matchType, String replaceChar) {
        String resultTxt = txt;
        Set<String> set = getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word = null;
        String replaceString = null;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }
        return resultTxt;
    }
    /**
     * 替换敏感字字符
     *
     * @param txt
     * @param replaceChar 替换字符，默认*
     */
    public static  String replaceSensitiveWord(String txt,  String replaceChar,Set sensitive) {
        String resultTxt = txt;
        Iterator<String> iterator = sensitive.iterator();
        String word = null;
        String replaceString = null;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }
        return resultTxt;
    }

    /**
    /**
     * 获取替换字符串
     *
     * @param replaceChar
     * @param length
     * @return
     * @version 1.0
     */
    private static String getReplaceChars(String replaceChar, int length) {
        String resultReplace = replaceChar;
        for (int i = 1; i < length; i++) {
            resultReplace += replaceChar;
        }
        return resultReplace;
    }

    /**
     * 检查文字中是否包含敏感字符，检查规则如下：
     *
     * @param txt
     * @param beginIndex
     * @param matchType
     * @return int
     */
    @SuppressWarnings({"rawtypes"})
    private  static int CheckSensitiveWord(String txt, int beginIndex, int matchType) {
        boolean flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况
        int matchFlag = 0;     //匹配标识数默认为0
        char word = 0;
        Map nowMap = sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            nowMap = (Map) nowMap.get(word);     //获取指定key
            if (nowMap != null) {     //存在，则判断是否为最后一个
                matchFlag++;     //找到相应key，匹配标识+1
                if ("1".equals(nowMap.get("isEnd"))) {       //如果为最后一个匹配规则,结束循环，返回匹配标识数
                    flag = true;       //结束标志位为true
                    if (minMatchTYpe == matchType) {    //最小规则，直接返回,最大规则还需继续查找
                        break;
                    }
                }
            } else {     //不存在，直接返回
                break;
            }
        }
        if (matchFlag < 2 || !flag) {        //长度必须大于等于1，为词
            matchFlag = 0;
        }
        return matchFlag;
    }


}
