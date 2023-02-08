package com.xydz.suppliermateriallabelprintingtool.service;

import com.xydz.suppliermateriallabelprintingtool.entity.Materiel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterielService {

    //获取供应商物料表
    List<Materiel> selMateriel(String suppCode);

    //查询供应商物料表
    List<Materiel> searchMateriels(String suppCode,String search);

    //根据供应商代码和物料编码查询供应商物料表
    Materiel getMateriel(String suppCode,String MATERCODE);

}
