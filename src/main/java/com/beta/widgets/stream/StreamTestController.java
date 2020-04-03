/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: StreamTestController
 * Author:   feiyi
 * Date:     2019/12/26 11:06 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.stream;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/12/26
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/stream")
public class StreamTestController {

    @RequestMapping(value = "/httpTest", method = RequestMethod.POST)
    public Object httpTest(Object params){
        System.out.println(JSONObject.toJSONString(params));
        return Collections.singletonMap("status", "from forest success");
    }
}
