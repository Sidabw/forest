#! /bin/bash

echo "shell 函数练习..."

fun1(){
   echo "这是我的第一个function"
#函数返回值只能是0-255的数字。没有显式的return，则函数最后一行代码的结果return
#   return "aaa"
}

fun1

fun2(){
#可以通过#? (获取上一行命令的执行结果。默认执行成功结果就是0) 或 反引号(只能拿到方法的最后一个echo) 拿到函数返回值。
# #? 只能拿到char的最大值 127
   echo "练习return..."
   return 12
}
fun2
a=$?
echo $a

fun3(){
# 这里的 $1 只能拿到调用方法时传递的参数，不能够拿到执行脚本时传递的参数
   echo "调用方法的第一个参数是 $1"
   echo "调用方法的第二个参数是 $2"
}

fun3 11 22

echo "当前脚本运行的pid是 $$"
echo "传递到当前脚本的参数个数为 $#"
