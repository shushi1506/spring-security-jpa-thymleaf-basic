package com.shushi.spring.blog.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author anhbt 8/1/2018
 * com.shushi.spring.blog.models
 */
@Entity
public class ListByXuatXu {
    @Id
    private long id;
    private Double percent;
    private String xuatXu;

    public ListByXuatXu() {
    }

    public ListByXuatXu(long id, Double percent, String xuatXu) {
        this.id = id;
        this.percent = percent;
        this.xuatXu = xuatXu;
    }

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

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    @Override
    public String toString() {
        return "ListByXuatXu{" +
                "id=" + id +
                ", percent=" + percent +
                ", xuatXu='" + xuatXu + '\'' +
                '}';
    }
}
