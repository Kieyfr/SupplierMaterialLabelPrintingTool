package com.xydz.suppliermateriallabelprintingtool.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PrintSheet {

    private String PK_ORDER;           //采购订单主键

    private String PK_ORDER_B;           //采购订单明细主键

    private String DBILLDATE;            //数据库开票日期

    private String SUPPCODE;            //供应商代码

    private String SUPPNAME;            //供应商名称

    private String SUPPSHORTNAME;       //供应商简称

    private String SUPPMATERCODE;       //供应商料号

    private String SUPPLOTNUM;          //供应商批号

    private String VBILLCODE;           //订单号

    private String MATERCODE;           //物料编码

    private String MATERNAME;           //物料名称

    private String MATERMATERIALSPEC;   //物料规格

    private String MATERMATERIALTYPE;   //物料颜色

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date PRODUCEDATE;           //生产日期

    private Double NETWEIGHT;           //净重

    private Double GROSSWEIGHT;         //毛重

    private Double NUM;                 //订单数量

    private Boolean PRINT;         //是否打印

    private Boolean HF;             //是否选了HF选了1未选0



}
