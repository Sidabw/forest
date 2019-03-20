package com.Java.basic.io;

import java.io.*;

/***
 *  Created by shao.guangze on 2018/8/15
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*//mkdir 只能创建1级目录
        File file = new File("C:\\Users\\think\\Desktop\\dir2\\2\1");
        System.out.println(file.isDirectory());
        file.mkdir();
        System.out.println(file.isDirectory());*/
        StringBuffer stringBuffer =  new StringBuffer();
        for(int i = 0; i < 65536 ; i++){
            stringBuffer.append("啊");
        }
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\think\\Desktop\\dir\\1.txt"));
        pw.println(stringBuffer.toString());
        pw.close();
        /*File file = new File("C:\\Users\\think\\Desktop\\dir");
        FileOutputStream fileInputStream = new FileOutputStream(file);
        fileInputStream.write
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("12.txt"));
        byte[] temp=new byte[1024];
        int read=0;
        while((read = bufferedInputStream.read(temp))!=-1){
            bufferedOutputStream.write(temp,0,read);
        }
        bufferedOutputStream.close();*/

    }
}
