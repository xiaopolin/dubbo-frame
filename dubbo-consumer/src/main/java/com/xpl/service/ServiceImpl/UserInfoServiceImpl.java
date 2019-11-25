package com.xpl.service.ServiceImpl;

import com.xpl.api.po.UserInfoPO;
import com.xpl.dubbo.UserInfoDubbo;
import com.xpl.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDubbo userInfoDubbo;

    @Override
    public UserInfoPO getById(int id) {
        return userInfoDubbo.getById(id);
    }

}
