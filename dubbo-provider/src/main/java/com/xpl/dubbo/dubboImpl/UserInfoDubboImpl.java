package com.xpl.dubbo.dubboImpl;

import com.xpl.api.po.UserInfoPO;
import com.xpl.dao.UserInfoDao;
import com.xpl.dubbo.UserInfoDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class UserInfoDubboImpl implements UserInfoDubbo {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfoPO getById(int id) {
        return userInfoDao.getById(id);
    }
}
