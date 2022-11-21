package com.xydz.suppliermateriallabelprintingtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xydz.suppliermateriallabelprintingtool.mapper")
public class SupplierMaterialLabelPrintingToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierMaterialLabelPrintingToolApplication.class, args);
    }

}
