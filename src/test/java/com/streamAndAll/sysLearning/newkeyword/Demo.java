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
package com.streamAndAll.sysLearning.newkeyword;

import com.streamAndAll.sysLearning.pojo.User;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 〈一句话功能简述〉:
 * 〈introduction of new keyword ::〉
 *
 * @author feiyi
 * @create 2018/11/22
 * @since 1.0.0
 */
public class Demo {

    //Method and Constructor References
    public static void main(String[] args){
        //pass reference by utilizing static method
        Function<String, Integer> f1 = Integer::valueOf;
        System.out.println(f1.apply("1"));
        //pass reference by utilizing object method
        //下面的Function和Supplier只是例子，代表接口的唯一抽象方法接受的参数和返回的参数的不同。
        Function<User, Integer> f2 = User::getAge;
        User user = new User(10, "a", "ad");
        Supplier<Integer> s1 = user::getAge;
        System.out.println(s1.get());
        //因为Supplier的唯一抽象方法是无参的，所以User对象必须要有无参构造
        Supplier<User> s2 = User::new;

    }
}
