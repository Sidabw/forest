/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: UploadProgressListener
 * Author:   feiyi
 * Date:     2019/1/15 上午10:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.config.upload.listener;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/1/15
 * @since 1.0.0
 */
//@Component
//public class UploadProgressListener implements ProgressListener {
//    private HttpSession session;
//    private int i = 0;
//
//    public void setSession(HttpSession session){
//        this.session = session;
//        HashMap<String, Object> map = new HashMap<>();
//        session.setAttribute("uploadStatus", map);
//    }
//
//    @Override
//    public void update(long readBytes, long allBytes, int index) {
//
//        Map uploadStatus = (Map)session.getAttribute("uploadStatus");
//        uploadStatus.put("readBytes", readBytes);
//        uploadStatus.put("allBytes", allBytes);
//        uploadStatus.put("index", index);
//    }
//}
