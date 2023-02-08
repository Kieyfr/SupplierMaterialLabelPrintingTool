package com.xydz.suppliermateriallabelprintingtool.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private String Print;               //是否有打印记录,1有，0无


    private String STARTDATE;             //起始日期

    private String ENDDATE;           //截止日期

    private Integer pageSize;   //每页的数量

    private Integer current;    //当前页码

}
