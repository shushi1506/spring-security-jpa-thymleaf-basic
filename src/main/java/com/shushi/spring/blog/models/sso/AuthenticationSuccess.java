package com.shushi.spring.blog.models.sso;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author anhbt 8/30/2018
 * com.shushi.spring.blog.models.sso
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthenticationSuccess {
    @XmlElement(name = "user",namespace = "http://www.yale.edu/tp/cas")
    private String user;
    private Attributes attributes;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AuthenticationSuccess{" +
                "user='" + user + '\'' +
                ", attributes=" + attributes.toString() +
                '}';
    }
}
