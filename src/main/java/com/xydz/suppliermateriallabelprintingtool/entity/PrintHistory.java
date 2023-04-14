package com.xydz.suppliermateriallabelprintingtool.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PrintHistory {

    private String PK_ORDER;          //采购订单主键

    private String PK_ORDER_B;        //采购订单明细主键

    private String SUPPCODE;            //供应商代码

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date PRODUCEDATE;           //生产日期

    private String LOTNUM;            //批号

    private Double NETWEIGHT;           //净重

    private Double GROSSWEIGHT;         //毛重

    private String SUPPLOTNUM;          //供应商批号

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date PRINTDATE;           //打印日期

    private String PALLET;          //托盘码，将所有一起的批号记录下来,用，隔开

    private Boolean HF;             //是否选了HF选了1未选0

}
