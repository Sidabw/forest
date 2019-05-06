/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/4/4 10:43 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.dom4j;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/4
 * @since 1.0.0
 */
public class Demo {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Demo demo = new Demo();
        SAXReader saxReader = new SAXReader();
//        InputStream resourceAsStream = demo.getClass().getClassLoader().getResourceAsStream("pom.xml");
        Document doc = saxReader.read(new FileInputStream("/Users/feiyi/Documents/feiyiGitProject/forest/pom.xml"));
        Element rootElement = doc.getRootElement();
        rootElement.elements().stream().forEach(e ->{
            Element eL = (Element)e;
            String name = eL.getName();
            if ("version".equals(name))  System.out.println(eL.getText());
        });
    }


    @Test
    public void test(){
        System.out.println(1);
    }
}
