/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: FileTypeJudgeModel
 * Author:   feiyi
 * Date:     2019/7/17 10:37 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zenki.modelPlatform.sysmodels.impl;

import com.zenki.modelPlatform.sysmodels.SysModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈文件类型区分模块〉
 *
 * @author feiyi
 * @create 2019/7/17
 * @since 1.0.0
 */
public class FileTypeJudgeModel implements SysModel {

    public final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();

    private FileTypeJudgeModel(){}
    static{
        getAllFileType(); //初始化文件类型信息
    }

    /**
     * Discription:[getAllFileType,常见文件头信息]
     */
    private static void getAllFileType()
    {
        FILE_TYPE_MAP.put("3c21444f435459504520", "html"); //HTML (html)
        FILE_TYPE_MAP.put("3c21646f637479706520", "htm"); //HTM (htm)
        FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", "doc"); //与excel的 xls相同
        FILE_TYPE_MAP.put("255044462d312e350d0a", "pdf"); //Adobe Acrobat (pdf)
        FILE_TYPE_MAP.put("504b0304140000000800", "zip");
        FILE_TYPE_MAP.put("526172211a0700cf9073", "rar");
        FILE_TYPE_MAP.put("504b03040a0000000000", "jar");
        FILE_TYPE_MAP.put("3c3f786d6c2076657273", "xml");//xml文件
        FILE_TYPE_MAP.put("504b0304140006000800", "docx");//与excel的 xlsx相同
    }

    @Override
    public Object process(Object object) {
        if (!(object instanceof InputStream)) return null;
        InputStream fileInputStream = (InputStream) object;
        try {
            byte[] bytes = new byte[10];
            fileInputStream.read(bytes, 0, bytes.length);
            String hex = bytesToHexString(bytes);
            return FILE_TYPE_MAP.get(hex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 二进制转十六进制
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        String filePath = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_pdf_test/feiyi_test4.pdf";
//        String filePath = "/Users/feiyi/Downloads/pdf_word_csv_files/csvtest/c.csv";
//        String filePath = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/佩蒂股份2019年03月06日投资者关系活动记录表.docx";//docx
//        String filePath2 = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/002093国脉科技投资者关系管理档案20190307.docx";//jar
        String filePath1 = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/肥遗1.docx";//docx 504b0304140006000800
        String filePath2 = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/肥遗2.docx";//docx 504b0304140006000800
        String filePath3 = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/肥遗3.doc";//doc d0cf11e0a1b11ae10000
        String filePath4 = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/肥遗4.doc";//doc d0cf11e0a1b11ae10000
        String filePath5 = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/肥遗5.xlsx";//xlsx 504b0304140006000800 8075342006080
        String filePath6 = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/肥遗6.xlsx";//xlsx 504b0304140006000800
        String filePath7 = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/肥遗7.xls";//xls d0cf11e0a1b11ae10000
        String filePath8 = "/Users/feiyi/Downloads/pdf_word_csv_files/zenki_doc_test2/肥遗8.xls";//xls d0cf11e0a1b11ae10000
        InputStream inputStream = new FileInputStream(filePath1);
        System.out.println(new FileTypeJudgeModel().process(inputStream));
    }
}
