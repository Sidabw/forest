/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/6/19 11:58 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.jvm;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.lang.management.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/6/19
 * @since 1.0.0
 */
public class JVMTest {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "---" + value);
            if (key.toString().contains("io")) System.out.println("0000000000000000000000000000000000");
            if (value.toString().contains("private")) System.out.println("1111111111111111111111111111111111");
            // java.io.tmpdir---/var/folders/8g/wd8tdvcd1m5_1krwg4s261qr0000gn/T/
        }
    }


    //对内存监控
    @Test
    public void test1(){
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());

        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        System.out.println(heapMemoryUsage.getInit());
        System.out.println(heapMemoryUsage.getUsed());
        System.out.println(heapMemoryUsage.getCommitted());
        System.out.println(heapMemoryUsage.getMax());

        MemoryUsage nonHeapMemoryUsage = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        System.out.println(nonHeapMemoryUsage.getInit());
        System.out.println(nonHeapMemoryUsage.getUsed());
        System.out.println(nonHeapMemoryUsage.getCommitted());
        System.out.println(nonHeapMemoryUsage.getMax());

        //即将被回收的对象个数
        int objectPendingFinalizationCount = ManagementFactory.getMemoryMXBean().getObjectPendingFinalizationCount();
        System.out.println(objectPendingFinalizationCount);

        //线程信息
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        int threadCount = threadMXBean.getThreadCount();
        ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds()[0]);
        System.out.println(threadCount);
        System.out.println(JSONObject.toJSONString(threadInfo));

        //gc信息
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeans) {
            System.out.println(garbageCollectorMXBean.getName());
            System.out.println(garbageCollectorMXBean.getCollectionCount());
            System.out.println(garbageCollectorMXBean.getCollectionTime());
        }

    }

}
