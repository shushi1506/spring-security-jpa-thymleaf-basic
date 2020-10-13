package com.shushi.spring.blog.repositorys;

import com.shushi.spring.blog.models.ListByXuatXu;
import com.shushi.spring.blog.models.ListTest;

import java.util.List;

/**
 * @author anhbt 7/31/2018
 * com.shushi.spring.blog.repositorys
 */
public interface ThietBiRepositoryCustom {
    List<ListTest>getPercentProc();
    List<ListByXuatXu>getPercentXuatXuProc();
}
