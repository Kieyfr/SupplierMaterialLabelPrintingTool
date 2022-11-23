package com.xydz.suppliermateriallabelprintingtool.mapper;

import com.xydz.suppliermateriallabelprintingtool.entity.PrintHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrintHistoryMapper {

    //添加打印历史记录
    Integer insPrintHistory(PrintHistory printHistory);

    //查询对应的打印历史
    List<PrintHistory> selPrintHistory(@Param("PK_ORDER_B") String PK_ORDER_B);

}
