package cn.xcion.mvvmhttp;

import java.io.Serializable;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/6/25  00:33
 * Intro:
 */
public class BaseDto<T> implements Serializable {

    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
