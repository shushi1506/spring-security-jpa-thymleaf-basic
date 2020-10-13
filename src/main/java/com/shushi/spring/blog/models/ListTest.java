package com.shushi.spring.blog.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author anhbt 7/31/2018
 * com.shushi.spring.blog.models
 */
@Entity
public class ListTest {
    @Id
    private long id;
    private Double percent;
    private String nhaSanXuat;

    public ListTest() {
    }

    public ListTest(long id,Double percent, String nhaSanXuat) {
        this.id = id;
        this.percent = percent;
        this.nhaSanXuat = nhaSanXuat;
    }
//
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return "ListTest{" +
                "id=" + id +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }
}
