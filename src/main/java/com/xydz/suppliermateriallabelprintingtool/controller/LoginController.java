package com.xydz.suppliermateriallabelprintingtool.controller;

import com.xydz.suppliermateriallabelprintingtool.entity.ResponseData;
import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.service.SuppUserService;
import com.xydz.suppliermateriallabelprintingtool.util.Md5Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private SuppUserService userService;

    /**
     * 获取供应商名称
     *
     * @return suppName
    */
    @RequestMapping("getSuppName")
    public ResponseData<String> getSuppName(@RequestParam("suppCode")String suppCode){
        String suppName = userService.selSuppName(suppCode);
        if (suppName!=null){
            if (userService.selSupp(suppCode)==null){
                SuppUser suppUser = new SuppUser();
                suppUser.setSUPPCODE(suppCode);
                suppUser.setSUPPNAME(suppName);
                suppUser.setSUPPPWD(Md5Util.getMD5String("123456"));
                userService.insertSuppUser(suppUser);
            }
            return new ResponseData<String>("200","获取成功",suppName);
        }
        return new ResponseData<String>("404","供应商代码不存在",null);
    }

    /**
     * 获取供应商密码
     *
     * @param  suppCode
     * @param  password
     * @return suppName
     */
    @RequestMapping("login")
    public ResponseData<String> login(@RequestParam("suppCode")String suppCode,
                                      @RequestParam("password")String password){
        SuppUser suppUser = userService.selSupp(suppCode);
        if (suppUser!=null){
            if (suppUser.getSUPPPWD().equals(Md5Util.getMD5String(password))){
                return new ResponseData<String>("200","登录成功",null);
            }
            return new ResponseData<String>("401","密码错误",null);
        }
        return new ResponseData<String>("404","供应商不存在",null);
    }

}
