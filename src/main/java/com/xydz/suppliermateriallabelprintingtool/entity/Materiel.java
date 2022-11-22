package com.xydz.suppliermateriallabelprintingtool.entity;

import lombok.Data;

/**
 * @Author xiachenchen
 * @ClassName: Materiel
 * @Description: 物料类 TODO
 * @Date 2022/11/22
*/
@Data
public class Materiel {
    private String MATERCODE;           //物料编码

    private String MATERNAME;           //物料名称

    private String MATERMATERIALSPEC;   //物料规格

    private String MATERMATERIALTYPE;   //物料颜色

    private Double NUM;                 //主数量

    private Double REMNUM;              //剩余数量

    private String MEASCODE;            //单位编码

    private String MEASNAME;            //单位名称
}
