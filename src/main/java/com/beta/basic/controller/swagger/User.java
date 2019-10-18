/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: User
 * Author:   feiyi
 * Date:     2019/10/13 6:14 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.controller.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/10/13
 * @since 1.0.0
 */
@ApiModel(value="serviceReq对象",description="serviceReq对象des")
public class User {

    @ApiModelProperty(value="用户名",name="username",example="xingguo")
    private String time = "";
    @ApiModelProperty(value="状态",name="state",required=true)
    private String src = "";

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
