package com.xydz.suppliermateriallabelprintingtool.service.impl;

import com.xydz.suppliermateriallabelprintingtool.entity.Materiel;
import com.xydz.suppliermateriallabelprintingtool.mapper.MaterielMapper;
import com.xydz.suppliermateriallabelprintingtool.service.MaterielService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterielServiceImpl implements MaterielService {

    @Resource
    private MaterielMapper materielMapper;

    @Override
    public List<Materiel> selMateriel() {
        return materielMapper.selMateriel();
    }
}
