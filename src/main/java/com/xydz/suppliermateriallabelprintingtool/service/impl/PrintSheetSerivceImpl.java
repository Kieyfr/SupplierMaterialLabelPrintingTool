package com.xydz.suppliermateriallabelprintingtool.service.impl;

import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import com.xydz.suppliermateriallabelprintingtool.mapper.PrintSheetMapper;
import com.xydz.suppliermateriallabelprintingtool.service.PrintSheetSerivce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrintSheetSerivceImpl implements PrintSheetSerivce {

    @Resource
    private PrintSheetMapper printSheetMapper;

    @Transactional
    @Override
    public PrintSheet selPrintSheetIfexist(String pkOrderB) {
        return printSheetMapper.selPrintSheetIfexist(pkOrderB);
    }

    @Transactional
    @Override
    public Integer insPrintSheet(PrintSheet printSheet) {
        return printSheetMapper.insPrintSheet(printSheet);
    }

    @Transactional
    @Override
    public List<PrintSheet> selPrintSheets(String suppCode) {
        return printSheetMapper.selPrintSheets(suppCode);
    }
}
