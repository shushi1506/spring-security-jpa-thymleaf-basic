package com.shushi.spring.blog.repositorys;

import com.shushi.spring.blog.models.ListTest;
import com.shushi.spring.blog.models.ThietBiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author anhbt 7/31/2018
 * com.shushi.spring.blog.services
 */
@Repository
public interface ThietBiRepository extends JpaRepository<ThietBiEntity,Long>,ThietBiRepositoryCustom {
//    @Query(value = "select new com.shushi.spring.blog.models.ListTest(round(100*(count(*) / sum(count(*)) over ()),2),tb.nhaSanXuat) from ThietBiEntity tb group by tb.nhaSanXuat")
//    List<ListTest> getListTest();
}
