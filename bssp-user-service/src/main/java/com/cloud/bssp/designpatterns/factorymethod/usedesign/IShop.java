package com.cloud.bssp.designpatterns.factorymethod.usedesign;

/**
 * IShop
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
public interface IShop {

    /**
     * 获取商品
     * @date: 2020/12/29
     * @param
     * @return java.lang.Object
     * @author weirx
     * @version 3.0
     */
    Product getProduct();
}
