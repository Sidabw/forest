package com.Java.streamAndAll.sysLearning.function;

import com.Java.streamAndAll.sysLearning.pojo.User;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Demo {
    /**
     * @Description aa
     * @param args  aa
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/10/31 9:56 PM
     **/
    public static void main(String[] args) {
        /**
         * 1.Function<T,R>	T 输入， R 输出
         * Function即为1个标准的lambad函数。stream操作中的map接受的就是1个Function
         * */
        Function<String, String> function = (x) -> {
            System.out.println("处理1");
            return "aa";
        };
        //简写
        Function<String, String> function2 = x -> x.toUpperCase();
        //另一种写法。	接受T User, 返回R Integer
        Function<User, Integer> function3 = User::getAge;

        System.out.println(function.apply("1111"));
        System.out.println(function2.apply("2222"));
        System.out.println(function3.apply(new User(1, "女", "哈哈")));

        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");

        /**
         * 2.Predicate<T>	T为输入。 断言函数，结果只能是boolean
         * */
        Predicate<String> predicate = (x) -> {
            return x.equals("");
        };
        //简写
        Predicate<String> predicate2 = e -> e.equals("");
        System.out.println(predicate.test("abc"));

        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");

        /**
         * 3.Consumer<T>	T为输入。没有输出
         * */
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("consumer");

        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");

        /**
         * 4.Supplier<T>	T为输出。没有输入。
         * */
        Supplier<String> supplier = () -> "supplier";
        System.out.println(supplier.get());

        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");

        /**
         * 5.BinaryOperator<T>	两个T作为输入，1个返回。	T只是类型限制。
         * */
        BinaryOperator<String> binaryOprator = (x, y) -> {
            return x + y;
        };
        System.out.println(binaryOprator.apply("hello", " world!"));

        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");

        /**
         * Comparator<T>	T为接受类型
         * */
        Comparator<String> comparator = (String a, String b) -> {
            return 1;
        };
        //简写
        Comparator<String> comparator2 = (a, b) -> a.compareTo(b);
        System.out.println(comparator.compare("aa", "bb"));
    }
}
