package com.shushi.spring.blog.config;

import com.shushi.spring.blog.models.SpringSessionEntity;
import com.shushi.spring.blog.repositorys.SpringSessionRepository;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author anhbt 8/15/2018
 * com.shushi.spring.blog.config
 */
@Configuration
public class HttpSessionConfig {
    org.apache.logging.log4j.Logger logger= LogManager.getLogger(HttpSessionConfig.class);
    @Autowired
    SpringSessionRepository springSessionRepository;

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher() {
            @Override
            public void sessionCreated(HttpSessionEvent event) {
                logger.info("Session created:"+event.getSession().getId());
                HttpSession httpSession = event.getSession();
                SpringSessionEntity t = new SpringSessionEntity();
                t.setPrimaryId(httpSession.getId());
                t.setSessionId(httpSession.getId());
                t.setCreationTime(httpSession.getCreationTime());
                t.setLastAccessTime(httpSession.getLastAccessedTime());
                t.setMaxInactiveInterval(httpSession.getMaxInactiveInterval());
                t.setExpiryTime(httpSession.getCreationTime());
                logger.info(t.toString());
                springSessionRepository.save(t);
                super.sessionCreated(event);
            }

            @Override
            public void sessionDestroyed(HttpSessionEvent event) {
                logger.info("Session delete:" + event.getSession().getId());
                try{
                    if(springSessionRepository.existsById(event.getSession().getId())) {
                        springSessionRepository.deleteById(event.getSession().getId());
                    }
                }catch (Exception e){
                }
                super.sessionDestroyed(event);
            }
        };
    }


    @Bean                   // bean for http session attribute listener
    public HttpSessionAttributeListener httpSessionAttributeListener() {
        return new HttpSessionAttributeListener() {
            @Override
            public void attributeAdded(HttpSessionBindingEvent se) {            // This method will be automatically called when session attribute added
                System.out.println("Attribute Added following information");
                System.out.println("Attribute Name:" + se.getName());
                System.out.println("Attribute Value:" + se.getName());
            }

            @Override
            public void attributeRemoved(HttpSessionBindingEvent se) {      // This method will be automatically called when session attribute removed
                System.out.println("attributeRemoved");
            }

            @Override
            public void attributeReplaced(HttpSessionBindingEvent se) {     // This method will be automatically called when session attribute replace
                System.out.println("Attribute Replaced following information");
                System.out.println("Attribute Name:" + se.getName());
                System.out.println("Attribute Old Value:" + se.getValue());
            }
        };
    }

}
