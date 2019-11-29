package com.xpl.dubbo;

import com.xpl.entity.po.UserInfoPO;

public class UserInfoDubboMock implements UserInfoDubbo {

    @Override
    public UserInfoPO getById(int id) {
        return null;
    }
}
