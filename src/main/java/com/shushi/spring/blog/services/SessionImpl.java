package com.shushi.spring.blog.services;

import com.shushi.spring.blog.models.SpringSessionEntity;
import com.shushi.spring.blog.repositorys.SpringSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anhbt 8/15/2018
 * com.shushi.spring.blog.services
 */
@Service
public class SessionImpl implements SessionService {
    @Autowired
    SpringSessionRepository springSessionRepository;
    private List<String> listSession=new ArrayList<String>(){
        {
            add("test1");
            add("test2");
        }
    };

    @Override
    public SpringSessionEntity save(SpringSessionEntity temp) {
       return springSessionRepository.save(temp);
    }
//    @Override
//    public boolean findSession(String sessionId) {
//        return listSession.stream().anyMatch((x)-> x.equals(sessionId));
//    }
//
//    @Override
//    public void saveSession(String sessionId) {
//        listSession.add(sessionId);
//    }

}
