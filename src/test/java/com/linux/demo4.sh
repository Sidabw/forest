#! /bin/bash
#shell 学习 —— shell运算符
echo "算数运算符"
echo "关系运算符"
echo "布尔运算符"
echo "字符串运算符"
echo "文件测试运算符"
#expr 后面的表达式之间应当有空格;应使用反引号而不是单引号
a=10
b=6
#这里可以使用的运算符有+ - * / % =(赋值) ==(相等) !=(不等)
#使用* 的时候需要使用反斜杠转译
echo "算数运算符"
value=`expr ${a} + ${b}`
echo "a + b = ${value}"

value=`expr ${a} \* ${b}`
echo "a * b = ${value}"

if [ ${a} != ${b} ];
then
   echo "a != b"
fi

echo "关系运算符"
#-eq(相等) -ne(不想等) -gt(大于) -lt(小于) -ge(大于等于) -le(小于等于)
if [ $a -eq $b ];
 then
   echo "a == b"
else
   echo "a != b"
fi

echo "布尔运算符"
# !非运算 -o或运算 -a且运算;也可以使用&& ||
if [ $a -eq 10 -a $b -ne 5 ];
then
   echo "且运算了..."
fi

echo "字符串运算符"
# =(字符串相等，不是赋值) !=(字符串不相等) -n(字符串长度不是0返回true) -z(字符串长度为0返回true) [ $a ] (字符串是否为空) 
a="abc"
b="def"
if [ $c ];
then
   echo "字符串c不为空"
else
   echo "字符串c为空"
fi

if [ -n $a ];
then
   echo "字符串 a 长度为0"
else
   echo "字符串 a 长度不为0"
fi

echo "文件测试运算符"
file="/Users/feiyi/Documents/some_shell/demo1.sh"
dir="/Users/feiyi/Documents/some_shell"
if [ -d $dir ];
then
   echo "$dir is a dir"
fi

if [ -f $file ];
then
   echo "$file is a file"
fi

if [ -r $file ];
then
   echo "$file 是可读的"
fi

if [ -w $file ];
then
   echo "$file 是可写的"
fi

if [ -x $file ];
then
   echo "$file 是可执行的"
fi













