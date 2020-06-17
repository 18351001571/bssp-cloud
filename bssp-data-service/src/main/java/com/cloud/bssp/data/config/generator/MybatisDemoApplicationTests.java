package com.cloud.bssp.data.config.generator;
 
import java.io.File;
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 
@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisDemoApplicationTests {

	@Autowired
	private GenComp genComp;
 
	@Test
	public void test() {
		 byte[] zipByte = genComp.generatorCode();
         try {
            //生成路径
			FileUtils.writeByteArrayToFile(new File("D:\\1.zip"), zipByte);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}