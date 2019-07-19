/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ServiceRequest
 * Author:   feiyi
 * Date:     2019/7/18 7:42 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.zenki.modelPlatform.common;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/18
 * @since 1.0.0
 */
public class ServiceRequest extends JSONObject {
    private ServiceRequest() {
    }

    private ServiceRequest(ServiceRequest.Builder builder) {
        this.setTime(builder.getTime());
        this.setSrc(builder.getSrc());
        this.setDes(builder.getDes());
        this.setMsgId(builder.getMsgId());
        this.setParam(builder.getParam());
    }

    public String getTime() {
        return this.getString("time");
    }

    public void setTime(String time) {
        this.put("time", time);
    }

    public String getSrc() {
        return this.getString("src");
    }

    public void setSrc(String src) {
        this.put("src", src);
    }

    public String getDes() {
        return this.getString("des");
    }

    public void setDes(String des) {
        this.put("des", des);
    }

    public String getMsgId() {
        return this.getString("msgId");
    }

    public void setMsgId(String msgId) {
        this.put("msgId", msgId);
    }

    public JSONObject getParam() {
        return this.getJSONObject("param");
    }

    public void setParam(JSONObject param) {
        this.put("param", param);
    }

    public void putParam(String key, Object value) {
        JSONObject param = this.getParam();
        param.put(key, value);
        this.setParam(param);
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public static class Builder {
        private String time = "";
        private String src = "";
        private String des = "";
        private JSONObject param = new JSONObject();
        private String msgId = "";

        public Builder() {
        }

        public ServiceRequest.Builder time(String time) {
            this.time = time;
            return this;
        }

        public ServiceRequest.Builder src(String src) {
            this.src = src;
            return this;
        }

        public ServiceRequest.Builder des(String des) {
            this.des = des;
            return this;
        }

        public ServiceRequest.Builder param(JSONObject param) {
            this.param = param;
            return this;
        }

        public ServiceRequest.Builder putParam(String key, Object value) {
            this.param.put(key, value);
            return this;
        }

        public ServiceRequest.Builder msgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public String getTime() {
            return this.time;
        }

        public String getSrc() {
            return this.src;
        }

        public String getDes() {
            return this.des;
        }

        public String getMsgId() {
            return this.msgId;
        }

        public JSONObject getParam() {
            return this.param;
        }

        public ServiceRequest build() {
            if (this.time.isEmpty()) {
                this.time = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
            }

            return new ServiceRequest(this);
        }
    }
}
