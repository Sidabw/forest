package com.Java.basic.test;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.widget.mongo.MongoUtil;
import org.bson.Document;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;
import org.bson.json.StrictJsonWriter;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/***
 *  Created by shao.guangze on 2018/7/26
 */
public class Demo {

    public static void main(String[] args) throws ParseException {
        String str = "Ddabcdefghijklmnopqrst";
        System.out.println(str.indexOf("def"));
        String str2 = "aa\\aba\"";
        str2 = str2.replaceAll("\\\\","\\\\\\\\");  //1个反斜线换成2个反斜线
        str2 = str2.replaceAll("\"","\\\\\"");  //1个单引号变成1个反斜杠+1个单引号
        str2 = str2.replaceAll("b","\\\\"); //同样，1个反斜杠需要用4个反斜杠来表示
        System.out.println(str2);
        System.out.println("----------------------------------");
        String str3 = "我爱吃萝卜头啊啊";
        System.out.println(str3.length());
        System.out.println(str3.substring(0,8));
        System.out.println(str3.substring(8).equals(""));
        System.out.println("----------------------------------");
        System.out.println(null instanceof String);
        System.out.println(new Double(Double.valueOf("0.1")*1000).intValue());
        String aaa = new String("aaa");
        String aaa1 = new String("aaa");
        System.out.println(aaa.hashCode() == aaa1.hashCode());
        System.out.println(aaa.equals(aaa1));
        Demo demo = new Demo();
        demo.equals(new Demo());
        System.out.println("-----------------------------------");
        Object o = new Demo();
        Demo d = (Demo)o;
        System.out.println(d == o); //所以说强转之后还是原来的对象
        System.out.println("----------------------------------");
        System.out.println(String.format("task.%s", 1));
        System.out.println("---");
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str222 = df.format(date);
        int a = Integer.parseInt(str222);
        if (a >= 0 && a <= 6) {
            System.out.println("凌晨");
        }
        if (a > 6 && a <= 12) {
            System.out.println("上午");
        }
        if (a > 12 && a <= 13) {
            System.out.println("中午");
        }
        if (a > 13 && a <= 18) {
            System.out.println("下午");
        }
        if (a > 18 && a <= 24) {
            System.out.println("晚上");
        }
        System.out.println("-----");
        int hour = 15;
        int min = 51;

        if ((hour >= 7 && hour <12) || (hour == 12 && min <=50)) {
            System.out.println(11111);
        }

        System.out.println("-----");
        String da = "2019/01/01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(da);
        System.out.println(parse.getTime());
    }

    @Test
    public void test(){
        //伪随机数；密码学安全随机数；真随机数
        //1。伪随机数：看着是随机的，但实际上有固定的生成规则
        //2。密码学安全随机数，也不是真正意义上的随机数，但是没有办法根据已有样本推测出下一个元素
        //3。真随机数：往往都是一些实际现象，如抛硬币等。对核裂变等要求的真正随机数，往往是非常复杂的。
        int i = new Random().nextInt(10);
        System.out.println(i);
    }

    //string 和 StringBuffer 在使用上的一点区别。不考虑字符缓冲区等内容
    @Test
    public void diffBetweenStr(){
        String a = null;
//        System.out.println(new StringBuffer(a).append("aaaa").toString()); //会抛异常
        System.out.println(new StringBuffer().append("aaa").append(a).toString());
        System.out.println(a + "aaa");
        System.out.println('-');
        String bb = "aa\n";
        System.out.print(bb.replaceAll("\\\\n",""));
        System.out.print('-');
        System.out.print(bb);
    }

    @Test
    public void assertTest(){
        //断言之所以本地测试会被启动是因为启动参数上加上了-ea ，即-enableassert
        assert(true);
    }

    @Test
    public void test2() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("/Users/feiyi/Desktop/1.txt"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String res = "";
        String line ;
        while ((line = bufferedReader.readLine()) != null) {
            res +=line;
        }
        bufferedReader.close();

        System.out.println(res);
        JSONObject jsonObject = JSONObject.parseObject(res);
        System.out.println(jsonObject.getJSONObject("a").getJSONObject("b").getJSONObject("c").get("data"));
    }

    @Test
    public void test3(){
        MongoClient mongoClient = MongoUtil.getMongoClient();
        MongoDatabase demo = mongoClient.getDatabase("demo");
        MongoCollection<Document> col = demo.getCollection("demo1");
        FindIterable<Document> id = col.find(Filters.eq("_id", "1"));
        Document next = id.iterator().next();
        String s = next.toJson();
        System.out.println(s);


        JsonWriterSettings build = JsonWriterSettings.builder()
                .outputMode(JsonMode.EXTENDED)
                .doubleConverter((Double value, StrictJsonWriter writer) -> writer.writeNumber(Double.toString(value)))
                .int64Converter((Long value, StrictJsonWriter writer) -> {
                    if (value > 9007199254740992L)
                        writer.writeString(Long.toString(value));
                    else
                        writer.writeNumber(Long.toString(value));
                })
                .int32Converter((Integer value, StrictJsonWriter writer) -> writer.writeNumber(Integer.toString(value)))
                .build();
//            JsonWriterSettings build1 = JsonWriterSettings.builder().outputMode(JsonMode.STRICT).build();
        String jsonStr = next.toJson(build);
        System.out.println(jsonStr);



    }
}
