package com.shushi.spring.blog.repositorys;

import com.shushi.spring.blog.models.ListByXuatXu;
import com.shushi.spring.blog.models.ListTest;

import javax.persistence.*;
import java.util.List;

/**
 * @author anhbt 7/31/2018
 * com.shushi.spring.blog.repositorys
 */
public class ThietBiRepositoryImpl implements ThietBiRepositoryCustom {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<ListTest> getPercentProc() {
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("ThietBiEntity.procGetPercent");
        query.execute();

        @SuppressWarnings("unchecked")
        List<ListTest> emps = query.getResultList();

        return emps;
    }

    @Override
    public List<ListByXuatXu> getPercentXuatXuProc() {
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("ThietBiEntity.procGetPercentXuatXu");
        query.execute();

        @SuppressWarnings("unchecked")
        List<ListByXuatXu> emps = query.getResultList();

        return emps;
    }

}
