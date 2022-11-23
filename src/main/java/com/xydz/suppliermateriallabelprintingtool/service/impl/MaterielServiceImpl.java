package com.xydz.suppliermateriallabelprintingtool.service.impl;

import com.xydz.suppliermateriallabelprintingtool.entity.Materiel;
import com.xydz.suppliermateriallabelprintingtool.mapper.MaterielMapper;
import com.xydz.suppliermateriallabelprintingtool.service.MaterielService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterielServiceImpl implements MaterielService {

    @Resource
    private MaterielMapper materielMapper;

    @Transactional
    @Override
    public List<Materiel> selMateriel(String suppCode) {
        return materielMapper.selMateriel(suppCode);
    }
}
