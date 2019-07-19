/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Controller
 * Author:   feiyi
 * Date:     2019/7/18 7:30 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.zenki.modelPlatform.domain.controller;

import com.beta.zenki.modelPlatform.common.ServiceRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/18
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/zenki")
public class ModelsProceedController {

    @RequestMapping(value = "/proceed/{proceedId}", method = RequestMethod.POST)
    public Object proceed(@PathVariable(value = "proceedId") String proceedId,
//                          @RequestParam(value="file") MultipartFile file,
//                          @RequestParam String a
                          @RequestParam ServiceRequest serviceRequest) throws IOException {
        System.out.println(proceedId);
//        System.out.println(file.getInputStream().available());
        System.out.println(serviceRequest.getParam().getString("sida"));
        return "111";
    }
}
