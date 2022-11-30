package com.xydz.suppliermateriallabelprintingtool.service.impl;

import com.xydz.suppliermateriallabelprintingtool.entity.Print;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintHistory;
import com.xydz.suppliermateriallabelprintingtool.entity.ShowPrintHistory;
import com.xydz.suppliermateriallabelprintingtool.mapper.PrintHistoryMapper;
import com.xydz.suppliermateriallabelprintingtool.mapper.PrintSheetMapper;
import com.xydz.suppliermateriallabelprintingtool.service.PrintHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrintHistoryServiceImpl implements PrintHistoryService {

    @Resource
    private PrintHistoryMapper printHistoryMapper;

    @Resource
    private PrintSheetMapper printSheetMapper;

    @Transactional
    @Override
    public Integer insPrintHistory(PrintHistory printHistory) {
        Integer integer = printHistoryMapper.insPrintHistory(printHistory);
        Print print = printHistoryMapper.selPrintHistoryNum(printHistory.getPK_ORDER_B());
        if (print.getHistoryNum()>=print.getNum()){
            printSheetMapper.modPrintSheetPrint(printHistory.getPK_ORDER_B());
            integer=201;
        }
        return integer;
    }

    @Override
    public Integer delPrintHistory(String PK_ORDER_B,String LOTNUM) {
        return printHistoryMapper.delPrintHistory(PK_ORDER_B,LOTNUM);
    }

    @Override
    public Print selPrintHistoryNum(String PK_ORDER_B) {
        return printHistoryMapper.selPrintHistoryNum(PK_ORDER_B);
    }

    @Transactional
    @Override
    public List<ShowPrintHistory> selPrintHistory(String PK_ORDER_B) {
        return printHistoryMapper.selPrintHistory(PK_ORDER_B);
    }
}
