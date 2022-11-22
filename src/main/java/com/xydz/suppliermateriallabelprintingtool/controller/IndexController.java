package com.xydz.suppliermateriallabelprintingtool.controller;

import com.xydz.suppliermateriallabelprintingtool.entity.Materiel;
import com.xydz.suppliermateriallabelprintingtool.entity.ResponseData;
import com.xydz.suppliermateriallabelprintingtool.service.MaterielService;
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

    /**
     * 获取物料信息列表
     *
     * @return materielList
    */
    @RequestMapping("getMateriels")
    public ResponseData<List<Materiel>> getMateriels(){
        List<Materiel> materielList = materielService.selMateriel();
        if (materielList!=null){
            return new ResponseData<List<Materiel>>("200","获取成功",materielList);
        }
        return new ResponseData<List<Materiel>>("404","物料列表为空",null);
    }

}
