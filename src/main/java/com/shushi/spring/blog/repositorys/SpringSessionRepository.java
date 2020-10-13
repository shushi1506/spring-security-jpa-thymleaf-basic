package com.shushi.spring.blog.repositorys;

import com.shushi.spring.blog.models.SpringSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anhbt 8/17/2018
 * com.shushi.spring.blog.repositorys
 */
@Repository
public interface SpringSessionRepository extends JpaRepository<SpringSessionEntity,String> {
        SpringSessionEntity findBySessionId(String sessionID);
}
