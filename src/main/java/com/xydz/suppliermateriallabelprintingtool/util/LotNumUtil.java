package com.xydz.suppliermateriallabelprintingtool.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiachenchen
 * @ClassName: LotNumUtil
 * @Description: 批号工具 TODO
 * @Date 2022/11/22
*/
@Component
public class LotNumUtil  {

    public static Map<String,Integer> numMap = new HashMap<String,Integer>();

    /**
     * 供应商流水号自减
     *
    */
    public static void numDec(String suppCode){
        numMap.put(suppCode,numMap.get(suppCode)-1);
    }

    /**
     * 供应商流水号自增
     *
     */
    public static void numAdd(String suppCode){
        numMap.put(suppCode,numMap.get(suppCode)+1);
    }

    /**
     * 供应商获取批号
     *
     * @return lotNum
    */
    public static String  getLotNum(String suppCode){
        if (numMap.get(suppCode)==null){
            numMap.put(suppCode,1);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        String lotNum = simpleDateFormat.format(new Date()) + String.format("%0".concat(String.valueOf(4)).concat("d"), numMap.get(suppCode));
        return lotNum;
    }

    /**
     * 每天0点重置流水号
     *
    */
    @Scheduled(cron = "0 0 0 * * ?")
    public static void init(){
        numMap.clear();
    }
}
