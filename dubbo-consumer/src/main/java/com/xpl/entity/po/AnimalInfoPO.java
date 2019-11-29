package com.xpl.entity.po;

import com.xpl.framework.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class AnimalInfoPO extends BaseEntity {

    private int id;
    private String name;
    private Date createTime;
    private Date updateTime;
}
