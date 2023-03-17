package com.xydz.suppliermateriallabelprintingtool.service;

import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.entity.Supplier;
import com.xydz.suppliermateriallabelprintingtool.entity.SupplierVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuppUserService {

    //获取供应商信息
    SuppUser selSuppUser(String suppCode);

    //根据供应商代码获取供应商信息
    Supplier selSupplier(String suppCode);

    //获取所有供应商信息
    List<SuppUser> adminSelSuppUser();

    //获取供应商用户表中供应商信息
    SuppUser selSupp(String suppCode);

    //添加供应商到供应商用户表
    int insertSuppUser(SuppUser suppUser);

    //获取所有供应商信息数量
    Integer selSupplierVOTotal(String SUPPCODE, String SUPPNAME,
                               String SUPPSHORTNAME,Integer loginRecordSUPPCODE);

    //获取所有供应商信息
    List<SupplierVO> selSupplierVO(String SUPPCODE, String SUPPNAME,
                                   String SUPPSHORTNAME, Integer loginRecordSUPPCODE,
                                   Integer current, Integer pageSize);

    int delSuppUser(String suppCode);

    int updateSuppUserPWD(String suppCode,String PWD);

}
