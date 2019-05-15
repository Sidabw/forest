#! /bin/bash

#test命令测试
#使用demo4的-f命令同样可:
file="/Users/feiyi/Documents/some_shell/demo1.sh"
if test -e $file ;
then
 echo "$file 文件存在"
fi

echo "流程控制之 if elif  for while case break continue..."
a=10
if [ $a == 1 ];
then
  echo "a eq 1"
elif [ $a == 10 ];
then
   echo " 进入了elif --> a eq 10"
fi 

echo "for 循环练习在demo2.sh 中可以找到..."

echo "while 循环练习"
while [ $a -gt 5 ];
do
   echo "$a"
   a=`expr $a - 1`
done

#echo "while 读取键盘输入"
#echo "按下 <CTRL + D> 退出"
#echo -n "输入您最喜欢的网站..."
#while read FILM
#do
#  echo "$FILM is good"
#done

#echo "无限循环"
#while true;
#do
#   echo "进入无限循环了....."
#done

echo "until就不练习了吧...."

echo "case练习..."
echo "请输入一个数字"
read aNum
case $aNum in
   1) echo "你输入了 1 "
   ;; #这里的双分号 就相当于 break..
   2) echo "你输入了 2 "
   ;;
   *) echo "管你输入了啥..."
   ;;
esac

echo "break continue 就是跳出循环 及 跳出本次循环...  不练习了...  又得写while 又得写 if/case"
