package com.xydz.suppliermateriallabelprintingtool.mapper;

import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuppUserMapper{

    //获取供应商信息
    SuppUser selSuppUser(@Param("suppCode")String suppCode);

    //根据供应商代码获取供应商信息
    Supplier selSupplier(@Param("suppCode")String suppCode);

    //获取所有供应商信息
    List<SuppUser> adminSelSuppUser();

    //获取供应商用户表中供应商信息
    SuppUser selSupp(@Param("suppCode")String suppCode);

    //添加供应商到供应商用户表
    int insertSuppUser(SuppUser suppUser);

}
