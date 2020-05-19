package com.byc.enums;

public enum  ResponseCodeEnum {
    SUCCESS(0,"SUCCESS"),

    ERROR(1,"ERROR"),

    WARN(2,"WARN    "),

    NEED_LOGIN(10,"NEED_LOGIN"),

    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");
    private final  int code;
    private final  String desc;
     private  ResponseCodeEnum(int code,String desc) {
         this.code = code;
         this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}