package com.Java.basic.io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

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

    //流复制测试
    @Test
    public void test() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("/Users/feiyi/Desktop/11.png"));
        byte[] bytes = inputStreamToByte(fileInputStream);
        ByteArrayInputStream b1 = new ByteArrayInputStream(bytes);
        ByteArrayInputStream b2 = new ByteArrayInputStream(bytes);

        BufferedOutputStream bo1 = new BufferedOutputStream(new FileOutputStream(new File("/Users/feiyi/Desktop/12.png")));
        BufferedOutputStream bo2 = new BufferedOutputStream(new FileOutputStream(new File("/Users/feiyi/Desktop/13.png")));

        byte[] temp = new byte[1024];
        int len;
        while ((len = b1.read(temp)) != -1) {
            bo1.write(temp,0, len);
        }
        bo1.close();

        byte[] temp2 = new byte[1024];
        int len2;
        while ((len2 = b2.read(temp2)) != -1) {
            bo2.write(temp2,0, len2);
        }
        bo2.close();
    }

    private byte[] inputStreamToByte(InputStream inputStream) throws IOException {
        int length ;
        byte[] temp = new byte[1024];
        ArrayList<Byte> list = new ArrayList<>();
        while ((length = inputStream.read(temp)) != -1){
            for (int i = 0 ; i<length ; i ++) {
                list.add(temp[i]);
            }
        }
        Object[] objects = list.toArray();
        byte[] bytes = new byte[objects.length];
        for (int i = 0 ; i < objects.length ; i ++){
            bytes[i] = ((Byte)objects[i]).byteValue();
        }
        return bytes;
    }
}
