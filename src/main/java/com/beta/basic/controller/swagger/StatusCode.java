/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: StatusCode
 * Author:   feiyi
 * Date:     2019/10/13 6:09 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.controller.swagger;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/10/13
 * @since 1.0.0
 */
public enum StatusCode {
    SUCCESS(200),
    EMPTY_RESULT(2001),
    EMPTYFAILDED(4001),
    PARAM_EMPTY(4002),
    VERIFYFAILED(403),
    PRIVATEPAGE(4031),
    EXCEPTION(500),
    FAILED(501);

    private Integer name;

    private StatusCode(Integer name) {
        this.name = name;
    }

    public Integer getName() {
        return this.name;
    }

    public static StatusCode valueOf(Integer statusCode) throws Exception {
        StatusCode[] scs = values();
        StatusCode[] var2 = scs;
        int var3 = scs.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            StatusCode sc = var2[var4];
            if (statusCode == sc.getName()) {
                return sc;
            }
        }

        throw new Exception("statusCode is error");
    }

    public static void main(String[] args) {
        StatusCode statusCode = null;

        try {
            statusCode = valueOf(200);
        } catch (Exception var3) {
            ;
        }

        System.out.println(statusCode);
    }
}
