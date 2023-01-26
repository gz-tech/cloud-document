package com.upuphone.cloudplatform.document.errorcode;

import com.upuphone.cloudplatform.common.response.ErrorCode;

/**
 * @Classname DocumentErrorCode
 * @Description TODO
 * @Date 2022/6/29 2:59 下午
 * @Created by gz-d
 */
public enum DocumentErrorCode implements ErrorCode {
    NOT_EXIST_ERROR(3000001, "文案不存在"),
    LENTH_LIMIT_ERROR(3000002, "文案类型不超过50个字符"),
    DUPLICATE_NAME_ERROR(3000003, "文案类型名称重复");
    private int errorCode;
    private String errorMessage;

    DocumentErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
