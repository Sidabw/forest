/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: EOFExceptionTest
 * Author:   feiyi
 * Date:     2020/5/29 11:43 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.http.ok;

import okhttp3.*;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/5/29
 * @since 1.0.0
 */
public class EOFExceptionTest {

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(1200, TimeUnit.SECONDS)
            .writeTimeout(1200, TimeUnit.SECONDS)
            .readTimeout(2000, TimeUnit.SECONDS)
            //解决OkHttp的: java.io.EOFException: \n not found...
            //keep alive时间过后，server端会关闭tcp连接，这个时候如果请求还没结束，就会抛出该异常。
            //这里说的额keep alive time 是server端的配置
            .retryOnConnectionFailure(Boolean.TRUE)
//            .addInterceptor(new ThHttpInterceptor())
            .build();

    public static void main(String[] args) throws IOException {
        String url = "http://223.112.6.2:8899/data/receive/insertBatch";
        String paramsIn = "{\"des\":\"\",\"src\":\"\",\"param\":{\"records\":[{\"financial_label_id_list\":[\"hy13\",\"hy1303\"],\"gmt8_created\":\"2020-07-10 11:45:25:861\",\"content_fc\":\"原标题：7月10日石家庄柏坡正元液氨价格持稳\\r\\n            \\r\\n                \\r\\n\\r\\n        \\r\\n             　　7月10日，石家庄柏坡正元液氨今日报价稳定，目前厂家报价3000元/吨，据厂家反映，目前沧州正元液氨不销售，该企业所在河北地区液氨供应压力略有缓解，料厂家价格会维稳。\\r\\n 　　注：以上价格为含税价格。\\r\\n        \\r\\n            \\r\\n                (责任编辑：DF533)\",\"is_delete\":0,\"simhash_split\":{\"sim_4\":65434,\"sim_1\":33556,\"sim_3\":12089,\"sim_2\":60805},\"crawl_time\":\"2020-07-10 11:09:32\",\"financial_label\":[{\"paragraph_offset\":-1,\"score\":\"6.0\",\"key_list\":[{\"name\":\"公用事业\",\"id\":\"hy13\"},{\"name\":\"工业气体\",\"id\":\"hy1303\"}],\"file_id\":\"5f07dbec92cdba3dc9732096\",\"name\":\"行业标签\",\"text_offset\":12,\"type\":1,\"value\":\"工业气体\",\"key\":\"hy1303\",\"node_id\":\"\"}],\"date_time\":\"2020-07-10 11:06:00\",\"simhash_id\":\"1000001100010100111011011000010100101111001110011111111110011010\",\"meta_info\":{\"sentiment\":\"0\",\"meta_name_fc\":\"7月10日石家庄柏坡正元液氨价格持稳\",\"meta_name\":\"7月10日石家庄柏坡正元液氨价格持稳\",\"author\":\"生意社\",\"publish_time\":\"2020-07-10 11:06:00\",\"importance\":\"3\",\"host\":\"futures.eastmoney.com\",\"project\":\"东方财富网\",\"abstract\":\"\",\"norm_title\":\"月10日石家庄柏坡正元液氨价格持稳\",\"url\":\"http://futures.eastmoney.com/a/202007101550498193.html\"},\"file_info\":{\"name\":\"7月10日石家庄柏坡正元液氨价格持稳\",\"file_id\":\"5f07dbec92cdba3dc9732096\"},\"_id\":\"5f07dbec92cdba3dc9732096\",\"gmt8_modified\":\"2020-07-10 11:45:25:861\"}],\"is_duplication\":\"1\",\"type\":\"taiji_test\",\"is_force_refresh\":false,\"index_name\":\"taiji_test\"},\"msgId\":\"\",\"time\":\"2020-07-10 11:45:30:618\"}";
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, paramsIn.toString());
        Request.Builder reqBuilder = new Request.Builder().url(url).post(body);
//        reqBuilder.header("Connection", "close");
        Headers headers = reqBuilder.build().headers();
        Set<String> names = headers.names();
//        for (String name : names) {
//            System.out.println(name + " : " + headers.get(name));
//        }
//        System.out.println(reqBuilder.build().body());
        Call call = client.newCall(reqBuilder.build());
        Response response = call.execute();
        if (response.code() != 200) throw new RuntimeException("request error, code " + response.code());
        String result = response.body().string();
        System.out.println(result);
    }
}
