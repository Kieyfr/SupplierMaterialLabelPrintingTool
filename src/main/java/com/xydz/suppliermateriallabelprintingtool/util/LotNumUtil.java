package com.xydz.suppliermateriallabelprintingtool.util;

import com.xydz.suppliermateriallabelprintingtool.service.PrintHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
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

    @Autowired
    private PrintHistoryService printHistoryService;

    public static Map<String,Integer> numMap = new HashMap<String,Integer>();

    /**
     * 供应商流水号自减
     *
    */
    public synchronized void numDec(String PK_ORDER_B){
        numMap.put(PK_ORDER_B,numMap.get(PK_ORDER_B)-1);
    }

    /**
     * 供应商流水号自增
     *
     */
    public synchronized void numAdd(String PK_ORDER_B){
        numMap.put(PK_ORDER_B,numMap.get(PK_ORDER_B)+1);
    }

    /**
     * 供应商获取批号
     *
     * @return lotNum
    */
    public synchronized String getLotNum(String PK_ORDER_B) {
        if (numMap.get(PK_ORDER_B)==null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date PRINTDATE=null;
            try {
                PRINTDATE=simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String lotNum=printHistoryService.selMaxLOTNUM(PK_ORDER_B,PRINTDATE);
            if(lotNum!=null&&lotNum!=""){
                Integer num = Integer.parseInt(lotNum.substring(lotNum.length() - 4));
                numMap.put(PK_ORDER_B,num+1);
            }else{
                numMap.put(PK_ORDER_B,1);
            }

        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        String lotNum = simpleDateFormat.format(new Date()) + String.format("%0".concat(String.valueOf(4)).concat("d"), numMap.get(PK_ORDER_B));
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
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Autowired
//    private RedisUtils redisUtils;
////    public static Map<String,Integer> numMap = new HashMap<String,Integer>();
//
//    /**
//     * 供应商流水号自减
//     *
//     */
//    public synchronized void numDec(String PK_ORDER_B){
//        String lotNum= String.valueOf((Long.valueOf((String) redisUtils.get(PK_ORDER_B))-1));
//        redisUtils.set(PK_ORDER_B,lotNum,(long)DateUtil.getRemainSecondsOneDay(new Date()));
//    }
//
//    /**
//     * 供应商流水号自增
//     *
//     */
//    public synchronized void numAdd(String PK_ORDER_B){
//        String lotNum= String.valueOf((Long.valueOf((String) redisUtils.get(PK_ORDER_B))+1));
//        redisUtils.set(PK_ORDER_B,lotNum,(long)DateUtil.getRemainSecondsOneDay(new Date()));
//    }
//
//    /**
//     * 供应商获取批号
//     *
//     * @return lotNum
//     */
//    public synchronized String getLotNum(String PK_ORDER_B){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
//        if (redisUtils.get(PK_ORDER_B)==null){
//            String lotNum = simpleDateFormat.format(new Date()) + String.format("%0".concat(String.valueOf(4)).concat("d"), 1);
//            redisUtils.set(PK_ORDER_B,lotNum,(long)DateUtil.getRemainSecondsOneDay(new Date()));
//        }
//
//        String lotNum = (String) redisUtils.get(PK_ORDER_B);
//        return lotNum;
//    }

}
