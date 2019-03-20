/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: IndexDemo
 * Author:   feiyi
 * Date:     2019/3/19 9:54 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.elasticsearch;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/3/19
 * @since 1.0.0
 */
public class IndexDemo {

    /***
     * insert操作
     * 不指定id的话es会自动生成
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
}
