package com.shushi.spring.blog.services;

import com.shushi.spring.blog.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anhbt 7/7/2018
 * com.shushi.spring.blog.services
 */
@Service
public class ProductImpl implements ProductService {
    private List<Product> products=new ArrayList<Product>(){{
        add(new Product(1,"Phông Trơn1","BTA01",100,"Cái","lamp",0,"Đen;Đỏ","Chất hịn",10,79000));
        add(new Product(2,"Phông Gió2","BTA02",100,"Cái","tulips",10,"Đen;Đỏ","Chất bình thường",10,129000));
        add(new Product(3,"Khoác Trơn3","BTA03",100,"Cái","wheel",0,"Đen;Trắng","Chất hịn",130,79000));
        add(new Product(4,"Kaki Trơn4","BTA04",100,"Chiếc","sydney",3,"Đen;Đỏ","Chất hịn",10,99000));
        add(new Product(5,"Quần Trơn5","BTA05",100,"Cái","guitarman",0,"Trắng;Đỏ","Chất hịn",10,79000));
        add(new Product(6,"Jean6","BTA06",100,"Cái","fuji",4,"Đen;Đỏ","Chất au",10,69000));
        add(new Product(7,"Crop top7","BTA07",100,"Cái","cookies",0,"Đen;Đỏ","Chất hịn",105,79000));
        add(new Product(8,"Phông Trơn8","BTA01",100,"Cái","lamp",0,"Đen;Đỏ","Chất hịn",10,79000));
        add(new Product(9,"Phông Gió9","BTA02",100,"Cái","tulips",10,"Đen;Đỏ","Chất bình thường",10,129000));
        add(new Product(10,"Khoác Trơn10","BTA03",100,"Cái","wheel",0,"Đen;Trắng","Chất hịn",130,79000));
        add(new Product(11,"Kaki Trơn11","BTA04",100,"Chiếc","sydney",3,"Đen;Đỏ","Chất hịn",10,99000));
        add(new Product(12,"Quần Trơn12","BTA05",100,"Cái","guitarman",0,"Trắng;Đỏ","Chất hịn",10,79000));
        add(new Product(13,"Jean13","BTA06",100,"Cái","fuji",4,"Đen;Đỏ","Chất au",10,69000));
        add(new Product(14,"Crop top14","BTA07",100,"Cái","cookies",0,"Đen;Đỏ","Chất hịn",105,79000));
        add(new Product(15,"Crop top15","BTA07",100,"Cái","cookies",0,"Đen;Đỏ","Chất hịn",105,79000));

    }};
    @Override
    public List<Product> findAll() {
        return this.products;
    }

    @Override
    public Product findById(long id) {
        return this.products.stream().filter((x)-> id==x.getId()).findAny().orElse(null);
    }

    @Override
    public Product findByName(String search) {
        return this.products.stream().filter(x-> search.equals(x.getTenSanPham())).findAny().orElse(null);
    }
}
