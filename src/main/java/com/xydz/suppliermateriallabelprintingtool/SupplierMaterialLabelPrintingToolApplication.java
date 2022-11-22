package com.xydz.suppliermateriallabelprintingtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling   //开启定时任务
@MapperScan("com.xydz.suppliermateriallabelprintingtool.mapper")
public class SupplierMaterialLabelPrintingToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierMaterialLabelPrintingToolApplication.class, args);
    }

}
