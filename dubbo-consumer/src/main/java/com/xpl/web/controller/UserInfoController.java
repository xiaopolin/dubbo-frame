package com.xpl.web.controller;

import com.xpl.entity.po.AnimalInfoPO;
import com.xpl.entity.po.UserInfoPO;
import com.xpl.entity.constant.ErrorCodeConstant;
import com.xpl.framework.ResultView;
import com.xpl.service.AnimalInfoService;
import com.xpl.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private AnimalInfoService animalInfoService;

    @GetMapping(value = "exclude")
    public ResultView<?> exclude(UserInfoPO userInfoPO){
        ResultView<?> result = new ResultView<>();

        log.trace("trace日志打印");
        log.debug("debug日志打印");
        log.info("info日志打印");
        log.warn("warn日志打印");
        log.error("error日志打印");
        result.setCode(ErrorCodeConstant.CODE_SUCCESS);
        result.setMsg(ErrorCodeConstant.ERRORMSG_EXCEPTION);
        return result;
    }

    @GetMapping(value = "user/{id}")
    public ResultView<UserInfoPO> getUser(@PathVariable("id") int id){
        ResultView<UserInfoPO> result = new ResultView<>();

        result.setData(userInfoService.getById(id));
        return result;
    }

    @GetMapping(value = "animal/{id}")
    public ResultView<AnimalInfoPO> getAnimal(@PathVariable("id") int id){
        ResultView<AnimalInfoPO> result = new ResultView<>();

        result.setData(animalInfoService.getById(id));
        return result;
    }



}
