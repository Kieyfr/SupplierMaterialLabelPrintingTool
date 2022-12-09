package com.xydz.suppliermateriallabelprintingtool.entity;

import lombok.Data;

/**
 * @Author xiachenchen
 * @ClassName: SuppUser
 * @Description: 用户类 TODO
 * @Date 2022/11/22
*/

@Data
public class SuppUser {
    private String CODE;    //供应商代码



    private String NAME;    //供应商全称

    private String SHORTNAME;    //供应商简称

    private String PWD;     //供应商密码


}
