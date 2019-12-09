package com.widget.bak.phantom.demo;

import com.alibaba.fastjson.JSONObject;
import com.beta.basic.pojo.User;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/***
 *  Created by shao.guangze on 2018/7/3
 */
@RestController
@RequestMapping("/phantom")
public class PhantomController {

    @RequestMapping("/test")
    @ResponseBody
    public String testform(String username,Date timetest){
        User user = new User();
        user.setGender("woman");
        user.setHobby("anger");
        user.setName("sida");
        String jsonString = JSONObject.toJSONString(user);
        String temp = jsonString+"#TRS#"+jsonString+"#TRS#"+jsonString+"#TRS#"+jsonString+"#TRS#"+jsonString;
        System.out.println(temp);
        return "result from testform";
    }

    @RequestMapping("/echarts")
    @ResponseBody
    public Object echartsTest(String name,String value){
        System.out.println("request in ........................");
        System.out.println(name);
        System.out.println(value);
        List<Integer> listHigh = Arrays.asList(7,8,3,2,9,6,5);
        List<Integer> listLow = Arrays.asList(-1,-3,-2,-5,-6,-3,-2);
        List<String> listTitle = Arrays.asList("周一","周二","周三","周四","周五","周六","周天");
        HashMap<String,List<?>> hashMap = new HashMap<>();
        hashMap.put("listHigh", listHigh);
        hashMap.put("listLow", listLow);
        hashMap.put("listTitle", listTitle);
        return hashMap;
    }

    @RequestMapping("/echarts2")
    @ResponseBody
    public Object echartsTest2(String base64url) throws Exception{
        System.out.println(base64url);
        String[] split = base64url.split(",");
        String b64 = split[1];
        Base64 base64 = new Base64();
        byte[] decode = base64.decode(b64);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("11.png"));
        byte[] temp=new byte[1024];
        int read;
        while((read = bufferedInputStream.read(temp))!=-1){
            bufferedOutputStream.write(temp,0,read);
        }
        bufferedOutputStream.close();
        return base64url;
    }
}
