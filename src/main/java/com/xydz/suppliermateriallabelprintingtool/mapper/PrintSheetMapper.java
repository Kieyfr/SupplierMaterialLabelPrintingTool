package com.xydz.suppliermateriallabelprintingtool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import com.xydz.suppliermateriallabelprintingtool.entity.SelInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrintSheetMapper {

    //检查打印表是否有了该订单
    PrintSheet selPrintSheetIfexist(@Param("pkOrderB")String pkOrderB,@Param("suppLotnum")String suppLotnum);

    //添加到打印表
    Integer insPrintSheet(PrintSheet printSheet);

    //查询到供应商的未完成打印表
    List<PrintSheet> selPrintSheets(@Param("suppCode")String suppCode);

    //查询到供应商的全部完成打印表
    List<PrintSheet> selAllPrintSheets(@Param("suppCode")String suppCode);

    //查询到供应商的打印表
    List<PrintSheet> selIfPrintSheets(SelInfo selInfo);

    //修改供应商的打印表
    Integer modPrintSheet(PrintSheet printSheet);

    //修改打印表为完成
    Integer modPrintSheetPrint(@Param("PK_ORDER_B")String PK_ORDER_B);

}
