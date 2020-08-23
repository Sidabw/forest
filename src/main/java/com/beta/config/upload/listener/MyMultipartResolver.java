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
package com.beta.config.upload.listener;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/1/15
 * @since 1.0.0
 */
//@Component
//public class MyMultipartResolver extends CommonsMultipartResolver {
//    @Autowired
//    private UploadProgressListener progressListener;
//
//    @Override
//    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
//        String encoding = super.determineEncoding(request);
//        progressListener.setSession(request.getSession());
//        FileUpload fileUpload = prepareFileUpload(encoding);
//        fileUpload.setProgressListener(progressListener);
//        try {
//            List<FileItem> fileItemList = ((ServletFileUpload) fileUpload).parseRequest(request);
//            return super.parseFileItems(fileItemList, encoding);
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
