//package com.shushi.spring.blog.config;
//
//import com.shushi.spring.blog.models.SpringSessionEntity;
//import com.shushi.spring.blog.repositorys.SpringSessionRepository;
//import com.shushi.spring.blog.services.SessionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.web.session.HttpSessionEventPublisher;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSessionEvent;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author anhbt 8/15/2018
// * com.shushi.spring.blog.config
// */
////@Component
//public class MyHttpSessionEventPublisher extends HttpSessionEventPublisher {
//    private static Map<String, HttpSession> map = new
//            HashMap<String, HttpSession>();
//
////    @Autowired
////    SessionService springSessionRepository;
//
//    @Override
//    public void sessionCreated(HttpSessionEvent event) {
////        System.out.println(event.getSession().getId());
////        map.put(event.getSession().getId(),event.getSession());
////        HttpSession httpSession=event.getSession();
////        SpringSessionEntity t=new SpringSessionEntity();
////        t.setPrimaryId(httpSession.getId());
////        t.setSessionId(httpSession.getId());
////        t.setCreationTime(httpSession.getCreationTime());
////        t.setLastAccessTime(httpSession.getLastAccessedTime());
////        t.setMaxInactiveInterval(httpSession.getMaxInactiveInterval());
////        t.setExpiryTime(httpSession.getCreationTime());
////        springSessionRepository.save(t);
//        super.sessionCreated(event);
//    }
//
//    public static HttpSession getHttpSession(String id){
//        return map.get(id);
//    }
//    public static void deleteHttpSession(String id){
//        map.remove(id);
//    }
//    @Override
//    public void sessionDestroyed(HttpSessionEvent event) {
//        //do something
//        super.sessionDestroyed(event);
//    }
//}
