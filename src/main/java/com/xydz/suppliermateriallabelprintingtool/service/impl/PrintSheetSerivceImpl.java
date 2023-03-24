package com.xydz.suppliermateriallabelprintingtool.service.impl;


import com.xydz.suppliermateriallabelprintingtool.entity.Print;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import com.xydz.suppliermateriallabelprintingtool.entity.SelInfo;
import com.xydz.suppliermateriallabelprintingtool.mapper.PrintHistoryMapper;
import com.xydz.suppliermateriallabelprintingtool.mapper.PrintSheetMapper;
import com.xydz.suppliermateriallabelprintingtool.service.PrintSheetSerivce;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrintSheetSerivceImpl implements PrintSheetSerivce {

    @Resource
    private PrintSheetMapper printSheetMapper;

    @Resource
    private PrintHistoryMapper printHistoryMapper;

    @Transactional
    @Override
    public PrintSheet selPrintSheetIfexist(String pkOrderB, String suppLotnum) {
        return printSheetMapper.selPrintSheetIfexist(pkOrderB, suppLotnum);
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
        if (selInfo.getPrint().equals("有")) {
            List<PrintSheet> printSheets = printSheetMapper.selIfHavePrintSheets(selInfo);
            return printSheets;
        } else if (selInfo.getPrint().equals("无")) {
            List<PrintSheet> printSheets = printSheetMapper.selIfNothingPrintSheets(selInfo);
            return printSheets;
        } else {
            List<PrintSheet> printSheets = printSheetMapper.selIfAllPrintSheets(selInfo);
            return printSheets;
        }
    }

    @Override
    public Integer getQueryPrintSheetsTotal(SelInfo selInfo) {
        if (selInfo.getPrint().equals("有")) {
            return printSheetMapper.getQueryHavePrintSheetsTotal(selInfo);
        } else if (selInfo.getPrint().equals("无")) {
            return printSheetMapper.getQueryNothingPrintSheetsTotal(selInfo);
        } else {
            Integer PrintSheetsTotal1 = printSheetMapper.getQueryHavePrintSheetsTotal(selInfo);
            Integer PrintSheetsTotal2 = printSheetMapper.getQueryNothingPrintSheetsTotal(selInfo);
            return PrintSheetsTotal1 + PrintSheetsTotal2;
        }
    }

    @Override
    public Integer modPrintSheet(PrintSheet printSheet) {
        return printSheetMapper.modPrintSheet(printSheet);
    }

    @Override
    public Integer modPrintSheetPrint(String PK_ORDER_B) {
        return printSheetMapper.modPrintSheetPrint(PK_ORDER_B);
    }


    @Override
    @Transactional
    public int delPrintSheet(String PK_ORDER_B, String SUPPLOTNUM) {
        Integer integer = printHistoryMapper.selectPrintHistoryNum(PK_ORDER_B, SUPPLOTNUM);
        int a = printSheetMapper.delPrintSheet(PK_ORDER_B, SUPPLOTNUM);
        if (integer > 0) {
            int b = printHistoryMapper.delAllPrintHistory(PK_ORDER_B, SUPPLOTNUM);
            if (a > 0 && b > 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return a;
        }
    }

}
