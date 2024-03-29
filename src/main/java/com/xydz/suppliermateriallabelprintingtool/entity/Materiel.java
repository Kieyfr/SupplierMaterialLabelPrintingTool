package com.xydz.suppliermateriallabelprintingtool.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author xiachenchen
 * @ClassName: Materiel
 * @Description: 物料类 TODO
 * @Date 2022/11/22
*/
@Data
public class Materiel {

    private String PK_ORDER;           //采购订单主键

    private String PK_ORDER_B;           //采购订单明细主键

    private String VBILLCODE;           //订单号

    private String MATERCODE;           //物料编码

    private String MATERNAME;           //物料名称

    private String MATERMATERIALSPEC;   //物料规格

    private String MATERMATERIALTYPE;   //物料颜色

    private Double NUM;                 //订单数量

    private String DBILLDATE;             //采购日期

}
