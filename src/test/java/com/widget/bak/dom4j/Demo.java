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
package com.widget.bak.dom4j;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/4
 * @since 1.0.0
 */
public class Demo {

    @Test
    public void readXml() throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
//        InputStream resourceAsStream = demo.getClass().getClassLoader().getResourceAsStream("pom.xml");
        Document doc = saxReader.read(new FileInputStream("/Users/feiyi/Documents/feiyiGitProject/forest/pom.xml"));
        Element rootElement = doc.getRootElement();
        rootElement.elements().stream().forEach(e -> {
            Element eL = (Element) e;
            String name = eL.getName();
            if ("version".equals(name)) System.out.println(eL.getText());
        });
    }

    @Test
    public void createXml(){
        Document document = DocumentHelper.createDocument();
        Element appid = document.addElement("xml");
        Element a = appid.addElement("a");
        a.setText("aaa");
        Element b = appid.addElement("b");
        b.setText("vvvvv");
        System.out.println("asXML+++++++   "+document.getRootElement().asXML());
        String text = document.getText();
        System.out.println(text);
    }
}
