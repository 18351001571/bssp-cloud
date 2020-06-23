package com.cloud.bssp.api.common.util;

import com.cloud.bssp.api.common.enums.CommonReturnEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private long code;

    private T data;

    private String msg;

    public R() {
    }

    /**
     * @param
     * @return com.cloud.bssp.util.R<T>
     * @description: 成功返回, 不指定参数
     * @author weirx
     * @date 2020/6/19
     */
    public static <T> R<T> success() {
        return restResult(null, CommonReturnEnum.SUCCESS.getCode(), CommonReturnEnum.SUCCESS.getName());
    }

    /**
     * @param
     * @return com.cloud.bssp.util.R<T>
     * @description: 成功返回，指定msg
     * @author weirx
     * @date 2020/6/19
     */
    public static <T> R<T> success(String msg) {
        return restResult(null, CommonReturnEnum.SUCCESS.getCode(), msg);
    }

    /**
     * @param
     * @return com.cloud.bssp.util.R<T>
     * @description: 成功返回，指定对象
     * @author weirx
     * @date 2020/6/19
     */
    public static <T> R<T> success(T data) {
        return restResult(data, CommonReturnEnum.SUCCESS.getCode(), CommonReturnEnum.SUCCESS.getName());
    }

    /**
     * @param
     * @return com.cloud.bssp.util.R<T>
     * @description: 成功返回，指定msg,data
     * @author weirx
     * @date 2020/6/19
     */
    public static <T> R<T> success(String msg, T data) {
        return restResult(data, CommonReturnEnum.SUCCESS.getCode(), msg);
    }

    /**
     * @param
     * @return com.cloud.bssp.util.R<T>
     * @description: 成功返回，指定code,msg,data
     * @author weirx
     * @date 2020/6/19
     */
    public static <T> R<T> success(int code, String msg, T data) {
        return restResult(data, code, msg);
    }


    /**
     * @param
     * @return com.cloud.bssp.util.R<T>
     * @description: 失败返回
     * @author weirx
     * @date 2020/6/19
     */
    public static <T> R<T> failed() {
        return restResult(null, CommonReturnEnum.FIELD.getCode(), CommonReturnEnum.FIELD.getName());
    }

    /**
     * @param
     * @return com.cloud.bssp.util.R<T>
     * @description: 失败返回，指定msg
     * @author weirx
     * @date 2020/6/19
     */
    public static <T> R<T> failed(String msg) {
        return restResult(null, CommonReturnEnum.FIELD.getCode(), msg);
    }

    /**
     * @param
     * @return com.cloud.bssp.util.R<T>
     * @description: 失败返回，指定msg,data
     * @author weirx
     * @date 2020/6/19
     */
    public static <T> R<T> failed(String msg, T data) {
        return restResult(data, CommonReturnEnum.FIELD.getCode(), msg);
    }

    /**
     * @param
     * @return com.cloud.bssp.util.R<T>
     * @description: 失败返回，指定code,msg,data
     * @author weirx
     * @date 2020/6/19
     */
    public static <T> R<T> failed(int code, String msg, T data) {
        return restResult(data, code, msg);
    }

    private static <T> R<T> restResult(T data, long code, String msg) {
        R<T> apiResult = new R();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}