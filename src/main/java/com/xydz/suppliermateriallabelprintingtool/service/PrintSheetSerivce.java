package com.xydz.suppliermateriallabelprintingtool.service;


import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;

import java.util.List;

public interface PrintSheetSerivce  {

    Integer insPrintSheets(PrintSheet printSheet);

    List<PrintSheet> selPrintSheets(String suppCode);

}
