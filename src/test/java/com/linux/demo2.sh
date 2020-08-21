#! /bin/bash
#
#
#
#
#shell 学习 —— shell变量
sida="luobotou"
echo ${sida}
echo $(ls /Users/feiyi)
echo "---------------------------"
echo "for循环...wile的话则是 wile condition ... 后边的相同do.. done"
for skill in Java Kafka websocket es;
 do
  echo "I'm to learn ${skill} right now!"
done
variabletest="read only variable"
#变量只读
readonly variabletest
echo ${variabletest}
echo "我要删除只读变量  variabletest"
#只读变量不可删除
unset variabletest
echo "variabletest is ${variabletest}"
echo "字符串使用双引号，因为这样可以在字符串里饮用其他字符串。如果是单引号的话就不可以了"
name="zhangsan"
name2="shazi${name}"
echo ${name2}
echo "字符串长度打印"
echo ${#name2}
string="runoob is a great site"
#expr 计数器命令。在mac下index等参数被禁用了。
#expr index ${string} r
echo "字符串截取"
#从角标1开始，包含角标1，向后截取4位
echo ${string:1:4}

echo "数组练习"
array_test=("a" "b" "c" "d" "e")
array_test[0]="sida"
echo ${array_test[0]}
#在这里 @ 和 * 一个意思
echo "获取所有的数组元素@ ${array_test[@]}"
echo "获取所有的数组元素* ${array_test[*]}"
echo "获取数组元素个数 ${#array_test[*]}"
echo "获取数组中0角标元素的长度 ${#array_test[0]}"
