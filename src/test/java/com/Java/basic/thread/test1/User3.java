/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: User3
 * Author:   feiyi
 * Date:     2020/3/19 3:20 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.thread.test1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/3/19
 * @since 1.0.0
 */
public class User3 implements Runnable{

    private static ReentrantLock lock = new ReentrantLock();

    private static final String user = "user3";

    private WebApp webApp;

    private static int i = 0;

    public User3(WebApp webApp) {
        this.webApp = webApp;
    }

    @Override
    public void run() {
        i++;
        while (true) {
            webApp.webMethod(lock, user  + " -- " +  i);
        }
    }
}
