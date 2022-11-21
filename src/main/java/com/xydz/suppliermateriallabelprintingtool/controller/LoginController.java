package com.xydz.suppliermateriallabelprintingtool.controller;

import com.xydz.suppliermateriallabelprintingtool.entity.ResponseData;
import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.service.SuppUserService;
import com.xydz.suppliermateriallabelprintingtool.util.JwtUtil;
import com.xydz.suppliermateriallabelprintingtool.util.Md5Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private SuppUserService suppUserService;

    /**
     * 获取供应商名称
     *
     * @return suppName
    */
    @RequestMapping("getSuppName")
    public ResponseData<String> getSuppName(@RequestParam("suppCode")String suppCode){
        String suppName = suppUserService.selSuppName(suppCode);
        if (suppName!=null){
            if (suppUserService.selSupp(suppCode)==null){
                SuppUser suppUser = new SuppUser();
                suppUser.setSUPPCODE(suppCode);
                suppUser.setSUPPNAME(suppName);
                suppUser.setSUPPPWD(Md5Util.getMD5String("123456"));
                suppUserService.insertSuppUser(suppUser);
            }
            return new ResponseData<String>("200","获取成功",suppName);
        }
        return new ResponseData<String>("404","供应商代码不存在",null);
    }

    /**
     * 登录
     *
     * @param  suppCode
     * @param  password
     * @return suppName
     */
    @RequestMapping("login")
    public ResponseData<String> login(@RequestParam("suppCode")String suppCode,
                                      @RequestParam("password")String password){
        SuppUser suppUser = suppUserService.selSupp(suppCode);
        if (suppUser!=null){
            if (suppUser.getSUPPPWD().equals(Md5Util.getMD5String(password))){
                String token = JwtUtil.sign(suppUser);
                return new ResponseData<String>("200","登录成功",token);
            }
            return new ResponseData<String>("401","密码错误",null);
        }
        return new ResponseData<String>("404","供应商不存在",null);
    }

}
