package com.shushi.spring.blog.services;

import com.shushi.spring.blog.models.SpringSessionEntity;

/**
 * @author anhbt 8/15/2018
 * com.shushi.spring.blog.services
 */
public interface SessionService {

     SpringSessionEntity save(SpringSessionEntity temp);
}
