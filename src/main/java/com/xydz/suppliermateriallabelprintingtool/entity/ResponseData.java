package com.xydz.suppliermateriallabelprintingtool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseData<T> {

    private String state;

    private String msg;

    private T data;

}
