/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: MultiThread4
 * Author:   feiyi
 * Date:     2020/3/3 7:43 AM
 * Description: 测试synchronized
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread;

/**
 * 〈一句话功能简述〉:
 * 〈测试synchronized〉
 *
 * @author feiyi
 * @create 2020/3/3
 * @since 1.0.0
 */
public class MultiThread4 {


}

class MyThread implements Runnable {

    private Resource resource;

    public MyThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.produce();
    }
}

class Resource {

    public void produce() {
        //就没有synchronized{}这个用法...
        synchronized (this) {

        }
    }
}