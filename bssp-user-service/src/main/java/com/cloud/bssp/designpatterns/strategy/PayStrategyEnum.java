package com.cloud.bssp.designpatterns.strategy;

/**
 * 支付策略
 * @date: 2021/1/25
 * @author weirx
 * @version 3.0
 */
public enum PayStrategyEnum {


    /**
     * weixin
     */
    WEIXIN("weixin") {
        @Override
        public IPayStrategy create() {
            return new WXPay();
        }
    },
    /**
     * zhifubao
     */
    ZHIFUBAO("zhifubao") {
        @Override
        public IPayStrategy create() {
            return new ZFBPay();
        }
    };

    /**
     * 根据枚举值获取bean实例
     * @param analyseTypeEnum
     * @return
     */
    public static IPayStrategy newInstance(PayStrategyEnum analyseTypeEnum) {
        return analyseTypeEnum.create();
    }

    public abstract IPayStrategy create();

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    PayStrategyEnum(String code) {
        this.code = code;
    }

    /**
     * 根据code获取枚举
     * @param code
     * @return
     */
    public static PayStrategyEnum getEnum(String code) {
        for (PayStrategyEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
