package com.xydz.suppliermateriallabelprintingtool.service;

import com.xydz.suppliermateriallabelprintingtool.entity.Materiel;

import java.util.List;

public interface MaterielService {

    //获取供应商物料表
    List<Materiel> selMateriel(String suppCode);

}
