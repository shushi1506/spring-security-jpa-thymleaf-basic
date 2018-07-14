package com.shushi.spring.blog.services;

import com.shushi.spring.blog.models.BlogDmTinhThanhEntity;
import com.shushi.spring.blog.repositorys.BlogDmTinhThanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author anhbt 7/5/2018
 * com.shushi.spring.blog.services
 */
@Service
@Primary
public class BlogDmTinhThanhJpaImpl implements BlogDmTinhThanhService {
    @Autowired
    private BlogDmTinhThanhRepository blogDmTinhThanhRepository;
    @Override
    public List<BlogDmTinhThanhEntity> findAll() {
        return blogDmTinhThanhRepository.findAll();
    }

    @Override
    public Page<BlogDmTinhThanhEntity> findPage(Pageable pageRequest) {
        return blogDmTinhThanhRepository.findAll(pageRequest);
    }

    @Override
    public BlogDmTinhThanhEntity findOne(Long id) {
        return blogDmTinhThanhRepository.getOne(id);
    }
}
