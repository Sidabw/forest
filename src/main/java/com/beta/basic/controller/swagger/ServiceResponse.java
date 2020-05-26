/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ServiceResponse
 * Author:   feiyi
 * Date:     2019/10/13 6:08 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.controller.swagger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/10/13
 * @since 1.0.0
 */
public class ServiceResponse extends JSONObject {
    public static ServiceResponse loadByJson(JSONObject dataJson) {
        ServiceResponse response;
        try {
            response = (new ServiceResponse.Builder()).msgId(dataJson.getString("msgId")).src(dataJson.getString("src")).des(dataJson.getString("des")).statusCode(StatusCode.valueOf(dataJson.getInteger("statusCode"))).statusDetail(dataJson.getJSONObject("statusDetail")).content(dataJson.getJSONObject("content")).time(dataJson.getString("time")).build();
        } catch (Exception var3) {
            response = (new ServiceResponse.Builder()).exception().putStatusDetail(ServiceResponse.SpecialStatusKey.ERROR_MSG.getName(), var3.getMessage()).build();
        }

        return response;
    }

    public ServiceResponse() {
    }

    public ServiceResponse(ServiceResponse.Builder builder) {
        this.setStatusCode(builder.getStatusCode());
        this.setStatusDetail(builder.getStatusDetail());
        this.setTime(builder.getTime());
        this.setSrc(builder.getSrc());
        this.setDes(builder.getDes());
        this.setMsgId(builder.getMsgId());
        this.setContent(builder.getContent());
    }

    public Integer getStatusCode() {
        return this.getInteger("statusCode");
    }

    public void setStatusCode(StatusCode statusCode) {
        this.put("statusCode", statusCode.getName());
    }

    public JSONObject getStatusDetail() {
        return this.getJSONObject("statusDetail");
    }

    public void setStatusDetail(JSONObject statusDetail) {
        this.put("statusDetail", statusDetail);
    }

    public void putStatusDetail(String key, Object value) {
        JSONObject statusDetail = this.getStatusDetail();
        if (ServiceResponse.SpecialStatusKey.contains(key)) {
            JSONArray msgJsonArray;
            if (statusDetail.containsKey(key)) {
                msgJsonArray = statusDetail.getJSONArray(key);
                msgJsonArray.add(value);
                statusDetail.put(key, msgJsonArray);
            } else {
                msgJsonArray = new JSONArray();
                msgJsonArray.add(value);
                statusDetail.put(key, msgJsonArray);
            }
        } else {
            statusDetail.put(key, value);
        }

        this.setStatusDetail(statusDetail);
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

    public JSONObject getContent() {
        return this.getJSONObject("content");
    }

    public void setContent(JSONObject content) {
        this.put("content", content);
    }

    public void putContent(String key, Object value) {
        JSONObject content = this.getContent();
        content.put(key, value);
        this.setContent(content);
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public static class Builder {
        private StatusCode statusCode;
        private JSONObject statusDetail;
        private String time;
        private String src;
        private String des;
        private JSONObject content;
        private String msgId;

        public Builder() {
            this.statusCode = StatusCode.SUCCESS;
            this.statusDetail = new JSONObject();
            this.time = "";
            this.src = "";
            this.des = "";
            this.content = new JSONObject();
            this.msgId = "";
        }

        public ServiceResponse.Builder success() {
            this.statusCode = StatusCode.SUCCESS;
            return this;
        }

        public ServiceResponse.Builder exception() {
            this.statusCode = StatusCode.EXCEPTION;
            return this;
        }

        public ServiceResponse.Builder verifyFailed() {
            this.statusCode = StatusCode.VERIFYFAILED;
            return this;
        }

        public ServiceResponse.Builder paramError() {
            this.statusCode = StatusCode.PARAM_EMPTY;
            this.putStatusDetail(ServiceResponse.SpecialStatusKey.ERROR_MSG.getName(), "输入参数异常,请检查参数是否符合规范");
            return this;
        }

        public ServiceResponse.Builder failed() {
            this.statusCode = StatusCode.FAILED;
            return this;
        }

        public ServiceResponse.Builder emtpyFailed() {
            this.statusCode = StatusCode.EMPTYFAILDED;
            return this;
        }

        public ServiceResponse.Builder privatePage() {
            this.statusCode = StatusCode.PRIVATEPAGE;
            return this;
        }

        public ServiceResponse.Builder emptyResult() {
            this.statusCode = StatusCode.EMPTY_RESULT;
            return this;
        }

        public ServiceResponse.Builder statusCode(StatusCode code) {
            this.statusCode = code;
            return this;
        }

        public ServiceResponse.Builder statusDetail(JSONObject detail) {
            this.statusDetail = detail;
            return this;
        }

        public ServiceResponse.Builder time(String time) {
            this.time = time;
            return this;
        }

        public ServiceResponse.Builder src(String src) {
            this.src = src;
            return this;
        }

        public ServiceResponse.Builder des(String des) {
            this.des = des;
            return this;
        }

        public ServiceResponse.Builder msgId(String msgId) {
            this.msgId = msgId;
            return this;
        }

        public ServiceResponse.Builder content(JSONObject content) {
            this.content = content;
            return this;
        }

        public StatusCode getStatusCode() {
            return this.statusCode;
        }

        public JSONObject getStatusDetail() {
            return this.statusDetail;
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

        public JSONObject getContent() {
            return this.content;
        }

        public String getMsgId() {
            return this.msgId;
        }

        public ServiceResponse.Builder putContent(String key, Object value) {
            this.content.put(key, value);
            return this;
        }

        public ServiceResponse.Builder putStatusDetail(String key, Object value) {
            if (ServiceResponse.SpecialStatusKey.contains(key)) {
                JSONArray msgJsonArray;
                if (this.statusDetail.containsKey(key)) {
                    msgJsonArray = this.statusDetail.getJSONArray(key);
                    msgJsonArray.add(value);
                } else {
                    msgJsonArray = new JSONArray();
                    msgJsonArray.add(value);
                    this.statusDetail.put(key, msgJsonArray);
                }
            } else {
                this.statusDetail.put(key, value);
            }

            return this;
        }

        public ServiceResponse build() {
            return new ServiceResponse(this);
        }
    }

    public static enum SpecialStatusKey {
        SUCCESS_MSG("successMsg"),
        ERROR_MSG("errorMsg"),
        FALLBACK("fallback");

        private String name;

        private SpecialStatusKey(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static boolean contains(String name) {
            ServiceResponse.SpecialStatusKey[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                ServiceResponse.SpecialStatusKey specialStatusKey = var1[var3];
                if (specialStatusKey.getName().equals(name)) {
                    return true;
                }
            }

            return false;
        }
    }
}