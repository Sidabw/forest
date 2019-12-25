/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: HbaseDemo
 * Author:   feiyi
 * Date:     2019/12/20 11:50 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.elasticsearch;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.ipc.Server.Connection;
import org.junit.Test;
//import org.apache.hadoop.hbase.client.tableindexed.IndexedTable;


/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/12/20
 * @since 1.0.0
 */
public class HbaseDemo {

    @Test
    public void createTable() {
        TableName tableName = TableName.valueOf("sidabw");

    }

    public static Connection initHbase() {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.property.clientPort", "2181");
        config.set("hbase.zookeeper.quorum", "127.0.0.1");
        config.set("hbase.master", "127.0.0.1:51584");
        return null;
    }

}
