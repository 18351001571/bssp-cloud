package com.cloud.bssp.designpatterns.bridge.usedesign.enums;

/**
 * 支付方式
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public enum PayWaysEnum {

    ZHIFUBAO(0, "支付宝"),
    WEIXIN(1, "微信");


    PayWaysEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

}
