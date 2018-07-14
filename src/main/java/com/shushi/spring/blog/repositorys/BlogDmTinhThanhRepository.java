package com.shushi.spring.blog.repositorys;

import com.shushi.spring.blog.models.BlogDmTinhThanhEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author anhbt 7/4/2018
 * com.shushi.spring.blog.repositorys
 */
@Repository
public interface BlogDmTinhThanhRepository extends JpaRepository<BlogDmTinhThanhEntity,Long> {
    @Override
    List<BlogDmTinhThanhEntity> findAll();

    @Override
    Page<BlogDmTinhThanhEntity> findAll(Pageable pageable);

    @Override
    BlogDmTinhThanhEntity getOne(Long aLong);
}
