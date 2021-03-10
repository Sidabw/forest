/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Singleton2
 * Author:   feiyi
 * Date:     2019/1/2 下午2:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.designMode.singleton;

/**
 * 〈一句话功能简述〉:
 * 〈懒汉式单例〉
 *
 * @author feiyi
 * @create 2019/1/2
 * @since 1.0.0
 */
public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                    return singleton2;
                }
            }
        }
        return singleton2;
    }

}
