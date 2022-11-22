package com.xydz.suppliermateriallabelprintingtool.mapper;

import com.xydz.suppliermateriallabelprintingtool.entity.Materiel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterielMapper {

    //获取供应商物料表
    List<Materiel> selMateriel(@Param("suppCode") String suppCode);

}
