### Jenkins
*   下载jenkins war包，放到tomcat webapp下，启动tomcat，访问http://localhost:8080/jenkins/ 按照提醒进行安装向导，如果最后一直没反应就重启一下tomcat。
*   manage Jenkins -> configure System
*   manage Jenkins -> Global Tool Configuration 配置jdk和maven。NAME：apache-maven-3.5.3，MAVEN_HOME：/Users/feiyi/Documents/apache-maven-3.5.3。jdk亦同。
*   new item -> Freestyle project.配置git，配置execute shell.
*   execute shell 1.invoke top-level Maven targets。goals：clean package
*   execute shell 
2.#!/bin/bash
pid=` ps -ef | grep springbootdemo.jar | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]
then
   echo "kill -9 的pid:" $pid
   kill -9 $pid
fi
BUILD_ID=dontKillMe nohup java -jar /Users/feiyi/.jenkins/workspace/forest/target/springbootdemo.jar > nohup.out 2>&1 &