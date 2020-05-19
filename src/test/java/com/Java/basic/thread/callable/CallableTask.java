/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: CallableTask
 * Author:   feiyi
 * Date:     2020/5/19 9:55 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.callable;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/5/19
 * @since 1.0.0
 */
public class CallableTask implements Callable<Integer> {

    private int taskIndex;
    public CallableTask(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    public CallableTask() {
        taskIndex = 0;
    }
    @Override
    public Integer call() throws Exception {
        int t = new Random().nextInt(5) * 1000;
        try {
            Thread.sleep(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
