package com.xydz.suppliermateriallabelprintingtool.controller;

import com.xydz.suppliermateriallabelprintingtool.entity.Materiel;
import com.xydz.suppliermateriallabelprintingtool.entity.PrintSheet;
import com.xydz.suppliermateriallabelprintingtool.entity.ResponseData;
import com.xydz.suppliermateriallabelprintingtool.service.MaterielService;
import com.xydz.suppliermateriallabelprintingtool.service.PrintSheetSerivce;
import com.xydz.suppliermateriallabelprintingtool.util.LoginUtil;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * @return status
     */
    @RequestMapping("addPrintSheet")
    public ResponseData<Integer> addPrintSheet(PrintSheet printSheet){
        System.out.println(printSheet);
        Integer status = printSheetSerivce.insPrintSheets(printSheet);
        if (status==1){
            return new ResponseData<Integer>("200","添加成功",status);
        }
        return new ResponseData<Integer>("500","添加失败",null);
    }

    /**
     * 获取打印列表
     *
     * @return status
     */
    @RequestMapping("getPrintSheets")
    public ResponseData<Integer> getPrintSheets(PrintSheet printSheet){
        System.out.println(printSheet);
        Integer status = printSheetSerivce.insPrintSheets(printSheet);
        if (status==1){
            return new ResponseData<Integer>("200","添加成功",status);
        }
        return new ResponseData<Integer>("500","添加失败",null);
    }

}
