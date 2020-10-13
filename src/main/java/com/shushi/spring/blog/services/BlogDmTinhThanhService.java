package com.shushi.spring.blog.services;

import com.shushi.spring.blog.models.BlogDmTinhThanhEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author anhbt 7/5/2018
 * com.shushi.spring.blog.services
 */
public interface BlogDmTinhThanhService {
    List<BlogDmTinhThanhEntity>findAll();
    Page<BlogDmTinhThanhEntity> findPage(Pageable pageable);
    BlogDmTinhThanhEntity findOne(Long id);
    Page<BlogDmTinhThanhEntity> findBySearch(String tenTinhThanh,Pageable pageable);
}
