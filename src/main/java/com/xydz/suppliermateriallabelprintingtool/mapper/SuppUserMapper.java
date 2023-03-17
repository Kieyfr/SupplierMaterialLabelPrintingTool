package com.xydz.suppliermateriallabelprintingtool.mapper;

import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.entity.Supplier;
import com.xydz.suppliermateriallabelprintingtool.entity.SupplierVO;
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

    //获取所有供应商信息
    List<SupplierVO> selSupplierVO(@Param("SUPPCODE")String SUPPCODE,@Param("SUPPNAME")String SUPPNAME,
                                   @Param("SUPPSHORTNAME")String SUPPSHORTNAME,@Param("loginRecordSUPPCODE")Integer loginRecordSUPPCODE,
                                    @Param("current")Integer current,@Param("pageSize")Integer pageSize);

    //获取所有供应商信息数量
    Integer selSupplierVOTotal(@Param("SUPPCODE")String SUPPCODE,@Param("SUPPNAME")String SUPPNAME,
                                   @Param("SUPPSHORTNAME")String SUPPSHORTNAME,@Param("loginRecordSUPPCODE")Integer loginRecordSUPPCODE);

    //删除供应商用户表信息
    int delSuppUser(@Param("suppCode")String suppCode);

    //设置密码
    int updateSuppUserPWD(@Param("suppCode")String suppCode,@Param("PWD")String PWD);
}
