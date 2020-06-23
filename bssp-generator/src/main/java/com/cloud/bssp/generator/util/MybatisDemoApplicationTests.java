package com.cloud.bssp.generator.util;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisDemoApplicationTests {

    @Autowired
    private GenComp genComp;

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("bssp_sys_menu");
        byte[] zipByte = genComp.generatorCode(list, "weirx",
                "com.cloud.bssp.data.sysmenu", "bssp-data-service");
        try {
            //生成路径
            FileUtils.writeByteArrayToFile(new File("D:\\1.zip"), zipByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}