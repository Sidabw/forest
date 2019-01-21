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
package com.beta.basic.config.upload.listener;

import org.apache.commons.fileupload.ProgressListener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
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
@Component
public class UploadProgressListener implements ProgressListener {
    private HttpSession session;
    private int i = 0;

    public void setSession(HttpSession session) {
        this.session = session;
        HttpServletRequest request = RequestHolder.getRequest();
        System.out.println(request.getAttribute("user"));
        System.out.println(request.getAttribute("user1"));
        Map<String, String[]> parameterMap = request.getParameterMap();
        Enumeration<String> attributeNames = request.getAttributeNames();
//        Collection<Part> parts = request.getParts();
        System.out.println(parameterMap.get("userIdtime"));
        String userIdtime = request.getParameter("userIdtime");
        System.out.println(userIdtime);
        HashMap<String, Object> map = new HashMap<>();
        session.setAttribute("uploadStatus", map);
    }

    @Override
    public void update(long readBytes, long allBytes, int index) {

        Map uploadStatus = (Map)session.getAttribute("uploadStatus");
        uploadStatus.put("readBytes", readBytes);
        uploadStatus.put("allBytes", allBytes);
        uploadStatus.put("index", index);
    }


}
