package com.xydz.suppliermateriallabelprintingtool.util;

import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;

/**
 * @Author xiachenchen
 * @ClassName: LoginUtil
 * @Description: 登录用户信息工具类 TODO
 * @Date 2022/11/22
*/

public class LoginUtil {
    private static ThreadLocal<SuppUser> threadLocal = new ThreadLocal<SuppUser>();

    public static void setLoginUser(SuppUser suppUser){
        threadLocal.set(suppUser);
    }

    public static SuppUser getLoginUser(){
        SuppUser suppUser = threadLocal.get();
        return suppUser;
    }
    public static void remove(){
        threadLocal.remove();
    }
}
