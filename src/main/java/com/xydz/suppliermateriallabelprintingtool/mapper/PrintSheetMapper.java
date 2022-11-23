package com.xydz.suppliermateriallabelprintingtool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrintSheetMapper {

    Integer insPrintSheets(PrintSheet printSheet);

    List<PrintSheet> selPrintSheets(@Param("suppCode")String suppCode);

}
