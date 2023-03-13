package com.xydz.suppliermateriallabelprintingtool.service;

import com.xydz.suppliermateriallabelprintingtool.entity.Print;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintHistory;
import com.xydz.suppliermateriallabelprintingtool.entity.ShowPrintHistory;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PrintHistoryService {

    //添加打印历史记录
    Integer insPrintHistory(PrintHistory printHistory);

    //删除对应的打印历史
    Integer delPrintHistory(String PK_ORDER_B,String LOTNUM);

    //查询打印历史数量
    Print selPrintHistoryNum(String PK_ORDER_B,String SUPPLOTNUM);

    //查询对应的打印历史
    List<ShowPrintHistory> selPrintHistory(String PK_ORDER_B,String SUPPLOTNUM);


    //获取最大的订单批号
    String selMaxLOTNUM(String PK_ORDER_B, Date PRINTDATE);

}
