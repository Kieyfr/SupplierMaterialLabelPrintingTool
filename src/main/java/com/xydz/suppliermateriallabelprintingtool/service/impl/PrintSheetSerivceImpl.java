package com.xydz.suppliermateriallabelprintingtool.service.impl;

import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import com.xydz.suppliermateriallabelprintingtool.mapper.PrintSheetMapper;
import com.xydz.suppliermateriallabelprintingtool.service.PrintSheetSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrintSheetSerivceImpl implements PrintSheetSerivce {

    @Resource
    private PrintSheetMapper printSheetMapper;

    @Override
    public Integer insPrintSheets(PrintSheet printSheet) {
        return printSheetMapper.insPrintSheets(printSheet);
    }

    @Override
    public List<PrintSheet> selPrintSheets(String suppCode) {
        return printSheetMapper.selPrintSheets(suppCode);
    }
}
