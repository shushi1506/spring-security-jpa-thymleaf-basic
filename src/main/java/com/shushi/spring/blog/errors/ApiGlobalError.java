package com.shushi.spring.blog.errors;

/**
 * @author anhbt 7/29/2018
 * com.shushi.spring.blog.errors
 */
public class ApiGlobalError {
    private String code;

    public ApiGlobalError(String code) {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
