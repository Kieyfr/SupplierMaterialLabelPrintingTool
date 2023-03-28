package com.xydz.suppliermateriallabelprintingtool.mapper;

import com.xydz.suppliermateriallabelprintingtool.entity.Print;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintHistory;
import com.xydz.suppliermateriallabelprintingtool.entity.ShowPrintHistory;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PrintHistoryMapper {

    //添加打印历史记录
    Integer insPrintHistory(PrintHistory printHistory);

    //删除对应的打印历史
    Integer delPrintHistory(@Param("PK_ORDER_B")String PK_ORDER_B,@Param("LOTNUM") String LOTNUM);

    //查询打印历史数量
    Print selPrintHistoryNum(@Param("PK_ORDER_B") String PK_ORDER_B,@Param("SUPPLOTNUM") String SUPPLOTNUM);

    //查询对应的打印历史
    List<ShowPrintHistory> selPrintHistory(@Param("PK_ORDER_B") String PK_ORDER_B,@Param("SUPPLOTNUM") String SUPPLOTNUM);

    //查询对应订单物料打印历史
    List<ShowPrintHistory> selPrintHistoryB(@Param("PK_ORDER_B") String PK_ORDER_B,@Param("SUPPLOTNUM") String SUPPLOTNUM);


    //获取当前订单最大的批号
    String selMaxLOTNUM(@Param("PK_ORDER_B")String PK_ORDER_B,@Param("PRINTDATE")Date PRINTDATE);

    //删除对应所有对应历史
    Integer delAllPrintHistory(@Param("PK_ORDER_B")String PK_ORDER_B,@Param("SUPPLOTNUM") String SUPPLOTNUM);

    Integer selectPrintHistoryNum(@Param("PK_ORDER_B")String PK_ORDER_B,@Param("SUPPLOTNUM") String SUPPLOTNUM);
}
