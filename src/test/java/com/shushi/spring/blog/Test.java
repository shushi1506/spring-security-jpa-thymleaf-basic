package com.shushi.spring.blog;

import com.shushi.spring.blog.common.CommonUtils;

/**
 * @author anhbt 7/13/2018
 * com.shushi.spring.blog
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(CommonUtils.checkString("a",true));
        System.out.println(CommonUtils.checkString("",true));
        System.out.println(CommonUtils.checkString(null,true));
        System.out.println(CommonUtils.checkString(null,false,"abc","aaa","ddd"));
        System.out.println(CommonUtils.checkString(null,false,"abc","","ddd"));
        System.out.println(CommonUtils.checkString(null,false,"abc",null,"ddd"));
    }
}
