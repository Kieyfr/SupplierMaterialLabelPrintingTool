package com.xydz.suppliermateriallabelprintingtool.service;

import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;

public interface SuppUserService {

    //获取供应商信息
    SuppUser selSuppUser(String suppCode);

    //获取供应商用户表中供应商信息
    SuppUser selSupp(String suppCode);

    //添加供应商到供应商用户表
    int insertSuppUser(SuppUser suppUser);

}
