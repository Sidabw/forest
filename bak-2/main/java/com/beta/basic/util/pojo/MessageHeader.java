/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: MessageHeader
 * Author:   feiyi
 * Date:     2020/10/22 10:08 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.util.pojo;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/10/22
 * @since 1.0.0
 */
public class MessageHeader {


    /**
     * 行政区域编码
     */
    private String areaCode;

    /**
     * 前置代码
     */
    private String fepCode;

    /**
     * 前置授权码
     */
    private String authCode;

    /**
     * 省验证系统代码
     */
    private String sysCode;

    /**
     * 签名值
     */
    private String sign;

    /**
     * 错误码(响应报文中有该字段)
     */
    private String errorCode;
    /**
     * 错误信息(响应报文中有该字段)
     */
    private String errorInfo;

    public MessageHeader(String errorCode, String errorInfo){
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }

    public MessageHeader() {
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getFepCode() {
        return fepCode;
    }

    public void setFepCode(String fepCode) {
        this.fepCode = fepCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
