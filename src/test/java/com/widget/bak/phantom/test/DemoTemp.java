
package com.widget.bak.phantom.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;

public class DemoTemp {
    public static void main(String[] args) throws Exception {

        Base64 base64 = new Base64();
        byte[] decode = base64.decode("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");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("12.png"));
        byte[] temp = new byte[1024];
        int read = 0;
        while ((read = bufferedInputStream.read(temp)) != -1) {
            bufferedOutputStream.write(temp, 0, read);
        }
        bufferedOutputStream.close();
		
		/*Integer everyTime = 300;
		Integer hour = everyTime/3600;
		Integer minute =  (everyTime/3600) > 1 ?;
		Integer second = */
		/*List<User> asList = Arrays.asList(new User(),new User(), new User());
		for(User u : asList){
			u.setAge(1);
		}
		for(User user : asList){
			System.out.println(user.getAge());
		}*/
        //Base64 base64 = new Base64();
		/*Object encode = base64.encode("我是谁".getBytes());
		byte[] temp =(byte[])encode;
		System.out.println(new String(temp));*/
	/*	byte[] decode = base64.decode("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println(decode);
		new String()*/
		/*String str ="                    ";
		byte[] bytes = str.getBytes("utf-8");
		System.out.println(bytes);*/
        //Base64 base64 = new Base64();
		/*String str = "iVBORw0KGgoAAAANSUhEUgAAAjAAAAEOCAYAAACXaS0vAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAgAElEQVR4AQBPg7B8";
		byte[] decode = base64.decode(str.toString());
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("12.png"));
		byte[] temp=new byte[1024];
		int read=0;
		while((read = bufferedInputStream.read(temp))!=-1){
			bufferedOutputStream.write(temp,0,read);
		}
		bufferedOutputStream.close();*/
		/*StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("aaa");
		System.out.println(stringBuffer);*/
    }

    @Test
    public void test() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(2000);
        int i = 10000000;
        while (i > 0) {
            i--;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println(currentTimeMillis2 - currentTimeMillis);
    }
}

class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
