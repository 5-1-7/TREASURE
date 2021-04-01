package com.cc.common.util;

/**
 * 判断是否为空工具类  <p>on 2021/3/16 13:57
 */
public class StringUtil {

    public static boolean isEmpty(String content) {
        /*这里的if语句可简写成第14行
        if (content == null || content.length() == 0) {
            return true;
        }
        return false;*/
        return content == null || content.length() == 0;

        /*第14行效果也可写成：
        return content == null || "".equals(content);*/
    }

    public static boolean isNotEmpty(String content) {
        return !isEmpty(content);
    }
}
