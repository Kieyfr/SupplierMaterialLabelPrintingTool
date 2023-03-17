package com.xydz.suppliermateriallabelprintingtool.service.impl;

import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.entity.Supplier;
import com.xydz.suppliermateriallabelprintingtool.entity.SupplierVO;
import com.xydz.suppliermateriallabelprintingtool.mapper.SuppUserMapper;
import com.xydz.suppliermateriallabelprintingtool.service.SuppUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SuppUserServiceImpl implements SuppUserService {

    @Resource
    private SuppUserMapper userMapper;

    @Transactional
    @Override
    public SuppUser selSuppUser(String suppCode ){
        return userMapper.selSuppUser(suppCode);
    }

    @Override
    public Supplier selSupplier(String suppCode) {
        return userMapper.selSupplier(suppCode);
    }

    @Override
    public List<SuppUser> adminSelSuppUser() {
        return userMapper.adminSelSuppUser();
    }

    @Transactional
    @Override
    public SuppUser selSupp(String suppCode) {
        return userMapper.selSupp(suppCode);
    }

    @Transactional
    @Override
    public int insertSuppUser(SuppUser suppUser) {
        return userMapper.insertSuppUser(suppUser);
    }

    @Override
    public Integer selSupplierVOTotal(String SUPPCODE, String SUPPNAME, String SUPPSHORTNAME, Integer loginRecordSUPPCODE) {
        return userMapper.selSupplierVOTotal(SUPPCODE,SUPPNAME,SUPPSHORTNAME,loginRecordSUPPCODE);
    }

    @Override
    public List<SupplierVO> selSupplierVO(String SUPPCODE, String SUPPNAME, String SUPPSHORTNAME, Integer loginRecordSUPPCODE, Integer current, Integer pageSize) {
        return userMapper.selSupplierVO(SUPPCODE,SUPPNAME,SUPPSHORTNAME,loginRecordSUPPCODE,current,pageSize);
    }

    @Override
    public int delSuppUser(String suppCode) {
        return userMapper.delSuppUser(suppCode);
    }

    @Override
    public int updateSuppUserPWD(String suppCode, String PWD) {
        return userMapper.updateSuppUserPWD(suppCode,PWD);
    }


}
