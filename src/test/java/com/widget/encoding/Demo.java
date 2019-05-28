/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/5/28 10:52 AM
 * Description: 对文件进行编码转换，统一转到UTF、
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.encoding;


import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 〈一句话功能简述〉:
 * 〈对文件进行编码转换，统一转到UTF-8〉
 *
 * @author feiyi
 * @create 2019/5/28
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) throws IOException {
//        String filePath = "/Users/feiyi/Documents/feiyiGitProject/forest/src/test/java/com/Java/bak/primary/1JavaGrammer/src/com/string1/StringDemo.java";
//        String filePath2 = "/Users/feiyi/Documents/feiyiGitProject/forest/src/test/java/com/Java/bak/primary/1JavaGrammer/src/com/string1/StringDemoRc.java";
        String dir = "/Users/feiyi/Documents/feiyiGitProject/forest/src/test/java/com/Java/bak/primary/9Demo";
        tranfer(dir);
//        String path = "";
//        transferSingle(path,"", "");
    }

    public static void tranfer(String dir) throws IOException {
        System.out.println(dir);
        File file = new File(dir);
        File[] files = file.listFiles();
        if (files == null || files.length == 0) return;
        for (File eachFile : files) {
            String name = eachFile.getName();
            if (eachFile.isDirectory()) {
                tranfer(dir + "/" + name);
            }
            if (!name.contains(".java") && !name.contains(".md")) continue;
            if (name.contains("Rc")) continue;
            String newFileName = name.replaceAll("\\.java", "") + "Rc" + ".java";
            String newFilePath = dir + "/" + newFileName;
            InputStreamReader isr = new InputStreamReader(new FileInputStream(eachFile), "GBK");
            OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(newFilePath), "UTF-8");
            int re = -1;
            while ((re = isr.read()) != -1) {
                osr.write(re);
            }
            isr.close();
            osr.close();
        }
    }

    public static void transferSingle(String path, String oldCharset, String newCharset) throws IOException {
        File eachFile = new File(path);
        String name = eachFile.getName();
        String dir = path.substring(0,path.lastIndexOf(name) - 1);
        String newFileName = name.replaceAll("\\.java", "") + "Rc" + ".java";
        String newFilePath = dir + "/" + newFileName;
        InputStreamReader isr = new InputStreamReader(new FileInputStream(eachFile), oldCharset);
        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(newFilePath), newCharset);
        int re = -1;
        while ((re = isr.read()) != -1) {
            osr.write(re);
        }
        isr.close();
        osr.close();
    }




    @Test
    public void test(){
        String str = ".a";
        System.out.println(str.replaceAll("\\.","b"));
    }
}
