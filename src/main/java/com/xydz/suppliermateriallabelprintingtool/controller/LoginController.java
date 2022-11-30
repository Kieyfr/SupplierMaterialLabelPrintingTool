package com.xydz.suppliermateriallabelprintingtool.controller;

import com.xydz.suppliermateriallabelprintingtool.entity.ResponseData;
import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.service.SuppUserService;
import com.xydz.suppliermateriallabelprintingtool.util.JwtUtil;
import com.xydz.suppliermateriallabelprintingtool.util.LoginUtil;
import com.xydz.suppliermateriallabelprintingtool.util.Md5Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author xiachenchen
 * @ClassName: LoginController
 * @Description: 登录页面接口 TODO
 * @Date 2022/11/22
*/

@RestController
public class LoginController {

    @Resource
    private SuppUserService suppUserService;

    /**
     * 获取供应商名称
     *
     * @return suppUser
    */
    @RequestMapping("getSuppName")
    public ResponseData<SuppUser> getSuppName(@RequestParam("suppCode")String suppCode){
        System.out.println(suppCode);
        SuppUser suppUser = suppUserService.selSuppUser(suppCode);
        if (suppUser!=null){
            if (suppUserService.selSupp(suppCode)==null){
                return new ResponseData<SuppUser>("201","供应商第一次登录",suppUser);
            }
            return new ResponseData<SuppUser>("200","获取成功",suppUser);
        }
        return new ResponseData<SuppUser>("404","供应商代码不存在",null);
    }

    /**
     * 供应商第一次登录设置密码
     *
     * @return suppUser
     */
    @RequestMapping("addSuppUser")
    public ResponseData<Integer> addSuppUser(SuppUser suppUser){
        System.out.println(suppUser);
        suppUser.setPWD(Md5Util.getMD5String(suppUser.getPWD()));
        int i = suppUserService.insertSuppUser(suppUser);
        if (i>0){
            return new ResponseData<Integer>("200","添加成功",i);
        }
        return new ResponseData<Integer>("500","添加失败",i);
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
            if (suppUser.getPWD().equals(Md5Util.getMD5String(password))){
                String token = JwtUtil.sign(suppUser);
                return new ResponseData<String>("200","登录成功",token);
            }
            return new ResponseData<String>("401","密码错误",null);
        }
        return new ResponseData<String>("404","供应商不存在",null);
    }

    /**
     * 获取供应商信息
     *
     * @return suppUser
     */
    @RequestMapping("getSuppUser")
    public ResponseData<SuppUser> getSuppUser(){
        SuppUser suppUser = LoginUtil.getLoginUser();
        return new ResponseData<SuppUser>("200","获取成功",suppUser);
    }

}
