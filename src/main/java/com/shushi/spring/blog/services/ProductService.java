package com.shushi.spring.blog.services;

import com.shushi.spring.blog.models.Product;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

/**
 * @author anhbt 7/7/2018
 * com.shushi.spring.blog.services
 */
public interface ProductService {
    public List<Product>findAll();
    public Product findById(long id);
    public Product findByName(String search);
}
