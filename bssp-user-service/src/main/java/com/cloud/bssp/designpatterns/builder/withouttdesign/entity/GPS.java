package com.cloud.bssp.designpatterns.builder.withouttdesign.entity;

import lombok.Data;

/**
 * TODO
 * @date: 2021/1/4
 * @author weirx
 * @version 3.0
 */

@Data
public class GPS {

    /**
     * 路线
     */
    private String route;

    public GPS(String route) {
        this.route = route;
    }
}
