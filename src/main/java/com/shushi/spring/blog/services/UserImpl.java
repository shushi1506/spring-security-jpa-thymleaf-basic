package com.shushi.spring.blog.services;

import com.shushi.spring.blog.models.Role;
import com.shushi.spring.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author anhbt 7/10/2018
 * com.shushi.spring.blog.services
 */
@Service
public class UserImpl implements UserService {


    private Set<Role> roles = new HashSet<Role>() {
        {
            add(new Role(1, "ROLE_ADMIN"));
            add(new Role(2, "ROLE_USER"));
        }
    };
    private Set<Role> roleM = new HashSet<Role>() {
        {
            add(new Role(3, "ROLE_USER"));
        }
    };

    private List<User> userList = new ArrayList<User>() {{
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        add(new User(1, "admin@gmail.com", passwordEncoder.encode("123456"), roles));
        add(new User(2, "anhbt@gmail.com", passwordEncoder.encode("654321"), roleM));
    }};

    @Override
    public User findByEmail(String email) {
        return userList.stream().
                filter((x) -> email.equals(x.getEmail())).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

}
