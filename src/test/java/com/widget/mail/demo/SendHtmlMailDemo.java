package com.widget.mail.demo;

import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/***
 *  Created by shao.guangze on 2018/8/13
 */
public class SendHtmlMailDemo {
    public static void main(String[] args) throws FileNotFoundException {
        SAXReader reader = new SAXReader();
//        Document document = reader.

        System.out.println(SendHtmlMailDemo.class.getResource("/mystaticdir/pageTemplate.html").getPath());
        new FileInputStream(new File("src/main/resources/mystaticdir/pageTemplate.html"));
    }
}
