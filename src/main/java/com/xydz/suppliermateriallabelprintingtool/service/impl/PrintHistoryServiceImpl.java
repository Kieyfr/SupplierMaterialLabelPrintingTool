package com.xydz.suppliermateriallabelprintingtool.service.impl;

import com.xydz.suppliermateriallabelprintingtool.entity.PrintHistory;
import com.xydz.suppliermateriallabelprintingtool.mapper.PrintHistoryMapper;
import com.xydz.suppliermateriallabelprintingtool.service.PrintHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrintHistoryServiceImpl implements PrintHistoryService {

    @Resource
    private PrintHistoryMapper printHistoryMapper;

    @Transactional
    @Override
    public Integer insPrintHistory(PrintHistory printHistory) {
        return printHistoryMapper.insPrintHistory(printHistory);
    }

    @Transactional
    @Override
    public List<PrintHistory> selPrintHistory(String PK_ORDER_B) {
        return printHistoryMapper.selPrintHistory(PK_ORDER_B);
    }
}
