package com.cloud.bssp.designpatterns.factorymethod.usedesign.impl;

import com.cloud.bssp.designpatterns.factorymethod.usedesign.IShop;
import com.cloud.bssp.designpatterns.factorymethod.usedesign.Ship;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * CarImpl
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
@Slf4j
@Service("shipImpl")
public class ShipImpl implements IShop {

    @Override
    public Ship getProduct() {
        log.info("this is Ship");
        return new Ship();
    }
}
