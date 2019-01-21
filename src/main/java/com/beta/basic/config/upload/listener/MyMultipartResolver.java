/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: MyMultipartResolver
 * Author:   feiyi
 * Date:     2019/1/15 上午10:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.config.upload.listener;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
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
public class MyMultipartResolver extends CommonsMultipartResolver {
    @Autowired
    private UploadProgressListener progressListener;

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        ServletContext servletContext = request.getSession().getServletContext();
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();

        HttpServlet httpServlet = new MyServlet();
//        servletContext.res
        Map<String, String[]> parameterMap = request.getParameterMap();
        Enumeration<String> attributeNames = request.getAttributeNames();
        String userIdtime = request.getParameter("userIdtime");
        String encoding = super.determineEncoding(request);
        progressListener.setSession(request.getSession());
        FileUpload fileUpload = prepareFileUpload(encoding);
        fileUpload.setProgressListener(progressListener);
        Map<String, String[]> parameterMap2 = request.getParameterMap();
        try {
            List<FileItem> fileItemList = ((ServletFileUpload) fileUpload).parseRequest(request);
            Map<String, String[]> parameterMap3 = request.getParameterMap();
            MultipartParsingResult multipartParsingResult = super.parseFileItems(fileItemList, encoding);
            Map<String, String[]> parameterMap4 = request.getParameterMap();
            return multipartParsingResult;
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return null;
    }
}
