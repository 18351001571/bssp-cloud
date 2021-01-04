package com.cloud.bssp.designpatterns.factorymethod.usedesign.impl;

import com.cloud.bssp.designpatterns.factorymethod.usedesign.IShop;
import com.cloud.bssp.designpatterns.factorymethod.usedesign.Plane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * CarImpl
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
@Slf4j
@Service("planeImpl")
public class PlaneImpl implements IShop {

    @Override
    public Plane getProduct() {
        log.info("this is plane");
        return new Plane();
    }
}
