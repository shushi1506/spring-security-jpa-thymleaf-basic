package com.shushi.spring.blog.services;

import com.shushi.spring.blog.models.User;

/**
 * @author anhbt 7/10/2018
 * com.shushi.spring.blog.services
 */
public interface UserService {
    public User findByEmail(String email);
    public void save(User user);
}
