package com.example.springboot.common;

/**
 * ClassName:BusinessErrorException
 * Package:com.example.springboot.common
 * Description:
 *
 * @date:2020/2/23 14:07
 * @author:zh
 */
public class BusinessErrorException  extends RuntimeException{

    private static final long serialVersionUID = -7480022450501760611L;

    /**
     * 异常码
     */
    private String code;
    /**
     * 异常提示信息
     */
    private String message;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum) {
        this.code = businessMsgEnum.getCode();
        this.message = businessMsgEnum.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
