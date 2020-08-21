/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/10/11 10:37 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.elasticsearch.rest.test;

import com.widget.elasticsearch.rest.ClientDemo;
import com.widget.elasticsearch.rest.QueryDemo;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;

import java.io.IOException;

/**
 * 〈一句话功能简述〉:
 * 〈https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-search.html〉
 *
 * @author feiyi
 * @create 2019/10/11
 * @since 1.0.0
 */
public class Demo {

    @Test
    public void test() throws IOException {
        String host = "localhost";
        int port = 9200;
        String index = "tianmao";
        RestHighLevelClient client = ClientDemo.getClient(host, port);
        SearchResponse response = QueryDemo.query(client, index);
        ClientDemo.getResponseResult(response, "product_name");
    }

}
