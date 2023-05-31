#   forest
[![Travis](https://img.shields.io/badge/language-Java-yellow.svg)](https://developer.apple.com/.md)

### 🍺简介
*   使用@ControllerAdvice进行统一的异常处理，异常捕获。提供了ExceptionHandler、ResponseStatus两个注解，可以针对不同异常、不同状态码做出细颗粒的处理。
*   目前不知道如何跳转到error.jsp，可以跳到error.html
*   日期处理，DateConverterConfig
*   加入swagger
*   **phantomjs**   [参考1](http://blinkfox.com/shi-yong-javadiao-yong-phantomjsdong-tai-dao-chu-echartstu-pian-dao-wordwen-jian-zhong/)
[参考2](https://blog.csdn.net/tengdazhang770960436/article/details/41348035)
*	springboot 结合 mybatis 报错，多半是xml 不在target目录下，可以加入mybatis.mapperLocations配置，扫描resource下的.xml文件
*	aop环绕通知，切面处理。详细见config/aop包下readme
*   quartz，详细见com.beta.scheduler.quartz.README.md
*   mail，test包下有实现。详细见blog：  https://www.cnblogs.com/xdp-gacl/p/4216311.html
*  elasticsearch 详细见/basic/elasticsearch
