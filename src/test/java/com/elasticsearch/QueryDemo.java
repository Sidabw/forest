/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: QueryDemo
 * Author:   feiyi
 * Date:     2019/3/19 9:54 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.elasticsearch;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.*;

import java.util.Map;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/3/19
 * @since 1.0.0
 */
public class QueryDemo {

    /***
     * 以下查询分别为 id、term(.keyword)、match、range、multiBool
     */
    public static void findById(TransportClient client){
        GetRequest getRequest = new GetRequest("bank");
        getRequest.id("25");
        ActionFuture<GetResponse> getResponseActionFuture = client.get(getRequest);
        GetResponse getFields = getResponseActionFuture.actionGet();
        Map<String, Object> source = getFields.getSource();
        System.out.println(getResponseActionFuture.actionGet());
        System.out.println(source.get("firstname"));
    }

    //if u want to perform a termQuery , u must add ".keyword' after the field you wanna search.
    public static SearchResponse simpleTermQuery(TransportClient client, String index) {
        TermQueryBuilder termQueryBuilder1 = QueryBuilders.termQuery("firstname.keyword", "Effie");
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        SearchResponse response = searchRequestBuilder.setQuery(termQueryBuilder1).get();
        return response;

    }
    //NOTE:这里firstname:o并不是不分词，而是库中的数据分词后没有和o能对上的，如果有Sida o 这样的fitstname那么就能对应
    //The standard query for performing full text queries, including fuzzy matching and phrase or proximity(接近) queries.
    public static SearchResponse simpleMatchQuery(TransportClient client, String index, String name, String text) {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(name, text);
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "Doe");
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        SearchResponse response = searchRequestBuilder.setQuery(matchQueryBuilder).get();
        return response;
    }
    public static SearchResponse simpleMatchPhraseQuery(TransportClient client, String index, String name, String text) {
        MatchPhraseQueryBuilder matchQueryBuilder = QueryBuilders.matchPhraseQuery(name, text);
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "Doe");
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        SearchResponse response = searchRequestBuilder.setQuery(matchQueryBuilder).get();
        return response;
    }
    public static SearchResponse simpleWildcardQuery(TransportClient client, String index, String name, String text) {
        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery(name, text);
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "Doe");
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        SearchResponse response = searchRequestBuilder.setQuery(wildcardQueryBuilder).get();
        return response;
    }
    public static SearchResponse simpleMultiMatch(TransportClient client, String index, String text, String... fields){
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(text, fields);
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        SearchResponse response = searchRequestBuilder.setQuery(multiMatchQueryBuilder).get();
        return response;
    }
    // gt大于, lt小于 gte、ge大于等于   lte、le 小于等于
    //分页的话需要使用SearchRequestBuilder 执行查询方式 两种都可以
    public static SearchResponse simpleRangeQuery(TransportClient client, String index){
        RangeQueryBuilder ageRangeQueryBuilder = QueryBuilders.rangeQuery("age");
        ageRangeQueryBuilder.gt(1);
        ageRangeQueryBuilder.lte(32);
        //加 分页
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        searchRequestBuilder.setQuery(ageRangeQueryBuilder);
        searchRequestBuilder.setFrom(10).setSize(20);
        SearchResponse searchResponse1 = searchRequestBuilder.get();
//        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();
        return searchResponse1;
    }
    public static SearchResponse boolQuery(TransportClient client, String index){
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("firstname", "o");
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("xx", "xxx");
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(matchPhraseQueryBuilder);
        boolQuery.must(termQueryBuilder);
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
        SearchResponse response = searchRequestBuilder.setQuery(boolQuery).get();
        return response;
    }
}
