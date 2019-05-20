# export env set read declare
#
#
#
#
#export 命令使用
#export
echo "**********************************************************"
#env 命令使用
#env
echo "**********************************************************"
#set 命令使用
#set
echo "**********************************************************" #会将环境变量和自定义变量全部打印
#read
#p 提示话 t 倒计时
read -p '说点你想说的，给你5秒钟.示例 我爱你sida' -t 5 sida
echo ${sida}
echo '我也爱你'

#declare -aixr。 -a声明一个数组；-i声明一个数字；-r声明一个只读变量；-x从环境变量中移除，也可以+x
#typeset 使用和declare一样
declare -i number=$RANDOM*10/32678;
echo ${number}
declare -a arr[1]=111
arr[2]=222
echo "${arr[1]}, ${arr[2]}"
#history 使用，列出最近使用的前1000条命令。仅在注销时才写入~/.bash_history中。防止黑客可以使用history -c 强制写入
history
 
