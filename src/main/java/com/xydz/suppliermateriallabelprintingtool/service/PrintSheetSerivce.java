package com.xydz.suppliermateriallabelprintingtool.service;


import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;

import java.util.List;

public interface PrintSheetSerivce  {

    //检查打印表是否有了该订单
    PrintSheet selPrintSheetIfexist(String pkOrderB);

    //添加到打印表
    Integer insPrintSheet(PrintSheet printSheet);

    //查询到供应商的打印表
    List<PrintSheet> selPrintSheets(String suppCode);

}
