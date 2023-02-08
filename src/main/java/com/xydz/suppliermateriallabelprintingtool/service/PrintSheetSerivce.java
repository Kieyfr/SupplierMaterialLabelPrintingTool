package com.xydz.suppliermateriallabelprintingtool.service;



import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import com.xydz.suppliermateriallabelprintingtool.entity.SelInfo;

import java.util.List;

public interface PrintSheetSerivce  {

    //检查打印表是否有了该订单
    PrintSheet selPrintSheetIfexist(String pkOrderB,String suppLotnum);

    //添加到打印表
    Integer insPrintSheet(PrintSheet printSheet);

    //查询到供应商的打印表
    List<PrintSheet> selPrintSheets(String suppCode);

    //查询到供应商的全部完成打印表
    List<PrintSheet> selAllPrintSheets(String suppCode);

    //查询到供应商的打印表
    List<PrintSheet> selIfPrintSheets(SelInfo selInfo);

    //查询到供应商的打印表数据数量

    Integer getQueryPrintSheetsTotal(SelInfo selInfo);

    //修改供应商的打印表
    Integer modPrintSheet(PrintSheet printSheet);

    //修改打印表为完成
    Integer modPrintSheetPrint(String PK_ORDER_B);

}
