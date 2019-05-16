/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/5/16 3:27 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.csv;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/5/16
 * @since 1.0.0
 */
public class Demo {

    //CSV文件分隔符
    private static final String NEW_LINE_SEPARATOR="\n";
    //文件后缀
//    private static final String suffix = ".csv";
    private static final String suffix = ".zenki";
    //文件路径
    private static final String filePath = "/Users/feiyi/Desktop/csvdir/1" + suffix;


    //写操作
    @Test
    public void test() throws IOException {
        //初始化csvformat
        CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        //创建FileWriter对象,filePathcsv文件路径
        FileWriter fileWriter=new FileWriter(filePath);
        //创建CSVPrinter对象
        CSVPrinter printer=new CSVPrinter(fileWriter,formator);
        String[] headers = new String[]{"name", "content"};
        List<String[]> data = Arrays.asList(
                new String[]{"header--1", "content--内容--1"},
                new String[]{"header--2", "content--内容--2"},
                new String[]{"header--3", "content--内容--3"},
                new String[]{"header--4", "content--内容--4"},
                new String[]{"header--5", "content--内容--5"},
                new String[]{"header--6", "content--内容--6"},
                new String[]{"header--7", "content--内容--7"},
                new String[]{"header--8", "content--内容--8"},
                new String[]{"header--9", "content--内容--9"}
        );
        //写入头数据
        printer.printRecord(headers);
        //写入内容数据
        for (String[] dataEach : data) {
            printer.printRecord(dataEach);
        }
        printer.close();
    }


    //读操作
    @Test
    public void test2() throws IOException {
        String filePath = "/Users/feiyi/Desktop/csvdir/1" + suffix;
        CSVFormat formator = CSVFormat.DEFAULT;
        FileReader fileReader=new FileReader(filePath);
        //创建CSVParser对象
        CSVParser parser=new CSVParser(fileReader,formator);
        List<CSVRecord> records=parser.getRecords();
        CSVRecord headersRecord = records.get(0);
        Iterator<String> iterator = headersRecord.iterator();
        ArrayList<String> headers = new ArrayList<>();
        while (iterator.hasNext()) {
            String next = iterator.next();
            headers.add(next);
        }
        JSONArray result = new JSONArray();
        for (int i = 1; i<records.size(); i++) {
            JSONObject each = new JSONObject();
            Iterator<String> iteratorIn = records.get(i).iterator();
//            ArrayList<String> eachContent = new ArrayList<>();
//            while (iteratorIn.hasNext()) {
//                eachContent.add(iteratorIn.next());
//            }
            headers.stream().forEach(e ->{
               each.put(e, iteratorIn.hasNext()? iteratorIn.next() : "");
            });
            result.add(each);
        }
        System.out.println(result.size());
        System.out.println(result.getJSONObject(0).getString("name"));
        parser.close();
        fileReader.close();
    }
}
