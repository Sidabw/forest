/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Obsevable
 * Author:   feiyi
 * Date:     2019/12/27 3:18 PM
 * Description: 被观察者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.designMode.observe;

import java.util.Observable;

/**
 * 〈一句话功能简述〉:
 * 〈被观察者〉
 *
 * @author feiyi
 * @create 2019/12/27
 * @since 1.0.0
 */
public class MyObservable extends Observable {
    public static void main(String[] args) {
        //创建一个被观察者，把观察者加进来
        MyObservable myObservable = new MyObservable();
        myObservable.addObserver(new MyObserver());

        //被观察者发生变化了，把消息发给观察者。
        myObservable.setChanged();
        myObservable.notifyObservers("aaa");
    }
}
