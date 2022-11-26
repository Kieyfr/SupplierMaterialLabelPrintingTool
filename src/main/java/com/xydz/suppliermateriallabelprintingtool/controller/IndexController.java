package com.xydz.suppliermateriallabelprintingtool.controller;

import com.xydz.suppliermateriallabelprintingtool.entity.Materiel;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintHistory;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import com.xydz.suppliermateriallabelprintingtool.entity.ResponseData;
import com.xydz.suppliermateriallabelprintingtool.service.MaterielService;
import com.xydz.suppliermateriallabelprintingtool.service.PrintHistoryService;
import com.xydz.suppliermateriallabelprintingtool.service.PrintSheetSerivce;
import com.xydz.suppliermateriallabelprintingtool.util.LoginUtil;
import com.xydz.suppliermateriallabelprintingtool.util.LotNumUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xiachenchen
 * @ClassName: IndexController
 * @Description: 主页接口 TODO
 * @Date 2022/11/22
*/
@RestController
public class IndexController {

    @Resource
    private MaterielService materielService;

    @Resource
    private PrintSheetSerivce printSheetSerivce;

    @Resource
    private PrintHistoryService printHistoryService;

    /**
     * 获取批号
     *
     * @return materielList
     */
    @RequestMapping("getLotNum")
    public ResponseData<String> getLotNum(){
        String suppCode = LoginUtil.getLoginUser().getCODE();
        String lotNum = LotNumUtil.getLotNum(suppCode);
        if (lotNum!=null){
            return new ResponseData<String>("200","获取成功",lotNum);
        }
        return new ResponseData<String>("500","获取失败",null);
    }

    /**
     * 获取物料信息列表
     *
     * @return materielList
    */
    @RequestMapping("getMateriels")
    public ResponseData<List<Materiel>> getMateriels(){
        String suppCode = LoginUtil.getLoginUser().getCODE();
        List<Materiel> materielList = materielService.selMateriel(suppCode);
        if (materielList!=null){
            return new ResponseData<List<Materiel>>("200","获取成功",materielList);
        }
        return new ResponseData<List<Materiel>>("404","物料列表为空",null);
    }

    /**
     * 添加打印列表
     *
     * @param printSheet
     * @return status
     */
    @RequestMapping("addPrintSheet")
    public ResponseData<Integer> addPrintSheet(PrintSheet printSheet){
        //检测单子是否存在（暂废弃）
//        if (printSheetSerivce.selPrintSheetIfexist(printSheet.getPK_ORDER_B())==null){
        System.out.println(printSheet);
            Integer status = printSheetSerivce.insPrintSheet(printSheet);
            if (status==1){
                return new ResponseData<Integer>("200","添加成功",status);
            }
//        }
        return new ResponseData<Integer>("500","添加失败",null);
    }

    /**
     * 获取供应商打印列表
     *
     * @return printSheets
     */
    @RequestMapping("getPrintSheets")
    public ResponseData<List<PrintSheet>> getPrintSheets(){
        String suppCode = LoginUtil.getLoginUser().getCODE();
        List<PrintSheet> printSheets = printSheetSerivce.selPrintSheets(suppCode);
        if (printSheets!=null){
            return new ResponseData<List<PrintSheet>>("200","获取成功",printSheets);
        }
        return new ResponseData<List<PrintSheet>>("500","获取失败",null);
    }

    /**
     * 添加打印历史
     *
     * @param printHistory
     * @return status
     */
    @RequestMapping("addPrintHistory")
    public ResponseData<Integer> addPrintHistory(PrintHistory printHistory){

            Integer status = printHistoryService.insPrintHistory(printHistory);
            if (status==1){
                LotNumUtil.numAdd(printHistory.getSUPPCODE());
                return new ResponseData<Integer>("200","添加成功",status);
            }
        return new ResponseData<Integer>("500","添加失败",null);
    }

    /**
     * 查询对应的打印历史
     *
     * @param PK_ORDER_B
     * @return status
     */
    @RequestMapping("selPrintHistory")
    public ResponseData<List<PrintHistory> > selPrintHistory(@RequestParam("PK_ORDER_B")String PK_ORDER_B){
        List<PrintHistory> printHistories = printHistoryService.selPrintHistory(PK_ORDER_B);
        return new ResponseData<List<PrintHistory> >("200","获取成功",printHistories);
    }

}
