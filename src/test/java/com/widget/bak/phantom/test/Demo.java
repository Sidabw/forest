
package com.widget.bak.phantom.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws Exception {
        Runtime rt = Runtime.getRuntime();
        String url = "http://www.oicqzone.com";
        Process p = rt.exec("phantomjs " + "D:/phantomjs/jstest/a.js " + url);
        InputStream inputStream = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer sbf = new StringBuffer();
        String temp;
        while ((temp = br.readLine()) != null) {
            sbf.append(temp);
        }
        System.out.println(sbf.toString());

    }
}
