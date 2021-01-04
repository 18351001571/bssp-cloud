package com.cloud.bssp.designpatterns.factorymethod.usedesign.impl;

import com.cloud.bssp.designpatterns.factorymethod.usedesign.Car;
import com.cloud.bssp.designpatterns.factorymethod.usedesign.IShop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * CarImpl
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
@Slf4j
@Service("carImpl")
public class CarImpl implements IShop {

    @Override
    public Car getProduct() {
        log.info("this is car");
        return new Car();
    }
}
