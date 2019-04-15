/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ReadDeamo
 * Author:   feiyi
 * Date:     2019/4/15 10:02 AM
 * Description: 读操作demo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.poiexcel4j.demo1;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈读操作demo〉
 *
 * @author feiyi
 * @create 2019/4/15
 * @since 1.0.0
 */
public class ReadDeamo {


    @Test
    public void excelTest() throws IOException, InvalidFormatException, Excel4JException {
        //1.非注解
        String path = "/Users/feiyi/Documents/feiyiGitProject/forest/src/test/java/com/widget/poiexcel4j/excelfile/pre2read.xlsx";
        List<List<String>> lists = ExcelUtils.getInstance().readExcel2List(path, 1, 2, 0);
        System.out.println("读取excel到List<List<String>>， 非注解。");
        for (List<String> each : lists) {
            System.out.println(each);
        }
        //2.基于注解
        System.out.println("----------- 基于注解 -----------");
        List<Student> students = ExcelUtils.getInstance().readExcel2Objects(path, Student.class, 0, 0);
        System.out.println(students.size());
        for (Student stu : students) {
            //得到了三行空行...  可能跟一开始添了6条数据，后来删除掉了3条有关系...
            System.out.println(stu);
        }
    }

}
