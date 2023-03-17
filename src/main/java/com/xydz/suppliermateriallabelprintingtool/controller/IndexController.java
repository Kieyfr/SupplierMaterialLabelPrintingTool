package com.xydz.suppliermateriallabelprintingtool.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xydz.suppliermateriallabelprintingtool.entity.*;
import com.xydz.suppliermateriallabelprintingtool.service.MaterielService;
import com.xydz.suppliermateriallabelprintingtool.service.PrintHistoryService;
import com.xydz.suppliermateriallabelprintingtool.service.PrintSheetSerivce;
import com.xydz.suppliermateriallabelprintingtool.service.SuppUserService;
import com.xydz.suppliermateriallabelprintingtool.util.LoginUtil;
import com.xydz.suppliermateriallabelprintingtool.util.LotNumUtil;
import com.xydz.suppliermateriallabelprintingtool.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private SuppUserService suppUserService;

    @Resource
    private MaterielService materielService;

    @Resource
    private PrintSheetSerivce printSheetSerivce;

    @Resource
    private PrintHistoryService printHistoryService;

    @Autowired
    private LotNumUtil lotNumUtil;

    /**
     * 获取批号
     *
     * @return materielList
     */
    @RequestMapping("getLotNum")
    public ResponseData<String> getLotNum(@RequestParam("PK_ORDER_B") String PK_ORDER_B) {
        String lotNum = lotNumUtil.getLotNum(PK_ORDER_B);
//        System.out.println("批号是"+lotNum);
        if (lotNum != null) {
            return new ResponseData<String>("200", "获取成功", lotNum);
        }
        return new ResponseData<String>("500", "获取失败", null);
    }

    /**
     * 获取物料信息列表
     *
     * @return materielList
     */
    @RequestMapping("getMateriels")
    public ResponseData<List<Materiel>> getMateriels() {
        String suppCode = LoginUtil.getLoginUser().getCODE();
        List<Materiel> materielList = materielService.selMateriel(suppCode);
        if (materielList != null) {
//            if (printSheets!=null){
//                for(PrintSheet j : printSheets){
//                    for(Materiel i : materielList){
//                        if (j.getPK_ORDER_B().equals(i.getPK_ORDER_B())){
//                            materielList.remove(materielList.indexOf(i));
//                            break;
//                        }
//                    }
//                }
//            }
            return new ResponseData<List<Materiel>>("200", "获取成功", materielList);
        }
        return new ResponseData<List<Materiel>>("404", "物料列表为空", null);
    }

    /**
     * 根据供应商代码获取物料信息列表
     *
     * @return materielList
     */
    @RequestMapping("getMaterielsByCode")
    public ResponseData<List<Materiel>> getMaterielsByCode(String suppCode) {

        List<Materiel> materielList = materielService.selMateriel(suppCode);
        if (materielList != null) {
//            if (printSheets!=null){
//                for(PrintSheet j : printSheets){
//                    for(Materiel i : materielList){
//                        if (j.getPK_ORDER_B().equals(i.getPK_ORDER_B())){
//                            materielList.remove(materielList.indexOf(i));
//                            break;
//                        }
//                    }
//                }
//            }
            return new ResponseData<List<Materiel>>("200", "获取成功", materielList);
        }
        return new ResponseData<List<Materiel>>("404", "物料列表为空", null);
    }

    /**
     * 根据物料编码获取物料信息列表
     *
     * @return materiel
     */
    @RequestMapping("getMateriel")
    public ResponseData<Materiel> getMaterielsByCode(String suppCode, String materCode) {
        Materiel materiel = materielService.getMateriel(suppCode, materCode);
        if (materiel != null) {
//            if (printSheets!=null){
//                for(PrintSheet j : printSheets){
//                    for(Materiel i : materielList){
//                        if (j.getPK_ORDER_B().equals(i.getPK_ORDER_B())){
//                            materielList.remove(materielList.indexOf(i));
//                            break;
//                        }
//                    }
//                }
//            }
            return new ResponseData<Materiel>("200", "获取成功", materiel);
        }
        return new ResponseData<Materiel>("404", "物料列表为空", null);
    }


    /**
     * 查找物料信息列表
     *
     * @return materielList
     */
    @RequestMapping("searchMateriels")
    public ResponseData<List<Materiel>> getMateriels(@RequestParam("search") String search,
                                                     @RequestParam("suppCode") String suppCode) {

        List<Materiel> materielList = materielService.searchMateriels(suppCode, search);
        if (materielList != null) {
//            if (printSheets!=null){
//                for(PrintSheet j : printSheets){
//                    for(Materiel i : materielList){
//                        if (j.getPK_ORDER_B().equals(i.getPK_ORDER_B())){
//                            materielList.remove(materielList.indexOf(i));
//                            break;
//                        }
//                    }
//                }
//            }
            return new ResponseData<List<Materiel>>("200", "获取成功", materielList);
        }
        return new ResponseData<List<Materiel>>("404", "物料列表为空", null);
    }

    /**
     * 添加打印列表
     *
     * @param printSheet
     * @return status
     */
    @RequestMapping("addPrintSheet")
    public synchronized ResponseData<Integer> addPrintSheet(PrintSheet printSheet) {
        //检测单子是否存在
        if (printSheetSerivce.selPrintSheetIfexist(printSheet.getPK_ORDER_B(), printSheet.getSUPPLOTNUM()) == null) {
//            System.out.println(printSheet);
            Integer status = printSheetSerivce.insPrintSheet(printSheet);
            if (status == 1) {
                return new ResponseData<Integer>("200", "添加成功", status);
            }
            return new ResponseData<Integer>("500", "添加失败", null);
        }
        return new ResponseData<Integer>("403", "同一订单供应商批号不能重复", null);
    }

    /**
     * 修改打印列表
     *
     * @param printSheet
     * @return status
     */
    @RequestMapping("modPrintSheet")
    public ResponseData<Integer> modPrintSheet(PrintSheet printSheet) {
        Integer status = printSheetSerivce.modPrintSheet(printSheet);
        if (status == 1) {
            return new ResponseData<Integer>("200", "修改成功", status);
        }
        return new ResponseData<Integer>("500", "修改失败", null);
    }

    /**
     * 获取供应商打印列表
     *
     * @return printSheets
     */
    @RequestMapping("getPrintSheets")
    public ResponseData<List<PrintSheet>> getPrintSheets() {
        String suppCode = LoginUtil.getLoginUser().getCODE();
        List<PrintSheet> printSheets = printSheetSerivce.selPrintSheets(suppCode);
        if (printSheets != null) {
            return new ResponseData<List<PrintSheet>>("200", "获取成功", printSheets);
        }
        return new ResponseData<List<PrintSheet>>("500", "获取失败", null);
    }

    /**
     * 根据供应商代码获取供应商打印列表
     *
     * @return printSheets
     */
    @RequestMapping("getPrintSheetsByCode")
    public ResponseData<List<PrintSheet>> getPrintSheetsByCode(String suppCode) {
        List<PrintSheet> printSheets = printSheetSerivce.selPrintSheets(suppCode);
        if (printSheets != null) {
            return new ResponseData<List<PrintSheet>>("200", "获取成功", printSheets);
        }
        return new ResponseData<List<PrintSheet>>("500", "获取失败", null);
    }

    /**
     * 条件查询供应商打印列表
     *
     * @return printSheets
     */
    @RequestMapping("getIfPrintSheets")
    public ResponseData<List<PrintSheet>> getIfPrintSheets(SelInfo selInfo) {
        selInfo.setSUPPCODE(LoginUtil.getLoginUser().getCODE());
//        System.out.println(selInfo);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        if (selInfo.getSTARTDATE()!=null){
//            Date parse = null;
//            try {
//                parse = simpleDateFormat.parse(simpleDateFormat.format(selInfo.getSTARTDATE()));
//                selInfo.setSTARTDATE(parse);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        if (selInfo.getENDDATE()!=null){
//            Date parse = null;
//            try {
//                parse = simpleDateFormat.parse(simpleDateFormat.format(selInfo.getENDDATE()));
//                selInfo.setENDDATE(parse);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(selInfo);
//        List<PrintSheet> printSheets = printSheetSerivce.selIfPrintSheets(page);
//        if (printSheets!=null){
//            return new ResponseData<List<PrintSheet>>("200","获取成功",printSheets);
//        }
        return new ResponseData<List<PrintSheet>>("500", "获取失败", null);
    }

    /**
     * 根据条件查询打印物料数量
     */
    @PostMapping("getQueryPrintSheetsTotal")
    public ResponseData<Integer> getQueryPageReports(SelInfo selInfo) {
        Integer total = printSheetSerivce.getQueryPrintSheetsTotal(selInfo);
        if (total > 0) {
            return new ResponseData<Integer>("200", "获取数量", total);
        } else {
            return new ResponseData<Integer>("200", "无数据", total);
        }

    }

    /**
     * 条件查询供应商打印列表
     *
     * @return printSheets
     */
    @RequestMapping("getIfPrintSheetsByCode")
    public ResponseData<List<PrintSheet>> getIfPrintSheetsByCode(SelInfo selInfo) {


        if (LoginUtil.getState() == 1) {
            selInfo.setSUPPCODE(LoginUtil.getLoginUser().getCODE());
        }
        List<PrintSheet> printSheets = printSheetSerivce.selIfPrintSheets(selInfo);
        if (printSheets != null) {
            return new ResponseData<List<PrintSheet>>("200", "获取成功", printSheets);
        }
        return new ResponseData<List<PrintSheet>>("500", "获取失败", null);
    }

    /**
     * 添加打印历史
     *
     * @param printHistory
     * @return status
     */
    @RequestMapping("addPrintHistory")
    public synchronized ResponseData<String> addPrintHistory(PrintHistory printHistory) {
//        System.out.println(printHistory.getPRINTDATE());
        printHistory.setLOTNUM(lotNumUtil.getLotNum(printHistory.getPK_ORDER_B()));
        Integer status = printHistoryService.insPrintHistory(printHistory);
        if (status == 1) {
            String lotNum = lotNumUtil.getLotNum(printHistory.getPK_ORDER_B());
            lotNumUtil.numAdd(printHistory.getPK_ORDER_B());
            return new ResponseData<String>("200", "添加成功", lotNum);
        } else if (status == 201) {
            String lotNum = lotNumUtil.getLotNum(printHistory.getPK_ORDER_B());
            lotNumUtil.numAdd(printHistory.getPK_ORDER_B());
            return new ResponseData<String>("201", "订单完成", lotNum);
        }
        return new ResponseData<String>("500", "添加失败", null);
    }

    /**
     * 删除对应的打印历史
     *
     * @param PK_ORDER_B
     * @return status
     */
    @RequestMapping("delPrintHistory")
    public ResponseData<Integer> delPrintHistory(@RequestParam("PK_ORDER_B") String PK_ORDER_B,
                                                 @RequestParam("LOTNUM") String LOTNUM) {
        Integer integer = printHistoryService.delPrintHistory(PK_ORDER_B, LOTNUM);
        return new ResponseData<Integer>("200", "获取成功", integer);
    }

    /**
     * 查询对应的打印历史
     *
     * @param PK_ORDER_B
     * @return status
     */
    @RequestMapping("selPrintHistory")
    public ResponseData<List<ShowPrintHistory>> selPrintHistory(SelPrintHistory selPrintHistory) {
        List<ShowPrintHistory> showPrintHistoryList = printHistoryService.selPrintHistory(selPrintHistory.getPK_ORDER_B(), selPrintHistory.getSUPPLOTNUM());
//        System.out.println(selPrintHistory.getSUPPLOTNUM());
        return new ResponseData<List<ShowPrintHistory>>("200", "获取成功", showPrintHistoryList);
    }

    /**
     * 查询对应的打印历史数量
     *
     * @param PK_ORDER_B
     * @return status
     */
    @RequestMapping("selPrintHistoryNum")
    public ResponseData<Print> selPrintHistoryNum(SelPrintHistory selPrintHistory) {
        Print print = printHistoryService.selPrintHistoryNum(selPrintHistory.getPK_ORDER_B(), selPrintHistory.getSUPPLOTNUM());
        return new ResponseData<Print>("200", "获取成功", print);
    }

    /**
     * 根据供应商ID获取供应商信息
     *
     * @return suppUser
     */
    @RequestMapping("getSupplier")
    public ResponseData<Supplier> getSupplier(@RequestParam("suppCode") String suppCode) {
        Supplier supplier = suppUserService.selSupplier(suppCode);
        return new ResponseData<Supplier>("200", "获取成功", supplier);
    }

    /**
     * 获取供应商总数
     *
     * @return suppUser
     */
    @RequestMapping("selSupplierVOTotal")
    public ResponseData<Integer> selSupplierVOTotal(@RequestParam("SUPPCODE") String SUPPCODE, @RequestParam("SUPPNAME") String SUPPNAME,
                                                    @RequestParam("SUPPSHORTNAME") String SUPPSHORTNAME, @RequestParam("loginRecordSUPPCODE") Integer loginRecordSUPPCODE) {
        Integer integer = suppUserService.selSupplierVOTotal(SUPPCODE, SUPPNAME, SUPPSHORTNAME, loginRecordSUPPCODE);
        return new ResponseData<Integer>("200", "获取成功", integer);
    }

    /**
     * 获取供应商
     *
     * @return suppUser
     */
    @RequestMapping("selSupplierVO")
    public ResponseData<List<SupplierVO>> selSupplierVO(@RequestParam("SUPPCODE") String SUPPCODE, @RequestParam("SUPPNAME") String SUPPNAME,
                                                        @RequestParam("SUPPSHORTNAME") String SUPPSHORTNAME, @RequestParam("loginRecordSUPPCODE") Integer loginRecordSUPPCODE,
                                                        @RequestParam("current") Integer current, @RequestParam("pageSize") Integer pageSize) {
        List<SupplierVO> supplierVOS = suppUserService.selSupplierVO(SUPPCODE, SUPPNAME, SUPPSHORTNAME, loginRecordSUPPCODE, current, pageSize);
        return new ResponseData<List<SupplierVO>>("200", "获取成功", supplierVOS);
    }

    /**
     * 清除登录信息
     *
     * @return SUPPCODE
     */
    @RequestMapping("delSuppUser")
    public ResponseData<String> delSuppUser(@RequestParam("SUPPCODE") String SUPPCODE) {

        int i = suppUserService.delSuppUser(SUPPCODE);
        if (i>0){
            return new ResponseData<String >("200", "删除成功", null);
        }else {
            return new ResponseData<String>("400", "删除失败", null);
        }
    }
    /**
     * 重置密码
     *
     * @return SUPPCODE
     */
    @RequestMapping("resetPWD")
    public ResponseData<String> resetPWD(@RequestParam("SUPPCODE") String SUPPCODE) {
        String pwd=Md5Util.getMD5String(SUPPCODE);
        int i = suppUserService.updateSuppUserPWD(SUPPCODE,pwd);
        if (i>0){
            return new ResponseData<String >("200", "修改成功", null);
        }else {
            return new ResponseData<String>("400", "修改失败", null);
        }
    }
    /**
     * 修改密码
     *
     * @return SUPPCODE
     */
    @RequestMapping("updatePWD")
    public ResponseData<String> updatePWD(@RequestParam("SUPPCODE") String SUPPCODE,@RequestParam("PWD") String PWD) {
        int i = suppUserService.updateSuppUserPWD(SUPPCODE,PWD);
        if (i>0){
            return new ResponseData<String >("200", "修改成功", null);
        }else {
            return new ResponseData<String>("400", "修改失败", null);
        }
    }
}
