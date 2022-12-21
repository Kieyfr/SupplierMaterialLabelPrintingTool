package com.xydz.suppliermateriallabelprintingtool.entity;

import lombok.Data;

@Data
public class Login {
    private SuppUser suppUser;
    private Integer State;//0管理,1其它


}
