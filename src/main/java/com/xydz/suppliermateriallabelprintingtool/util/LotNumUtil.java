package com.xydz.suppliermateriallabelprintingtool.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author xiachenchen
 * @ClassName: LotNumUtil
 * @Description: 批号工具 TODO
 * @Date 2022/11/22
*/

@Component
public class LotNumUtil  {
    public static Integer num = 1;

    /**
     * 流水号自增
     *
    */
    public synchronized static void numAdd(){
        num++;
    }

    /**
     * 获取批号
     *
     * @return lotNum
    */
    public static String  getLotNum(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        String lotNum = simpleDateFormat.format(new Date()) + String.format("%0".concat(String.valueOf(4)).concat("d"), num);
        return lotNum;
    }

    /**
     * 每天0点重置流水号
     *
    */
    @Scheduled(cron = "0 0 0 * * ?")
    public static void init(){
        num=1;
    }
}
