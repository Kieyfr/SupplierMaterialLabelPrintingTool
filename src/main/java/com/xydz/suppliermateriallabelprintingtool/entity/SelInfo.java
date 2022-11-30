package com.xydz.suppliermateriallabelprintingtool.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SelInfo {

    private String SUPPCODE;            //供应商代码

    private String SUPPMATERCODE;       //供应商料号

    private String SUPPLOTNUM;          //供应商批号

    private String VBILLCODE;           //订单号

    private String COMPLETION;          //是否完成

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date STARTDATE;             //起始日期

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ENDDATE;           //截止日期

}
