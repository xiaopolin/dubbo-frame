package com.xpl.dao;

import com.xpl.entity.po.AnimalInfoPO;
import org.apache.ibatis.annotations.Param;

public interface AnimalInfoDao {

    public AnimalInfoPO getById(@Param("id") int id);
}
