/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2018/11/20 下午5:29
 * Description: mongo测试使用类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mongo;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 〈一句话功能简述〉:
 * 〈mongo测试使用类
 * pom开启mongo依赖
 * 〉
 *
 * @author feiyi
 * @create 2018/11/20
 * @since 1.0.0
 */
public class Demo {

    public void test(){
         /*System.out.println("-------mongo-----");
        //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress("10.10.1.6",12003);
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential("ie_model", "zk_ie_model", "8a1d3920aea87ea01098012f8188dc96".toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs,credentials);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("zk_ie_model");
        MongoCollection<Document> label_info = mongoDatabase.getCollection("label_info");
        FindIterable<Document> documents = label_info.find();
        MongoCursor<Document> iterator = documents.iterator();
        int i = 1;
        while (iterator.hasNext()){
            Document eachModel = iterator.next();
            String comment = eachModel.getString("comment");
            String id = eachModel.getString("_id");
            Model model = new Model();
            model.setComment(comment);
            model.setPinyinMongonId(id);
            model.setId(i);
            model.setPinyinAll(getPinyin(comment));
            i++;
            modelMapper.insert(model);
        }*/
    }

    private String getPinyin(String hanzi){
        //ascii 32-126 是所有符号及大小写英文的10进制值
        StringBuffer convertResult = new StringBuffer();
        for(int i =0 ; i < hanzi.length(); i++){
            char c = hanzi.charAt(i);
            boolean condition = (c > 31 && c < 127) || c == 65295 || c == 12289;
            if(!condition){
                convertResult.append(c);
            }
        }
        String input = convertResult.toString();
        StringBuilder pinyin = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
            char c = input.charAt(i);
            String[] pinyinArray = null;
            try {
                pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            if (pinyinArray != null) {
                pinyin.append(pinyinArray[0]);
            } else if (c != ' ') {
                pinyin.append(input.charAt(i));
            }
        }
        return pinyin.toString().trim().toLowerCase();
    }
    public static void main(String[] args){
        char a = '、';
        System.out.println(a);
    }
}
