package com.xydz.suppliermateriallabelprintingtool.util;

import com.xydz.suppliermateriallabelprintingtool.entity.Login;
import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;

/**
 * @Author xiachenchen
 * @ClassName: LoginUtil
 * @Description: 登录用户信息工具类 TODO
 * @Date 2022/11/22
*/

public class LoginUtil {
    private static ThreadLocal<Login> threadLocal = new ThreadLocal<Login>();
    public static void setLoginUser(Login login){

        threadLocal.set(login);
    }

    public static SuppUser getLoginUser(){
        Login login=threadLocal.get();
        SuppUser suppUser = login.getSuppUser();
        return suppUser;
    }



    public static Integer getState(){
        Login login=threadLocal.get();
        Integer state = login.getState();
        return state;
    }
    public static void remove(){
        threadLocal.remove();
    }
}
