package com.qf.dao;

import com.qf.domain.AgriculturePicture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by lucifer on 2019.7.24.0024.
 */
@Mapper
public interface AgriculturePictureDao {
    int update(AgriculturePicture agriculturePicture);
    int add(AgriculturePicture agriculturePicture);
    int deletepp(Integer pictureId);
    int deleteap(Integer pictureId);
    AgriculturePicture loadById(Integer pictureId);
    List<AgriculturePicture> loadAll();
    int countRows();
     int deleteBatch(List<Integer> list);
     int addpp(Map<String,Integer> map);
}
