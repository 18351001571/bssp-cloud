package com.cloud.bssp.designpatterns.bridge.withoutdesign;

/**
 * 支付方式
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public enum PayMethodEnum {

    FACE(0, "扫脸"),
    FINGER(1, "指纹");


    PayMethodEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName(int code) {
        PayMethodEnum[] payWaysEnums = values();
        for (PayMethodEnum payMethodEnum : payWaysEnums) {
            if (payMethodEnum.code == code) {
                return payMethodEnum.name;
            }
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int code;

    private String name;

}
