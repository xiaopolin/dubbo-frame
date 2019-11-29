package com.xpl.dubbo.dubboImpl;

import com.xpl.entity.po.AnimalInfoPO;
import com.xpl.dao.AnimalInfoDao;
import com.xpl.dubbo.AnimalInfoDubbo;
import org.springframework.beans.factory.annotation.Autowired;

public class AnimalInfoDubboImpl implements AnimalInfoDubbo {

    @Autowired
    private AnimalInfoDao animalInfoDao;

    @Override
    public AnimalInfoPO getById(int id) {
        return animalInfoDao.getById(id);
    }
}
