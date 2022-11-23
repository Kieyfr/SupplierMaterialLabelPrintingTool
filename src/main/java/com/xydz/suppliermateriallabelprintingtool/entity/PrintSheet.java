package com.xydz.suppliermateriallabelprintingtool.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
public class PrintSheet {

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

    private Date PRODUCEDATE;           //生产日期

    private Double NETWEIGHT;           //净重

    private Double GROSSWEIGHT;         //毛重

    private Boolean PRINT;         //毛重

}
