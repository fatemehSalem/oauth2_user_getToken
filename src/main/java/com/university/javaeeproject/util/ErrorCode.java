package com.university.javaeeproject.util;

public enum  ErrorCode {
    TENANT_CAN_NOT_BE_FOUND(1L),
    MEMBER_CAN_NOT_BE_ADDED(2L),
    VIDYO_MEMBER_DOES_NOT_FOUND(3L),
    VIDYO_USER_ID_NOT_VALID(4L),
    UPDATE_MEMBERINFO_FAILED(5L),
    FORBIDDEN_CHANGE_NAME_OF_EXISTING_ACCOUNT(6L);

    private Long code;

    ErrorCode(Long code) {
        this.setCode(code);
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}
