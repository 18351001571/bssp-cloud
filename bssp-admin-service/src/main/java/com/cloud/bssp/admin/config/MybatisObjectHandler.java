package com.cloud.bssp.admin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis-plus处理器字段自动赋值
 *
 * @author weirx
 * @date 2020-07-14
 */
@Slf4j
@Component
public class MybatisObjectHandler implements MetaObjectHandler {

    /**
     * Description: 插入时的填充
     * Created date: 2020/7/14
     * @param metaObject
     * @return void
     * @author weirx
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("star insert fill...");
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
    }

    /**
     * Description: 更新时的填充
     * Created date: 2020/7/14
     * @param metaObject
     * @return void
     * @author weirx
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("star update fill...");
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}