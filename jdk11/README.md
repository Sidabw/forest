# instructions

## jdk9
* 模块化
  * 在package和project中间加了一层模块的概念。
  * 感觉主要用于大型项目的管理。
  * 使用上就是创建一个module-info.java，然后在里面写上当前模块叫什么，需要引用那些模块，要暴露出去哪些模块
  * 未实践
* 接口支持私有方法【参考jdk9.Demo2】
* 改进版的try-with-resource【参考jdk9.Demo1】
* StreamAPI新增：dropWhile、takeWhile、ofNullable
* CMS垃圾回收器废弃，G1成为默认

## jdk10
* APPCDS
  * Class-Data Sharing in App Class Loader
  * 提高应用启动速度可以：预处理class。后面java程序启动时直接内存映射。
  * jdk1.5的CDS只应用在了BootClassLoader中
  * jdk1.9扩展到了app class loader 和自定义class loader
* 多线程并行GC
  * G1是为了避免full GC而设计的
  * 故而设计之初Young GC和Mixed GC是并行的，但是full gc是串行的标记-清理-合并算法
  * 本次升级对g1的full gc部分改为：并行的标记清除
* var关键字：局部变量类型推断【参考jdk10.Demo1】

## jdk11
* String新增方法  
  * isBlank
  * 去全角半角空字符的strip()，相比于原来的trim只能去半角
* TLS1.3的支持
* 新增简单易用的HttpClient并支持Http1.1 Http2 ws
* Epsilon：低开销垃圾回收器
* 飞行记录器：JFR
  * 类似黑盒子，低开销的记录一些信息以在应用崩溃时分析

