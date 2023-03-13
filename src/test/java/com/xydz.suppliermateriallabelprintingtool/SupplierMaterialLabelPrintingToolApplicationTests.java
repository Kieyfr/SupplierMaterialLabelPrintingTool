package com.xydz.suppliermateriallabelprintingtool;


import com.xydz.suppliermateriallabelprintingtool.entity.Supplier;
import com.xydz.suppliermateriallabelprintingtool.service.SuppUserService;
import com.xydz.suppliermateriallabelprintingtool.util.DateUtil;
import com.xydz.suppliermateriallabelprintingtool.util.LotNumUtil;
import com.xydz.suppliermateriallabelprintingtool.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;

@SpringBootTest
public class SupplierMaterialLabelPrintingToolApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SuppUserService suppUserService;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void test1() {
//        String lotNum = LotNumUtil.getLotNum("123456");
//        System.out.println(redisUtils.get(lotNum));
//        redisUtils.set("12345",lotNum,(long)DateUtil.getRemainSecondsOneDay(new Date()));
//        LotNumUtil.numAdd("123456");
//        lotNum = LotNumUtil.getLotNum("123456");
//        redisUtils.set("123456",lotNum);
    }
}
