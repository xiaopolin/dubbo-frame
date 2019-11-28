package com.xpl.dubbo;

import com.xpl.api.po.UserInfoPO;

public class UserInfoDubboMock implements UserInfoDubbo {

    @Override
    public UserInfoPO getById(int id) {
        return null;
    }
}
