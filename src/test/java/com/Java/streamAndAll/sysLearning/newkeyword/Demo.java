/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2018/11/22 上午10:06
 * Description: introduction of new keyword ::
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.streamAndAll.sysLearning.newkeyword;

import com.Java.streamAndAll.sysLearning.pojo.User;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 〈一句话功能简述〉:
 * 〈introduction of new keyword ::
 * 静态方法引用
 * 类型上的实例方法引用
 * 实例上的实例方法引用
 * 构造方法引用
 * 超类上的实例方法引用：super::methodName
 * 数组构造方法引用：TypeName[]::new〉
 *
 * @author feiyi
 * @create 2018/11/22
 * @since 1.0.0
 */
public class Demo {

    //Method and Constructor References
    public static void main(String[] args){
        //pass reference by utilizing static method
        //静态方法引用
        Function<String, Integer> f1 = Integer::valueOf;
        System.out.println(f1.apply("1"));
        //pass reference by utilizing object method
        //下面的Function和Supplier只是例子，代表接口的唯一抽象方法接受的参数和返回的参数的不同。
        //类型上的实例方法引用
        Function<User, Integer> f2 = User::getAge;
        User user = new User(10, "a", "ad");
        //实例上的实例方法引用
        Supplier<Integer> s1 = user::getAge;
        System.out.println(s1.get());
        //因为Supplier的唯一抽象方法是无参的，所以User对象必须要有无参构造
        //构造方法引用
        Supplier<User> s2 = User::new;

    }
}
