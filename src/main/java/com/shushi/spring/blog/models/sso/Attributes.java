package com.shushi.spring.blog.models.sso;

/**
 * @author anhbt 8/31/2018
 * com.shushi.spring.blog.models.sso
 */
public class Attributes {
    private String ten;
    private String email;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "ten='" + ten + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
