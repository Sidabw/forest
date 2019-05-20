#!/bin/bash
#echo printf 命令学习
#
#
#
#
echo "Hello Shell!"
# -e 允许使用转义字符， \c表示不换行。 echo默认自动添加了\n
echo -e "aaa \c"
echo "bbb"

# printf 允许string-format; 默认是没有换行的 
printf "%-10s %-8s %-4s \n" 姓名 性别 收入
printf "%-10s %-8s %-4.2f \n" sida women 91.1222
printf "oooo输入-还不行oooo \n"






















