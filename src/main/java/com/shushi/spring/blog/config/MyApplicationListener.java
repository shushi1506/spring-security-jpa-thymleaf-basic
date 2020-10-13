package com.shushi.spring.blog.config;

import com.shushi.spring.blog.models.SpringSessionEntity;
import com.shushi.spring.blog.repositorys.SpringSessionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author anhbt 8/17/2018
 * com.shushi.spring.blog.config
 */
@Component
public class MyApplicationListener implements AuthenticationSuccessHandler {
    Logger logger= LogManager.getLogger(MyApplicationListener.class);
    @Autowired
    SpringSessionRepository springSessionRepository;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        HttpSession httpSession = httpServletRequest.getSession();
        SpringSessionEntity t = new SpringSessionEntity();
        t.setPrimaryId(httpSession.getId());
        t.setSessionId(httpSession.getId());
        t.setCreationTime(httpSession.getCreationTime());
        t.setLastAccessTime(httpSession.getLastAccessedTime());
        t.setMaxInactiveInterval(httpSession.getMaxInactiveInterval());
        t.setExpiryTime(httpSession.getCreationTime());
        t.setPrincipalName(authUser.getUsername());
        logger.info(t.toString());
        springSessionRepository.save(t);
        //set our response to OK status
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        //since we have created our custom success handler, its up to us to where
        //we will redirect the user after successfully login
        httpServletResponse.sendRedirect("/");
    }
}
