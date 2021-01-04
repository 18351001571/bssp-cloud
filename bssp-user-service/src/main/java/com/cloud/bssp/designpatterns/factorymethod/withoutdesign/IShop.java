package com.cloud.bssp.designpatterns.factorymethod.withoutdesign;

/**
 * IShop
 * @date: 2020/12/29
 * @author weirx
 * @version 3.0
 */
public interface IShop {

    /**
     * 获取汽车
     * @date: 2020/12/29
     * @param
     * @return com.cloud.bssp.designpatterns.factorymethod.withoutdesign.factory.Car
     * @author weirx
     * @version 3.0
     */
    Car getCar();

    /**
     * 获取船
     * @date: 2020/12/29
     * @param
     * @return com.cloud.bssp.designpatterns.factorymethod.withoutdesign.factory.Car
     * @author weirx
     * @version 3.0
     */
    Ship getShip();

    /**
     * 获取飞机
     * @date: 2020/12/29
     * @param
     * @return com.cloud.bssp.designpatterns.factorymethod.withoutdesign.factory.Car
     * @author weirx
     * @version 3.0
     */
    Plane getPlane();
}
