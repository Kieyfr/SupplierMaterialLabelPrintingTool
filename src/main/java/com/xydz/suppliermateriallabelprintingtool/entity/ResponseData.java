package com.xydz.suppliermateriallabelprintingtool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author xiachenchen
 * @ClassName: ResponseData
 * @Description: 返回的数据类 TODO
 * @Date 2022/11/22
*/

@Data
@AllArgsConstructor
public class ResponseData<T> {

    private String state;   //状态码

    private String msg;     //消息

    private T data;         //数据

}
