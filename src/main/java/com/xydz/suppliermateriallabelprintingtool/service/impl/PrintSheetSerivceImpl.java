package com.xydz.suppliermateriallabelprintingtool.service.impl;

import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import com.xydz.suppliermateriallabelprintingtool.entity.SelInfo;
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
    public PrintSheet selPrintSheetIfexist(String pkOrderB,String suppLotnum) {
        return printSheetMapper.selPrintSheetIfexist(pkOrderB,suppLotnum);
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

    @Override
    public List<PrintSheet> selAllPrintSheets(String suppCode) {
        return printSheetMapper.selAllPrintSheets(suppCode);
    }

    @Override
    public List<PrintSheet> selIfPrintSheets(SelInfo selInfo) {
        return printSheetMapper.selIfPrintSheets(selInfo);
    }

    @Override
    public Integer modPrintSheet(PrintSheet printSheet) {
        return printSheetMapper.modPrintSheet(printSheet);
    }

    @Override
    public Integer modPrintSheetPrint(String PK_ORDER_B) {
        return printSheetMapper.modPrintSheetPrint(PK_ORDER_B);
    }
}
