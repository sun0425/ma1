package com.qf.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by lucifer on 2019.7.25.0025.
 */
@Mapper
public interface SubclassProductDao {

    /*int delete(Integer id);*/
    int deletesp(Integer id);
    int deleteop(Integer id);
    int deletepp(Integer id);
    int deletesup(Integer id);
    int deletesop(Integer id);

}
