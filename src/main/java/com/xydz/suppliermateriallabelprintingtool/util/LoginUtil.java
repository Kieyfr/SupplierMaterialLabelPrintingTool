package com.xydz.suppliermateriallabelprintingtool.util;

import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;

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
