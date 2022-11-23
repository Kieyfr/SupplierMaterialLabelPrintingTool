package com.xydz.suppliermateriallabelprintingtool.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PrintHistory {

    private String PK_ORDER;          //采购订单主键

    private String PK_ORDER_B;        //采购订单明细主键

    private String SUPPCODE;            //供应商代码

    private String LOTNUM;            //批号

    private Date PRINTDATE;           //打印日期

}
