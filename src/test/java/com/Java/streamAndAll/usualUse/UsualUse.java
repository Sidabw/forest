package com.Java.streamAndAll.usualUse;

import com.Java.streamAndAll.sysLearning.pojo.User;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/***
 *  Created by shao.guangze on 2018/9/10
 */
public class UsualUse {

    @Test
    public void mapTest() {
        User user = new User(12,"women","sida");
        User user1 = new User(12,"women","sida");
        User user2 = new User(13,"women","sida");
        User user3 = new User(12,"women","sida");
        User[] users = new User[] {user, user1, user2, user3};
        //将users中的所有age拿出来重新组成1个集合，--->[方便：不需要重新声明1个数组，不需要手动遍历users，不需要去手动赋值。满分！！！]
        List<Integer> array = Arrays.stream(users).map(User::getAge).collect(Collectors.toList());
        //这样方便在于使用的时候需要强转
        Object[] array2 = Arrays.stream(users).map(u ->u.getAge()).toArray();
        for(Object obj:array2){
            System.out.println(obj);
        }
        List<Integer> list = Arrays.asList(1,2,3,4);
        //避免理解为静态函数	forEach接受的参数为Consumer
        list.forEach(System.out::println);


        System.out.println("=====   Map Collect   =====");
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

    @Test
    public void groupByTest(){
        System.out.println("=====   Grouping By   =====");
        User sida1 = new User(17, "女", "sida1");
        User sida2 = new User(17, "女", "sida2");
        User sida3 = new User(19, "女", "sida3");
        List<User> users = Arrays.asList(sida2, sida3, sida1);
        Map<Integer, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(collect.get(19).get(0).getName());

    }

    @Test
    public void summing(){
        System.out.println("=====   Summing   =====");
        List<Integer> intList = Arrays.asList(12, 10, 29, 4, 1);
//        Integer sum = intList.stream().collect(Collectors.summingInt(value -> value));
        Integer sum = intList.stream().mapToInt(value -> value).sum();
        System.out.println(sum);
    }

    @Test
    public void sort(){
        System.out.println("=====   String Sort   =====");
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        //1
//        Collections.sort(names, (String a, String b) -> {
//    		return b.compareTo(a);
//    	});
        //2
//        Collections.sort(names,(a, b) -> a.compareTo(b));
        //3
        Collections.sort(names,String::compareTo);
        names.stream().forEach(System.out::println);

        System.out.println("=====   Object Sort   =====");
        User sida1 = new User(17, "女", "sida1");
        User sida2 = new User(17, "女", "sida2");
        User sida3 = new User(19, "女", "sida3");
        List<User> users = Arrays.asList(sida2, sida3, sida1);
        //已给的users中的age为 17 19  17
        users.stream().sorted(Comparator.comparing(User::getAge)).forEach(e -> {
            System.out.println(e.getAge());
        });
    }


    @Test
    public void sumTest() {
        int sum = IntStream.of(1, 2, 4).sum();
        System.out.println(sum);

        List<Integer> integers = Arrays.asList(1, 2, 4, 5);
        int sum1 = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);
    }


    @Test
    public void collectTest(){
        //指定collect的构造容器

        //不指定的情况
        List<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        //指定了的情况
        ArrayList<Integer> collect1 = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toCollection(ArrayList::new));

        //partitioningBy 二值逻辑

        User sida1 = new User(17, "女", "sida1");
        User sida2 = new User(17, "女", "sida2");
        User sida3 = new User(19, "男", "sida3");

        Map<Boolean, List<User>> map = Stream.of(sida1, sida2, sida3).collect(Collectors.partitioningBy(e -> e.getGender().equals("男")));
        System.out.println(map.get(Boolean.TRUE).size());
        System.out.println(map.get(Boolean.FALSE).size());

        String collect2 = Stream.of("I", "Love", "u", "sida").collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect2);
    }

    //reduce 擅长的是从一组值中生成一个值
    @Test
    public void reduceTest(){
        //使用reduce 找出最长单词
        Stream<String> strStream = Stream.of("I", "LOVE", "YOU", "TOO");
        Optional<String> reduce = strStream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        System.out.println(reduce.get());
        //使用reduce求长度之和
        Stream<String> strStream2 = Stream.of("I", "LOVE", "YOU", "TOO");
        Integer result = strStream2.reduce(
                0,  //初始值
                (sum, l1) -> sum += l1.length(),    //累加器
                (a, b) -> a + b);   //并行时用到的拼接器
        System.out.println(result);

        Stream<String> strStream3 = Stream.of("I", "LOVE", "YOU", "TOO");
        Optional<String> max = strStream3.max((s1, s2) -> s1.length() - s2.length());
        //reduce的变种-max
//        Optional<String> max = strStream3.max(Comparator.comparingInt(String::length));
        System.out.println(max.get());

    }

    @Test
    public void parallelStreamTest() throws InterruptedException {

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0 ; i <  10 ; i ++) {
            integers.add(i);
        }

        long date = System.nanoTime();
        integers.stream().forEach(e ->{
            System.out.println(e);
        });
        long date2 = System.nanoTime();
        integers.parallelStream().forEach(e ->{
            if (e == 2) System.out.println(e);
        });
        long date3 = System.nanoTime();
        System.out.println("-------------------");
        System.out.println(date2 - date);
        System.out.println(date3 - date2);
    }


    /**
     * @Description 测试 stream.map是处理完一个给后边还是等全部处理完了再给后边
     * @param
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/12/23 10:17 AM
     **/
    @Test
    public void concurrentMapTest() {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
//        System.out.println("⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️⬇️️️️⬇️️️");
//        strings.stream().map(e -> {
//            System.out.print(e);
//            return e+" z";
//        }).map(e ->{
//            System.out.print(" map2 ");
//            return e;
//        }).forEach(e -> {
//            System.out.print(" -> foreach :: ");
//            System.out.println(e);
//        });
//        System.out.println("⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️");

        Stream<String> stream = strings.stream();

//        //内部通过spliterator.forEachRemaining实现迭代
//        Spliterator<String> spliterator = stream.spliterator();
//        spliterator.forEachRemaining(System.out::println);

        stream.map(e ->{
            System.out.println(e);
            return e + 'z';
        }).forEach(e ->{
            System.out.println(e);
        });
    }

}
