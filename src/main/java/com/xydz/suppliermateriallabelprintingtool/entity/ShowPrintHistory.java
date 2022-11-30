package com.xydz.suppliermateriallabelprintingtool.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ShowPrintHistory {

    private String PK_ORDER;          //采购订单主键

    private String PK_ORDER_B;        //采购订单明细主键

    private String MATERNAME;           //物料名称

    private String SUPPMATERCODE;       //供应商料号

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date PRODUCEDATE;           //生产日期

    private String LOTNUM;            //批号

    private Double NETWEIGHT;           //净重

    private Double GROSSWEIGHT;         //毛重

    private String SUPPLOTNUM;          //供应商批号

    private String MATERMATERIALSPEC;   //物料规格

    private String MATERMATERIALTYPE;   //物料颜色
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date PRINTDATE;           //打印日期

}
