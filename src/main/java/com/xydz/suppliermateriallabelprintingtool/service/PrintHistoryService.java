package com.xydz.suppliermateriallabelprintingtool.service;

import com.xydz.suppliermateriallabelprintingtool.entity.PrintHistory;

import java.util.List;

public interface PrintHistoryService {

    //添加打印历史记录
    Integer insPrintHistory(PrintHistory printHistory);

    //查询对应的打印历史
    List<PrintHistory> selPrintHistory(String PK_ORDER_B);

}
