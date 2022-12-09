package com.xydz.suppliermateriallabelprintingtool.controller;

import com.xydz.suppliermateriallabelprintingtool.entity.Login;
import com.xydz.suppliermateriallabelprintingtool.entity.ResponseData;
import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.service.SuppUserService;
import com.xydz.suppliermateriallabelprintingtool.util.JwtUtil;
import com.xydz.suppliermateriallabelprintingtool.util.LoginUtil;
import com.xydz.suppliermateriallabelprintingtool.util.Md5Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
     * 获取所有供应商名称
     *
     * @return suppUser
     */
    @RequestMapping("adminGetSuppNames")
    public ResponseData<List<SuppUser>> adminGetSuppNames(){
        List<SuppUser> suppUserList = suppUserService.adminSelSuppUser();
        if (suppUserList!=null){
            return new ResponseData<List<SuppUser>>("200","获取成功",suppUserList);
        }
        return new ResponseData<>("404","供应商代码不存在",null);
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
                                      @RequestParam("password")String password,
                                      @RequestParam("state")Integer state){
        SuppUser suppUser = suppUserService.selSupp(suppCode);
        System.out.println(suppUser);
        if (suppUser!=null){
            if (suppUser.getPWD().equals(Md5Util.getMD5String(password))){
                Login login=new Login();
                login.setSuppUser(suppUser);
                login.setState(state);
                String token = JwtUtil.sign(login);
                return new ResponseData<String>("200","登录成功",token);
            }
            return new ResponseData<String>("401","密码错误",null);
        }
        return new ResponseData<String>("404","供应商不存在",null);
    }

    /**
     * 管理员无需密码登录
     *
     * @param  suppCode
     * @return suppName
     */
    @RequestMapping("loginAdminsupplier")
    public ResponseData<String> loginAdminsupplier(@RequestParam("suppCode")String suppCode,
                                                   @RequestParam("state")Integer state){
        SuppUser suppUser = suppUserService.selSupp(suppCode);
        if (suppUser!=null){
                Login login=new Login();
                login.setSuppUser(suppUser);
                login.setState(state);
                String token = JwtUtil.sign(login);
                return new ResponseData<String>("200","登录成功",token);
        }
        return new ResponseData<String>("404","供应商从没登录过此网站",null);
    }

    @RequestMapping("loginAdmin")
    public ResponseData<String> loginAdmin(@RequestParam("admin")String admin,
                                      @RequestParam("password")String password,
                                           @RequestParam("state")Integer state){
        if (!admin.equals("admin")){
            return new ResponseData<String>("404","账号错误",null);
        } else if (!password.equals("xinyaadmin123")) {
            return new ResponseData<String>("404","密码错误",null);
        }else{
            SuppUser suppUser=new SuppUser();
            suppUser.setNAME("admin");
            suppUser.setCODE("0");
            suppUser.setPWD("xinyaadmin123");
            suppUser.setSHORTNAME("admin");
            Login login=new Login();
            login.setSuppUser(suppUser);
            login.setState(state);
            String token = JwtUtil.sign(login);
            return new ResponseData<String>("200","登录成功",token);

        }
    }

    /**
     * 获取登录的供应商信息
     *
     * @return suppUser
     */
    @RequestMapping("getSuppUser")
    public ResponseData<SuppUser> getSuppUser(){
        SuppUser suppUser = LoginUtil.getLoginUser();
        return new ResponseData<SuppUser>("200","获取成功",suppUser);
    }
    /**
     * 获取登录state信息
     *
     * @return Integer
     */
    @RequestMapping("getState")
    public ResponseData<Integer> getState(){
        Integer state=LoginUtil.getState();
        if (state!=null){
            return new ResponseData<Integer>("200","获取成功",state);
        }else {
            return new ResponseData<Integer>("404","登录信息有误",null);
        }

    }
}
