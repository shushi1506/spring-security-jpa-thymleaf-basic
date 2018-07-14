package com.shushi.spring.blog.common;

import java.util.Arrays;

/**
 * @author anhbt 7/10/2018
 * com.shushi.spring.blog.common
 */
public class CommonUtils {
    public static void showString(String... temp) {
        Arrays.stream(temp).forEach((x) -> {
            System.out.println(x + "\t");
        });
    }

    public static boolean checkString(String temp, boolean isSingle, String... a) {
        if (isSingle) {
            return temp != null && !temp.isEmpty();
        }else {
            return !Arrays.stream(a).anyMatch(x->!checkString(x,true));
        }
    }
}
