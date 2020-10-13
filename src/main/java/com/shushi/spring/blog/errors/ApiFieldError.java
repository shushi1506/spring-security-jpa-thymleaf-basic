package com.shushi.spring.blog.errors;

/**
 * @author anhbt 7/29/2018
 * com.shushi.spring.blog.errors
 */
public class ApiFieldError {
    private String field;
    private String code;
    private Object rejectedValue;
    private String defaultMess;

    public ApiFieldError(String field, String code, String defaultMess) {
        this.field = field;
        this.code = code;
        this.defaultMess = defaultMess;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getDefaultMess() {
        return defaultMess;
    }

    public void setDefaultMess(String defaultMess) {
        this.defaultMess = defaultMess;
    }
}
