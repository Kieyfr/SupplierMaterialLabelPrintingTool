package com.xydz.suppliermateriallabelprintingtool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrintSheetMapper {

    //检查打印表是否有了该订单
    PrintSheet selPrintSheetIfexist(@Param("pkOrderB")String pkOrderB);

    //添加到打印表
    Integer insPrintSheet(PrintSheet printSheet);

    //查询到供应商的打印表
    List<PrintSheet> selPrintSheets(@Param("suppCode")String suppCode);

}
