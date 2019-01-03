/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: Demo1
 * Author:   feiyi
 * Date:     2018/11/12 下午7:04
 * Description: demo1
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.elasticsearch;


import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.index.reindex.UpdateByQueryAction;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.elasticsearch.common.xcontent.XContentFactory.*;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


/**
 * 〈一句话功能简述〉:
 * 〈based on transport client 6.〉
 *
 * @author feiyi
 * @create 2018/11/12
 * @since 1.0.0
 */

public class Demo1 {
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
    /***
     * insert操作
     */
    public static void indexNewRecored(TransportClient client, String index, String type, String id, String jsonRecored) {
        /*HashMap<String, String> newRecored = new HashMap<>();
        newRecored.put("name", "J");
        String jsonRecored = JSONObject.toJSONString(newRecored);*/
        IndexResponse response = client.prepareIndex(index, type, id)
                .setSource(jsonRecored, XContentType.JSON)
                .get();
        System.out.println(response.status());
    }

    /***
     * 批量 insert操作
     */
    public static void bulkIndexNewRecoreds(TransportClient client, String index, String type, List<String> ids, List<String> jsonRecored){
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for(int i = 0 ; i < jsonRecored.size(); i++){
            bulkRequestBuilder.add(client
                    .prepareIndex(index, type, ids.get(i)).
                    setSource(jsonRecored.get(i), XContentType.JSON));
            if(i != 0 && i % 100 == 0){
                //一次插入100条记录
                bulkRequestBuilder.execute().actionGet();
            }
        }
        //插入最后一组数据
        bulkRequestBuilder.execute().actionGet();

    }

    /***
     * update操作
     * update by id
     */
    public static void update(TransportClient client) throws IOException, ExecutionException, InterruptedException {
        //update by id. [officially called document merged]
        ArrayList<String> list = new ArrayList<>();
//        list.add("恒指法巴九甲牛Y");
        UpdateRequest updateRequest = new UpdateRequest("gonggao_metadata_search", "gonggao", "AN201812211275485715")
                .doc(jsonBuilder()
                        .startObject()
                        .field("subject_type_name", list)
                        .endObject());
        UpdateResponse updateResponse = client.update(updateRequest).get();
        System.out.println(updateResponse.status());

    }

    /***
     * delete操作
     * delete by id
     * delete index
     * delete by filter
     */
    public static void delete(TransportClient client){
        //delete by id
//        DeleteResponse consumer = client.prepareDelete().setIndex("consumer").setType("_doc")
//                                        .setId("MMJFIGcBefsE9oGgzK4p").execute().actionGet();
        //delete index
        //DeleteIndexResponse deleteIndexResponse = client.admin().indices().prepareDelete("").execute().actionGet();

        //delete by filter
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name.keyword", "J");
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        BulkByScrollResponse deleteByFilterResponse = DeleteByQueryAction.INSTANCE
                .newRequestBuilder(client).source("medcl")
                .filter(matchAllQueryBuilder)
                .execute().actionGet();

        System.out.println(deleteByFilterResponse.getStatus());
    }


    /***
     * 程序执行入口
     */
    public static void main(String[] args) throws Exception {
        TransportClient client = getClient("10.10.1.6","zk_es_data");
//        TransportClient client = getClient();
//        SearchResponse searchResponse = simpleTermQuery(client, "bank");
//        getResponseResult(searchResponse, "firstname");
        /*SearchResponse searchResponse = simpleMatchQuery(client, "customer");
        getResponseResult(searchResponse, "name");*/
        /*SearchResponse response = simpleRangeQuery(client, "bank");
        getResponseResult(response, "firstname");*/
        /*indexNewRecored(client);*/
//        delete(client);
        update(client);
    }
    public static TransportClient getClient() throws UnknownHostException {
        return getClient("localhost", "elasticsearch_feiyi");
    }

    public static TransportClient getClient(String address, String clusterName) throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .put("client.transport.sniff", true).build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(address), 9301));
        return client;
    }

    public static void getResponseResult(SearchResponse response, String showField){
        SearchHit[] hits = response.getHits().getHits();
        System.out.println("total hits:::" + response.getHits().totalHits);
        for(SearchHit searchHit : hits){
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            System.out.println(sourceAsMap.get(showField));
        }
    }

}
