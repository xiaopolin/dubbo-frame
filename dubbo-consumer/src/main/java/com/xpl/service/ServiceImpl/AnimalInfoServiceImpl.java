package com.xpl.service.ServiceImpl;

import com.xpl.entity.po.AnimalInfoPO;
import com.xpl.dubbo.AnimalInfoDubbo;
import com.xpl.service.AnimalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("animalInfoService")
public class AnimalInfoServiceImpl implements AnimalInfoService {

    @Autowired
    private AnimalInfoDubbo animalInfoDubbo;

    @Override
    public AnimalInfoPO getById(int id) {
        return animalInfoDubbo.getById(id);
    }
}
