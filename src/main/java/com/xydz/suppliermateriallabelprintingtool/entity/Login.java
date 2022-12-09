package com.xydz.suppliermateriallabelprintingtool.entity;

public class Login {
    private SuppUser suppUser;
    private Integer State;//0管理,1其它

    public SuppUser getSuppUser() {
        return suppUser;
    }

    public void setSuppUser(SuppUser suppUser) {
        this.suppUser = suppUser;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }
}
