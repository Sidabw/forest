/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: BusinessRegisterRequest
 * Author:   feiyi
 * Date:     2020/10/22 10:08 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.util.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/10/22
 * @since 1.0.0
 */
public class BusinessRegisterRequest {

    @JsonProperty("message_header")
    private MessageHeader header;

    @JsonProperty("message_content")
    private BusinessRegisterContent content;

    public BusinessRegisterRequest(MessageHeader header, BusinessRegisterContent content) {
        this.header = header;
        this.content = content;
    }

    public BusinessRegisterRequest() {

    }

    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    public BusinessRegisterContent getContent() {
        return content;
    }

    public void setContent(BusinessRegisterContent content) {
        this.content = content;
    }
}
