package com.xydz.suppliermateriallabelprintingtool.service.impl;

import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.mapper.SuppUserMapper;
import com.xydz.suppliermateriallabelprintingtool.service.SuppUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SuppUserServiceImpl implements SuppUserService {

    @Resource
    private SuppUserMapper userMapper;

    @Transactional
    @Override
    public SuppUser selSuppUser(String suppCode ){
        return userMapper.selSuppUser(suppCode);
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
}
