package com.shushi.spring.blog.models;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author anhbt 8/2/2018
 * com.shushi.spring.blog.models
 */
public class MyFile implements Serializable {
    private static final long serialVersionUID = 1L;
    private MultipartFile multipartFile;
    private String description;
    public MultipartFile getMultipartFile() {
        return multipartFile;
    }
    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
