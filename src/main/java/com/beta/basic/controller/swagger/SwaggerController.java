/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: SwaggerController
 * Author:   feiyi
 * Date:     2019/10/13 6:05 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.controller.swagger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/10/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/swagger")
@Api(description = "【v2】数据组/数据源相关接口")
public class SwaggerController {


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("增加数据源")
    public ServiceResponse addDataGroup(@RequestBody User request) {
        System.out.println(request.toString());
        return new ServiceResponse.Builder().success().build();
    }


}
