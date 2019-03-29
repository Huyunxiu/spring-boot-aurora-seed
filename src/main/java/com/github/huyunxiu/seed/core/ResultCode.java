package com.github.huyunxiu.seed.core;

/**
 * @author huyunxiu01@gmail.com
 * @version 1.0.0
 * @since 2019-03-29
 */
public enum ResultCode {
    /**
     * 操作成功
     */
    SUCCESS("操作成功", 0),

    /**
     * 操作失败
     */
    FAIL("操作失败", -1);

    private String message;
    private int code;

    ResultCode(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
