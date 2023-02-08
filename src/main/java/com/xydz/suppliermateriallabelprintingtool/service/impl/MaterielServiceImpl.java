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

    @Override
    public List<Materiel> searchMateriels(String suppCode, String search) {
        return materielMapper.searchMateriels(suppCode,search);
    }

    @Override
    public Materiel getMateriel(String suppCode, String matercode) {
        return materielMapper.getMateriel(suppCode,matercode);
    }
}
