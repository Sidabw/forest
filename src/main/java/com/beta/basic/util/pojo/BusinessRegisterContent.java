/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: BusinessRegisterContent
 * Author:   feiyi
 * Date:     2020/10/22 10:09 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.util.pojo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/10/22
 * @since 1.0.0
 */
public class BusinessRegisterContent {

    /**
     *  业务代码
     */
    @NotEmpty
    private String serviceCode;
    /**
     * 业务名称
     */
    @NotEmpty
    private String serviceName;
    /**
     * 业务分类。1-电子政务，2：电子商务
     */
    @NotEmpty
    private String serviceType;
    /**
     * 业务地址
     */
    @NotEmpty
    private String serviceUrl;

    /**
     * 前置代码
     */
    private String describe;

    public BusinessRegisterContent(String serviceCode, String serviceName, String serviceType, String serviceUrl, String describe) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.serviceUrl = serviceUrl;
        this.describe = describe;
    }

    public BusinessRegisterContent() {
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
