package com.streamAndAll.usualUse;

import com.streamAndAll.sysLearning.pojo.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *  Created by shao.guangze on 2018/9/10
 */
public class UsualUse {
    public static void main(String[] args){
        System.out.println("=====   Grouping By   =====");

        System.out.println("=====   Grouping By   =====");
        User sida1 = new User(17, "女", "sida1");
        User sida2 = new User(17, "女", "sida2");
        User sida3 = new User(19, "女", "sida3");
        List<User> users = Arrays.asList(sida2, sida3, sida1);
        Map<Integer, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(collect.get(19).get(0).getName());
        System.out.println("=====   Summing   =====");
        List<Integer> intList = Arrays.asList(12, 10, 29, 4, 1);
        Integer sum = intList.stream().collect(Collectors.summingInt(value -> value));
        System.out.println(sum);

        System.out.println("=====   String Sort   =====");
        //String sort   这里是倒序
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names,(a, b) -> b.compareTo(a));
        names.stream().forEach(System.out::println);
    	/*Collections.sort(names, (String a, String b) -> {
    		return b.compareTo(a);
    	});*/

    	System.out.println("=====   Object Sort   =====");
    	//已给的users中的age为 17 19  17
        users.stream().sorted(Comparator.comparing(User::getAge)).forEach(e -> {
            System.out.println(e.getAge());
        });

        System.out.println("=====   Map Collect   =====");
        User user = new User(12,"women","sida");
        User user1 = new User(12,"women","sida");
        User user2 = new User(13,"women","sida");
        User user3 = new User(12,"women","sida");
        mapCollect(user,user1,user2,user3);

        //param seed unary operator 参数 种子， 一元运算
        //iterate 生成无限大的stream(懒加载，并非无限大) limit做限制
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
        System.out.println("----------------------------");
        //peek方法，接口一个Consumer,但与foreach不同
        //1.void foreach ，Stream peek
        //2.peek 只是给each element 包了一个consumer，不会立即执行，后面对each element有操作时才会执行
        Stream.of(1,2,3,4).forEach(System.out::println);
        System.out.println("----------------------------");
        Stream.of(1,2,3,4).peek(System.out::println).forEach(e -> System.out.println(e + 1));
        System.out.println("----------------------------");
    }
    public static void mapCollect(User... users){
        //将users中的所有age拿出来重新组成1个集合，--->[方便：不需要重新声明1个数组，不需要手动遍历users，不需要去手动赋值。满分！！！]
        List<Integer> array = Arrays.stream(users).map(User::getAge).collect(Collectors.toList());
        Object[] array2 = Arrays.stream(users).map(u ->u.getAge()).toArray();
        for(Object obj:array2){
            System.out.println(obj);
        }
        List<Integer> list = Arrays.asList(1,2,3,4);
        //避免理解为静态函数	forEach接受的参数为Consumer
        list.forEach(System.out::println);
    }
}
