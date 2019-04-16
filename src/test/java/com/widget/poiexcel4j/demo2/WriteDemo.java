/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: WriteDemo
 * Author:   feiyi
 * Date:     2019/4/15 2:18 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.poiexcel4j.demo2;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import com.widget.poiexcel4j.demo1.Student;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * 〈一句话功能简述〉:
 * 〈写入Excel测试〉
 *
 * @author feiyi
 * @create 2019/4/15
 * @since 1.0.0
 */
public class WriteDemo {

    @Test
    public void basicExport1() throws IOException, Excel4JException {
        //1.非注解
        List<List<String>> list2 = new ArrayList<>();
        List<String> header = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> _list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                _list.add(i + " -- " + j);
            }
            list2.add(_list);
            header.add(i + "---");
        }
        ExcelUtils.getInstance().exportObjects2Excel(list2, header, "/Users/feiyi/Documents/feiyiGitProject/forest/src/test/java/com/widget/poiexcel4j/excelfile/export1.xlsx");

        //2.基于注解导出
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(10000L + i, "学生" + i, new Date(), 201, false));
        }
        ExcelUtils.getInstance().exportObjects2Excel(list, Student.class, true, "sheet0", true, "/Users/feiyi/Documents/feiyiGitProject/forest/src/test/java/com/widget/poiexcel4j/excelfile/export2.xlsx");


    }

    @Test
    public void templateExport1() throws Excel4JException {
        //模版看不明白，就看excelfile 目录下的readme
        //3.基于模版固定样式导出
        String tempPath = "/Users/feiyi/Documents/feiyiGitProject/forest/src/test/java/com/widget/poiexcel4j/excelfile/normal_template.xlsx";
        List<Student1> list1 = new ArrayList<>();
        list1.add(new Student1("1010001", "盖伦", "六年级三班"));
        list1.add(new Student1("1010002", "古尔丹", "一年级三班"));
        list1.add(new Student1("1010003", "蒙多(被开除了)", "六年级一班"));
        list1.add(new Student1("1010004", "萝卜特", "三年级二班"));
        list1.add(new Student1("1010005", "奥拉基", "三年级二班"));
        list1.add(new Student1("1010006", "得嘞", "四年级二班"));
        list1.add(new Student1("1010007", "瓜娃子", "五年级一班"));
        list1.add(new Student1("1010008", "战三", "二年级一班"));
        list1.add(new Student1("1010009", "李四", "一年级一班"));
        Map<String, String> data = new HashMap<>();
        data.put("title", "战争学院花名册");
        data.put("info", "学校统一花名册");
        // 基于模板导出Excel
        ExcelUtils.getInstance().exportObjects2Excel(tempPath, 0, list1, data, Student1.class, false, "/Users/feiyi/Documents/feiyiGitProject/forest/src/test/java/com/widget/poiexcel4j/excelfile/export3.xlsx");
        // 不基于模板导出Excel
//        ExcelUtils.getInstance().exportObjects2Excel(list, Student1.class, true, null, true, "D:/B.xlsx");
    }

    @Test
    public void templateExport2() throws Excel4JException {
        //基于模版自定义样式导出
        Map<String, List> classes = new HashMap<>();

        Map<String, String> data = new HashMap<>();
        data.put("title", "战争学院花名册");
        data.put("info", "学校统一花名册");

        classes.put("class_one", new ArrayList<Student1>() {{
            add(new Student1("1010009", "李四", "一年级一班"));
            add(new Student1("1010002", "古尔丹", "一年级三班"));
        }});
        classes.put("class_two", new ArrayList<Student1>() {{
            add(new Student1("1010008", "战三", "二年级一班"));
        }});
        classes.put("class_three", new ArrayList<Student1>() {{
            add(new Student1("1010004", "萝卜特", "三年级二班"));
            add(new Student1("1010005", "奥拉基", "三年级二班"));
        }});
        classes.put("class_four", new ArrayList<Student1>() {{
            add(new Student1("1010006", "得嘞", "四年级二班"));
        }});
        classes.put("class_six", new ArrayList<Student1>() {{
            add(new Student1("1010001", "盖伦", "六年级三班"));
            add(new Student1("1010003", "蒙多", "六年级一班"));
        }});

        ExcelUtils.getInstance().exportObjects2Excel("/map_template.xlsx",
                0, (List<?>) classes, data, Student1.class, false, "D:/C.xlsx");
    }
}
