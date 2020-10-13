package com.shushi.spring.blog.models.sso;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author anhbt 8/30/2018
 * com.shushi.spring.blog.models.sso
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "serviceResponse",namespace = "http://www.yale.edu/tp/cas")
public class ServiceResponse {
    @XmlElement(namespace = "http://www.yale.edu/tp/cas",name = "authenticationSuccess")
    private AuthenticationSuccess authenticationSuccess;

    public AuthenticationSuccess getAuthenticationSuccess() {
        return authenticationSuccess;
    }

    public void setAuthenticationSuccess(AuthenticationSuccess authenticationSuccess) {
        this.authenticationSuccess = authenticationSuccess;
    }
}
