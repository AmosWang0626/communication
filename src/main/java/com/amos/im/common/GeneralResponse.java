package com.amos.im.common;

import java.io.Serializable;

/**
 * PROJECT: im
 * DESCRIPTION: GeneralCode
 *
 * @author Daoyuan
 * @date 2019/3/20
 */
@SuppressWarnings("all")
public class GeneralResponse<T> implements Serializable {

    private static final long serialVersionUID = -5627607859424842220L;

    private final String code;
    private final String msg;
    private T body;
    private boolean success;

    public static GeneralResponse SUCCESS = new GeneralResponse(GeneralCode.SUCCESS);
    public static GeneralResponse FAIL = new GeneralResponse(GeneralCode.FAIL);
    public static GeneralResponse ERROR_PARAM = new GeneralResponse(GeneralCode.ERROR_PARAM);
    public static GeneralResponse ILLEGAL = new GeneralResponse(GeneralCode.ILLEGAL_REQUEST);

    public GeneralResponse(T body) {
        this(GeneralCode.SUCCESS);
        this.body = body;
    }

    public GeneralResponse(GeneralCode code) {
        this(code.getCode(), code.getMsg());
        this.success = GeneralCode.SUCCESS.getCode().equals(code.getCode());
    }

    public GeneralResponse(GeneralCode code, String msg) {
        this(code.getCode(), msg);
        this.success = GeneralCode.SUCCESS.getCode().equals(code.getCode());
    }

    private GeneralResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
