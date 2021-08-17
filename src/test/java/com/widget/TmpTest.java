package com.widget;

import org.junit.Test;

import java.io.*;

/**
 * @author shaogz
 */
public class TmpTest {

    @Test
    public void testProcessBuilder() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/feiyi/Desktop/py-test/abc.log"));
        String eachLine = null;
        while ((eachLine = bufferedReader.readLine()) != null) {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.directory(new File("/Users/feiyi/Desktop/aa"));
            processBuilder.command("git", "clone", eachLine);
            //将标准输入流和错误输入流合并，通过标准输入流读取信息
            processBuilder.redirectErrorStream(true);
            //启动进程
            Process start = processBuilder.start();
            //获取输入流
            InputStream inputStream = start.getInputStream();
            //转成字符输入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
            int len = -1;
            char[] c = new char[1024];
            StringBuilder outputString = new StringBuilder();
            //读取进程输入流中的内容
            while ((len = inputStreamReader.read(c)) != -1) {
                String s = new String(c, 0, len);
                outputString.append(s);
                System.out.print(s);
            }
            inputStream.close();
        }
    }
}
