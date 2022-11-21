package com.xydz.suppliermateriallabelprintingtool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import org.apache.ibatis.annotations.Param;

public interface SuppUserMapper extends BaseMapper<SuppUser> {

    //获取供应商名称
    String selSuppName(@Param("suppCode")String suppCode);

    //获取供应商用户表中供应商信息
    SuppUser selSupp(@Param("suppCode")String suppCode);

    //添加供应商到供应商用户表
    int insertSuppUser(SuppUser suppUser);

}
