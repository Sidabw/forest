#使用@ControllerAdvice进行统一的异常处理，异常捕获。
#使用@Exception进行进行异常的确定处理。
#目前不知道如何跳转到error.jsp，需引入thymeleaf模板的pom依赖。

#get，post乱码解决

#日期处理，DateConverterConfig

#Swagger使用相关
swagger除了前后端交互使用外，在更改别人bug，定位请求方法时，也很好用

#phantomjs相关;
http://blinkfox.com/shi-yong-javadiao-yong-phantomjsdong-tai-dao-chu-echartstu-pian-dao-wordwen-jian-zhong/
https://blog.csdn.net/tengdazhang770960436/article/details/41348035
#springboot 结合 mybatis 报错，
多半是xml 不在target目录下，现通过在properties中
加入mapping/*.xml，把xml移到resource/mapping下解决

#aop环绕通知相关
通过@pointcut("...")设置切面，该切面的名称就是方法名，余下注解都可通过指定方法名来指定切面。
1.@around 执行...proceed执行
2.@before 执行
3.接口 执行
4.@around 继续执行，走完
5.@after 执行
6.@afterrunning 执行
补充说明excution配置
execution(public * com.beta.basic.controller..*.*(..))
第一个*代表不限制接口返回值
第一个..代表 当前包及其子包
第二个*代表所有的类
第三个*代表所有的方法
最后的(..)代表方法参数列表不为空

#打印mybatis sql console
在application.properties中加入；
logging.level.com.beta.mybatis.mapper=trace


#quartz     详细见com.beta.scheduler.quartz.README.md
#mail 相关实现      ->  blog:https://www.cnblogs.com/xdp-gacl/p/4216311.html

#springboot 在实现jsp和thyemleaf双模板引擎上太麻烦，各种问题，最终解决方案是使用jsp，
#全局异常处理废弃，使用interceptor拦截500/404错误，并return到errorPage.jsp页面
