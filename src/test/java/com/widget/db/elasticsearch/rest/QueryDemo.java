/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: QueryDemo
 * Author:   feiyi
 * Date:     2019/12/3 4:17 PM
 * Description: query
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.elasticsearch.rest;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * 〈一句话功能简述〉:
 * 〈query〉
 *
 * @author feiyi
 * @create 2019/12/3
 * @since 1.0.0
 */
public class QueryDemo {

    public static SearchResponse query(RestHighLevelClient client, String... indices) throws IOException {
        //支持跨index查询
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
//        QueryBuilder queryBuilder = QueryBuilders.idsQuery().addIds("ngz9k2kBSX1ny91H8x2Y");
//        QueryBuilder queryBuilder = QueryBuilders.termQuery("_id", "ngz9k2kBSX1ny91H8x2Y");
        QueryBuilder queryBuilder = QueryBuilders.termQuery("store_name.keyword", "梵希蔓旗舰店");
        sourceBuilder.query(queryBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(1);

        SearchRequest searchRequest = new SearchRequest(indices); //index 哪张表
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(response.getHits().getTotalHits());
        return response;
    }


}
